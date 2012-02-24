package org.openstack.client.storage;

import static org.testng.Assert.assertEquals;
import java.io.InputStream;
import java.util.Map;

import org.openstack.client.utils.RandomDataInputStream;
import org.openstack.model.storage.Container;
import org.openstack.model.storage.ObjectProperties;
import org.openstack.model.storage.StorageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Maps;

public class ITSwift extends StorageIntegrationTest {

	@Test
	public void testListContainers() throws Exception {
		Map<String, Container> containers = findAllContainers();

		for (Container container : containers.values()) {
			System.out.println(container);
		}
	}

	@Test
	public void createAndDeleteContainer() throws Exception {
		String containerName = random.randomAlphanumericString(4, 100);

		swift.root().containers().create(containerName);

		Container container = findAllContainers().get(containerName);
		Assert.assertNotNull(container);
		Assert.assertEquals(container.getName(), containerName);
		Assert.assertEquals(container.getBytes(), 0);
		Assert.assertEquals(container.getCount(), 0);

		swift.root().containers().id(containerName).delete();
	}

	static final int MAX_LENGTH = 256;

	@Test
	public void createAndDeleteObject() throws Exception {
		String containerName = random.randomAlphanumericString(4, 100);

		swift.root().containers().create(containerName);

		ContainerResource containerResource = swift.root().containers().id(containerName);

		RandomDataInputStream stream = random.randomStream(MAX_LENGTH);

		String objectName = random.randomAlphanumericString(4, 100);

		ObjectProperties properties = new ObjectProperties();
		properties.setName(objectName);

		containerResource.objects().putObject(stream, stream.getStreamLength(), properties);

		StorageObject storedObject = findAllObjects(containerName).get(objectName);

		Assert.assertNotNull(storedObject);
		Assert.assertEquals(storedObject.getName(), objectName);

		{
			InputStream read = containerResource.objects().id(objectName).openStream();
			assertStreamsTheSame(stream.clone(), read);
			read.close();
		}

		ObjectProperties metadata = containerResource.objects().id(objectName).metadata();
		System.out.println(metadata);

		containerResource.objects().id(objectName).delete();
		containerResource.delete();
	}

	@Test
	public void testMetadata() throws Exception {
		String containerName = random.randomAlphanumericString(4, 100);
		String objectName = random.randomAlphanumericString(4, 100);

		swift.root().containers().create(containerName);

		ContainerResource containerResource = swift.root().containers().id(containerName);
		RandomDataInputStream stream = random.randomStream(MAX_LENGTH);

		ObjectProperties expectedProperties = new ObjectProperties();
		expectedProperties.setName(objectName);

		for (int i = 0; i < random.uniform(0, 12); i++) {
			String k = random.randomAlphanumericString(1, 32);
			k = k.toLowerCase();

			String v = random.randomAlphanumericString(1, 32);

			expectedProperties.getCustomProperties().put(k, v);
		}

		containerResource.objects().putObject(stream, stream.getStreamLength(), expectedProperties);

		for (int i = 0; i < 5; i++) {
			ObjectProperties actualProperties = containerResource.objects().id(objectName).metadata();
			assertPropertiesEqual(actualProperties, expectedProperties);

			ObjectProperties changeProperties = containerResource.objects().id(objectName).metadata();
			for (int j = 0; j < random.uniform(0, 12); j++) {
				String k = random.randomAlphanumericString(1, 32);
				k = k.toLowerCase();

				String v = random.randomAlphanumericString(1, 32);

				changeProperties.getCustomProperties().put(k, v);
				expectedProperties.getCustomProperties().put(k, v);
			}

			containerResource.objects().id(objectName).updateMetadata(changeProperties);
		}

		containerResource.objects().id(objectName).delete();
		containerResource.delete();
	}

	private void assertPropertiesEqual(ObjectProperties actualProperties, ObjectProperties expectedProperties) {
		assertEquals(actualProperties.getCustomProperties(), expectedProperties.getCustomProperties());
	}

	private Map<String, Container> findAllContainers() {
		Map<String, Container> containers = Maps.newHashMap();
		for (Container container : swift.root().containers().list()) {
			String name = container.getName();
			Assert.assertNull(containers.get(name));
			containers.put(name, container);
		}
		return containers;
	}

	private Map<String, StorageObject> findAllObjects(String containerName) {
		Map<String, StorageObject> objects = Maps.newHashMap();
		for (StorageObject object : swift.root().containers().id(containerName).objects().list()) {
			String name = object.getName();
			Assert.assertNull(objects.get(name));
			objects.put(name, object);
		}
		return objects;
	}

}
