package org.openstack.nova.api.extensions;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
		public Certificate execute(WebTarget target) {
			target.path("os-certificates").path(id).request(MediaType.APPLICATION_JSON).method("POST");
			return null;
		}
		
	}
	
	public static class ShowCertificate implements NovaCommand<KeyPairs>{

		@Override
		public KeyPairs execute(WebTarget target) {
			return target.path("os-keypairs").request(MediaType.APPLICATION_JSON).get(KeyPairs.class);
		}

	}
	
	public CreateCertificate createCertificate(String id) {
		return new CreateCertificate(id);
	}
	
	public ShowCertificate showCertificate(String id) {
		return new ShowCertificate();
	}
	
}
