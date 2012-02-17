package org.openstack.client.compute;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackClient;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.Extension;
import org.openstack.model.compute.ExtensionList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExtensions extends ComputeApiTest {

    @Test
    public void testListExtensions() throws OpenstackException {
        OpenstackClient client = context.client;
        OpenstackComputeClient nova = client.getComputeClient();
        ExtensionList extensions = nova.root().extensions().list();
        for (Extension extension : extensions) {
            Extension details = nova.root().extensions().extension(extension.getAlias()).show();

            Assert.assertEquals(details.getAlias(), extension.getAlias());
            Assert.assertEquals(details.getDescription(), extension.getDescription());
            Assert.assertEquals(details.getName(), extension.getName());
            Assert.assertEquals(details.getNamespace(), extension.getNamespace());
            Assert.assertEquals(details.getUpdated(), extension.getUpdated());
        }
    }
}
