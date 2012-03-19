//package org.openstack.api.storage;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.Target;
//
//import org.openstack.api.common.Resource;
//import org.openstack.client.OpenStackSession;
//import org.openstack.model.storage.SwiftAccount;
//
//public class AccountResource extends Resource {
//	
//	private AccountResource(Target target) {
//		super(target);
//	}
//
//	public AccountResource(OpenStackSession session, String resource) {
//		initialize(session, resource);
//	}
//
//	public SwiftAccount get() {
//		return target.request().get(SwiftAccount.class);
//	}
//
//	public ContainersResource containers() {
//		return target.request().get(ContainersResource.class);
//	}
//
//	public String getBaseUrl() {
//		return resource;
//	}
//
//	public static AccountResource endpoint(Client client, String endpoint) {
//		return new AccountResource(client.target(endpoint));
//	}
//
//}
