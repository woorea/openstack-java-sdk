package org.openstack.api.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.io.IOUtils;
import org.openstack.model.common.JsonRootElement;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Encapsulates GSON support for custom serializing/deserializing objects.
 * TODO: [GsonProvider] This is the reusable class.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class GsonProvider implements MessageBodyWriter<Object>, MessageBodyReader<Object> {

    private Gson gson;

    @Context
    public Providers providers;
    
    public GsonProvider() {
    	final GsonBuilder gsonBuilder = new GsonBuilder()
    		.setPrettyPrinting();
    	gson = gsonBuilder.create();
    }

    // message body reader implementation

    /**
     * {@inheritDoc}
     */
    public boolean isReadable(Class<?> type, Type genericType, java.lang.annotation.Annotation[] annotations, MediaType mediaType) {
        // all the types are supported
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public Object readFrom(Class<Object> type, Type genericType, java.lang.annotation.Annotation[] annotations,
                           MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
                           InputStream entityStream) throws IOException, WebApplicationException {
        // all the aspects of the system shall encode their content in the UTF-8 encoding.
        final InputStreamReader streamReader = new InputStreamReader(entityStream, Charsets.UTF_8);
        String json = IOUtils.toString(streamReader);
        System.out.println("<<< " + json);
        try {
        	Object result = null;
        	JsonRootElement jsonRootElement = type.getAnnotation(JsonRootElement.class);
        	if(jsonRootElement != null) {
        		JsonElement je = gson.fromJson(json, JsonElement.class).getAsJsonObject().get(jsonRootElement.value());
        		if("access".equals(jsonRootElement.value())) {
        			if(!je.getAsJsonObject().get("serviceCatalog").isJsonArray()) {
        				//dirty hack since when no services keystone does not return an array it returns an object!
        				je.getAsJsonObject().remove("serviceCatalog");
        			}
        		}
            	//JsonObject jo = je.getAsJsonObject();
            	//Set<Entry<String, JsonElement>> els = jo.entrySet();
            	//je = els.iterator().next().getValue();
            	result = gson.fromJson(je, genericType);
        	} else {
        		result = gson.fromJson(json, genericType);
        	}
        	System.out.println("<<< " + result);
            return result;
        } finally {
            streamReader.close();
        }
    }


    // message body writer implementation

    /**
     * {@inheritDoc}
     */
    public boolean isWriteable(Class<?> type, Type genericType, java.lang.annotation.Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public long getSize(Object object, Class<?> type, Type genericType, java.lang.annotation.Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public void writeTo(Object object, Class<?> type, Type genericType, java.lang.annotation.Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws IOException, WebApplicationException {
    	JsonRootElement jsonRootElement = object.getClass().getAnnotation(JsonRootElement.class);
    	final OutputStreamWriter writer = new OutputStreamWriter(entityStream, Charsets.UTF_8);
    	try {
    		System.out.println(">>> " + object);
	        JsonElement element = gson.toJsonTree(object);
	        JsonObject json = new JsonObject();
	        json.add(jsonRootElement.value(), element);
	        System.out.println(">>> " + json);
	        writer.write(json.toString());
    	} finally {
            writer.close();
        }
        /*
        try {
            final Type jsonType;
            if (type.equals(genericType)) {
                jsonType = type;
            } else {
                jsonType = genericType;
            }

            new Gson().toJson(object, jsonType, writer);
        } finally {
            writer.close();
        }
        */
    }
}
