package org.openstack.client.storage;

import static org.testng.Assert.assertEquals;
import java.io.InputStream;
import java.util.Map;

import org.openstack.api.storage.ContainerResource;
import org.openstack.client.utils.RandomDataInputStream;
import org.openstack.model.storage.SwiftContainer;
import org.openstack.model.storage.SwiftObjectProperties;
import org.openstack.model.storage.SwiftStorageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Maps;

public class ITSwift extends StorageIntegrationTest {

	@Test
	public void testListContainers() throws Exception {
		Map<String, SwiftContainer> containers = findAllContainers();

		for (SwiftContainer container : containers.values()) {
			System.out.println(container);
		}
	}

	@Test
	public void createAndDeleteContainer() throws Exception {
		String containerName = random.randomAlphanumericString(4, 100);

		client.storage().publicEndpoint().container(containerName).put();

		SwiftContainer container = findAllContainers().get(containerName);
		Assert.assertNotNull(container);
		Assert.assertEquals(container.getName(), containerName);
		Assert.assertEquals(container.getBytes(), 0);
		Assert.assertEquals(container.getCount(), 0);

		client.storage().publicEndpoint().container(containerName).delete();
	}

	static final int MAX_LENGTH = 256;

	@Test
	public void createAndDeleteObject() throws Exception {
		String containerName = random.randomAlphanumericString(4, 100);
		
		client.storage().publicEndpoint().container(containerName).put();
		

		ContainerResource containerResource = client.storage().publicEndpoint().container(containerName);

		RandomDataInputStream stream = random.randomStream(MAX_LENGTH);

		String objectName = random.randomAlphanumericString(4, 100);

		SwiftObjectProperties properties = new SwiftObjectProperties();
		properties.setName(objectName);

		containerResource.object(objectName).put(stream, stream.getStreamLength(), properties);

		SwiftStorageObject storedObject = findAllObjects(containerName).get(objectName);

		Assert.assertNotNull(storedObject);
		Assert.assertEquals(storedObject.getName(), objectName);

		{
			InputStream read = containerResource.object(objectName).openStream();
			assertStreamsTheSame(stream.clone(), read);
			read.close();
		}

		SwiftObjectProperties metadata = containerResource.object(objectName).head();
		System.out.println(metadata);

		containerResource.object(objectName).delete();
		containerResource.delete();
	}

	@Test
	public void testMetadata() throws Exception {
		String containerName = random.randomAlphanumericString(4, 100);
		String objectName = random.randomAlphanumericString(4, 100);

		client.storage().publicEndpoint().container(containerName);

		ContainerResource containerResource = client.storage().publicEndpoint().container(containerName);
		RandomDataInputStream stream = random.randomStream(MAX_LENGTH);

		SwiftObjectProperties expectedProperties = new SwiftObjectProperties();
		expectedProperties.setName(objectName);

		for (int i = 0; i < random.uniform(0, 12); i++) {
			String k = random.randomAlphanumericString(1, 32);
			k = k.toLowerCase();

			String v = random.randomAlphanumericString(1, 32);

			expectedProperties.getCustomProperties().put(k, v);
		}

		containerResource.object(objectName).put(stream, stream.getStreamLength(), expectedProperties);

		for (int i = 0; i < 5; i++) {
			SwiftObjectProperties actualProperties = containerResource.object(objectName).head();
			assertPropertiesEqual(actualProperties, expectedProperties);

			SwiftObjectProperties changeProperties = containerResource.object(objectName).head();
			for (int j = 0; j < random.uniform(0, 12); j++) {
				String k = random.randomAlphanumericString(1, 32);
				k = k.toLowerCase();

				String v = random.randomAlphanumericString(1, 32);

				changeProperties.getCustomProperties().put(k, v);
				expectedProperties.getCustomProperties().put(k, v);
			}

			containerResource.object(objectName).post(changeProperties);
		}

		containerResource.object(objectName).delete();
		containerResource.delete();
	}

	private void assertPropertiesEqual(SwiftObjectProperties actualProperties, SwiftObjectProperties expectedProperties) {
		assertEquals(actualProperties.getCustomProperties(), expectedProperties.getCustomProperties());
	}

	private Map<String, SwiftContainer> findAllContainers() {
		Map<String, SwiftContainer> containers = Maps.newHashMap();
		for (SwiftContainer container : client.storage().publicEndpoint().get()) {
			String name = container.getName();
			Assert.assertNull(containers.get(name));
			containers.put(name, container);
		}
		return containers;
	}

	private Map<String, SwiftStorageObject> findAllObjects(String containerName) {
		Map<String, SwiftStorageObject> objects = Maps.newHashMap();
		for (SwiftStorageObject object : client.storage().publicEndpoint().container(containerName).get()) {
			String name = object.getName();
			Assert.assertNull(objects.get(name));
			objects.put(name, object);
		}
		return objects;
	}

}
