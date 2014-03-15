package com.woorea.openstack.examples.objectstore;

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

import com.woorea.openstack.swift.model.ObjectDownload;

public class ObjectDownloadMessageBodyReader implements MessageBodyReader<ObjectDownload> {
	 
	@Override
	public boolean isReadable(Class<?> type, Type genericType,
	    Annotation[] annotations, MediaType mediaType) {
	    return type == ObjectDownload.class;
	}
	 
	@Override
	public ObjectDownload readFrom(Class<ObjectDownload> type,
	    Type genericType,
	    Annotation[] annotations, MediaType mediaType,
	    MultivaluedMap<String, String> httpHeaders,
	    InputStream entityStream)
	        throws IOException, WebApplicationException {
			ObjectDownload objectDownload = new ObjectDownload();
			objectDownload.setInputStream(copyStream(entityStream));
			return objectDownload;

	}
	
    private InputStream copyStream(InputStream stream) throws IOException {
        byte[] entity = new byte[4096];
        int entitySize = 0;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((entitySize = stream.read(entity)) != -1) {
        	baos.write(entity, 0, entitySize);
        }
        return new ByteArrayInputStream(baos.toByteArray());
    }	
}
