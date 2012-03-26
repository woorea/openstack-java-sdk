package org.openstack.client.compute;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.InvocationException;

import org.openstack.model.compute.NovaCreateSecurityGroupRuleRequest;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;
import org.openstack.model.compute.NovaSecurityGroupRule;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITSecurityGroups extends ComputeIntegrationTest {

	@Test
	public void testListSecurityGroups() throws OpenstackException {
		skipIfNoSecurityGroups();

		
		NovaSecurityGroupList securityGroups = compute.securityGroups().get();
		for (NovaSecurityGroup securityGroup : securityGroups) {
			NovaSecurityGroup details = compute.securityGroups().securityGroup(securityGroup.getId()).get();

			assertSecurityGroupEquals(securityGroup, details);
		}
	}

	@Test
	public void testCreateAndDelete() throws OpenstackException {
		skipIfNoSecurityGroups();

		

		String groupName = random.randomAlphanumericString(1, 128).trim();
		String description = random.randomAlphanumericString(1, 255).trim();

		NovaSecurityGroup createRequest = new NovaSecurityGroup();
		createRequest.setName(groupName);
		createRequest.setDescription(description);

		NovaSecurityGroup created = compute.securityGroups().post(Entity.json(createRequest));
		Assert.assertEquals(created.getName(), groupName);
		Assert.assertEquals(created.getDescription(), description);
		Assert.assertNotNull(created.getId());
		Assert.assertNotEquals(created.getId(), 0);

		NovaSecurityGroup fetched = compute.securityGroups().securityGroup(created.getId()).get();
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

			NovaSecurityGroupRule createdRule = compute.securityGroupRules().post(Entity.xml(newRule));
			Assert.assertNotEquals(createdRule.id, "");

			fetched = compute.securityGroups().securityGroup(created.getId()).get();
			assertSecurityGroupEquals(fetched, created);

			Assert.assertEquals(fetched.getRules().size(), 1);
			NovaSecurityGroupRule rule = fetched.getRules().get(0);
			assertSecurityGroupRuleEquals(newRule, rule);

			// List the rules directly
			{
			//NovaSecurityGroupRule found = client.compute().publicEndpoint().securityGroupRules().securityGroupRule(createdRule.id).get();
			//assertSecurityGroupRuleEquals(newRule, found);
			}
		}

		// Drop the rule
		{
			NovaSecurityGroupRule rule = fetched.getRules().get(0);
			compute.securityGroupRules().securityGroupRule(rule.id).delete();

			fetched = compute.securityGroups().securityGroup(created.getId()).get();
			Assert.assertEquals(fetched.getRules().size(), 0);
		}

		compute.securityGroups().securityGroup(created.getId()).delete();

		fetched = null;
		try {
			fetched = compute.securityGroups().securityGroup(created.getId()).get();
		} catch (InvocationException e) {
			// Expected; leave fetched as null
		}

		Assert.assertNull(fetched);
	}
	
	private void assertSecurityGroupEquals(NovaSecurityGroup actual, NovaSecurityGroup expected) {
		Assert.assertEquals(actual.getId(), expected.getId());
		Assert.assertEquals(actual.getTenantId(), expected.getTenantId());
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getDescription(), expected.getDescription());
	}

	private void assertSecurityGroupRuleEquals(NovaCreateSecurityGroupRuleRequest newRule, NovaSecurityGroupRule rule) {
		Assert.assertEquals(rule.getFromPort(), newRule.getFromPort());
		Assert.assertEquals(rule.getToPort(), newRule.getToPort());
		Assert.assertEquals(rule.getIpProtocol(), newRule.getIpProtocol());
		Assert.assertEquals(rule.getIpRange().cidr, newRule.getCidr());
	}

}
