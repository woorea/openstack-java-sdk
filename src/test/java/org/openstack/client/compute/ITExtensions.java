package org.openstack.client.compute;

import org.openstack.model.common.Extension;
import org.openstack.model.common.ExtensionList;
import org.openstack.model.exceptions.OpenStackException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITExtensions extends ComputeIntegrationTest {

    @Test
    public void testListExtensions() throws OpenStackException {
        
        ExtensionList extensions = compute.extensions().get();
        for (Extension extension : extensions) {
            Extension details = compute.extensions().extension(extension.getAlias()).get();

            Assert.assertEquals(details.getAlias(), extension.getAlias());
            Assert.assertEquals(details.getDescription(), extension.getDescription());
            Assert.assertEquals(details.getName(), extension.getName());
            Assert.assertEquals(details.getNamespace(), extension.getNamespace());
            Assert.assertEquals(details.getUpdated(), extension.getUpdated());
        }
    }
}
