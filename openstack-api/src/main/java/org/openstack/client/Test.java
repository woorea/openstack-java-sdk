package org.openstack.client;

import org.openstack.client.common.OpenstackSession;
import org.openstack.client.common.OpenstackSession.Feature;
import org.openstack.client.compute.TenantResource;
import org.openstack.client.identity.IdentityResource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Server;
import org.openstack.model.identity.Tenant;

public class Test {

	public static void main(String[] args) {
		OpenstackSession session = new OpenstackSession().with(Feature.VERBOSE);
		OpenstackCredentials credentials = new OpenstackCredentials("admin", "woorea");
		session.authenticate("http://192.168.1.49:5000/v2.0", credentials);

		// X-Auth-Token has been set on session object

		IdentityResource identity = session.getAuthenticationClient().root();

		Iterable<Tenant> tenants = identity.tenants().list();
		for (Tenant tenant : tenants) {
			System.out.println(tenant);
		}

		// I will choose the first tenant
		for (Tenant tenant : tenants) {
			credentials.setTenant(tenant.getName());
			session.authenticate("http://192.168.1.49:5000/v2.0", credentials);
			break;
		}

		TenantResource compute = session.getComputeClient().root();
		for (Server s : compute.servers().list()) {
			System.out.println(s);
		}

		Iterable<Image> images = compute.images().list();
		Image image = null;
		for (Image i : images) {
			System.out.println(i);
			if (i.getName().equals("cirros-0.3.0-x86_64-blank")) {
				image = i;
				break;
			}
		}

		System.out.println(image);

		Iterable<Flavor> flavors = compute.flavors().list();
		for (Flavor f : flavors) {
			System.out.println(f);
		}

		// ServerForCreate serverForCreate = new ServerForCreate();
		// serverForCreate.setName("eureka1");
		// serverForCreate.setFlavorRef("1");
		// serverForCreate.setImageRef(image.getId());
		// serverForCreate.setSecurityGroups(new ArrayList<ServerForCreate.SecurityGroup>() {{
		// add(new ServerForCreate.SecurityGroup("test"));
		// }});
		// System.out.println(serverForCreate);

		/*
		 * AsyncServerOperation async = nova.createServer(serverForCreate); Server server = async.get();
		 */

		// Server server = compute.servers().create(serverForCreate);
		// System.out.println(server.getImage(session).getMinDisk());
		//
		// System.out.println(server);
		// System.out.println("DELETING");
		// compute.servers().server(server.getId()).delete();

		// TODO: Review the endpoint resolver for admin.
		// for (User user : identity.users().list()) {
		// System.out.println(user);
		// }

		/*
		 * RolesResource rolesResource = identity.roles(); RolesRepresentation rolesRepresentation =
		 * rolesResource.list(); List<Role> roles = rolesRepresentation.getList(); for(Role role : roles) {
		 * System.out.println(role); }
		 * 
		 * RoleResource roleResource = rolesResource.role(roles.get(0).getId());
		 * System.out.println(roleResource.show());
		 */

		/*
		 * ServicesResource servicesResource = identity.services(); ServicesRepresentation servicesRepresentation =
		 * servicesResource.list(); List<Service> services = servicesRepresentation.getList(); for(Service service :
		 * services) { System.out.println(service); }
		 * 
		 * ServiceResource serviceResource = servicesResource.service(services.get(0).getId());
		 * System.out.println(serviceResource.show());
		 */

		/*
		 * EndpointTemplatesResource endpointTemplatesResource = identity.endpointTemplates();
		 * EndpointTemplatesRepresentation endpointTemplatesRepresentation = identity.endpointTemplates().list();
		 * List<EndpointTemplate> endpointTemplates = endpointTemplatesRepresentation.getList(); for(EndpointTemplate
		 * endEndpointTemplate : endpointTemplates) { System.out.println(endEndpointTemplate); }
		 * 
		 * EndpointTemplateResource endpointTemplateResource =
		 * endpointTemplatesResource.endpointTemplate(services.get(0).getId());
		 * System.out.println(endpointTemplateResource.show());
		 */

		// representation = representation.next();
		// System.out.println(representation.getList());

		// ComputeResource compute = new ComputeResource(client, "http://192.168.1.49:8774/v1.1");
		// TenantResource tenant = compute.tenant(); // tenants.get(0).getId());

		// client.resource("http://192.168.1.49:8774/v2/1/extensions").accept(MediaType.APPLICATION_JSON).get(String.class);

		/*
		 * FlavorsRepresentation flavorsRepresentation = tenant.flavors().list(); flavorsRepresentation.fetchAll();
		 * for(Flavor flavor : flavorsRepresentation.getList()) { System.out.println(flavor); }
		 * 
		 * 
		 * ImagesRepresentation imagesRepresentation = tenant.images().list(); imagesRepresentation.fetchAll();
		 * for(Image image : imagesRepresentation.getList()) { System.out.println(image); }
		 * 
		 * 
		 * ServerForCreate serverForCreate = new ServerForCreate(); serverForCreate.setName("eureka");
		 * serverForCreate.setFlavorRef("1");
		 * serverForCreate.setImageRef(imagesRepresentation.getList().get(1).getId()); ServerRepresentation
		 * serverRepresentation = tenant.servers().create(serverForCreate);
		 * System.out.println(serverRepresentation.getModel());
		 * 
		 * 
		 * 
		 * ServersRepresentation serversRepresentation = tenant.servers().list(true);
		 * //serversRepresentation.fetchAll(); List<Server> servers = serversRepresentation.getList(); for(Server server
		 * : servers) { System.out.println(server); }
		 * 
		 * 
		 * 
		 * 
		 * System.out.println(tenant.servers().server(servers.get(0).getId()).getConsoleOutput(20));
		 * System.out.println(tenant.servers().server(servers.get(0).getId()).getVncConsole("novnc"));
		 */
		// System.out.println(tenant.zones().list().getList());

		// tenant.servers().server(servers.get(0).getId()).getVNCConsole("novnc");

		/*
		 * ConsolesResource consolesResource = tenant.servers().server(servers.get(0).getId()).consoles();
		 * consolesResource.create(); ConsoleList consoleList = consolesResource.list(); for(Console console :
		 * consoleList.getList()) { System.out.println(console); }
		 */

		/*
		 * KeyPairsResource keyPairsResource = compute.tenant(tenants.get(0).getId()).keyPairs(); KeyPairList
		 * keyPairList = keyPairsResource.list(); for(KeyPair keyPair : keyPairList.getList()) {
		 * System.out.println(keyPair); }
		 */
		/*
		 * SecurityGroupsResource securityGroupsResource = tenant.securityGroups(); //SecurityGroup sg = new
		 * SecurityGroup(); //sg.setName("test"); //sg.setDescription("desc"); //sg = securityGroupsResource.create(sg);
		 * SecurityGroupList securityGroupList = securityGroupsResource.list(); for(SecurityGroup securityGroup :
		 * securityGroupList.getList()) { System.out.println(securityGroup); }
		 */
		/*
		 * SecurityGroupRulesResource rulesResource =
		 * securityGroupsResource.securityGroup(securityGroupList.getList().get(0).getId()).rules();
		 * SecurityGroupRuleForCreate sgr = new SecurityGroupRuleForCreate(); sgr.setIpProtocol("TCP");
		 * sgr.setParentGroupId(securityGroupList.getList().get(0).getId());
		 * //sgr.setGroupId(securityGroupList.getList().get(0).getId()); sgr.setFromPort(22); sgr.setToPort(23);
		 * sgr.setCidr("0.0.0.0/0"); //rulesResource.create(sgr);
		 * 
		 * //client.resource("http://192.168.1.49:8774/v1.1/1/os-security-group-rules").accept(MediaType.APPLICATION_XML)
		 * .type(MediaType.APPLICATION_XML).post(SecurityGroupRule.class, sgr);
		 */
		/*
		 * VolumesResource volumesResource = tenant.volumes(); Volume vol = new Volume(); vol.setSizeInGB(1);
		 * vol.setType(""); VolumeList volumeList = volumesResource.list(false); for(Volume volumex :
		 * volumeList.getList()) { System.out.println(volumex); }
		 */

		/*
		 * ZonesResource zonesResource = tenant.zones(); Zone zone = new Zone(); zone.setName("dos");
		 * zonesResource.create(zone); ZoneList zoneList = zonesResource.detail(); for(Zone zonex : zoneList.getList())
		 * { System.out.println(zonex); }
		 */

	}

}
