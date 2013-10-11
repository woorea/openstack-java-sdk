package org.openstack.examples.objectstore;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftClient;
import org.openstack.swift.api.*;
import org.openstack.swift.model.Object;

/**
 * Swift copy operation with TempAuth.
 * The containers and source file need to exist.
 *
 * @author Robin Bramley
 */
public class SwiftCopyExample {
    
    public static void main( String[] args ) {
        SwiftClient swiftClient = new SwiftClient("https://192.168.22.66:8443/auth/v1.0", null);
        Response res = swiftClient.execute(new TempAuthenticate("test:tester", "testing"));
        
        String storageUrl = res.getHeaderString(TempAuthenticate.RES_HEADER_STORAGE_URL);
        String token = res.getHeaderString(TempAuthenticate.RES_HEADER_AUTH_TOKEN);
        System.out.println("Token: " + token);
        
        swiftClient = new SwiftClient(storageUrl, token);
        
        swiftClient.execute(new CopyObject("container1","robin_monochrome.jpg","backup","rb-mono.jpg", "image/jpeg"));
        
        List<Object> objs = swiftClient.execute(new ListObjects("backup", new HashMap<String, String>() {{
            put("path", "");
        }}));
        for(Object obj : objs) {
            System.out.println(obj.getName() + " - " + obj.getContentType());
        }
    }
}
