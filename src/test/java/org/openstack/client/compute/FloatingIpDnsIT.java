package org.openstack.client.compute;

import org.openstack.model.compute.nova.floatingipdns.DnsEntry;
import org.openstack.model.compute.nova.floatingipdns.DomainEntry;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FloatingIpDnsIT extends ComputeIntegrationTest {
	
	@BeforeClass
	public void init() {
		init("etc/openstack.admin.properties");
		compute = client.getComputeEndpoint();
	}

	@Test
	public void listDomains() {
		compute.floatingIpDns().get();
	}
	
	public void listByIp() {
		compute.floatingIpDns().domain("").entries().get("10.2.3.4");
	}
	
	public void listByName() {
		compute.floatingIpDns().domain("").entries().entry("").get();
	}
	
	@Test
	public void createPrivateDomain() {
		DomainEntry entry = new DomainEntry();
		entry.setAvailabilityZone("nova");
		entry.setScope("private");
		compute.floatingIpDns().domain("woorea").put(entry);
	}
	
	//@Test error maybe project
	public void createPublicDomain() {
		DomainEntry entry = new DomainEntry();
		entry.setScope("public");
		entry.setProject("demo");
		compute.floatingIpDns().domain("woorea2").put(entry);
	}
	
	@Test
	public void deleteDomain() {
		compute.floatingIpDns().domain("woorea").delete();
	}
	
	@Test
	public void createDnsEntry() {
		DnsEntry entry = new DnsEntry();
		entry.setIp("10.0.0.1");
		entry.setDnsType("A");
		compute.floatingIpDns().domain("woorea").entries().entry("fake").put(entry);
	}
	
	@Test
	public void updateDnsEntry() {
		DnsEntry entry = new DnsEntry();
		entry.setIp("10.0.0.2");
		entry.setDnsType("B");
		compute.floatingIpDns().domain("woorea").entries().entry("fake").put(entry);
	}
	
	@Test
	public void deleteDnsEntry() {
		compute.floatingIpDns().domain("woorea").entries().entry("fake").delete();
	}
	
}
