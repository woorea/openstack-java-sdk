package org.openstack.client.compute;

import java.util.HashMap;
import java.util.Set;

import javax.ws.rs.client.Entity;

import org.openstack.client.OpenStackComputeClient;
import org.openstack.model.compute.NovaCreateSecurityGroupRuleRequest;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;
import org.openstack.model.compute.NovaSecurityGroupRule;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.common.collect.Sets;

public class ITSecurityGroups extends ComputeApiTest {

	@Test
	public void testListSecurityGroups() throws OpenstackException {
		skipIfNoSecurityGroups();

		
		NovaSecurityGroupList securityGroups = client.compute().publicEndpoint().securityGroups().get(new HashMap<String, Object>());
		for (NovaSecurityGroup securityGroup : securityGroups) {
			NovaSecurityGroup details = client.compute().publicEndpoint().securityGroups().securityGroup(securityGroup.getId()).get(new HashMap<String, Object>());

			assertSecurityGroupEquals(securityGroup, details);
		}
	}

	private void assertSecurityGroupEquals(NovaSecurityGroup actual, NovaSecurityGroup expected) {
		Assert.assertEquals(actual.getId(), expected.getId());
		Assert.assertEquals(actual.getTenantId(), expected.getTenantId());
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getDescription(), expected.getDescription());
	}

	@Test(expectedExceptions = { OpenstackNotFoundException.class, SkipException.class })
	public void testNonExistentSecurityGroup() throws OpenstackException {
		skipIfNoSecurityGroups();

		

		Set<Integer> ids = Sets.newHashSet();
		for (NovaSecurityGroup securityGroup : client.compute().publicEndpoint().securityGroups().get(new HashMap<String, Object>())) {
			ids.add(securityGroup.getId());
		}

		int unused;
		while (true) {
			unused = random.uniform(1, Integer.MAX_VALUE);
			if (!ids.contains(unused)) {
				break;
			}
		}

		client.compute().publicEndpoint().securityGroups().securityGroup(unused).get(new HashMap<String, Object>());
	}

	@Test
	public void testCreateAndDelete() throws OpenstackException {
		skipIfNoSecurityGroups();

		

		String groupName = random.randomAlphanumericString(1, 128).trim();
		String description = random.randomAlphanumericString(1, 255).trim();

		NovaSecurityGroup createRequest = new NovaSecurityGroup();
		createRequest.setName(groupName);
		createRequest.setDescription(description);

		NovaSecurityGroup created = client.compute().publicEndpoint().securityGroups().post(Entity.json(createRequest), new HashMap<String, Object>());
		Assert.assertEquals(created.getName(), groupName);
		Assert.assertEquals(created.getDescription(), description);
		Assert.assertNotNull(created.getId());
		Assert.assertNotEquals(created.getId(), 0);

		NovaSecurityGroup fetched = client.compute().publicEndpoint().securityGroups().securityGroup(created.getId()).get(new HashMap<String, Object>());
		assertSecurityGroupEquals(fetched, created);

		Assert.assertEquals(fetched.getRules().size(), 0);

		// Create a rule
		{
			NovaCreateSecurityGroupRuleRequest newRule = new NovaCreateSecurityGroupRuleRequest();
			newRule.setCidr("1.2.3.4/32");
			newRule.setFromPort(1234);
			newRule.setToPort(5678);
			newRule.setIpProtocol("tcp");
			newRule.setParentGroupId(created.getId());

			NovaSecurityGroupRule createdRule = client.compute().publicEndpoint().securityGroupRules().post(new HashMap<String, Object>(), Entity.xml(newRule));
			Assert.assertNotEquals(createdRule.id, "");

			fetched = client.compute().publicEndpoint().securityGroups().securityGroup(created.getId()).get(new HashMap<String, Object>());
			assertSecurityGroupEquals(fetched, created);

			Assert.assertEquals(fetched.getRules().size(), 1);
			NovaSecurityGroupRule rule = fetched.getRules().get(0);
			assertSecurityGroupRuleEquals(newRule, rule);

			// // List the rules directly
			// {
			// SecurityGroupRule found = nova.root().securityGroupRules().securityGroupRule(createdRule.id).fetch();
			// assertSecurityGroupRuleEquals(newRule, found);
			// }
		}

		// Drop the rule
		{
			NovaSecurityGroupRule rule = fetched.getRules().get(0);
			client.compute().publicEndpoint().securityGroupRules().securityGroupRule(rule.id).delete(new HashMap<String, Object>());

			fetched = client.compute().publicEndpoint().securityGroups().securityGroup(created.getId()).get(new HashMap<String, Object>());
			Assert.assertEquals(fetched.getRules().size(), 0);
		}

		client.compute().publicEndpoint().securityGroups().securityGroup(created.getId()).delete(new HashMap<String, Object>());

		fetched = null;
		try {
			fetched = client.compute().publicEndpoint().securityGroups().securityGroup(created.getId()).get(new HashMap<String, Object>());
		} catch (OpenstackNotFoundException e) {
			// Expected; leave fetched as null
		}

		Assert.assertNull(fetched);
	}

	private void assertSecurityGroupRuleEquals(NovaCreateSecurityGroupRuleRequest newRule, NovaSecurityGroupRule rule) {
		Assert.assertEquals(rule.getFromPort(), newRule.getFromPort());
		Assert.assertEquals(rule.getToPort(), newRule.getToPort());
		Assert.assertEquals(rule.getIpProtocol(), newRule.getIpProtocol());
		Assert.assertEquals(rule.getIpRange().cidr, newRule.getCidr());
	}

	/**
	 * Description is limited to 255 chars
	 */
	@Test(expectedExceptions = { OpenstackException.class, SkipException.class })
	public void testBigDescriptionFails() throws OpenstackException {
		skipIfNoSecurityGroups();

		

		String description = random.randomAlphanumericString(500);
		String groupName = random.randomAlphanumericString(1, 128);

		NovaSecurityGroup createRequest = new NovaSecurityGroup();
		createRequest.setName(groupName);
		createRequest.setDescription(description);

		// Should fail because description is too long
		Assert.assertTrue(description.length() > 255);
		client.compute().publicEndpoint().securityGroups().post(Entity.json(createRequest), new HashMap<String, Object>());
	}

	@Test
	public void testDuplicateNameFails() throws OpenstackException {
		/*
		skipIfNoSecurityGroups();

		OpenstackComputeClient nova = getComputeClient();

		String groupName = random.randomAlphanumericString(1, 128).trim();
		String description = random.randomAlphanumericString(1, 255).trim();

		NovaSecurityGroup createRequest = new NovaSecurityGroup();
		createRequest.setName(groupName);
		createRequest.setDescription(description);

		NovaSecurityGroup created1 = nova.root().securityGroups().create(createRequest);
		Assert.assertNotNull(created1);

		try {
			NovaSecurityGroup created2 = nova.root().securityGroups().create(createRequest);
			Assert.fail();
		} catch (OpenstackException e) {
			// This would ideally be a better exception (different error code), but we can cope...
			Assert.assertTrue(e.getMessage().contains("already exists"), "Unexpected message: " + e.getMessage());
		}
		*/
	}

}
