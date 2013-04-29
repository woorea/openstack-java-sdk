package org.openstack.ceilometer.v2.api;

import java.util.List;

import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Meter;

public class MeterList extends QueriableCeilometerCommand<MeterList,List<Meter>> {
		
	public MeterList() {
		//return query(target.path("meters")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Meter>>() {});
	}

}