package org.openstack.api.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.ResponseFilter;

import org.openstack.model.compute.NovaBadRequest;
import org.openstack.model.compute.NovaItemNotFound;
import org.openstack.model.exceptions.OpenstackAuthenticationException;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackForbiddenException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.openstack.utils.Io;

public class OpenstackExceptionClientFilter implements ResponseFilter {
	
	static final Logger log = Logger.getLogger(OpenstackExceptionClientFilter.class.getName());

	@Override
	public void postFilter(FilterContext context) throws IOException {
		int httpStatus = context.getResponse().getStatus();
		if (httpStatus == 404) {
			String message = "Not found";
			MediaType responseType = context.getResponse().getHeaders().getMediaType();
			
			if (responseType != null && responseType.isCompatible(MediaType.APPLICATION_XML_TYPE)) {
				try {
					// TODO(justinsb): This is only valid on compute (I think!)
					NovaItemNotFound itemNotFound = (NovaItemNotFound) context.getResponse().getEntity();
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
					inputStream = context.getResponse().readEntity(InputStream.class);
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
				NovaBadRequest badRequest = (NovaBadRequest) context.getResponse().getEntity();
				if (badRequest.getMessage() != null) {
					message = badRequest.getMessage();
				}
			} catch (Exception e) {
				// Ignore
				log.log(Level.FINE, "Ignoring error deserializing BadRequest on 400", e);
			}

			throw new OpenstackException(message);
		}
		
	}
}
