package org.openstack.client.compute;

import java.util.HashMap;

import javax.ws.rs.client.Entity;

import org.openstack.client.OpenStackComputeClient;
import org.openstack.model.compute.NovaKeyPair;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITKeyPairs extends ComputeApiTest {

	@Test
	public void testListKeypairs() throws OpenstackException {
		skipIfNoKeyPairs();

		
		Iterable<NovaKeyPair> keyPairs = client.compute().publicEndpoint().keyPairs().get(new HashMap<String, Object>());
		for (NovaKeyPair keyPair : keyPairs) {
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

	private void assertKeyPairEquals(NovaKeyPair actual, NovaKeyPair expected) {
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getFingerprint(), expected.getFingerprint());
		Assert.assertEquals(actual.getPublicKey(), expected.getPublicKey());
	}

	private void testCreateAndDelete(String name) {
		
		NovaKeyPair createRequest = new NovaKeyPair();
		createRequest.setName(name);

		NovaKeyPair created = client.compute().publicEndpoint().keyPairs().post(new HashMap<String, Object>(), Entity.xml(createRequest));
		Assert.assertEquals(created.getName(), name);
		Assert.assertNotNull(created.getPublicKey());
		Assert.assertNotNull(created.getFingerprint());

		NovaKeyPair fetched = findKeyPair(client.compute(), created.getName());
		assertKeyPairEquals(fetched, created);

		// Delete the keypair
		client.compute().publicEndpoint().keyPairs().keypair(created.getName()).delete();

		fetched = findKeyPair(client.compute(), created.getName());

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

	@Test
	public void testHardName1() throws OpenstackException {
		skipIfNoKeyPairs();

		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "{JSB";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName2() throws OpenstackException {
		skipIfNoKeyPairs();

		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "'JSB";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName3() throws OpenstackException {
		skipIfNoKeyPairs();

		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "F ZZ";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName4() throws OpenstackException {
		skipIfNoKeyPairs();

		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = ">JSB";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName5() throws OpenstackException {
		skipIfNoKeyPairs();

		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "J/SB";

		testCreateAndDelete(name);
	}

	@Test
	public void testHardName6() throws OpenstackException {
		skipIfNoKeyPairs();

		// Problems with difficult names reported as bug #937408
		skipUntilBugFixed(937408);

		String name = "J~SB";

		testCreateAndDelete(name);
	}

	private NovaKeyPair findKeyPair(OpenStackComputeClient nova, String name) {
		for (NovaKeyPair keyPair : nova.publicEndpoint().keyPairs().get(new HashMap<String, Object>())) {
			if (keyPair.getName().equals(name))
				return keyPair;
		}
		return null;
	}

}
