package org.openstack.client.compute;

import javax.ws.rs.client.Entity;

import org.openstack.api.compute.TenantResource;
import org.openstack.model.compute.NovaKeyPair;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITKeyPairs extends ComputeIntegrationTest {

	@Test
	public void testListKeypairs() throws OpenstackException {
		skipIfNoKeyPairs();

		
		Iterable<NovaKeyPair> keyPairs = compute.keyPairs().get();
		for (NovaKeyPair keyPair : keyPairs) {
			Assert.assertNotNull(keyPair.getName());
			Assert.assertNotNull(keyPair.getFingerprint());
			Assert.assertNotNull(keyPair.getPublicKey());
		}
	}

	@Test
	public void deleteAllKeypairs() throws OpenstackException {
		
		Iterable<NovaKeyPair> keyPairs = compute.keyPairs().get();
		for (NovaKeyPair keyPair : keyPairs) {
			try {
				compute.keyPairs().keypair(keyPair.getName()).delete();
			} catch (Exception e) {

			}
		}
	}

	private void assertKeyPairEquals(NovaKeyPair actual, NovaKeyPair expected) {
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getFingerprint(), expected.getFingerprint());
		Assert.assertEquals(actual.getPublicKey(), expected.getPublicKey());
	}

	private void testCreateAndDelete(String name) {
		
		NovaKeyPair createRequest = new NovaKeyPair();
		createRequest.setName(name);

		NovaKeyPair created = compute.keyPairs().post(Entity.json(createRequest));
		Assert.assertEquals(created.getName(), name);
		Assert.assertNotNull(created.getPublicKey());
		Assert.assertNotNull(created.getFingerprint());

		NovaKeyPair fetched = findKeyPair(compute, created.getName());
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

	private NovaKeyPair findKeyPair(TenantResource nova, String name) {
		for (NovaKeyPair keyPair : nova.keyPairs().get()) {
			if (keyPair.getName().equals(name))
				return keyPair;
		}
		return null;
	}

}
