package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
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
		public KeyPair execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/os-keypairs");
		    request.header("Accept", "application/json");
		    request.json(keyPairForCreate);
		    return connector.execute(request, KeyPair.class);
		}
		
	}
	
	public static class DeleteKeyPair implements NovaCommand<Void> {

		private String name;
		
		public DeleteKeyPair(String name) {
			this.name = name;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("DELETE");
		    request.path("/os-keypairs").path(name);
		    request.header("Accept", "application/json");
		    connector.execute(request);
		    return null;
		}
		
	}
	
	public static class ListKeyPairs implements NovaCommand<KeyPairs>{

		@Override
		public KeyPairs execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-keypairs");
		    request.header("Accept", "application/json");
		    return connector.execute(request, KeyPairs.class);
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
