package org.openstack.client.images;

import java.io.ByteArrayInputStream;
import java.io.File;

import org.apache.commons.io.IOUtils;
import org.openstack.api.images.ImagesResource;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.model.images.Image;
import org.openstack.model.images.ImageList;
import org.openstack.model.images.glance.GlanceImage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GlanceIntegrationTest extends AbstractOpenStackTest {
	
	private ImagesResource images;
	
	
	private Image image;
	
	@BeforeClass
	public void init() {
		super.init();
		//if (!glanceEnabled) {
			//	throw new SkipException("Skipping because glance not present / accessible");
		//}
		
		
		images = client.target("http://192.168.1.52:9292/v1/images", ImagesResource.class);
	}
	
	@Test
	public void createImage() {
		try {
			image = new GlanceImage();
			Image template = new GlanceImage();
			template.setName(random.randomAlphanumericString(1, 16).trim());
			template.setDiskFormat("raw");
			template.setContainerFormat("bare");
			
			image = images.post(new ByteArrayInputStream(new byte[1024]), 1024, image);
		} catch(Exception e) {
			
		}
	}
	
	@Test(dependsOnMethods="createImage", priority=1)
	public void listImages() {
		ImageList list = images.get();
	}
	
	
	@Test(dependsOnMethods="createImage", priority=2)
	public void showImage() {
		images.image(image.getId()).head();
	}
	
	public void updateImage() {
		
	}
	
	@Test(dependsOnMethods="createImage", priority=3)
	public void deleteImage() {
		images.image(image.getId()).head();
	}

}
