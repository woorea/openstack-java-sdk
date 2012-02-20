package org.openstack.client.common;

import java.io.Serializable;
import java.util.List;

import org.openstack.client.OpenstackCredentials;
import org.openstack.client.OpenstackException;
import org.openstack.model.atom.Link;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Service;

import com.google.common.collect.Lists;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class OpenstackSession implements Serializable {
	Access access;

	final String authenticationUrl;

	private boolean verbose;

	transient LinkResolver linkResolver;

	public OpenstackSession(String authUrl) {
		this.authenticationUrl = authUrl;
	}

	public OpenstackSession(String authUrl, OpenstackCredentials credentials) {
		this(authUrl);
		authenticate(credentials);
	}

	public boolean isAuthenticated() {
		return access != null;
	}

	public synchronized Access getAuthenticationToken() throws OpenstackException {
		// TODO: Allow saving credentials and automatically re-authenticate on timeout
		// if (access == null)
		// access = getAuthenticationClient().authenticate();

		return access;
	}

	public WebResource resource(String resourceUrl) {
		Client jerseyClient = JerseyClient.INSTANCE.getJerseyClient();
		WebResource resource = jerseyClient.resource(resourceUrl);

		// It could be nice to just put the OpenstackSession into a property,
		// and have a constant filterset.  BUT head() doesn't use properties.
		// resource.setProperty(OpenstackSession.class.getName(), this);

		resource.addFilter(new OpenstackAuthenticationFilter(access));
		
		if (isVerbose()) {
			// But verbose filter is just easier done here!
			resource.addFilter(new LoggingFilter(System.out));
		}
		
		return resource;
	}

	public OpenstackImageClient getImageClient() {
		return new OpenstackImageClient(this);
	}

	public OpenstackComputeClient getComputeClient() {
		return new OpenstackComputeClient(this);
	}

	public OpenstackAuthenticationClient getAuthenticationClient() {
		return new OpenstackAuthenticationClient(this, authenticationUrl);
	}

	public void authenticate(OpenstackCredentials credentials) {
		Access access = getAuthenticationClient().authenticate(credentials);
		this.access = access;
	}

	public String getBestEndpoint(String serviceType) throws OpenstackException {
		Access access = getAuthenticationToken();
		List<Service> foundServices = Lists.newArrayList();
		for (Service service : access.getServiceCatalog()) {
			if (serviceType.equals(service.getType())) {
				foundServices.add(service);
			}
		}

		if (foundServices.isEmpty()) {
			throw new OpenstackException("Cannot find service");
		}

		if (foundServices.size() != 1) {
			throw new OpenstackException("Found multiple services of type: " + serviceType);
		}

		Service service = foundServices.get(0);

		if (service.getEndpoints().size() != 1) {
			throw new OpenstackException("Unhandled number of endpoints");
		}

		String bestUrl = service.getEndpoints().get(0).getPublicURL();

		if (bestUrl == null) {
			throw new OpenstackException("Cannot find endpoint URL for image service");
		}

		return bestUrl;
	}

	public <T> T followLink(Link link, Class<T> clazz) {
		return link.follow(this, null, clazz);
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public LinkResolver getLinkResolver() {
		if (linkResolver == null) {
			linkResolver = new SimpleLinkResolver(this);
		}
		return linkResolver;
	}

	public void setLinkResolver(LinkResolver linkResolver) {
		this.linkResolver = linkResolver;
	}
}
