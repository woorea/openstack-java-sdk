package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Certificate;

public class CredentialsExtension {

	public static class CreateCertificate extends OpenStackRequest<Certificate> {

		public CreateCertificate(String id) {
			method(HttpMethod.POST);
			path("/os-certificates/").path(id);
			header("Accept", "application/json");
			returnType(Certificate.class);
		}

	}

	public static class ShowCertificate extends OpenStackRequest<Certificate> {

		public ShowCertificate() {
			OpenStackRequest request = new OpenStackRequest();
			method(HttpMethod.GET);
			path("/os-certificates");
			header("Accept", "application/json");
			returnType(Certificate.class);
		}

	}

	public CreateCertificate createCertificate(String id) {
		return new CreateCertificate(id);
	}

	public ShowCertificate showCertificate(String id) {
		return new ShowCertificate();
	}

}
