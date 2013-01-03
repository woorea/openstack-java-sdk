package org.openstack.examples.objectstore;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.ListTenants;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.utils.KeystoneUtils;
import org.openstack.swift.SwiftClient;
import org.openstack.swift.api.CreateContainer;
import org.openstack.swift.api.DeleteContainer;
import org.openstack.swift.api.ListContainers;
import org.openstack.swift.api.ListObjects;
import org.openstack.swift.api.UploadObject;
import org.openstack.swift.model.ObjectForUpload;

public class SwiftExample {
	
	private static final File TEST_FILE = new File("pom.xml");
	
	private static final String KEYSTONE_AUTH_URL = "https://region-a.geo-1.identity.hpcloudsvc.com:35357/v2.0";
	
	private static final String KEYSTONE_USERNAME = "";
	
	private static final String KEYSTONE_PASSWORD = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		KeystoneClient keystone = new KeystoneClient(KEYSTONE_AUTH_URL);		
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(KEYSTONE_USERNAME, KEYSTONE_PASSWORD));
		
		//use the token in the following requests
		keystone.setToken(access.getToken().getId());
		
		Tenants tenants = keystone.execute(new ListTenants());
		
		//try to exchange token using the first tenant
		if(tenants.getList().size() > 0) {
			
			access = keystone.execute(Authenticate.withToken(access.getToken().getId()).withTenantId(tenants.getList().get(0).getId()));
			
			SwiftClient swiftClient = new SwiftClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "object-store", null, "public"), access.getToken().getId());
		
			swiftClient.execute(new DeleteContainer("navidad"));
			
			swiftClient.execute(new CreateContainer("navidad"));
			
			System.out.println(swiftClient.execute(new ListContainers()));
			
			ObjectForUpload upload = new ObjectForUpload();
			upload.setContainer("navidad");
			upload.setName("example");
			upload.setInputStream(new FileInputStream(TEST_FILE));
			swiftClient.execute(new UploadObject(upload));
			
			System.out.println(swiftClient.execute(new ListObjects("navidad", new HashMap<String, String>() {{
				put("path", "");
			}})).get(0).getContentType());
			
		}

	}

}
