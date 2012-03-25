package org.openstack.client.storage;

import java.util.List;

import javax.ws.rs.core.Response;

import org.openstack.api.storage.AccountResource;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.model.storage.SwiftAccount;
import org.openstack.model.storage.SwiftContainer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StorageIntegrationTest extends AbstractOpenStackTest {
	
	private AccountResource storage;
	
	private SwiftAccount account;
	private SwiftContainer container;
	private SwiftAccount object;

	@BeforeClass
	public void init() {
		super.init();
//		if (!swiftEnabled) {
//			throw new SkipException("Skipping because swift not present / accessible");
//		}
		storage = client.target("http://192.168.1.52:8080/v1/AUTH_"+client.getAccess().getToken().getTenant().getId(), AccountResource.class);
	}
	
	public void showAccount() {
		Response response = storage.head();
	}
	
	public void updateAccount() {
		//Response response = storage.post();
	}
	
	@Test(priority=1)
	public void createContainer() {
		Response response = storage.container("test-container").put();
	}
	@Test(priority=2)
	public void listContainers() {
		List<SwiftContainer> containers = storage.get();
	}
	@Test(dependsOnMethods="createContainer")
	public void showContainer() {
		storage.container(container.getName()).head();
	}
	@Test(dependsOnMethods="createContainer")
	public void updateContainer() {
		storage.container(container.getName()).post();
	}
	@Test(dependsOnMethods="createContainer")
	public void deleteContainer() {
		storage.container("").delete();
	}
	
	@Test(dependsOnMethods="createTenant", priority=1)
	public void createObject() {
		Response response = storage.container(container.getName()).object("test-object").post(null);
	}
	
	@Test(dependsOnMethods={"createObject"})
	public void listObjects() {
		storage.container("").get();
	}
	
	@Test(dependsOnMethods={"createObject"})
	public void showObject() {
		storage.container("").object("").head();
	}
	
	@Test(dependsOnMethods="createObject")
	public void updateObject() {
		storage.container("").object("").post(null);
	}
	
	@Test(dependsOnMethods={"createObject"})
	public void deleteObject() {
		storage.container("").object("").delete();
	}
	
}
