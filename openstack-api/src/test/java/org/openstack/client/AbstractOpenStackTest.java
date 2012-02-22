package org.openstack.client;

import org.openstack.client.utils.RandomUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

public class AbstractOpenStackTest {
	protected OpenstackTestContext context;
	protected RandomUtil random = new RandomUtil();

	@BeforeClass
	public void setUp() {
		context = OpenstackTestContext.buildFromProperties();
	}

	protected void skipUntilBugFixed(int bugNumber) {
		throw new SkipException("Skipping because of bug #" + bugNumber);
	}
}
