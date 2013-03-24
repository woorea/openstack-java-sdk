package org.openstack.ceilometer.v2.api;

import java.util.List;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Sample;


public class MeterShow extends QueriableCeilometerCommand<MeterShow, List<Sample>> {

	private String name;
		
	public MeterShow name(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public List<Sample> execute(OpenStackClientConnector connector, OpenStackRequest request) {
//		if(name == null) {
//			throw new UnsupportedOperationException("meter id is mandatory");
//		}
//		return query(target.path("meters").path(name)).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Sample>>() {});
		return null;
	}

}