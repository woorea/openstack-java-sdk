package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.SecurityGroup;
import org.openstack.nova.model.SecurityGroupForCreate;
import org.openstack.nova.model.SecurityGroupRuleForCreate;
import org.openstack.nova.model.SecurityGroups;

public class SecurityGroupsExtension {
	
	public static class ListSecurityGroups implements NovaCommand<SecurityGroups>{

		@Override
		public SecurityGroups execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-security-groups");
		    request.header("Accept", "application/json");
		    return connector.execute(request, SecurityGroups.class);
		}

	}

	public static class CreateSecurityGroup implements NovaCommand<SecurityGroup> {

		private SecurityGroupForCreate securityGroupForCreate;
		
		public CreateSecurityGroup(SecurityGroupForCreate securityGroupForCreate) {
			this.securityGroupForCreate = securityGroupForCreate;
		}

		@Override
		public SecurityGroup execute(OpenStackClientConnector connector, OpenStackRequest request) {
			//return target.path("os-security-groups").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupForCreate), SecurityGroup.class);
			return null;
		}
		
	}
	
	public static class ShowSecurityGroup implements NovaCommand<SecurityGroup> {

		private Integer id;
		
		public ShowSecurityGroup(Integer id) {
			this.id = id;
		}

		@Override
		public SecurityGroup execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-security-groups").path("id");
		    request.header("Accept", "application/json");
		    return connector.execute(request, SecurityGroup.class);
		}
		
	}
	
	public static class DeleteSecurityGroup implements NovaCommand<Void> {

		private Integer id;
		
		public DeleteSecurityGroup(Integer id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-security-groups").path(String.valueOf(id));
		    request.header("Accept", "application/json");
		    connector.execute(request);
			return null;
		}
		
	}
	
	public static class CreateSecurityGroupRule implements NovaCommand<SecurityGroup.Rule> {

		private SecurityGroupRuleForCreate securityGroupRuleForCreate;
		
		public CreateSecurityGroupRule(SecurityGroupRuleForCreate securityGroupRuleForCreate) {
			this.securityGroupRuleForCreate = securityGroupRuleForCreate;
		}

		@Override
		public SecurityGroup.Rule execute(OpenStackClientConnector connector, OpenStackRequest request) {
			return null;
			//return target.path("os-security-group-rules").request(MediaType.APPLICATION_JSON).post(Entity.json(securityGroupRuleForCreate), SecurityGroup.Rule.class);
		}
		
	}
	
	public static class DeleteSecurityGroupRule implements NovaCommand<Void> {

		private Integer id;
		
		public DeleteSecurityGroupRule(Integer id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			//target.path("os-security-group-rules").path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).delete();
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
