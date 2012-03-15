package org.openstack.client.common;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.NovaBadRequest;
import org.openstack.model.compute.NovaItemNotFound;
import org.openstack.model.exceptions.OpenstackAuthenticationException;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackForbiddenException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.openstack.utils.Io;

import com.google.common.base.Objects;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

class OpenstackExceptionClientFilter extends ClientFilter {
	static final Logger log = Logger.getLogger(OpenstackExceptionClientFilter.class.getName());

	public ClientResponse handle(ClientRequest request) {
		ClientResponse response = getNext().handle(request);

		int httpStatus = response.getStatus();
		if (httpStatus == 404) {
			String message = "Not found";
			MediaType responseType = response.getType();
			
			if (responseType != null && responseType.isCompatible(MediaType.APPLICATION_XML_TYPE)) {
				try {
					// TODO(justinsb): This is only valid on compute (I think!)
					NovaItemNotFound itemNotFound = response.getEntity(NovaItemNotFound.class);
					if (itemNotFound.getMessage() != null) {
						message = itemNotFound.getMessage();
					}
				} catch (Exception e) {
					// Ignore
					log.log(Level.FINE, "Ignoring error deserializing ItemNotFound on 404", e);
				}
			} else if (responseType != null && responseType.isCompatible(MediaType.TEXT_HTML_TYPE)) {
				InputStream inputStream = null;
				try {
					inputStream = response.getEntityInputStream();
					message = Io.readAll(inputStream);
				} catch (Exception e) {
					// Ignore
					log.log(Level.FINE, "Ignoring error reading 404 response body", e);
				} finally {
					Io.safeClose(inputStream);
				}
			}

			throw new OpenstackNotFoundException(message);
		}

		if (httpStatus == 401) {
			String message = "Not authorized";

			throw new OpenstackAuthenticationException(message);
		}

		if (httpStatus == 403) {
			String message = "Forbidden";

			throw new OpenstackForbiddenException(message);
		}

		if (httpStatus == 400) {
			String message = "Bad request";
			try {
				// TODO(justinsb): This is only valid on compute (I think!)
				NovaBadRequest badRequest = response.getEntity(NovaBadRequest.class);
				if (badRequest.getMessage() != null) {
					message = badRequest.getMessage();
				}
			} catch (Exception e) {
				// Ignore
				log.log(Level.FINE, "Ignoring error deserializing BadRequest on 400", e);
			}

			throw new OpenstackException(message);
		}
		return response;
	}
}
