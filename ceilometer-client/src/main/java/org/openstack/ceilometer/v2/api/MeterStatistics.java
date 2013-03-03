package org.openstack.ceilometer.v2.api;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Resource;
import org.openstack.ceilometer.v2.model.Statistics;


public class MeterStatistics extends QueriableCeilometerCommand<MeterStatistics, List<Statistics>> {

	private String name;
		
	public MeterStatistics name(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public List<Statistics> execute(WebTarget target) {
		if(name == null) {
			throw new UnsupportedOperationException("meter id is mandatory");
		}
		return query(target.path("meters").path(name).path("statistics")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Statistics>>(){});
	}

}