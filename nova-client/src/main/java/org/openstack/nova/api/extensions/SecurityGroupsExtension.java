package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.SecurityGroup;
import org.openstack.nova.model.SecurityGroupForCreate;
import org.openstack.nova.model.SecurityGroupRuleForCreate;
import org.openstack.nova.model.SecurityGroups;

public class SecurityGroupsExtension {

	public static class ListSecurityGroups extends OpenStackRequest {

		public ListSecurityGroups() {
			OpenStackRequest request = new OpenStackRequest();
			method(HttpMethod.GET);
			path("/os-security-groups");
			header("Accept", "application/json");
			returnType(SecurityGroups.class);
		}

	}

	public static class CreateSecurityGroup extends OpenStackRequest {

		private SecurityGroupForCreate securityGroupForCreate;

		public CreateSecurityGroup(SecurityGroupForCreate securityGroupForCreate) {
			this.securityGroupForCreate = securityGroupForCreate;
			
			// return
			// target.path("os-security-groups").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupForCreate),
			// SecurityGroup.class);
		}

	}

	public static class ShowSecurityGroup extends OpenStackRequest {

		public ShowSecurityGroup(Integer id) {
			method(HttpMethod.GET);
			path("/os-security-groups").path("id");
			header("Accept", "application/json");
			returnType(SecurityGroup.class);
		}

	}

	public static class DeleteSecurityGroup extends OpenStackRequest {

		public DeleteSecurityGroup(Integer id) {
			method(HttpMethod.DELETE);
			path("/os-security-groups").path(String.valueOf(id));
			header("Accept", "application/json");
		}

	}

	public static class CreateSecurityGroupRule extends OpenStackRequest {

		private SecurityGroupRuleForCreate securityGroupRuleForCreate;

		public CreateSecurityGroupRule(
				SecurityGroupRuleForCreate securityGroupRuleForCreate) {
			this.securityGroupRuleForCreate = securityGroupRuleForCreate;
			// return
						// target.path("os-security-group-rules").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupRuleForCreate),
						// SecurityGroup.Rule.class);
		}
	}

	public static class DeleteSecurityGroupRule extends OpenStackRequest {

		public DeleteSecurityGroupRule(Integer id) {
			// target.path("os-security-group-rules").path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).delete();
		}
	}

	public static ListSecurityGroups listSecurityGroups() {
		return new ListSecurityGroups();
	}

	public static CreateSecurityGroup createSecurityGroup(String name,
			String description) {
		return new CreateSecurityGroup(new SecurityGroupForCreate(name,
				description));
	}

	public static CreateSecurityGroup createSecurityGroup(String name) {
		return createSecurityGroup(name, null);
	}

	public static ShowSecurityGroup showSecurityGroup(Integer id) {
		return new ShowSecurityGroup(id);
	}

	public static DeleteSecurityGroup deleteSecurityGroup(Integer id) {
		return new DeleteSecurityGroup(id);
	}

	public static CreateSecurityGroupRule createSecurityGroupRule(
			Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,
			Integer toPort, String cidr) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(
				parentSecurityGroupId, ipProtocol, fromPort, toPort, cidr);
		return new CreateSecurityGroupRule(securityGroupRuleForCreate);
	}

	public static CreateSecurityGroupRule createSecurityGroupRule(
			Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,
			Integer toPort, Integer sourceGroupId) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(
				parentSecurityGroupId, ipProtocol, fromPort, toPort,
				sourceGroupId);
		return new CreateSecurityGroupRule(securityGroupRuleForCreate);
	}

	public static DeleteSecurityGroupRule deleteSecurityGroupRule(Integer id) {
		return new DeleteSecurityGroupRule(id);
	}

}
