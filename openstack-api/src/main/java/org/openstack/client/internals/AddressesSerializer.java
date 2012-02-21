package org.openstack.client.internals;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.SerializerBase;
import org.openstack.model.compute.Addresses;
import org.openstack.model.compute.Addresses.Network;
import org.openstack.model.compute.Addresses.Network.Ip;

public class AddressesSerializer extends SerializerBase<Addresses> {

	protected AddressesSerializer() {
		super(Addresses.class);
	}

	@Override
	public void serialize(Addresses value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
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
