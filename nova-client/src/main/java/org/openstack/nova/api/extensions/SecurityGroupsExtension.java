package org.openstack.nova.api.extensions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.SecurityGroup;
import org.openstack.nova.model.SecurityGroupForCreate;
import org.openstack.nova.model.SecurityGroupRuleForCreate;
import org.openstack.nova.model.SecurityGroups;

public class SecurityGroupsExtension {
	
	public static class ListSecurityGroups implements NovaCommand<SecurityGroups>{

		@Override
		public SecurityGroups execute(WebTarget target) {
			return target.path("os-security-groups").request(MediaType.APPLICATION_JSON).get(SecurityGroups.class);
		}

	}

	public static class CreateSecurityGroup implements NovaCommand<SecurityGroup> {

		private SecurityGroupForCreate securityGroupForCreate;
		
		public CreateSecurityGroup(SecurityGroupForCreate securityGroupForCreate) {
			this.securityGroupForCreate = securityGroupForCreate;
		}

		@Override
		public SecurityGroup execute(WebTarget target) {
			return target.path("os-security-groups").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupForCreate), SecurityGroup.class);
		}
		
	}
	
	public static class ShowSecurityGroup implements NovaCommand<SecurityGroup> {

		private Integer id;
		
		public ShowSecurityGroup(Integer id) {
			this.id = id;
		}

		@Override
		public SecurityGroup execute(WebTarget target) {
			return target.path("os-security-groups").path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).get(SecurityGroup.class);
		}
		
	}
	
	public static class DeleteSecurityGroup implements NovaCommand<Void> {

		private Integer id;
		
		public DeleteSecurityGroup(Integer id) {
			this.id = id;
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("os-security-groups").path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).delete();
			return null;
		}
		
	}
	
	public static class CreateSecurityGroupRule implements NovaCommand<SecurityGroup.Rule> {

		private SecurityGroupRuleForCreate securityGroupRuleForCreate;
		
		public CreateSecurityGroupRule(SecurityGroupRuleForCreate securityGroupRuleForCreate) {
			this.securityGroupRuleForCreate = securityGroupRuleForCreate;
		}

		@Override
		public SecurityGroup.Rule execute(WebTarget target) {
			return target.path("os-security-group-rules").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupRuleForCreate), SecurityGroup.Rule.class);
		}
		
	}
	
	public static class DeleteSecurityGroupRule implements NovaCommand<Void> {

		private Integer id;
		
		public DeleteSecurityGroupRule(Integer id) {
			this.id = id;
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("os-security-groups").path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).delete();
			return null;
		}
		
	}
	
	public static ListSecurityGroups listSecurityGroups() {
		return new ListSecurityGroups();
	}
	
	public static CreateSecurityGroup createSecurityGroup(String name, String description) {
		return new CreateSecurityGroup(new SecurityGroupForCreate(name, description));
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
	
	public static CreateSecurityGroupRule createSecurityGroupRule(Integer parentSecurityGroupId, String ipProtocol, Integer fromPort, Integer toPort, String cidr) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(parentSecurityGroupId, ipProtocol, fromPort, toPort, cidr);
		return new CreateSecurityGroupRule(securityGroupRuleForCreate);
	}
	
	public static CreateSecurityGroupRule createSecurityGroupRule(Integer parentSecurityGroupId, String ipProtocol, Integer fromPort, Integer toPort, Integer sourceGroupId) {
		SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate(parentSecurityGroupId, ipProtocol, fromPort, toPort, sourceGroupId);
		return new CreateSecurityGroupRule(securityGroupRuleForCreate);
	}
	
	public static DeleteSecurityGroupRule deleteSecurityGroupRule(Integer id) {
		return new DeleteSecurityGroupRule(id);
	}

}
