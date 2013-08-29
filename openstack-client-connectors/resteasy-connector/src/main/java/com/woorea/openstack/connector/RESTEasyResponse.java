package com.woorea.openstack.connector;

import org.jboss.resteasy.client.ClientResponse;
import com.woorea.openstack.base.client.OpenStackResponse;

import javax.ws.rs.core.MultivaluedMap;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RESTEasyResponse implements OpenStackResponse {

    private ClientResponse response;

    public RESTEasyResponse(ClientResponse response) {
        this.response = response;
    }

    @Override
    public <T> T getEntity(Class<T> returnType) {
        return (T) response.getEntity(returnType);
    }

    @Override
    public InputStream getInputStream() {
		return (InputStream) response.getEntity(InputStream.class);
    }

    @Override
    public String header(String name) {
        return response.getHeaders().getFirst(name).toString();
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<String, String>();
        MultivaluedMap<String, Object> responseHeaders = response.getHeaders();

        for (String key : responseHeaders.keySet()) {
            headers.put(key, responseHeaders.getFirst(key).toString());
        }

        return headers;
    }

}
