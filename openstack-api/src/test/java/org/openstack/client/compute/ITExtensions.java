package org.openstack.client.compute;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.Extension;
import org.openstack.model.compute.ExtensionList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITExtensions extends ComputeApiTest {

    @Test
    public void testListExtensions() throws OpenstackException {
        OpenstackComputeClient nova = getComputeClient();
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
