package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.SecurityGroup;
import org.openstack.nova.model.SecurityGroupForCreate;
import org.openstack.nova.model.SecurityGroupRuleForCreate;
import org.openstack.nova.model.SecurityGroups;

public class SecurityGroupsExtension {

	public static class List extends OpenStackRequest {

		public List() {
			OpenStackRequest request = new OpenStackRequest();
			method(HttpMethod.GET);
			path("/os-security-groups");
			header("Accept", "application/json");
			returnType(SecurityGroups.class);
		}

	}

	public static class Create extends OpenStackRequest {

		private SecurityGroupForCreate securityGroupForCreate;

		public Create(SecurityGroupForCreate securityGroupForCreate) {
			this.securityGroupForCreate = securityGroupForCreate;
			
			// return
			// target.path("os-security-groups").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupForCreate),
			// SecurityGroup.class);
		}

	}

	public static class Show extends OpenStackRequest {

		public Show(Integer id) {
			method(HttpMethod.GET);
			path("/os-security-groups").path("id");
			header("Accept", "application/json");
			returnType(SecurityGroup.class);
		}

	}

	public static class Delete extends OpenStackRequest {

		public Delete(Integer id) {
			method(HttpMethod.DELETE);
			path("/os-security-groups").path(String.valueOf(id));
			header("Accept", "application/json");
		}

	}

	public static class CreateRule extends OpenStackRequest {

		private SecurityGroupRuleForCreate securityGroupRuleForCreate;

		public CreateRule(
				SecurityGroupRuleForCreate securityGroupRuleForCreate) {
			this.securityGroupRuleForCreate = securityGroupRuleForCreate;
			// return
						// target.path("os-security-group-rules").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupRuleForCreate),
						// SecurityGroup.Rule.class);
		}
	}

	public static class DeleteRule extends OpenStackRequest {

		public DeleteRule(Integer id) {
			// target.path("os-security-group-rules").path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).delete();
		}
	}

	public static List listSecurityGroups() {
		return new List();
	}

	public static Create createSecurityGroup(String name,
			String description) {
		return new Create(new SecurityGroupForCreate(name,
				description));
	}

	public static Create createSecurityGroup(String name) {
		return createSecurityGroup(name, null);
	}

	public static Show showSecurityGroup(Integer id) {
		return new Show(id);
	}

	public static Delete deleteSecurityGroup(Integer id) {
		return new Delete(id);
	}

	public static CreateRule createSecurityGroupRule(
			Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,
			Integer toPort, String cidr) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(
				parentSecurityGroupId, ipProtocol, fromPort, toPort, cidr);
		return new CreateRule(securityGroupRuleForCreate);
	}

	public static CreateRule createSecurityGroupRule(
			Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,
			Integer toPort, Integer sourceGroupId) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(
				parentSecurityGroupId, ipProtocol, fromPort, toPort,
				sourceGroupId);
		return new CreateRule(securityGroupRuleForCreate);
	}

	public static DeleteRule deleteSecurityGroupRule(Integer id) {
		return new DeleteRule(id);
	}

}
