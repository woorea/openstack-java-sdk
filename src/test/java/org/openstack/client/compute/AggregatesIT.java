package org.openstack.client.compute;

import java.util.HashMap;
import java.util.Map;

import org.openstack.model.compute.nova.aggregate.AggregateActions;
import org.openstack.model.compute.nova.aggregate.AggregateForCreate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AggregatesIT extends ComputeIntegrationTest {

	@BeforeClass
	public void init() {
		init("etc/openstack.admin.properties");
		compute = client.getComputeEndpoint();
	}
	
	@Test
	public void create() {
		AggregateForCreate aggregate = new AggregateForCreate();
		aggregate.setName("aggregate.1");
		aggregate.setAvailabilityZone("nova");
		compute.aggregates().post(aggregate);
	}
	
	@Test
	public void setMetadata() {
		//actually adds metadata
		Map<String, String> data = new HashMap<String, String>();
		data.put("k1", "v1");
		data.put("k2", "v2");
		compute.aggregates().aggregate("1").post(AggregateActions.setMetadata(data));
	}
	
	@Test
	public void addHost() {
		compute.aggregates().aggregate("1").post(AggregateActions.addHost("openstack"));
	}
	
	@Test
	public void removeHost() {
		compute.aggregates().aggregate("1").post(AggregateActions.removeHost("openstack"));
	}
	
	@Test
	public void show() {
		compute.aggregates().aggregate("1").get();
	}
	
	@Test
	public void list() {
		compute.aggregates().get();
	}

	@Test
	public void delete() {
		compute.aggregates().aggregate("1").delete();
	}
	
}
