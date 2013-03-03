package org.openstack.ceilometer.v2.api;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Meter;

public class MeterList extends QueriableCeilometerCommand<MeterList,List<Meter>> {
		
	@Override
	public List<Meter> execute(WebTarget target) {
		return query(target.path("meters")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Meter>>() {});
	}

}