package com.woorea.openstack.examples.glance;

import com.woorea.openstack.glance.model.ImageDownload;
import com.woorea.openstack.glance.model.ImageUpload;
import com.woorea.openstack.keystone.utils.KeystoneTokenProvider;

import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.glance.Glance;
import com.woorea.openstack.glance.model.Image;
import com.woorea.openstack.glance.model.Images;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.Access.Service;
import com.woorea.openstack.keystone.model.Access.Service.Endpoint;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class GlanceListImages {

	protected static String IMAGE_CONTENT = "Hello World!";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneTokenProvider keystone = new KeystoneTokenProvider(
				ExamplesConfiguration.KEYSTONE_AUTH_URL,
				ExamplesConfiguration.KEYSTONE_USERNAME,
				ExamplesConfiguration.KEYSTONE_PASSWORD);

		Access access = keystone.getAccessByTenant(ExamplesConfiguration.TENANT_NAME);

		Service glanceService = null;

		for (Service service : access.getServiceCatalog()) {
			if (service.getType().equals("image")) {
				glanceService = service;
				break;
			}
		}

		if (glanceService == null) {
			throw new RuntimeException("Glance service not found");
		}

		for (Endpoint endpoint : glanceService.getEndpoints()) {
			Glance glance = new Glance(endpoint.getPublicURL() + "/v1");
			glance.setTokenProvider(keystone
					.getProviderByTenant(ExamplesConfiguration.TENANT_NAME));

			// Creating a new image
			Image newImage = new Image();
			newImage.setDiskFormat("raw");
			newImage.setContainerFormat("bare");
			newImage.setName("os-java-glance-test");
			newImage = glance.images().create(newImage).execute();

			// Uploading image
			ImageUpload uploadImage = new ImageUpload(newImage);
			uploadImage.setInputStream(new ByteArrayInputStream(IMAGE_CONTENT.getBytes()));
			glance.images().upload(newImage.getId(), uploadImage).execute();

			// Downloading the image and displaying the image content
			try {
				byte[] imgContent = new byte[IMAGE_CONTENT.length()];
				ImageDownload downloadImage = glance.images().download(newImage.getId()).execute();
				downloadImage.getInputStream().read(imgContent, 0, imgContent.length);
				System.out.println(new String(imgContent));
			} catch (IOException e) {
				e.printStackTrace();
			}

			Images images = glance.images().list(false).execute();

			for (Image image : images) {
				System.out.println(glance.images().show(image.getId()).execute());
			}

			glance.images().delete(newImage.getId()).execute();
		}
	}

}
