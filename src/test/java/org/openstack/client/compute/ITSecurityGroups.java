package org.openstack.client.compute;

import javax.ws.rs.client.InvocationException;

import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupForCreate;
import org.openstack.model.compute.SecurityGroupRule;
import org.openstack.model.compute.SecurityGroupRuleForCreate;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupForCreate;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRuleForCreate;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroup;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITSecurityGroups extends ComputeIntegrationTest {

	@Test
	public void testListSecurityGroups() throws OpenstackException {
		skipIfNoSecurityGroups();

		for (SecurityGroup securityGroup : compute.securityGroups().get().getList()) {
			SecurityGroup details = compute.securityGroups().securityGroup(securityGroup.getId()).get();

			assertSecurityGroupEquals(securityGroup, details);
		}
	}

	@Test
	public void testCreateAndDelete() throws OpenstackException {
		skipIfNoSecurityGroups();

		

		String groupName = random.randomAlphanumericString(1, 128).trim();
		String description = random.randomAlphanumericString(1, 255).trim();

		SecurityGroupForCreate createRequest = new NovaSecurityGroupForCreate();
		createRequest.setName(groupName);
		createRequest.setDescription(description);

		SecurityGroup created = compute.securityGroups().post(createRequest);
		Assert.assertEquals(created.getName(), groupName);
		Assert.assertEquals(created.getDescription(), description);
		Assert.assertNotNull(created.getId());
		Assert.assertNotEquals(created.getId(), 0);

		SecurityGroup fetched = compute.securityGroups().securityGroup(created.getId()).get();
		assertSecurityGroupEquals(fetched, created);

		Assert.assertEquals(fetched.getRules().size(), 0);

		// Create a rule
		{
			NovaSecurityGroupRuleForCreate newRule = new NovaSecurityGroupRuleForCreate();
			newRule.setCidr("1.2.3.4/32");
			newRule.setFromPort(1234);
			newRule.setToPort(5678);
			newRule.setIpProtocol("tcp");
			newRule.setParentGroupId(created.getId());
			//newRule.setGroupId(created.getId());

			SecurityGroupRule createdRule = compute.securityGroupRules().post(newRule);
			Assert.assertNotNull(createdRule.getId());

			fetched = compute.securityGroups().securityGroup(created.getId()).get();
			assertSecurityGroupEquals(fetched, created);

			Assert.assertEquals(fetched.getRules().size(), 1);
			SecurityGroupRule rule = fetched.getRules().get(0);
			assertSecurityGroupRuleEquals(newRule, rule);

			// List the rules directly
			{
			//NovaSecurityGroupRule found = client.compute().publicEndpoint().securityGroupRules().securityGroupRule(createdRule.id).get();
			//assertSecurityGroupRuleEquals(newRule, found);
			}
		}

		// Drop the rule
		{
			SecurityGroupRule rule = fetched.getRules().get(0);
			compute.securityGroupRules().rule(rule.getId()).delete();

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
	
	private void assertSecurityGroupEquals(SecurityGroup actual, SecurityGroup expected) {
		Assert.assertEquals(actual.getId(), expected.getId());
		Assert.assertEquals(actual.getTenantId(), expected.getTenantId());
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getDescription(), expected.getDescription());
	}

	private void assertSecurityGroupRuleEquals(SecurityGroupRuleForCreate newRule, SecurityGroupRule rule) {
		Assert.assertEquals(rule.getFromPort(), newRule.getFromPort());
		Assert.assertEquals(rule.getToPort(), newRule.getToPort());
		Assert.assertEquals(rule.getIpProtocol(), newRule.getIpProtocol());
		Assert.assertEquals(rule.getIpRange().cidr, newRule.getCidr());
	}

}
