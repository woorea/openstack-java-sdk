package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.KeyPair;
import org.openstack.nova.model.KeyPairs;

public class KeyPairsExtension {

	public static class CreateKeyPair extends OpenStackRequest {

		private KeyPair keyPairForCreate;

		public CreateKeyPair(KeyPair keyPairForCreate) {
			this.keyPairForCreate = keyPairForCreate;
			
			method(HttpMethod.POST);
			path("/os-keypairs");
			header("Accept", "application/json");
			json(keyPairForCreate);
			returnType(KeyPair.class);
		}

	}

	public static class DeleteKeyPair extends OpenStackRequest {

		private String name;

		public DeleteKeyPair(String name) {
			method(HttpMethod.DELETE);
			path("/os-keypairs").path(name);
			header("Accept", "application/json");
		}

	}

	public static class ListKeyPairs extends OpenStackRequest {

		public ListKeyPairs() {
			method(HttpMethod.GET);
			path("/os-keypairs");
			header("Accept", "application/json");
			returnType(KeyPairs.class);
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
