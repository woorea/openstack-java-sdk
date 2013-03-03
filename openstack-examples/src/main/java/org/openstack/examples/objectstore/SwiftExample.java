package org.openstack.examples.objectstore;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.ListTenants;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.utils.KeystoneUtils;
import org.openstack.swift.SwiftClient;
import org.openstack.swift.api.CreateContainer;
import org.openstack.swift.api.DownloadObject;
import org.openstack.swift.api.ListContainers;
import org.openstack.swift.api.ListObjects;
import org.openstack.swift.api.UploadObject;
import org.openstack.swift.model.ObjectDownload;
import org.openstack.swift.model.ObjectForUpload;

public class SwiftExample {
	
	private static final File TEST_FILE = new File("pom.xml");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);		
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD));
		
		//use the token in the following requests
		keystone.setToken(access.getToken().getId());
		
		Tenants tenants = keystone.execute(new ListTenants());
		
		//try to exchange token using the first tenant
		if(tenants.getList().size() > 0) {
			
			access = keystone.execute(Authenticate.withToken(access.getToken().getId()).withTenantId(tenants.getList().get(0).getId()));
			
			SwiftClient swiftClient = new SwiftClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "object-store", null, "public"), access.getToken().getId());
		
			//swiftClient.execute(new DeleteContainer("navidad2"));
			
			swiftClient.execute(new CreateContainer("navidad2"));
			
			System.out.println(swiftClient.execute(new ListContainers()));
			
			ObjectForUpload upload = new ObjectForUpload();
			upload.setContainer("navidad2");
			upload.setName("example2");
			upload.setInputStream(new FileInputStream(TEST_FILE));
			swiftClient.execute(new UploadObject(upload));
			
			System.out.println(swiftClient.execute(new ListObjects("navidad2", new HashMap<String, String>() {{
				put("path", "");
			}})).get(0).getContentType());
			
			
			ObjectDownload download = swiftClient.execute(new DownloadObject("navidad2", "example2"));
			write(download.getInputStream(), "example2");
		}

	}
	
	private static void write(InputStream is, String path) {
		try {
			OutputStream stream = new BufferedOutputStream(new FileOutputStream(path)); 
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
			    stream.write(buffer, 0, len);
			}
			stream.close();   
		} catch(IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}

}
