package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.SecurityGroup;
import com.woorea.openstack.nova.model.SecurityGroupForCreate;
import com.woorea.openstack.nova.model.SecurityGroupRuleForCreate;
import com.woorea.openstack.nova.model.SecurityGroups;

public class SecurityGroupsExtension {
	
	private final OpenStackClient CLIENT;
	
	public SecurityGroupsExtension(OpenStackClient client) {
		CLIENT = client;
	}

	public class List extends OpenStackRequest<SecurityGroups> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-security-groups", null, SecurityGroups.class);
		}

	}

	public class Create extends OpenStackRequest<SecurityGroup> {

		private SecurityGroupForCreate securityGroupForCreate;

		public Create(SecurityGroupForCreate securityGroupForCreate) {
			super(CLIENT, HttpMethod.POST, "/os-security-groups", Entity.json(securityGroupForCreate), SecurityGroup.class);
			this.securityGroupForCreate = securityGroupForCreate;
		}

	}

	public class Show extends OpenStackRequest<SecurityGroup> {

		/**
		 * @deprecated
		 * @param id
		 */
		public Show(Integer id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/os-security-groups/").append(id).toString(), null, SecurityGroup.class);
		}
		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/os-security-groups/").append(id).toString(), null, SecurityGroup.class);
		}

	}

	public class Delete extends OpenStackRequest<Void> {

		/**
		 * 
		 * @param id
		 * @deprecated
		 */
		public Delete(Integer id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-security-groups/").append(String.valueOf(id)).toString(), null, Void.class);
		}
		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-security-groups/").append(id).toString(), null, Void.class);
		}

	}

	public class CreateRule extends OpenStackRequest<SecurityGroup.Rule> {

		private SecurityGroupRuleForCreate securityGroupRuleForCreate;

		public CreateRule(SecurityGroupRuleForCreate securityGroupRuleForCreate) {
			super(CLIENT, HttpMethod.POST, "/os-security-group-rules", Entity.json(securityGroupRuleForCreate), SecurityGroup.Rule.class);
			this.securityGroupRuleForCreate = securityGroupRuleForCreate;
		}
	}

	public class DeleteRule extends OpenStackRequest<Void> {

		/**
		 * 
		 * @param id
		 * @deprecated
		 */
		public DeleteRule(Integer id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-security-group-rules/").append(String.valueOf(id)).toString(), null, Void.class);
		}
		
		public DeleteRule(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-security-group-rules/").append(String.valueOf(id)).toString(), null, Void.class);
		}
	}

	public List listSecurityGroups() {
		return new List();
	}

	public Create createSecurityGroup(String name,
			String description) {
		return new Create(new SecurityGroupForCreate(name, description));
	}

	public Create createSecurityGroup(String name) {
		return createSecurityGroup(name, null);
	}

	public Show showSecurityGroup(Integer id) {
		return new Show(String.valueOf(id));
	}
	
	public Show showSecurityGroup(String id) {
		return new Show(id);
	}
	public Delete deleteSecurityGroup(Integer id) {
		return new Delete(String.valueOf(id));
	}
	
	public Delete deleteSecurityGroup(String id) {
		return new Delete(id);
	}

	/**
	 * 
	 * @param parentSecurityGroupId
	 * @param ipProtocol
	 * @param fromPort
	 * @param toPort
	 * @param cidr
	 * @return
	 * @deprecated Use {@link #createSecurityGroupRule(String, String, Integer, Integer, String)}
	 */
	public CreateRule createSecurityGroupRule(
			Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,
			Integer toPort, String cidr) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(
				parentSecurityGroupId, ipProtocol, fromPort, toPort, cidr);
		return new CreateRule(securityGroupRuleForCreate);
	}
	/**
	 * 
	 * @param parentSecurityGroupId
	 * @param ipProtocol
	 * @param fromPort
	 * @param toPort
	 * @param cidr
	 * @return
	 * @deprecated Use {@link #createSecurityGroupRule(String, String, String, Integer, Integer)}
	 */
	public CreateRule createSecurityGroupRule(
			Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,
			Integer toPort, Integer sourceGroupId) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(
				parentSecurityGroupId, ipProtocol, fromPort, toPort,
				sourceGroupId);
		return new CreateRule(securityGroupRuleForCreate);
	}
	
	public CreateRule createSecurityGroupRule(
			String parentSecurityGroupId, String ipProtocol, Integer fromPort,
			Integer toPort, String cidr) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(
				parentSecurityGroupId, ipProtocol, fromPort, toPort, cidr);
		return new CreateRule(securityGroupRuleForCreate);
	}

	public CreateRule createSecurityGroupRule(
			String parentSecurityGroupId,String sourceGroupId,String ipProtocol, Integer fromPort,
			Integer toPort) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(
				parentSecurityGroupId, sourceGroupId,ipProtocol, fromPort, toPort
				);
		return new CreateRule(securityGroupRuleForCreate);
	}
	public DeleteRule deleteSecurityGroupRule(String id) {
		return new DeleteRule(id);
	}
	public DeleteRule deleteSecurityGroupRule(Integer id) {
		return new DeleteRule(String.valueOf(id));
	}

}
