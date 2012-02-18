package org.openstack.client.common;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openstack.client.OpenstackException;
import org.openstack.client.OpenstackNotFoundException;
import org.openstack.model.compute.BadRequest;
import org.openstack.model.compute.ItemNotFound;

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
			try {
				// TODO(justinsb): This is only valid on compute (I think!)
				ItemNotFound itemNotFound = response.getEntity(ItemNotFound.class);
				if (itemNotFound.getMessage() != null) {
					message = itemNotFound.getMessage();
				}
			} catch (Exception e) {
				// Ignore
				log.log(Level.FINE, "Ignoring error deserializing ItemNotFound on 404", e);
			}

			throw new OpenstackNotFoundException(message);
		}
		
		if (httpStatus == 400) {
			String message = "Bad request";
			try {
				// TODO(justinsb): This is only valid on compute (I think!)
				BadRequest badRequest = response.getEntity(BadRequest.class);
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
