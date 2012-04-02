package org.openstack.client.compute;

import java.util.NoSuchElementException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openstack.api.compute.ServerResource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;
import org.openstack.model.compute.nova.NovaServerForCreate;
import org.openstack.model.compute.nova.server.actions.PauseAction;
import org.openstack.model.compute.nova.server.actions.UnpauseAction;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ITServers extends ComputeIntegrationTest {
	
	private Server server;

	@Test
	public void listServers() {
		
		ServerList servers = compute.servers().get();

		for (Server server : servers.getList()) {
			//Until this is resolved? on compute server api we access throught id
			//NovaImage image = client.target(server.getImage().getLink("bookmark").getHref(), ImageResource.class).get(new HashMap<String, Object>());
			Image image = compute.images().image(server.getImage().getId()).get();
			//rel=self carries the version but rel=bookmark ¿clarify from openstack team?
			//client.target(server.getLink("self").getHref(), ServerResource.class).delete();
		}
	}

	
	@Test
	public void createServer() throws Exception {
		
		try {
			Flavor bestFlavor = null;
			for (Flavor flavor : compute.flavors().get().getList()) {
				if (bestFlavor == null || bestFlavor.getRam() > flavor.getRam()) {
					bestFlavor = flavor;
				}
			}
			
			Image image = Iterables.find(compute.images().get().getList(), new Predicate<Image>() {

				@Override
				public boolean apply(Image image) {
					return "cirros-0.3.0-x86_64-uec".equals(image.getName());
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

			server = compute.servers().post(serverForCreate);
			waitForState("ACTIVE");
		} catch (NoSuchElementException e) {
			throw new SkipException("Skipping test because image not found");
		}

	}
	
	@Test(dependsOnMethods="createServer", priority=1)
	public void pauseServer() throws Exception {
		compute.servers().server(server.getId()).action().post(new PauseAction(), String.class);
		waitForState("PAUSED");
	}
	
	@Test(dependsOnMethods={"createServer"}, priority=2)
	public void unpauseServer() {
		compute.servers().server(server.getId()).action().post(new UnpauseAction(), String.class);
	}
	
	@Test(dependsOnMethods="createServer", priority=1000)
	public void deleteServer() {
		compute.servers().server(server.getId()).delete();
	}
	
	private void waitForState(final String state) {
		try {
			final ScheduledThreadPoolExecutor timer = new ScheduledThreadPoolExecutor(1);
			timer.scheduleAtFixedRate(new Runnable() {
				
				@Override
				public void run() {
					server = compute.servers().server(server.getId()).get();
					if(state.equals(server.getStatus())) {
						timer.shutdown();
					} else {
						System.out.print(".");
					}
				}
			}, 3, 1, TimeUnit.SECONDS);
			timer.awaitTermination(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			
		}
		
	}

}
