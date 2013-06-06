package com.woorea.openstack.examples.glance;

import com.woorea.openstack.keystone.utils.KeystoneTokenProvider;

import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.glance.Glance;
import com.woorea.openstack.glance.model.Image;
import com.woorea.openstack.glance.model.Images;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.Access.Service;
import com.woorea.openstack.keystone.model.Access.Service.Endpoint;

public class GlanceListImages {

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

			Images images = glance.images().list(false).execute();

			for (Image image : images) {
				System.out.println(glance.images().show(image.getId()).execute());
			}

			glance.images().delete(newImage.getId()).execute();
		}
	}

}
