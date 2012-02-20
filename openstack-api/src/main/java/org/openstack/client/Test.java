package org.openstack.client;

import java.util.List;

import org.openstack.client.common.OpenStackClientFactory;
import org.openstack.client.compute.ComputeResource;
import org.openstack.client.compute.TenantResource;
import org.openstack.client.identity.IdentityResource;
import org.openstack.client.identity.TenantsRepresentation;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.Tenant;

import com.sun.jersey.api.client.Client;

public class Test {

    public static void main(String[] args) {
    	/*
        OpenStackClientFactory osf = new OpenStackClientFactory();
        Client client = osf.create();
        IdentityResource identity = new IdentityResource(client, "http://192.168.1.49:5000/v2.0");
        Authentication authentication = new Authentication();
        Authentication.PasswordCredentials passwordCredentials = new Authentication.PasswordCredentials();
        passwordCredentials.setUsername("demo");
        passwordCredentials.setPassword("woorea");
        authentication.setPasswordCredentials(passwordCredentials);
        Access access = identity.tokens().authenticate(authentication);
        TenantsRepresentation representation = identity.tenants().list();
        List<Tenant> tenants = representation.getList();
        for (Tenant tenant : tenants) {
            System.out.println(tenant);
        }
        */
        /*
         * UsersResource usersResource = identity.users(); UsersRepresentation usersRepresentation = usersResource.list(); List<User> users = usersRepresentation.getList(); for(User user : users) {
         * System.out.println(user); }
         * 
         * UserResource userResource = usersResource.user(users.get(0).getId()); System.out.println(userResource.show());
         */
        /*
         * RolesResource rolesResource = identity.roles(); RolesRepresentation rolesRepresentation = rolesResource.list(); List<Role> roles = rolesRepresentation.getList(); for(Role role : roles) {
         * System.out.println(role); }
         * 
         * RoleResource roleResource = rolesResource.role(roles.get(0).getId()); System.out.println(roleResource.show());
         */

        /*
         * ServicesResource servicesResource = identity.services(); ServicesRepresentation servicesRepresentation = servicesResource.list(); List<Service> services = servicesRepresentation.getList();
         * for(Service service : services) { System.out.println(service); }
         * 
         * ServiceResource serviceResource = servicesResource.service(services.get(0).getId()); System.out.println(serviceResource.show());
         */

        /*
         * EndpointTemplatesResource endpointTemplatesResource = identity.endpointTemplates(); EndpointTemplatesRepresentation endpointTemplatesRepresentation = identity.endpointTemplates().list();
         * List<EndpointTemplate> endpointTemplates = endpointTemplatesRepresentation.getList(); for(EndpointTemplate endEndpointTemplate : endpointTemplates) {
         * System.out.println(endEndpointTemplate); }
         * 
         * EndpointTemplateResource endpointTemplateResource = endpointTemplatesResource.endpointTemplate(services.get(0).getId()); System.out.println(endpointTemplateResource.show());
         */

        // representation = representation.next();
        // System.out.println(representation.getList());

        //ComputeResource compute = new ComputeResource(client, "http://192.168.1.49:8774/v1.1");
        //TenantResource tenant = compute.tenant(); // tenants.get(0).getId());

        // client.resource("http://192.168.1.49:8774/v2/1/extensions").accept(MediaType.APPLICATION_JSON).get(String.class);

        /*
         * FlavorsRepresentation flavorsRepresentation = tenant.flavors().list(); flavorsRepresentation.fetchAll(); for(Flavor flavor : flavorsRepresentation.getList()) { System.out.println(flavor); }
         * 
         * 
         * ImagesRepresentation imagesRepresentation = tenant.images().list(); imagesRepresentation.fetchAll(); for(Image image : imagesRepresentation.getList()) { System.out.println(image); }
         * 
         * 
         * ServerForCreate serverForCreate = new ServerForCreate(); serverForCreate.setName("eureka"); serverForCreate.setFlavorRef("1");
         * serverForCreate.setImageRef(imagesRepresentation.getList().get(1).getId()); ServerRepresentation serverRepresentation = tenant.servers().create(serverForCreate);
         * System.out.println(serverRepresentation.getModel());
         * 
         * 
         * 
         * ServersRepresentation serversRepresentation = tenant.servers().list(true); //serversRepresentation.fetchAll(); List<Server> servers = serversRepresentation.getList(); for(Server server :
         * servers) { System.out.println(server); }
         * 
         * 
         * 
         * 
         * System.out.println(tenant.servers().server(servers.get(0).getId()).getConsoleOutput(20)); System.out.println(tenant.servers().server(servers.get(0).getId()).getVncConsole("novnc"));
         */
        //System.out.println(tenant.zones().list().getList());

        // tenant.servers().server(servers.get(0).getId()).getVNCConsole("novnc");

        /*
         * ConsolesResource consolesResource = tenant.servers().server(servers.get(0).getId()).consoles(); consolesResource.create(); ConsoleList consoleList = consolesResource.list(); for(Console
         * console : consoleList.getList()) { System.out.println(console); }
         */

        /*
         * KeyPairsResource keyPairsResource = compute.tenant(tenants.get(0).getId()).keyPairs(); KeyPairList keyPairList = keyPairsResource.list(); for(KeyPair keyPair : keyPairList.getList()) {
         * System.out.println(keyPair); }
         */
        /*
         * SecurityGroupsResource securityGroupsResource = tenant.securityGroups(); //SecurityGroup sg = new SecurityGroup(); //sg.setName("test"); //sg.setDescription("desc"); //sg =
         * securityGroupsResource.create(sg); SecurityGroupList securityGroupList = securityGroupsResource.list(); for(SecurityGroup securityGroup : securityGroupList.getList()) {
         * System.out.println(securityGroup); }
         */
        /*
         * SecurityGroupRulesResource rulesResource = securityGroupsResource.securityGroup(securityGroupList.getList().get(0).getId()).rules(); SecurityGroupRuleForCreate sgr = new
         * SecurityGroupRuleForCreate(); sgr.setIpProtocol("TCP"); sgr.setParentGroupId(securityGroupList.getList().get(0).getId()); //sgr.setGroupId(securityGroupList.getList().get(0).getId());
         * sgr.setFromPort(22); sgr.setToPort(23); sgr.setCidr("0.0.0.0/0"); //rulesResource.create(sgr);
         * 
         * //client.resource("http://192.168.1.49:8774/v1.1/1/os-security-group-rules").accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).post(SecurityGroupRule.class, sgr);
         */
        /*
         * VolumesResource volumesResource = tenant.volumes(); Volume vol = new Volume(); vol.setSizeInGB(1); vol.setType(""); VolumeList volumeList = volumesResource.list(false); for(Volume volumex :
         * volumeList.getList()) { System.out.println(volumex); }
         */

        /*
         * ZonesResource zonesResource = tenant.zones(); Zone zone = new Zone(); zone.setName("dos"); zonesResource.create(zone); ZoneList zoneList = zonesResource.detail(); for(Zone zonex :
         * zoneList.getList()) { System.out.println(zonex); }
         */

    }

}
