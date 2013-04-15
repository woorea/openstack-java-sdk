package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Certificate;

public class CredentialsExtension {

	public static class CreateCertificate implements OpenStackCommand<Certificate> {

		private String id;
		
		public CreateCertificate(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.POST);
		    request.path("/os-certificates/").path(id);
		    request.header("Accept", "application/json");
		    request.returnType(Certificate.class);
		return request;
		}
		
	}
	
	public static class ShowCertificate implements OpenStackCommand<Void>{

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path("/os-certificates");
		    request.header("Accept", "application/json");
		    request.returnType(Certificate.class);
			return request;
		}

	}
	
	public CreateCertificate createCertificate(String id) {
		return new CreateCertificate(id);
	}
	
	public ShowCertificate showCertificate(String id) {
		return new ShowCertificate();
	}
	
}
