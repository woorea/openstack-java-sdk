package org.openstack.client.images;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.openstack.api.images.ImagesResource;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.model.images.Image;
import org.openstack.model.images.ImageList;
import org.openstack.model.images.glance.GlanceImage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GlanceIntegrationTest extends AbstractOpenStackTest {
	
	private ImagesResource images;
	
	
	private Image uploaded;
	
	@BeforeClass
	public void init() {
		if (!glanceEnabled) {
			init("/openstack.properties");
			client = client.reauthenticateOnTenant("admin");
			images = client.getImagesEndpoint();			
		} else {
			throw new SkipException("Skipping because glance not present / accessible");
		}
		
	}
	
	@Test
	public void createImage() {
		try {
			Image image = new GlanceImage();
			image.setName(random.randomAlphanumericString(1, 16).trim());
			image.setDiskFormat("raw");
			image.setContainerFormat("bare");
			
			int size = 1024;
			InputStream is = new ByteArrayInputStream(new byte[size]);
			
			uploaded = images.post(is, size, image);
			assertEquals(uploaded.getSize(), Long.valueOf(size));
			assertEquals(uploaded.getName(), image.getName());
			assertNull(uploaded.getDeletedAt());
			assertNotNull(uploaded.getCreatedAt());
			assertNotNull(uploaded.getUpdatedAt());
			assertNotNull(uploaded.getId());
			assertEquals(uploaded.isDeleted(), Boolean.FALSE);
			assertEquals(uploaded.getDiskFormat(), image.getDiskFormat());
			assertEquals(uploaded.getContainerFormat(), image.getContainerFormat());
			assertNotNull(uploaded.getOwner());
			assertEquals(uploaded.getStatus(), "active");		
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@Test(priority=1)
	public void listImages() {
		ImageList list = images.get();
		Assert.assertNotNull(list);
	}
	
	
	@Test(dependsOnMethods="createImage", priority=2)
	public void showImage() {
		Image image = images.image(uploaded.getId()).head();
		assertImageEquals(image, uploaded);
	}
	
	public void updateImage() {
		
	}
	
	@Test(dependsOnMethods="createImage", priority=3)
	public void deleteImage() {
		images.image(uploaded.getId()).delete();
	}
	
	private void assertImageEquals(Image actual, Image expected) {
		assertEquals(actual.getId(), expected.getId());
		assertEquals(actual.getChecksum(), expected.getChecksum());
		assertEquals(actual.getContainerFormat(), expected.getContainerFormat());
		assertEquals(actual.getCreatedAt(), expected.getCreatedAt());
		assertEquals(actual.getDeletedAt(), expected.getDeletedAt());
		assertEquals(actual.getDiskFormat(), expected.getDiskFormat());
		assertEquals(actual.getMinDisk(), expected.getMinDisk());
		assertEquals(actual.getMinRam(), expected.getMinRam());
		assertEquals(actual.getName(), expected.getName());
		assertEquals(actual.getOwner(), expected.getOwner());
		assertEquals(actual.getSize(), expected.getSize());
		assertEquals(actual.getStatus(), expected.getStatus());
		assertEquals(actual.getProperties(), expected.getProperties());
	}

}
