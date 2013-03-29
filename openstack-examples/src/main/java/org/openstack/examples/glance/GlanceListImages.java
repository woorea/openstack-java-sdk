package org.openstack.examples.glance;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.glance.GlanceClient;
import org.openstack.glance.api.ListImages;
import org.openstack.glance.model.Image;
import org.openstack.glance.model.Images;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.ListTenants;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.utils.KeystoneUtils;

public class GlanceListImages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(
				ExamplesConfiguration.KEYSTONE_AUTH_URL);

		Access access = keystone.execute(Authenticate.withPasswordCredentials(
				ExamplesConfiguration.KEYSTONE_USERNAME,
				ExamplesConfiguration.KEYSTONE_PASSWORD));
		keystone.token(access.getToken().getId());

		Tenants tenants = keystone.execute(new ListTenants());

		if (tenants.getList().size() > 0) {
			access = keystone.execute(Authenticate.withToken(
					access.getToken().getId()).withTenantId(
					tenants.getList().get(0).getId()));

			GlanceClient client = new GlanceClient(
					KeystoneUtils.findEndpointURL(access.getServiceCatalog(),
							"image", null, "public"));
			client.token(access.getToken().getId());

			Images images = client.execute(new ListImages(false));

			for (Image image : images) {
				System.out.println(image);
			}
		} else {
			System.out.println("No tenants found!");
		}
	}

}
