package org.openstack.client.compute;

import org.openstack.model.compute.nova.quota.NovaQuotaSet;

public class QuotasIT extends ComputeIntegrationTest {

	public void show() {
		compute.quotas("").get();
	}
	
	public void update() {
		NovaQuotaSet quotas = new NovaQuotaSet();
		compute.quotas("").put(quotas);
	}
	
}
