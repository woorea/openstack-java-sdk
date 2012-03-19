package org.openstack.client.storage;

import org.openstack.api.storage.OpenstackStorageClient;
import org.openstack.client.AbstractOpenStackTest;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;

public abstract class StorageIntegrationTest extends AbstractOpenStackTest {
	protected OpenstackStorageClient swift;

	@BeforeMethod
	@Override
	public void beforeMethod() {
		super.beforeMethod();

		skipIfNoSwift();

		this.swift = context.session.getStorageClient();
	}

	protected void skipIfNoSwift() {
		if (!context.isSwiftEnabled()) {
			throw new SkipException("Skipping because swift not present / accessible");
		}
	}
}
