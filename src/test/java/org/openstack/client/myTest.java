package org.openstack.client;

import java.util.List;
import java.util.Properties;

import org.openstack.api.compute.ServerResource;
import org.openstack.api.compute.ServersResource;
import org.openstack.api.compute.TenantResource;
import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;
import org.openstack.model.compute.nova.NovaServerForCreate;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;


public class myTest {

	public static void main(String[] args) throws Exception {

		Properties properties = new Properties(); 
		
		properties.setProperty("verbose", "true");
		properties.setProperty("auth.endpoint", "http://172.16.118.91:5000/v2.0");
		properties.setProperty("auth.username", "demo");
		properties.setProperty("auth.password", "demo");
		properties.setProperty("auth.tenantName", "demo");

		properties.setProperty("identity.endpoint.adminURL","http://172.16.118.91:35357/v2.0");
		properties.setProperty("identity.endpoint.publicURL","http://172.16.118.91:35357/v2.0");
		//The admintoken (setted on keystone config file)
		properties.setProperty("identity.admin.token", "demo");

		OpenStackClient openstack = OpenStackClient.authenticate(properties);
		
		IdentityAdministrationEndpoint identity = openstack.getIdentityAdministationEndpoint();
		TenantList tenants = identity.tenants().get();
		List<Tenant> tenantsList = tenants.getList();
		for(Tenant t:tenantsList){
			System.out.println(t.getName() + " " + "  " + t.getId());
		}
		
		TenantResource tr = openstack.getComputeEndpoint();
		
		ImageList il = tr.images().get();
////	
		Image imageForCreate;
		String imageHref="";
		for(Image i:il){
			
			if(i.getName().equals("cirros-0.3.0-x86_64-uec")){
				System.out.println(i.getName());
				imageForCreate = i;
				Link link = i.getLink("self");
				imageHref = link.getHref();
				System.out.println(imageHref);
			}
		}
		
		//code
		
	
		ComputeClient compute = openstack.getComputeClient();
//		TINY ID = 1
//		FlavorList flavorList = compute.listFlavors();
//		List<Flavor> flList = flavorList.getList();
//		for(Flavor f:flList){
//			System.out.println(f.getName());
//			System.out.println(f.getId());
//		}
		
		NovaServerForCreate serverForCreate = new NovaServerForCreate();
		serverForCreate.setName("api test");
		serverForCreate.setImageRef(imageHref);
		serverForCreate.setFlavorRef("1");
		
//		compute.createServer(serverForCreate);
		//ServerResource s = new ServerResource(target, properties)
		ServersResource servers = tr.servers();
		ServerList serverList = servers.get();
		List<Server> serList = serverList.getList();
		
		ServerResource ourServer=null;
		for(Server s:serList){
			System.out.println(s.getName() + " Id: " + s.getId() );
			if(s.getName().equals("api test")){
				ourServer = servers.server(s.getId());
			}
		}
		ourServer.reboot(ServerResource.REBOOT_HARD);


	}

}