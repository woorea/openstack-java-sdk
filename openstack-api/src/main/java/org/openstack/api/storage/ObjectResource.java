package org.openstack.api.storage;

import java.io.InputStream;

import org.openstack.api.common.HeadResponse;
import org.openstack.api.common.RequestBuilder;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.openstack.model.storage.SwiftObjectProperties;

public class ObjectResource extends StorageResourceBase {
	public void delete() {
		resource().delete();
	}

	public InputStream openStream() {
		RequestBuilder request = buildDownloadRequest();

		return request.get(InputStream.class);
	}

	public RequestBuilder buildDownloadRequest() {
		RequestBuilder builder = resource();
		builder.setMethod("GET");
		return builder;
	}

	public SwiftObjectProperties metadata() {
		HeadResponse response = resource().head();
		int httpStatus = response.getStatus();
		if (httpStatus == 200) {
			SwiftObjectProperties properties = SwiftHeaderUtils.unmarshalHeaders(response);
			return properties;
		}

		if (httpStatus == 404) {
			throw new OpenstackNotFoundException("Object not found");
		}

		throw new OpenstackException("Unexpected HTTP status code: " + httpStatus);
	}

	public void updateMetadata(SwiftObjectProperties changeProperties) {
		RequestBuilder builder = resource();
		builder = SwiftHeaderUtils.setHeadersForProperties(builder, changeProperties);
		builder.post();
	}

}
