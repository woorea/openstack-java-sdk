package org.openstack.client;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

public class AbstractOpenStackTest {
	protected OpenstackTestContext context;

	@BeforeClass
	public void setUp() {
		context = OpenstackTestContext.buildFromProperties();
	}

	protected void skipUntilBugFixed(int bugNumber) {
		throw new SkipException("Skipping because of bug #" + bugNumber);
	}
}
