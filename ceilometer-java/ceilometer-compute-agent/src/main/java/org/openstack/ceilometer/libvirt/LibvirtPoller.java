package org.openstack.ceilometer.libvirt;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.DomainBlockStats;
import org.libvirt.DomainInfo;
import org.openstack.ceilometer.Poller;
import org.openstack.ceilometer.model.MeterEvent;

public class LibvirtPoller extends Poller {
	
	private static final long MIB = 2^20;
	
	private String uri = "qemu:///system";

	private Connect connect;
	
	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	protected void onStart() {
		try {
			System.out.println("Connnection libvirt");
			connect = new Connect(uri, true);
		} catch (Exception e) {
			new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public Collection<MeterEvent> poll() {
		
		Collection<MeterEvent> events = new HashSet<MeterEvent>();
		
		try {
			for(int domainId : connect.listDomains()) {
				
				Domain domain = connect.domainLookupByID(domainId);
			
				System.out.println(domain.getXMLDesc(0));
				
				events.add(instanceMeter(domain));
				events.add(cpuMeter(domain));
				events.add(ramMeter(domain));
				events.add(diskMeter(domain));
				
			}
			return events;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}
	
	private MeterEvent instanceMeter(Domain domain) {
		try {
			return createEvent("instance", "delta", 1, domain.getUUIDString());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	private MeterEvent cpuMeter(Domain domain) {
		try {
			DomainInfo info = domain.getInfo();
			return createEvent("cpu", "cumulative", info.cpuTime, domain.getUUIDString());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	private MeterEvent ramMeter(Domain domain) {
		try {
			DomainInfo info = domain.getInfo();
			return createEvent("ram", "cumulative", info.memory, domain.getUUIDString());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
	private MeterEvent diskMeter(Domain domain) {
		try {
			
			Set<String> devices = LibvirtUtils.getDisks(domain);
			
			int bytes = 0;
			for(String device : devices) {
				DomainBlockStats stats = domain.blockStats(device);
				bytes += stats.rd_bytes + stats.wr_bytes;
			}
			
			return createEvent("disk", "cumulative", bytes/MIB, domain.getUUIDString());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	private static final MeterEvent createEvent(String name, String type, Number volume, String resourceId) {
		MeterEvent m = new MeterEvent();
		m.setSource(null);
		m.setName(name);
		//m.setUserId(server.getUserId());
		//m.setProjectId(server.getTenantId());
		m.setResourceId(resourceId);
		m.setTimestamp(Calendar.getInstance());
		m.setType(type);
		m.setVolume(volume);
		//m.setMetadata(server.getMetadata().toString());
		return m;
	}

}
