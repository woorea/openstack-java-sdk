package org.openstack.client.cli;

import org.kohsuke.args4j.Option;
import org.openstack.client.OpenstackCredentials;
import org.openstack.client.OpenstackException;
import org.openstack.client.common.CachingLinkResolver;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.common.OpenstackSession;
import org.openstack.client.common.OpenstackSession.Feature;

import com.fathomdb.cli.CliOptions;

public class ConfigurationOptions extends CliOptions {
	@Option(name = "-u", aliases = { "--username", "--user" }, usage = "login username")
	String username;

	@Option(name = "-t", aliases = "--tenant", usage = "login tenant")
	String tenantId;

	@Option(name = "-p", aliases = "--password", usage = "login password")
	String password;

	@Option(name = "-s", aliases = "--server", usage = "specify authentication server")
	String server;

	@Option(name = "-debug", usage = "enable debug output")
	boolean debug;

	// public OpenstackComputeClient buildComputeClient() throws IOException {
	// OpenStackClientFactory osf = new OpenStackClientFactory();
	// Client client = debug ? osf.createWithStdoutLogging() : osf.create();
	// IdentityResource identity = new IdentityResource(client, server);
	// Authentication authentication = new Authentication();
	// Authentication.PasswordCredentials passwordCredentials = new
	// Authentication.PasswordCredentials();
	// passwordCredentials.setUsername(username);
	// passwordCredentials.setPassword(password);
	// authentication.tenantName = tenantId;
	// authentication.setPasswordCredentials(passwordCredentials);
	// Access access = identity.tokens().authenticate(authentication);
	// // TenantsRepresentation representation = identity.tenants().list();
	// // List<Tenant> tenants = representation.getList();
	// // for (Tenant tenant : tenants) {
	// // System.out.println(tenant);
	// // }
	//
	// List<Service> foundServices = Lists.newArrayList();
	// for (Service service : access.serviceCatalog) {
	// if ("compute".equals(service.getType())) {
	// foundServices.add(service);
	// }
	// }
	//
	// if (foundServices.isEmpty()) {
	// throw new IllegalArgumentException("Cannot find compute service");
	// }
	//
	// if (foundServices.size() != 1) {
	// throw new IllegalArgumentException("Found multiple compute services");
	// }
	//
	// Service service = foundServices.get(0);
	//
	// ServiceEndpoint bestEndpoint = null;
	// for (ServiceEndpoint endpoint : service.endpoints) {
	// bestEndpoint = endpoint;
	// }
	// if (bestEndpoint == null) {
	// throw new IllegalArgumentException("Cannot find suitable endpoint");
	// }
	// ComputeResource compute = new ComputeResource(client,
	// bestEndpoint.publicURL);
	// TenantResource tenant = compute.tenant();
	//
	// return tenant;
	// }

	public OpenstackComputeClient buildComputeClient() throws OpenstackException {
		return getOpenstackSession().getComputeClient();
	}

	public OpenstackImageClient buildImageClient() throws OpenstackException {
		return getOpenstackSession().getImageClient();
	}

	OpenstackSession session = null;

	public OpenstackSession getOpenstackSession() {
		if (session == null) {
			session = new OpenstackSession().with(Feature.VERBOSE);

			session.setLinkResolver(new CachingLinkResolver(session));
		}

		if (!session.isAuthenticated()) {
			OpenstackCredentials credentials = new OpenstackCredentials(username, password, tenantId);
			session.authenticate(server, credentials);
		}

		return session;
	}

}
