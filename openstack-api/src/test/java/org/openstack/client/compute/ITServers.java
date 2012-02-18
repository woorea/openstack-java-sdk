package org.openstack.client.compute;

import java.util.ArrayList;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackClient;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerForCreate;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ITServers extends ComputeApiTest {
	
	@Test
	public void testCreateAndDeleteServer() throws OpenstackException {
		OpenstackClient client = context.client;
        OpenstackComputeClient nova = client.getComputeClient();
        
        //Iterable<Flavor> flavors = nova.root().flavors().list();
        //Flavor flavor = flavors.iterator().next();
        
        ImagesRepresentation images = nova.root().images().list();
        Image image = null;
        for(Image i : images.getList()) {
        	System.out.println(i);
        	if(i.getId().equals("1a0772cd-066c-4de3-a395-b28913e8cfa4")) {
        		image = i;
        		break;
        	}
        }
        
		if (image == null) {
			throw new SkipException("Skipping test because image not found");
		}

        ServerForCreate serverForCreate = new ServerForCreate();
        serverForCreate.setName("eureka1");
        serverForCreate.setFlavorRef("1");
        serverForCreate.setImageRef(image.getId());
        serverForCreate.setSecurityGroups(new ArrayList<ServerForCreate.SecurityGroup>() {{
        	add(new ServerForCreate.SecurityGroup("test"));
        }});
        System.out.println(serverForCreate);
        
        /*
        AsyncServerOperation async = nova.createServer(serverForCreate);
        Server server = async.get();
        */
        
        Server server = nova.root().servers().create(serverForCreate);
        
        System.out.println(server);
        System.out.println("DELETING");
        nova.root().servers().server(server.getId()).delete();
	}

	//@Test
    public void testListSecurityGroups() throws OpenstackException {
        OpenstackClient client = context.client;
        OpenstackComputeClient nova = client.getComputeClient();
        SecurityGroupList securityGroups = nova.root().securityGroups().list();
        for (org.openstack.model.compute.SecurityGroup securityGroup : securityGroups.getList()) {
        	org.openstack.model.compute.SecurityGroup securityGroup2 = nova.root().securityGroups().securityGroup(securityGroup.getId()).show();
            
            Assert.assertEquals(securityGroup.getId(), securityGroup2.getId());
            Assert.assertEquals(securityGroup.getTenantId(), securityGroup2.getTenantId());
            Assert.assertEquals(securityGroup.getName(), securityGroup2.getName());
            Assert.assertEquals(securityGroup.getDescription(), securityGroup2.getDescription());
            
        }
    }
	
}
