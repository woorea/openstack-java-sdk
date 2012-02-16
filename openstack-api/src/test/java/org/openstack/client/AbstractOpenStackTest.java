package org.openstack.client;

import org.testng.annotations.BeforeClass;

public class AbstractOpenStackTest {
    protected OpenstackTestContext context;

    @BeforeClass
    public void setUp() {
        context = OpenstackTestContext.buildFromProperties();
    }
}
