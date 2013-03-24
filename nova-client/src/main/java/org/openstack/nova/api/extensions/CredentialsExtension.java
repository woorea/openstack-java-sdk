package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Certificate;
import org.openstack.nova.model.KeyPairs;

public class CredentialsExtension {

	public static class CreateCertificate implements NovaCommand<Certificate> {

		private String id;
		
		public CreateCertificate(String id) {
			this.id = id;
		}

		@Override
		public Certificate execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/os-certificates/").path(id);
		    request.header("Accept", "application/json");
		    return connector.execute(request, Certificate.class);
		}
		
	}
	
	public static class ShowCertificate implements NovaCommand<Void>{

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-certificates");
		    request.header("Accept", "application/json");
		    connector.execute(request, Certificate.class);
			return null;
		}

	}
	
	public CreateCertificate createCertificate(String id) {
		return new CreateCertificate(id);
	}
	
	public ShowCertificate showCertificate(String id) {
		return new ShowCertificate();
	}
	
}
