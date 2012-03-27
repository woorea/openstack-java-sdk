package org.openstack.client.compute;

import javax.ws.rs.client.Entity;

import org.openstack.api.compute.TenantResource;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairList;
import org.openstack.model.compute.KeyPairListItem;
import org.openstack.model.compute.nova.keypair.NovaKeyPair;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITKeyPairs extends ComputeIntegrationTest {

	@Test
	public void testListKeypairs() throws OpenstackException {
		skipIfNoKeyPairs();
		
		for (KeyPairListItem keyPairItem : compute.keyPairs().get().getList()) {
			KeyPair keyPair = keyPairItem.getKeypair();
			Assert.assertNotNull(keyPair.getName());
			Assert.assertNotNull(keyPair.getFingerprint());
			Assert.assertNotNull(keyPair.getPublicKey());
		}
	}

	@Test
	public void deleteAllKeypairs() throws OpenstackException {
		
		for (KeyPairListItem keyPair : compute.keyPairs().get().getList()) {
			try {
				compute.keyPairs().keypair(keyPair.getKeypair().getName()).delete();
			} catch (Exception e) {

			}
		}
	}

	private void assertKeyPairEquals(KeyPair actual, KeyPair expected) {
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getFingerprint(), expected.getFingerprint());
		Assert.assertEquals(actual.getPublicKey(), expected.getPublicKey());
	}

	private void testCreateAndDelete(String name) {
		
		NovaKeyPair createRequest = new NovaKeyPair();
		createRequest.setName(name);

		KeyPair created = compute.keyPairs().post(Entity.json(createRequest));
		Assert.assertEquals(created.getName(), name);
		Assert.assertNotNull(created.getPublicKey());
		Assert.assertNotNull(created.getFingerprint());

		KeyPair fetched = findKeyPair(compute, created.getName());
		assertKeyPairEquals(fetched, created);

		// Delete the keypair
		compute.keyPairs().keypair(created.getName()).delete();

		fetched = findKeyPair(compute, created.getName());

		Assert.assertNull(fetched);
	}

	@Test
	public void testCreateAndDelete() throws OpenstackException {
		skipIfNoKeyPairs();

		// OSAPI-BUG: I think an full-ascii name is often undeletable
		// String name = random.randomAsciiString(1, 10).trim();
		String name = random.randomAlphanumericString(1, 12).trim();

		testCreateAndDelete(name);
	}

	private KeyPair findKeyPair(TenantResource nova, String name) {
		for (KeyPairListItem keyPair : nova.keyPairs().get().getList()) {
			if (keyPair.getKeypair().getName().equals(name))
				return keyPair.getKeypair();
		}
		return null;
	}

}
