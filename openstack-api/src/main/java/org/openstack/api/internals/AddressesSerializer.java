package org.openstack.api.internals;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.SerializerBase;
import org.openstack.model.compute.NovaAddresses;
import org.openstack.model.compute.NovaAddresses.Network;
import org.openstack.model.compute.NovaAddresses.Network.Ip;

public class AddressesSerializer extends SerializerBase<NovaAddresses> {

	protected AddressesSerializer() {
		super(NovaAddresses.class);
	}

	@Override
	public void serialize(NovaAddresses value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonGenerationException {
		jgen.writeStartObject();
		for (Network network : value.getNetworks()) {
			jgen.writeFieldName(network.getId());
			jgen.writeStartArray();
			for (Ip ip : network.getIps()) {
				jgen.writeObject(ip);
			}
			jgen.writeEndArray();
		}
		jgen.writeEndObject();
	}

}
