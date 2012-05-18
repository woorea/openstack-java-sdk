package org.openstack.api.common;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ResponseFilter;

import org.openstack.model.exceptions.OpenstackException;

@Provider
public class OpenstackExceptionClientFilter implements ResponseFilter {

	@Override
	public void postFilter(FilterContext context) throws IOException {
		int httpStatus = context.getResponse().getStatus();
		if(httpStatus / 100 > 3) {
			MediaType responseType = context.getResponse().getHeaders().getMediaType();
			if (responseType != null && responseType.isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
				throw context.getResponse().readEntity(OpenstackException.class);
			} else if (context.getResponse().hasEntity()) {
				throw new OpenstackException(context.getResponse().readEntity(String.class));
			} else {
				throw new OpenstackException("Unknown exception");
			}
		} 
	}
}
