package org.openstack.client.internals;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.ser.std.SerializerBase;
import org.codehaus.jackson.type.JavaType;
import org.openstack.model.compute.NovaAddresses;
import org.openstack.model.compute.NovaAddresses.Network;
import org.openstack.model.compute.NovaAddresses.Network.Ip;

import com.google.common.collect.Lists;

public class AddressesDeserializer extends StdDeserializer<NovaAddresses> {

	protected AddressesDeserializer() {
		super(NovaAddresses.class);
	}

	@Override
	public NovaAddresses deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		NovaAddresses addresses = new NovaAddresses();

		JsonToken token = jp.getCurrentToken();
		if (token != JsonToken.START_OBJECT) {
			throw ctxt.wrongTokenException(jp, JsonToken.START_OBJECT, "Unexpected token");
		}

		while ((token = jp.nextToken()) != JsonToken.END_OBJECT) {
			switch (token) {
			case FIELD_NAME:
				String key = jp.getText();
				Network network = new Network();

				network.setId(key);

				jp.nextToken();
				network.getIps().addAll(readIpArray(jp, ctxt));

				addresses.getNetworks().add(network);
				break;

			default:
				throw ctxt.wrongTokenException(jp, JsonToken.FIELD_NAME, "Unexpected token");
			}
		}

		return addresses;
	}

	private List<Ip> readIpArray(JsonParser jp, DeserializationContext ctxt) throws JsonProcessingException,
			IOException {
		List<Ip> ips = Lists.newArrayList();

		JsonToken token = jp.getCurrentToken();
		if (token != JsonToken.START_ARRAY) {
			throw ctxt.wrongTokenException(jp, JsonToken.START_ARRAY, "Unexpected token");
		}

		while ((token = jp.nextToken()) != JsonToken.END_ARRAY) {
			switch (token) {
			case START_OBJECT:
				Ip ip = jp.readValueAs(Ip.class);
				ips.add(ip);
				break;

			default:
				throw ctxt.wrongTokenException(jp, JsonToken.START_OBJECT, "Unexpected token");
			}
		}

		return ips;
	}

}
