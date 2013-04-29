package org.openstack.ceilometer.v2.api;

import java.util.List;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Statistics;


public class MeterStatistics extends QueriableCeilometerCommand<MeterStatistics, List<Statistics>> {

	private String name;
		
	public MeterStatistics name(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
//		if(name == null) {
//			throw new UnsupportedOperationException("meter id is mandatory");
//		}
//		return query(target.path("meters").path(name).path("statistics")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Statistics>>(){});
		return null;
	}

}