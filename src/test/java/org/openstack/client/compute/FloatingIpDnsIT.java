package org.openstack.client.compute;

import org.openstack.model.compute.nova.floatingipdns.DnsEntry;
import org.openstack.model.compute.nova.floatingipdns.DomainEntry;

public class FloatingIpDnsIT extends ComputeIntegrationTest {

	public void listDomains() {
		compute.floatingIpDns().get();
	}
	
	public void listByIp() {
		compute.floatingIpDns().domain("").entries().get("10.2.3.4");
	}
	
	public void listByName() {
		compute.floatingIpDns().domain("").entries().entry("").get();
	}
	
	public void createDomain() {
		DomainEntry entry = new DomainEntry();
		compute.floatingIpDns().domain("").post(entry);
	}
	
	public void deleteDomain() {
		DomainEntry entry = new DomainEntry();
		compute.floatingIpDns().domain("").delete();
	}
	
	public void createDnsEntry() {
		DnsEntry entry = new DnsEntry();
		compute.floatingIpDns().domain("").entries().entry("").post(entry);
	}
	
	public void updateDnsEntry() {
		DnsEntry entry = new DnsEntry();
		compute.floatingIpDns().domain("").entries().entry("").put(entry);
	}
	
	public void deleteDnsEntry() {
		DnsEntry entry = new DnsEntry();
		compute.floatingIpDns().domain("").entries().entry("").delete();
	}
	
}
