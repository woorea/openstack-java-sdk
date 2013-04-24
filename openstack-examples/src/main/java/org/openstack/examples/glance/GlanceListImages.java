package org.openstack.examples.glance;

import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.glance.GlanceClient;
import org.openstack.glance.api.ListImages;
import org.openstack.glance.model.Image;
import org.openstack.glance.model.Images;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Access.Service;
import org.openstack.keystone.model.Access.Service.Endpoint;

public class GlanceListImages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(
				ExamplesConfiguration.KEYSTONE_AUTH_URL);

		Access access = keystone.execute(
				Authenticate.withPasswordCredentials(
						ExamplesConfiguration.KEYSTONE_USERNAME,
						ExamplesConfiguration.KEYSTONE_PASSWORD)
				.withTenantName(ExamplesConfiguration.TENANT_NAME));

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
			glance.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));

			Images images = glance.execute(new ListImages(false));

			for (Image image : images) {
				System.out.println(image);
			}
		}
	}

}
