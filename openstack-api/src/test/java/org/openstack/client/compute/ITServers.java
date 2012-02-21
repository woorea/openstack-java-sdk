package org.openstack.client.compute;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackSession;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerForCreate;
import org.openstack.model.compute.ServerList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ITServers extends ComputeApiTest {
	
	@Test
	public void listServers() {
		OpenstackComputeClient nova = getComputeClient();
		OpenstackSession session = nova.getSession();
		
		Iterable<Server> list = nova.root().servers().list();
//		System.out.println(list);
		
		for(Server server : list) {
			Image image = server.getImage(session);
			System.out.println(image);
//			System.out.println("DELETING");
//	        nova.root().servers().server(server.getId()).delete();
		}
	}
	
	@Test
	public void testCreateAndDeleteServer() throws OpenstackException {
        OpenstackComputeClient nova = getComputeClient();

        OpenstackSession session = nova.getSession();
        
        //Iterable<Flavor> flavors = nova.root().flavors().list();
        //Flavor flavor = flavors.iterator().next();
        
        Iterable<Image> images = nova.root().images().list();
        Image image = null;
        for(Image i : images) {
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
        //serverForCreate.setSecurityGroups(new ArrayList<ServerForCreate.SecurityGroup>() {{
        //	add(new ServerForCreate.SecurityGroup("test"));
        //}});
        System.out.println(serverForCreate);
        
        /*
        AsyncServerOperation async = nova.createServer(serverForCreate);
        Server server = async.get();
        */
        
        Server server = nova.root().servers().create(serverForCreate);
        System.out.println(server.getImage(session).getMinDisk());
        
        System.out.println(server);
        System.out.println("DELETING");
        nova.root().servers().server(server.getId()).delete();
	}

	
}
