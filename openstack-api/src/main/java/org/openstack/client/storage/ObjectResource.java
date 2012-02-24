package org.openstack.client.storage;

import java.io.InputStream;
import org.openstack.client.OpenstackException;
import org.openstack.client.OpenstackNotFoundException;
import org.openstack.model.storage.ObjectProperties;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;

public class ObjectResource extends StorageResourceBase {
	public void delete() {
		resource().delete();
	}

	public InputStream openStream() {
		return resource().get(InputStream.class);
	}

	public ObjectProperties metadata() {
		ClientResponse response = resource().head();
		int httpStatus = response.getStatus();
		if (httpStatus == 200) {
			ObjectProperties properties = SwiftHeaderUtils.unmarshalHeaders(response);
			return properties;
		}

		if (httpStatus == 404) {
			throw new OpenstackNotFoundException("Object not found");
		}

		throw new OpenstackException("Unexpected HTTP status code: " + httpStatus);
	}

	public void updateMetadata(ObjectProperties changeProperties) {
		Builder builder = resource();
		builder = SwiftHeaderUtils.setHeadersForProperties(builder, changeProperties);
		builder.post();
	}

}
