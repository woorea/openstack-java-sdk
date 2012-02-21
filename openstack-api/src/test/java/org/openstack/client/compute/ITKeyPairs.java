package org.openstack.client.compute;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.KeyPair;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITKeyPairs extends ComputeApiTest {

	@Test
	public void testListKeypairs() throws OpenstackException {
		OpenstackComputeClient nova = getComputeClient();
		Iterable<KeyPair> keyPairs = nova.root().keyPairs().list();
		for (KeyPair keyPair : keyPairs) {
			Assert.assertNotNull(keyPair.getName());
			Assert.assertNotNull(keyPair.getFingerprint());
			Assert.assertNotNull(keyPair.getPublicKey());
		}
	}

	/*
	@Test
	public void deleteAllKeypairs() throws OpenstackException {
		OpenstackComputeClient nova = getComputeClient();
		Iterable<KeyPair> keyPairs = nova.root().keyPairs().list();
		for (KeyPair keyPair : keyPairs) {
			try {
				nova.root().keyPairs().keypair(keyPair.getName()).delete();
			} catch (Exception e) {

			}
		}
	}
	*/

	private void assertKeyPairEquals(KeyPair actual, KeyPair expected) {
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getFingerprint(), expected.getFingerprint());
		Assert.assertEquals(actual.getPublicKey(), expected.getPublicKey());
	}

	private void testCreateAndDelete(String name) {
		OpenstackComputeClient nova = getComputeClient();
		KeyPair createRequest = new KeyPair();
		createRequest.setName(name);

		KeyPair created = nova.root().keyPairs().create(createRequest);
		Assert.assertEquals(created.getName(), name);
		Assert.assertNotNull(created.getPublicKey());
		Assert.assertNotNull(created.getFingerprint());

		KeyPair fetched = findKeyPair(nova, created.getName());
		assertKeyPairEquals(fetched, created);

		// Delete the keypair
		nova.root().keyPairs().keypair(created.getName()).delete();

		fetched = findKeyPair(nova, created.getName());

		Assert.assertNull(fetched);
	}

	@Test
	public void testCreateAndDelete() throws OpenstackException {
		// OSAPI-BUG: I think an full-ascii name is often undeletable
		// String name = random.randomAsciiString(1, 10).trim();
		String name = random.randomAlphanumericString(1, 12).trim();

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName1() throws OpenstackException {
		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "{JSB";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName2() throws OpenstackException {
		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "'JSB";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName3() throws OpenstackException {
		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "F ZZ";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName4() throws OpenstackException {
		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = ">JSB";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName5() throws OpenstackException {
		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "J/SB";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName6() throws OpenstackException {
		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "J~SB";

		testCreateAndDelete(name);
	}

	private KeyPair findKeyPair(OpenstackComputeClient nova, String name) {
		for (KeyPair keyPair : nova.root().keyPairs().list()) {
			if (keyPair.getName().equals(name))
				return keyPair;
		}
		return null;
	}

}
