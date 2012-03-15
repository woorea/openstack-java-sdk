package org.openstack.client.common;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.openstack.client.storage.OpenstackStorageClient;
import org.openstack.model.atom.Link;
import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeyStoneService;
import org.openstack.model.identity.KeyStoneToken;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public abstract class OpenStackSession implements Serializable {
	
	static final Logger log = Logger.getLogger(OpenStackSession.class.getName());
	
	protected OpenStackSessionData data = new OpenStackSessionData();
	
	protected OpenstackCredentials credentials;

	public enum Feature {

		VERBOSE(false), FORCE_JSON(false), FORCE_XML(false);

		private boolean enabled;

		public boolean isEnabled() {
			return enabled;
		}

		public int mask() {
			return (1 << ordinal());
		}

		private Feature(boolean enabled) {
			this.enabled = enabled;
		}
	}

	private int features;

	private OpenStackIdentityConfig identityConfig;

	private OpenStackComputeConfig computeConfig;

	private OpenStackImageConfig imageConfig;

	transient LinkResolver linkResolver;

	public OpenStackSession() {

		// calculate the bitmap
		for (Feature f : Feature.class.getEnumConstants()) {
			if (f.isEnabled()) {
				features = features | f.mask();
			}
		}

		computeConfig = new OpenStackComputeConfig();

		identityConfig = new OpenStackIdentityConfig();

		imageConfig = new OpenStackImageConfig();

	}

	public OpenStackSession enable(Feature feature) {
		features = features | feature.mask();
		return this;
	}

	public OpenStackSession disable(Feature feature) {
		features = features & ~feature.mask();
		return this;
	}

	public OpenStackIdentityConfig getIdentityConfig() {
		return identityConfig;
	}

	public void setIdentityConfig(OpenStackIdentityConfig identityConfig) {
		this.identityConfig = identityConfig;
	}

	public OpenStackComputeConfig getComputeConfig() {
		return computeConfig;
	}

	public void setComputeConfig(OpenStackComputeConfig computeConfig) {
		this.computeConfig = computeConfig;
	}

	public OpenStackImageConfig getImageConfig() {
		return imageConfig;
	}

	public void setImageConfig(OpenStackImageConfig imageConfig) {
		this.imageConfig = imageConfig;
	}

	public boolean isEnabled(Feature feature) {
		return (features & feature.mask()) == 1;
	}

	public OpenStackSession with(Feature... features) {
		for (Feature feature : features) {
			this.features = this.features | feature.mask();
		}
		return this;
	}

	public OpenStackSession without(Feature... features) {
		for (Feature feature : features) {
			this.features = this.features & ~feature.mask();
		}
		return this;
	}

	//

	/*
	 * public OpenstackSession(String authURL) { this.authenticationUrl = authURL; }
	 * 
	 * public OpenstackSession(String authUrl, OpenstackCredentials credentials) { this(authUrl);
	 * authenticate(credentials); }
	 */

	public RequestBuilder resource(String resourceUrl) {
		RequestBuilder request = createRequestBuilder(resourceUrl);

		if (isEnabled(Feature.VERBOSE)) {
			request.setVerbose(true);
		}

		KeyStoneToken token = null;
		if (data.isAuthenticated()) {
			token = data.getAccess().getToken();
		}

		String authTokenId = null;
		if (token != null) {
			authTokenId = token.getId();
		}

		if (authTokenId != null && !authTokenId.isEmpty()) {
			request.putHeader("X-Auth-Token", authTokenId);
		}

		return request;
	}

	protected abstract RequestBuilder createRequestBuilder(String resourceUrl);

	public OpenstackImageClient getImageClient() {
		return new OpenstackImageClient(this);
	}

	public OpenstackComputeClient getComputeClient() {
		return new OpenstackComputeClient(this);
	}

	public OpenstackAuthenticationClient getAuthenticationClient() {
		return new OpenstackAuthenticationClient(this);
	}

	public OpenstackStorageClient getStorageClient() {
		return new OpenstackStorageClient(this);
	}

	public void authenticate(OpenstackCredentials credentials) throws OpenstackException {
		authenticate(credentials, false);
	}

	public void authenticate(OpenstackCredentials credentials, boolean storeCredentials) throws OpenstackException {
		if (storeCredentials) {
			this.credentials = credentials;
		}
		data.setAccess(getAuthenticationClient().authenticate(credentials));
	}

	

	public <T> T followLink(Link link, Class<T> clazz) {
		return follow(link, null, clazz);
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

	public MediaType getForceContentType() {
		if (isEnabled(Feature.FORCE_JSON)) {
			return MediaType.APPLICATION_JSON_TYPE;
		}
		if (isEnabled(Feature.FORCE_XML)) {
			return MediaType.APPLICATION_XML_TYPE;
		}
		return null;
	}

	public NovaImage resolveImage(NovaImage image) throws OpenstackException {
		if (image == null)
			return null;

		return getLinkResolver().resolveImage(image.getId(), image.getLinks());
	}

	public NovaFlavor resolveFlavor(NovaFlavor flavor) throws OpenstackException {
		if (flavor == null)
			return null;

		return getLinkResolver().resolveFlavor(flavor.getId(), flavor.getLinks());
	}

	public static OpenStackSession create() {
		return new JerseyOpenstackSession();
	}

	

	public void reauthenticate() throws OpenstackException {
		if (!hasStoredCredentials()) {
			throw new IllegalStateException("Credentials were not saved");
		}
		authenticate(credentials, false);
	}
	
	public <T> T follow(Link link, String method, Class<T> c) {
		try {
			RequestBuilder request = resource(link.getHref()).addAcceptType(MediaType.APPLICATION_XML_TYPE).setContentType(MediaType.APPLICATION_XML_TYPE);
			return request.get(c);
		} catch (Exception e) {
			throw new OpenstackException(e.getMessage(), e);
		}
	}

	public OpenStackSessionData getData() {
		return data;
	}

	public void setData(OpenStackSessionData data) {
		this.data = data;
	}
	
	public boolean hasStoredCredentials() {
		return credentials != null;
	}

}
