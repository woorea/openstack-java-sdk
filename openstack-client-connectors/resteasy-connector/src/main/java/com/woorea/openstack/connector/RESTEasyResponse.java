package com.woorea.openstack.connector;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import com.woorea.openstack.base.client.OpenStackResponse;

import javax.ws.rs.core.MultivaluedMap;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RESTEasyResponse implements OpenStackResponse {

    private ClientRequest client;

    private ClientResponse response;

    public RESTEasyResponse(ClientRequest client, ClientResponse response) {
        this.client = client;
        this.response = response;
    }

    @Override
    public <T> T getEntity(Class<T> returnType) {
        return (T) response.getEntity(returnType);
    }

    @Override
    public InputStream getInputStream() {
		return new RESTEasyInputStream((InputStream) response.getEntity(InputStream.class), client.getExecutor());
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
