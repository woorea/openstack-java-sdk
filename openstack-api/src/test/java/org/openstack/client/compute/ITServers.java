package org.openstack.client.compute;

import java.util.NoSuchElementException;

import javax.ws.rs.client.Entity;

import org.openstack.api.compute.ServerResource;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.model.compute.NovaServerList;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ITServers extends ComputeIntegrationTest {
	
	private NovaServer server;

	@Test
	public void listServers() {
		
		NovaServerList servers = compute.servers().get();

		for (NovaServer server : servers.getList()) {
			//Until this is resolved? on compute server api we access throught id
			//NovaImage image = client.target(server.getImage().getLink("bookmark").getHref(), ImageResource.class).get(new HashMap<String, Object>());
			NovaImage image = compute.images().image(server.getImage().getId()).get();
			//rel=self carries the version but rel=bookmark ¿clarify from openstack team?
			client.target(server.getLink("self").getHref(), ServerResource.class).delete();
		}
	}

	
	@Test
	public void createServer() throws OpenstackException {
		
		try {
			NovaFlavor bestFlavor = null;
			for (NovaFlavor flavor : compute.flavors().get().getList()) {
				if (bestFlavor == null || bestFlavor.getRam() > flavor.getRam()) {
					bestFlavor = flavor;
				}
			}
			
			NovaImage image = Iterables.find(compute.images().get().getList(), new Predicate<NovaImage>() {

				@Override
				public boolean apply(NovaImage image) {
					return "cirros-0.3.0-x86_64-blank".equals(image.getName());
				}
			});
			
			NovaServerForCreate serverForCreate = new NovaServerForCreate();
			serverForCreate.setName(random.randomAlphanumericString(10));
			serverForCreate.setFlavorRef(findSmallestFlavor().getId());
			serverForCreate.setImageRef(image.getId());
			// serverForCreate.setSecurityGroups(new ArrayList<ServerForCreate.SecurityGroup>() {{
			// add(new ServerForCreate.SecurityGroup("test"));
			// }});
			System.out.println(serverForCreate);

			server = compute.servers().post(Entity.json(serverForCreate));
			
		} catch (NoSuchElementException e) {
			throw new SkipException("Skipping test because image not found");
		}

	}
	
	@Test(dependsOnMethods="createServer")
	public void deleteServer() {
		compute.servers().server(server.getId()).delete();
	}

}
