package org.openstack.client.common;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.openstack.model.exceptions.OpenstackAuthenticationException;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public abstract class RequestBuilder {
	static final Logger log = Logger.getLogger(RequestBuilder.class.getName());

	protected final String resourceUrl;
	protected boolean verbose;
	protected final Map<String, String> headers = Maps.newHashMap();
	protected final List<MediaType> acceptTypes = Lists.newArrayList();
	protected MediaType contentType = null;
	protected String method = "GET";
	protected Object body;

	protected Multimap<String, String> queryParameters = HashMultimap.create();
	
	private final OpenStackSession session;

	public RequestBuilder(OpenStackSession session, String resourceUrl) {
		this.session = session;
		this.resourceUrl = resourceUrl;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public void putHeader(String key, String value) {
		headers.put(key, value);
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public RequestBuilder addAcceptType(MediaType mediaType) {
		acceptTypes.add(mediaType);
		return this;
	}

	public RequestBuilder setContentType(MediaType contentType) {
		if (this.contentType != null) {
			if (this.contentType.equals(contentType))
				return this;
			throw new IllegalStateException("Attempt to change contentType from " + this.contentType + " to " + contentType);
		}

		this.contentType = contentType;
		return this;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public void delete() {
		this.method = "DELETE";
		doRequest();
	}

	public <T> T doRequest(Class<T> c) {
		if (session.hasStoredCredentials()) {
			try {
				return doRequest0(c);
			} catch (OpenstackAuthenticationException e) {
				log.log(Level.WARNING, "Caught not-authorized exception; trying to re-authenticate", e);
				if (session.getData().isAuthenticated()) {
					session.reauthenticate();
				}
			}
		}

		return doRequest0(c);
	}

	public abstract <T> T doRequest0(Class<T> c);

	public void doRequest() {
		doRequest(Void.class);
	}

	public <T> T get(Class<T> c) {
		this.method = "GET";
		return doRequest(c);
	}

	public abstract HeadResponse head();

	public <T> T post(Class<T> c) {
		return post(c, null);
	}

	public <T> T post(Class<T> c, Object body) {
		this.body = body;
		this.method = "POST";
		return doRequest(c);
	}

	public void put() {
		put(Void.class, null);
	}

	public <T> T put(Class<T> c, Object body) {
		this.method = "PUT";
		this.body = body;
		return doRequest(c);
	}

	public void put(Object body) {
		put(Void.class, body);
	}

	public void post() {
		post(Void.class, null);
	}

	public void addQueryParameter(String key, String value) {
		queryParameters.put(key, value);
	}

	public void clearAcceptTypes() {
		acceptTypes.clear();
	}

}
