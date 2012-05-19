package org.openstack.api.common;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ResponseFilter;

import org.openstack.model.exceptions.OpenStackComputeException;
import org.openstack.model.exceptions.OpenStackException;

@Provider
public class OpenstackExceptionClientFilter implements ResponseFilter {

	@Override
	public void postFilter(FilterContext context) throws IOException {
		int httpStatus = context.getResponse().getStatus();
		if(httpStatus / 100 > 3) {
			MediaType responseType = context.getResponse().getHeaders().getMediaType();
			if (responseType != null && responseType.isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
				// the filter should be applied per project basics
				// for now is applied in a coarse grained fashion
				try {
					throw context.getResponse().readEntity(OpenStackComputeException.class);
				} catch (Exception e) {
					throw context.getResponse().readEntity(OpenStackException.class);
				}
			} else if (context.getResponse().hasEntity()) {
				throw new OpenStackException(context.getResponse().readEntity(String.class));
			} else {
				throw new OpenStackException("Unknown exception");
			}
		} 
	}
}
