package org.openstack.client.compute;

import java.util.Set;

import org.openstack.client.OpenstackException;
import org.openstack.client.OpenstackNotFoundException;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Sets;

public class ITSecurityGroups extends ComputeApiTest {

	@Test
	public void testListSecurityGroups() throws OpenstackException {
		OpenstackComputeClient nova = getComputeClient();
		SecurityGroupList securityGroups = nova.root().securityGroups().list();
		for (SecurityGroup securityGroup : securityGroups) {
			SecurityGroup details = nova.root().securityGroups().securityGroup(securityGroup.getId()).show();

			assertSecurityGroupEquals(securityGroup, details);
		}
	}

	private void assertSecurityGroupEquals(SecurityGroup actual, SecurityGroup expected) {
		Assert.assertEquals(actual.getId(), expected.getId());
		Assert.assertEquals(actual.getTenantId(), expected.getTenantId());
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getDescription(), expected.getDescription());
	}

	@Test(expectedExceptions = { OpenstackNotFoundException.class })
	public void testNonExistentSecurityGroup() throws OpenstackException {
		OpenstackComputeClient nova = getComputeClient();

		Set<Integer> ids = Sets.newHashSet();
		for (SecurityGroup securityGroup : nova.root().securityGroups().list()) {
			ids.add(securityGroup.getId());
		}

		int unused;
		while (true) {
			unused = random.uniform(1, Integer.MAX_VALUE);
			if (!ids.contains(unused)) {
				break;
			}
		}

		nova.root().securityGroups().securityGroup(unused).show();
	}

	@Test
	public void testCreateAndDelete() throws OpenstackException {
		OpenstackComputeClient nova = getComputeClient();

		String groupName = random.randomAsciiString(1, 128);
		String description = random.randomAsciiString(1, 255);

		SecurityGroup createRequest = new SecurityGroup();
		createRequest.setName(groupName);
		createRequest.setDescription(description);

		SecurityGroup created = nova.root().securityGroups().create(createRequest);
		Assert.assertEquals(created.getName(), groupName);
		Assert.assertEquals(created.getDescription(), description);
		Assert.assertNotNull(created.getId());
		Assert.assertNotEquals(created.getId(), 0);

		SecurityGroup fetched = nova.root().securityGroups().securityGroup(created.getId()).show();
		assertSecurityGroupEquals(fetched, created);

		nova.root().securityGroups().securityGroup(created.getId()).delete();

		fetched = null;
		try {
			fetched = nova.root().securityGroups().securityGroup(created.getId()).show();
		} catch (OpenstackNotFoundException e) {
			// Expected; leave fetched as null
		}

		Assert.assertNull(fetched);
	}

	/**
	 * Description is limited to 255 chars
	 */
	@Test(expectedExceptions = { OpenstackException.class })
	public void testBigDescriptionFails() throws OpenstackException {
		OpenstackComputeClient nova = getComputeClient();

		String description = random.randomAsciiString(500);
		String groupName = random.randomAsciiString(1, 128);

		SecurityGroup createRequest = new SecurityGroup();
		createRequest.setName(groupName);
		createRequest.setDescription(description);

		// Should fail because description is too long
		Assert.assertTrue(description.length() > 255);
		nova.root().securityGroups().create(createRequest);
	}

}
