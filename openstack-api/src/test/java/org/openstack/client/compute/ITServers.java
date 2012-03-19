package org.openstack.client.compute;

import java.util.HashMap;

import org.openstack.client.OpenStackComputeClient;
import org.openstack.client.OpenStackSession;
import org.openstack.model.compute.NovaServer;
import org.testng.annotations.Test;

public class ITServers extends ComputeApiTest {

	@Test
	public void listServers() {
		OpenStackComputeClient nova = getComputeClient();
		OpenStackSession session = nova.getSession();

		Iterable<NovaServer> list = nova.root().servers().get(new HashMap<String, Object>()).getList();
		// System.out.println(list);

		for (NovaServer server : list) {
			//NovaImage image = new ServerResource(session, server).getImage().get(new HashMap<String, Object>());
			//System.out.println(image);
			// System.out.println("DELETING");
			// nova.root().servers().server(server.getId()).delete();
		}
	}

	/*
	@Test
	public void testCreateAndDeleteServer() throws OpenstackException {
		OpenstackComputeClient nova = getComputeClient();

		OpenStackSession session = nova.getSession();

		Iterable<NovaImage> images = nova.root().images().list();
		NovaImage image = null;
		for (NovaImage i : images) {
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
		for (NovaFlavor flavor : nova.root().flavors().list()) {
			if (bestFlavor == null || bestFlavor.getRam() > flavor.getRam()) {
				bestFlavor = flavor;
			}
		}

		NovaServerForCreate serverForCreate = new NovaServerForCreate();
		serverForCreate.setName(random.randomAlphanumericString(10));
		serverForCreate.setFlavorRef(bestFlavor.getId());
		serverForCreate.setImageRef(image.getId());
		// serverForCreate.setSecurityGroups(new ArrayList<ServerForCreate.SecurityGroup>() {{
		// add(new ServerForCreate.SecurityGroup("test"));
		// }});
		System.out.println(serverForCreate);

		NovaServer server = nova.root().servers().create(serverForCreate);

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
		NovaServer ready = async.get();

		Assert.assertEquals("ACTIVE", ready.getStatus());
		checkLinkedItems(session, ready);

		// Delete the server
		System.out.println(server);
		System.out.println("DELETING");
		nova.root().servers().server(server.getId()).delete();

		AsyncServerOperation asyncDelete = AsyncServerOperation.wrapServerDelete(nova, server);
		asyncDelete.get();

		NovaServer stillHere = null;
		try {
			stillHere = nova.root().servers().server(server.getId()).show();
		} catch (OpenstackNotFoundException e) {
			// Good!
		}

		if (stillHere == null) {
			// Good!
		} else {
			Assert.assertEquals(stillHere.getStatus(), "DELETED");
		}
	}
	*/

	private void checkLinkedItems(OpenStackSession session, NovaServer ready) {
		/*
		Assert.assertNotNull(ready.getImage());
		Assert.assertNotNull(ready.getImage().getId());
		Assert.assertNotNull(ready.getFlavor());
		Assert.assertNotNull(ready.getFlavor().getId());

		System.out.println("XXX " + new ServerResource(context.session, ready).getImage().show());

		ready.setImage(new ServerResource(context.session, ready).getImage().show());

		Assert.assertNotNull(ready.getImage());
		Assert.assertNotNull(ready.getImage().getId());
		Assert.assertNotNull(ready.getImage().getName());
		Assert.assertNotNull(ready.getImage().getMinDisk());
		System.out.println(ready.getImage().getMinDisk());

		ready.setFlavor(new ServerResource(context.session, ready).getFlavor().show());

		Assert.assertNotNull(ready.getFlavor());
		Assert.assertNotNull(ready.getFlavor().getId());
		Assert.assertNotNull(ready.getFlavor().getName());
		Assert.assertNotNull(ready.getFlavor().getRam());
		*/
	}

}
