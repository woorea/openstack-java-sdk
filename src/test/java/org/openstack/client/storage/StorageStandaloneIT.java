package org.openstack.client.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.Response;

import org.openstack.api.authentication.SwiftTempAuthenticationProvider;
import org.openstack.api.storage.AccountResource;
import org.openstack.client.StorageClient;
import org.openstack.model.storage.StorageContainer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StorageStandaloneIT {
	
	private AccountResource storage;
	
	private String container = "test-container";
	private String object = "test-object";

	@BeforeClass
	public void init() {
		Properties properties = new Properties();
		properties.put("auth.provider", "org.openstack.api.authentication.SwiftTempAuthenticationProvider");
		properties.put("storage.auth.endpoint", "http://192.168.1.43:8080/auth/v1.0");
		properties.put("storage.auth.account", "admin");
		properties.put("storage.auth.username", "admin");
		properties.put("storage.auth.password", "admin");
		StorageClient client = StorageClient.authenticate(properties);
		storage = client.getAccountResource();
	}
	
	@Test
	public void showAccount() {
		Response response = storage.head();
	}
	
	public void updateAccount() {
		//Response response = storage.post();
	}
	
	@Test(priority=1)
	public void createContainer() {
		Response response = storage.container(container).put();
	}
	@Test(priority=2)
	public void listContainers() {
		List<StorageContainer> containers = storage.get();
	}
	@Test(dependsOnMethods="createContainer", priority=1)
	public void showContainer() {
		storage.container(container).head();
	}
	@Test(dependsOnMethods="createContainer", priority=2)
	public void updateContainer() {
		//storage.container(container.getName()).post();
	}
	
	@Test(dependsOnMethods="createContainer", priority=3)
	public void createObject() throws Exception {
		//SwiftStorageObjectProperties properties = new SwiftStorageObjectProperties();
		//properties.setName("test-object");
		//InputStream is = new ByteArrayInputStream(new byte[1024]);
		//InputStream is = new FileInputStream("/Users/woorea/Downloads/D50102GC20_sg2.pdf");
		//File file = new File("/Users/woorea/Downloads/ubuntu-11.10-desktop-amd64.iso");
		File file = new File("/Users/woorea/Downloads/D50102GC20_sg2.pdf");
		//InputStream is = new FileInputStream(file);
		Response response = storage.container(container).object(object).put(file);
	}
	
	@Test(dependsOnMethods={"createObject"}, priority=4)
	public void listObjects() {
		storage.container(container).get();
	}
	
	@Test(dependsOnMethods={"createObject"}, priority=5)
	public void showObject() {
		storage.container(container).object(object).head();
	}
	
	@Test(dependsOnMethods="createObject", priority=6)
	public void updateObject() {
		//storage.container(container).object(object).post(null);
	}
	
	@Test(dependsOnMethods={"createObject"}, priority=7)
	public void deleteObject() {
		storage.container(container).object(object).delete();
	}
	
	@Test(dependsOnMethods={"createContainer","deleteObject"}, priority=8)
	public void deleteContainer() {
		storage.container(container).delete();
	}
	
	
}
