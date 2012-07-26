package org.openstack.nova.api.extensions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.KeyPair;
import org.openstack.nova.model.KeyPairs;

public class KeyPairsExtension {

	public static class CreateKeyPair implements NovaCommand<KeyPair> {

		private KeyPair keyPairForCreate;
		
		public CreateKeyPair(KeyPair keyPairForCreate) {
			this.keyPairForCreate = keyPairForCreate;
		}

		@Override
		public KeyPair execute(WebTarget target) {
			return target.path("os-keypairs").request(MediaType.APPLICATION_JSON).post(Entity.json(keyPairForCreate), KeyPair.class);
		}
		
	}
	
	public static class DeleteKeyPair implements NovaCommand<Void> {

		private String name;
		
		public DeleteKeyPair(String name) {
			this.name = name;
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("os-keypairs").path(name).request(MediaType.APPLICATION_JSON).delete();
			return null;
		}
		
	}
	
	public static class ListKeyPairs implements NovaCommand<KeyPairs>{

		@Override
		public KeyPairs execute(WebTarget target) {
			return target.path("os-keypairs").request(MediaType.APPLICATION_JSON).get(KeyPairs.class);
		}

	}
	
	public static ListKeyPairs listKeyPairs() {
		return new ListKeyPairs();
	}
	
	public static CreateKeyPair createKeyPair(String name, String publicKey) {
		KeyPair keyPairForCreate = new KeyPair(name, publicKey);
		return new CreateKeyPair(keyPairForCreate);
	}
	
	public static CreateKeyPair createKeyPair(String name) {
		return createKeyPair(name, null);
	}
	
	public static DeleteKeyPair delete(String name) {
		return new DeleteKeyPair(name);
	}

}
