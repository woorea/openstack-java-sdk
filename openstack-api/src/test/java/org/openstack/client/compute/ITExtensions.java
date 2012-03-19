package org.openstack.client.compute;

import java.util.HashMap;

import org.openstack.client.OpenStackComputeClient;
import org.openstack.model.common.Extension;
import org.openstack.model.common.ExtensionList;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITExtensions extends ComputeApiTest {

    @Test
    public void testListExtensions() throws OpenstackException {
        OpenStackComputeClient nova = getComputeClient();
        ExtensionList extensions = nova.root().extensions().get(new HashMap<String, Object>());
        for (Extension extension : extensions) {
            Extension details = nova.root().extensions().extension(extension.getAlias()).get(new HashMap<String, Object>());

            Assert.assertEquals(details.getAlias(), extension.getAlias());
            Assert.assertEquals(details.getDescription(), extension.getDescription());
            Assert.assertEquals(details.getName(), extension.getName());
            Assert.assertEquals(details.getNamespace(), extension.getNamespace());
            Assert.assertEquals(details.getUpdated(), extension.getUpdated());
        }
    }
}
