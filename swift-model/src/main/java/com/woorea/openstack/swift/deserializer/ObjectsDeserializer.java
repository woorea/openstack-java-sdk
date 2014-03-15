package com.woorea.openstack.swift.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.woorea.openstack.swift.model.Objects;

public class ObjectsDeserializer extends JsonDeserializer<Objects> {

	@Override
	public Objects deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		com.woorea.openstack.swift.model.Object[] containersArray = jp.readValueAs(com.woorea.openstack.swift.model.Object[].class);
		return new Objects(containersArray);
	}

}
