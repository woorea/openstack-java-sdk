package org.openstack.client.compute;

import java.util.HashMap;

import javax.ws.rs.client.Entity;

import org.openstack.api.compute.AsyncServerOperation;
import org.openstack.api.compute.FlavorResource;
import org.openstack.api.compute.ImageResource;
import org.openstack.api.compute.ServerResource;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaImageList;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.model.compute.NovaServerList;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ITServers extends ComputeApiTest {

	@Test
	public void listServers() {
		
		NovaServerList servers = client.compute().publicEndpoint().servers().get(new HashMap<String, Object>() {{ 
			put("detail", true);
		}});

		for (NovaServer server : servers.getList()) {
			//Until this is resolved? on compute server api we access throught id
			//NovaImage image = client.target(server.getImage().getLink("bookmark").getHref(), ImageResource.class).get(new HashMap<String, Object>());
			NovaImage image = client.compute().publicEndpoint().images().image(server.getImage().getId()).get(new HashMap<String, Object>());
			//rel=self carries the version but rel=bookmark ¿clarify from openstack team?
			client.target(server.getLink("self").getHref(), ServerResource.class).delete();
		}
	}

	
	@Test
	public void testCreateAndDeleteServer() throws OpenstackException {
		
		NovaImageList images = client.compute().publicEndpoint().images().get(new HashMap<String, Object>());
		NovaImage image = null;
		for (NovaImage i : images.getList()) {
			System.out.println(i);
			
			// HP Cloud image
			if (i.getName().equals("Ubuntu Lucid 10.04 LTS Server 64-bit")) {
				image = i;
				break;
			}

			// Devstack image
			if (i.getName().equals("cirros-0.3.0-x86_64-blank")) {
				image = i;
				break;
			}
		}

		if (image == null) {
			throw new SkipException("Skipping test because image not found");
		}

		NovaFlavor bestFlavor = null;
		for (NovaFlavor flavor : client.compute().publicEndpoint().flavors().get(new HashMap<String, Object>()).getList()) {
			if (bestFlavor == null || bestFlavor.getRam() > flavor.getRam()) {
				bestFlavor = flavor;
			}
		}

		NovaServerForCreate serverForCreate = new NovaServerForCreate();
		serverForCreate.setName(random.randomAlphanumericString(10));
		serverForCreate.setFlavorRef(findSmallestFlavor().getId());
		serverForCreate.setImageRef(image.getId());
		// serverForCreate.setSecurityGroups(new ArrayList<ServerForCreate.SecurityGroup>() {{
		// add(new ServerForCreate.SecurityGroup("test"));
		// }});
		System.out.println(serverForCreate);

		NovaServer server = client.compute().publicEndpoint().servers().post(new HashMap<String, Object>(), Entity.json(serverForCreate));

		// In trunk, the server returned from the create operation does not have image or flavor set
		// In Diablo(?)/HP Cloud, the image id is returned
		if (server.getImageId() != null) {
			checkLinkedItems(server);
		} else {
			// Not great, but nothing we can do about it
			System.out.println("No image returned from server create");
		}

		// Wait for the server to be ready
		AsyncServerOperation async = AsyncServerOperation.wrapServerCreate(client.compute(), server);
		NovaServer ready = async.get();

		Assert.assertEquals("ACTIVE", ready.getStatus());
		checkLinkedItems(ready);

		// Delete the server
		System.out.println(server);
		System.out.println("DELETING");
		client.compute().publicEndpoint().servers().server(server.getId()).delete();
		
		NovaServer stillHere = null;
		try {
			AsyncServerOperation asyncDelete = AsyncServerOperation.wrapServerDelete(client.compute(), server);
			asyncDelete.get();

			stillHere = client.compute().publicEndpoint().servers().server(server.getId()).get();
		} catch (Exception /*OpenstackNotFoundException*/ e) {
			//Jersey 2.0 doesn't work fine with exceptions yet
			// Good!
		}

		if (stillHere == null) {
			// Good!
		} else {
			Assert.assertEquals(stillHere.getStatus(), "DELETED");
		}
	}
	

	private void checkLinkedItems(NovaServer ready) {
		Assert.assertNotNull(ready.getImage());
		Assert.assertNotNull(ready.getImage().getId());
		Assert.assertNotNull(ready.getFlavor());
		Assert.assertNotNull(ready.getFlavor().getId());

		//bookmark link issue, so link through id
		NovaImage image = client.compute().publicEndpoint().images().image(ready.getImage().getId()).get(new HashMap<String, Object>());
		ready.setImage(image);

		Assert.assertNotNull(ready.getImage());
		Assert.assertNotNull(ready.getImage().getId());
		Assert.assertNotNull(ready.getImage().getName());
		Assert.assertNotNull(ready.getImage().getMinDisk());
		System.out.println(ready.getImage().getMinDisk());

		//bookmark link issue, so link through id
		NovaFlavor flavor = client.compute().publicEndpoint().flavors().flavor(ready.getFlavor().getId()).get(new HashMap<String, Object>());
		ready.setFlavor(flavor);

		Assert.assertNotNull(ready.getFlavor());
		Assert.assertNotNull(ready.getFlavor().getId());
		Assert.assertNotNull(ready.getFlavor().getName());
		Assert.assertNotNull(ready.getFlavor().getRam());
	}

}
