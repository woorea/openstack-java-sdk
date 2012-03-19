//package org.openstack.client.storage;
//
//import static org.testng.Assert.assertEquals;
//import java.io.InputStream;
//import java.util.Map;
//
//import org.openstack.api.storage.ContainerResource;
//import org.openstack.client.utils.RandomDataInputStream;
//import org.openstack.model.storage.SwiftContainer;
//import org.openstack.model.storage.SwiftObjectProperties;
//import org.openstack.model.storage.SwiftStorageObject;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.google.common.collect.Maps;
//
//public class ITSwift extends StorageIntegrationTest {
//
//	@Test
//	public void testListContainers() throws Exception {
//		Map<String, SwiftContainer> containers = findAllContainers();
//
//		for (SwiftContainer container : containers.values()) {
//			System.out.println(container);
//		}
//	}
//
//	@Test
//	public void createAndDeleteContainer() throws Exception {
//		String containerName = random.randomAlphanumericString(4, 100);
//
//		swift.root().containers().create(containerName);
//
//		SwiftContainer container = findAllContainers().get(containerName);
//		Assert.assertNotNull(container);
//		Assert.assertEquals(container.getName(), containerName);
//		Assert.assertEquals(container.getBytes(), 0);
//		Assert.assertEquals(container.getCount(), 0);
//
//		swift.root().containers().id(containerName).delete();
//	}
//
//	static final int MAX_LENGTH = 256;
//
//	@Test
//	public void createAndDeleteObject() throws Exception {
//		String containerName = random.randomAlphanumericString(4, 100);
//
//		swift.root().containers().create(containerName);
//
//		ContainerResource containerResource = swift.root().containers().id(containerName);
//
//		RandomDataInputStream stream = random.randomStream(MAX_LENGTH);
//
//		String objectName = random.randomAlphanumericString(4, 100);
//
//		SwiftObjectProperties properties = new SwiftObjectProperties();
//		properties.setName(objectName);
//
//		containerResource.objects().putObject(stream, stream.getStreamLength(), properties);
//
//		SwiftStorageObject storedObject = findAllObjects(containerName).get(objectName);
//
//		Assert.assertNotNull(storedObject);
//		Assert.assertEquals(storedObject.getName(), objectName);
//
//		{
//			InputStream read = containerResource.objects().id(objectName).openStream();
//			assertStreamsTheSame(stream.clone(), read);
//			read.close();
//		}
//
//		SwiftObjectProperties metadata = containerResource.objects().id(objectName).metadata();
//		System.out.println(metadata);
//
//		containerResource.objects().id(objectName).delete();
//		containerResource.delete();
//	}
//
//	@Test
//	public void testMetadata() throws Exception {
//		String containerName = random.randomAlphanumericString(4, 100);
//		String objectName = random.randomAlphanumericString(4, 100);
//
//		swift.root().containers().create(containerName);
//
//		ContainerResource containerResource = swift.root().containers().id(containerName);
//		RandomDataInputStream stream = random.randomStream(MAX_LENGTH);
//
//		SwiftObjectProperties expectedProperties = new SwiftObjectProperties();
//		expectedProperties.setName(objectName);
//
//		for (int i = 0; i < random.uniform(0, 12); i++) {
//			String k = random.randomAlphanumericString(1, 32);
//			k = k.toLowerCase();
//
//			String v = random.randomAlphanumericString(1, 32);
//
//			expectedProperties.getCustomProperties().put(k, v);
//		}
//
//		containerResource.objects().putObject(stream, stream.getStreamLength(), expectedProperties);
//
//		for (int i = 0; i < 5; i++) {
//			SwiftObjectProperties actualProperties = containerResource.objects().id(objectName).metadata();
//			assertPropertiesEqual(actualProperties, expectedProperties);
//
//			SwiftObjectProperties changeProperties = containerResource.objects().id(objectName).metadata();
//			for (int j = 0; j < random.uniform(0, 12); j++) {
//				String k = random.randomAlphanumericString(1, 32);
//				k = k.toLowerCase();
//
//				String v = random.randomAlphanumericString(1, 32);
//
//				changeProperties.getCustomProperties().put(k, v);
//				expectedProperties.getCustomProperties().put(k, v);
//			}
//
//			containerResource.objects().id(objectName).updateMetadata(changeProperties);
//		}
//
//		containerResource.objects().id(objectName).delete();
//		containerResource.delete();
//	}
//
//	private void assertPropertiesEqual(SwiftObjectProperties actualProperties, SwiftObjectProperties expectedProperties) {
//		assertEquals(actualProperties.getCustomProperties(), expectedProperties.getCustomProperties());
//	}
//
//	private Map<String, SwiftContainer> findAllContainers() {
//		Map<String, SwiftContainer> containers = Maps.newHashMap();
//		for (SwiftContainer container : swift.root().containers().list()) {
//			String name = container.getName();
//			Assert.assertNull(containers.get(name));
//			containers.put(name, container);
//		}
//		return containers;
//	}
//
//	private Map<String, SwiftStorageObject> findAllObjects(String containerName) {
//		Map<String, SwiftStorageObject> objects = Maps.newHashMap();
//		for (SwiftStorageObject object : swift.root().containers().id(containerName).objects().list()) {
//			String name = object.getName();
//			Assert.assertNull(objects.get(name));
//			objects.put(name, object);
//		}
//		return objects;
//	}
//
//}
