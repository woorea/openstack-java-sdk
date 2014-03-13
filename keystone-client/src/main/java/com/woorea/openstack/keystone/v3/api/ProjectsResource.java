package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Users;
import com.woorea.openstack.keystone.v3.model.Project;
import com.woorea.openstack.keystone.v3.model.Projects;

public class ProjectsResource extends GenericResource<Project, Projects> {

	public ProjectsResource(OpenStackClient client) {
		super(client, "/projects", Project.class, Projects.class);
	}
	
	public OpenStackRequest<Users> users(String projectId) {
		return CLIENT.get(new StringBuilder(path).append("/").append(projectId).append("/users/").toString(), Users.class);
	}
	
	public DomainUserRolesResource userRoles(String projectId, String userId) {
		return new DomainUserRolesResource(CLIENT, new StringBuilder(path).append("/").append(projectId).append("/users/").append(userId).append("/roles").toString());
	}
	
	public DomainUserRolesResource groupRoles(String projectId, String groupId) {
		return new DomainUserRolesResource(CLIENT, new StringBuilder(path).append("/").append(projectId).append("/groups/").append(groupId).append("/roles").toString());
	}

}
