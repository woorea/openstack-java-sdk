package com.woorea.openstack.examples.objectstore;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.woorea.openstack.swift.model.Container;
import com.woorea.openstack.swift.model.Containers;
public class ContainersMessageBodyReader implements MessageBodyReader<Containers> {
	 
	@Override
	public boolean isReadable(Class<?> type, Type genericType,
	    Annotation[] annotations, MediaType mediaType) {
	    return type == Containers.class;
	}
	 
	@Override
	public Containers readFrom(Class<Containers> type,
	    Type genericType,
	    Annotation[] annotations, MediaType mediaType,
	    MultivaluedMap<String, String> httpHeaders,
	    InputStream entityStream)
	        throws IOException, WebApplicationException {
			ObjectMapper DEFAULT_MAPPER = new ObjectMapper();
			DEFAULT_MAPPER.setSerializationInclusion(Include.NON_NULL);
			DEFAULT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
			DEFAULT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);		
			Container[] containersArray = DEFAULT_MAPPER.readValue(entityStream, Container[].class);
			return new Containers(containersArray);

	}
	
    private InputStream copyStream(InputStream stream) throws IOException {
        if (!stream.markSupported()) {
            stream = new BufferedInputStream(stream);
        }
        byte[] entity = new byte[4096];
        int entitySize = 0;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((entitySize = stream.read(entity)) != -1) {
        	baos.write(entity, 0, entitySize);
        }
        stream.reset();
        return new ByteArrayInputStream(baos.toByteArray());
    }	
}
