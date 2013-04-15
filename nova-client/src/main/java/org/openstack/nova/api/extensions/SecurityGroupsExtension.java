package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.SecurityGroup;
import org.openstack.nova.model.SecurityGroupForCreate;
import org.openstack.nova.model.SecurityGroupRuleForCreate;
import org.openstack.nova.model.SecurityGroups;

public class SecurityGroupsExtension {

	public static class ListSecurityGroups implements OpenStackCommand<SecurityGroups> {

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/os-security-groups");
			request.header("Accept", "application/json");
			request.returnType(SecurityGroups.class);
			return request;
		}

	}

	public static class CreateSecurityGroup implements OpenStackCommand<SecurityGroup> {

		private SecurityGroupForCreate securityGroupForCreate;

		public CreateSecurityGroup(SecurityGroupForCreate securityGroupForCreate) {
			this.securityGroupForCreate = securityGroupForCreate;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			// return
			// target.path("os-security-groups").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupForCreate),
			// SecurityGroup.class);
			return null;
		}

	}

	public static class ShowSecurityGroup implements OpenStackCommand<SecurityGroup> {

		private Integer id;

		public ShowSecurityGroup(Integer id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/os-security-groups").path("id");
			request.header("Accept", "application/json");
			request.returnType(SecurityGroup.class);
			return request;
		}

	}

	public static class DeleteSecurityGroup implements OpenStackCommand<Void> {

		private Integer id;

		public DeleteSecurityGroup(Integer id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/os-security-groups").path(String.valueOf(id));
			request.header("Accept", "application/json");

			return null;
		}

	}

	public static class CreateSecurityGroupRule implements OpenStackCommand<SecurityGroup.Rule> {

		private SecurityGroupRuleForCreate securityGroupRuleForCreate;

		public CreateSecurityGroupRule(
				SecurityGroupRuleForCreate securityGroupRuleForCreate) {
			this.securityGroupRuleForCreate = securityGroupRuleForCreate;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			return null;
			// return
			// target.path("os-security-group-rules").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupRuleForCreate),
			// SecurityGroup.Rule.class);
		}

	}

	public static class DeleteSecurityGroupRule implements OpenStackCommand<Void> {

		private Integer id;

		public DeleteSecurityGroupRule(Integer id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			// target.path("os-security-group-rules").path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).delete();
			return null;
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
