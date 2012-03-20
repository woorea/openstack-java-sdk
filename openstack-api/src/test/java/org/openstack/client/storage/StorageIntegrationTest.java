package org.openstack.client.storage;

import org.openstack.client.AbstractOpenStackTest;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;

public abstract class StorageIntegrationTest extends AbstractOpenStackTest {

	@BeforeMethod
	@Override
	public void beforeMethod() {
		super.beforeMethod();

		skipIfNoSwift();
	}

	protected void skipIfNoSwift() {
		if (!swiftEnabled) {
			throw new SkipException("Skipping because swift not present / accessible");
		}
	}
}
