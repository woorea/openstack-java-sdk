package org.openstack.examples.glance;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.glance.GlanceClient;
import org.openstack.glance.model.Image;
import org.openstack.glance.model.Images;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Access.Service;
import org.openstack.keystone.model.Access.Service.Endpoint;
import org.openstack.keystone.utils.KeystoneTokenProvider;

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
			GlanceClient glance = new GlanceClient(endpoint.getPublicURL() + "/v1");
			glance.setTokenProvider(keystone
					.getProviderByTenant(ExamplesConfiguration.TENANT_NAME));

			Images images = glance.images().list(false).execute();

			for (Image image : images) {
				System.out.println(image);
			}
		}
	}

}
