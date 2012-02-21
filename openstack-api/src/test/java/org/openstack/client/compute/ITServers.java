package org.openstack.client.compute;

import org.openstack.client.OpenstackException;
import org.openstack.client.OpenstackNotFoundException;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackSession;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerForCreate;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ITServers extends ComputeApiTest {

	@Test
	public void listServers() {
		OpenstackComputeClient nova = getComputeClient();
		OpenstackSession session = nova.getSession();

		Iterable<Server> list = nova.root().servers().list();
		// System.out.println(list);

		for (Server server : list) {
			Image image = server.getImage(session);
			System.out.println(image);
			// System.out.println("DELETING");
			// nova.root().servers().server(server.getId()).delete();
		}
	}

	@Test
	public void testCreateAndDeleteServer() throws OpenstackException {
		OpenstackComputeClient nova = getComputeClient();

		OpenstackSession session = nova.getSession();

		Iterable<Image> images = nova.root().images().list();
		Image image = null;
		for (Image i : images) {
			System.out.println(i);
			if (i.getId().equals("1a0772cd-066c-4de3-a395-b28913e8cfa4")) {
				image = i;
				break;
			}

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

		Flavor bestFlavor = null;
		for (Flavor flavor : nova.root().flavors().list()) {
			if (bestFlavor == null || bestFlavor.getRam() > flavor.getRam()) {
				bestFlavor = flavor;
			}
		}

		ServerForCreate serverForCreate = new ServerForCreate();
		serverForCreate.setName(random.randomAlphanumericString(10));
		serverForCreate.setFlavorRef(bestFlavor.getId());
		serverForCreate.setImageRef(image.getId());
		// serverForCreate.setSecurityGroups(new ArrayList<ServerForCreate.SecurityGroup>() {{
		// add(new ServerForCreate.SecurityGroup("test"));
		// }});
		System.out.println(serverForCreate);

		Server server = nova.root().servers().create(serverForCreate);

		

		// In trunk, the server returned from the create operation does not have image or flavor set
		// In Diablo(?)/HP Cloud, the image id is returned
		if (server.getImageId() != null) {
			checkLinkedItems(session, server);
		} else {
			// Not great, but nothing we can do about it
			System.out.println("No image returned from server create");
		}
		
		// Wait for the server to be ready
		AsyncServerOperation async = AsyncServerOperation.wrapServerCreate(nova, server);
		Server ready = async.get();

		Assert.assertEquals("ACTIVE", ready.getStatus());
		checkLinkedItems(session, ready);
		
		// Delete the server
		System.out.println(server);
		System.out.println("DELETING");
		nova.root().servers().server(server.getId()).delete();
		
		AsyncServerOperation asyncDelete = AsyncServerOperation.wrapServerDelete(nova, server);
		asyncDelete.get();
		
		Server stillHere = null;
		try {
			stillHere = nova.root().servers().server(server.getId()).show();
		}
		catch (OpenstackNotFoundException e) {
			// Good!
		}
		Assert.assertNull(stillHere);
	}

	private void checkLinkedItems(OpenstackSession session, Server ready) {
		Assert.assertNotNull(ready.getImage(null));
		Assert.assertNotNull(ready.getImage(null).getId());
		Assert.assertNotNull(ready.getFlavor(null));
		Assert.assertNotNull(ready.getFlavor(null).getId());

		Assert.assertNotNull(ready.getImage(session));
		Assert.assertNotNull(ready.getImage(session).getId());
		Assert.assertNotNull(ready.getImage(session).getName());
		Assert.assertNotNull(ready.getImage(session).getMinDisk());
		System.out.println(ready.getImage(session).getMinDisk());

		Assert.assertNotNull(ready.getFlavor(session));
		Assert.assertNotNull(ready.getFlavor(session).getId());
		Assert.assertNotNull(ready.getFlavor(session).getName());
		Assert.assertNotNull(ready.getFlavor(session).getRam());
	}

}
