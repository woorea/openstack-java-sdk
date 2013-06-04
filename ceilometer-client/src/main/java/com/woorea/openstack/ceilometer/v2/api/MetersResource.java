package com.woorea.openstack.ceilometer.v2.api;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.ceilometer.QueriableCeilometerCommand;
import com.woorea.openstack.ceilometer.v2.model.Sample;

public class MetersResource {
	
	private final OpenStackClient CLIENT;
	
	public MetersResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Show show() {
		return new Show();
	}
	
	public Statistics statistics() {
		return new Statistics();
	}
	
	public class List extends QueriableCeilometerCommand<List, java.util.List<Sample>> {
		public List() {
			//return query(target.path("meters")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Meter>>() {});
		}
	}
	
	public class Show extends QueriableCeilometerCommand<Show, java.util.List<Sample>> {

		private String name;
			
		public Show name(String name) {
			this.name = name;
			return this;
		}
		
		public Show() {
//			if(name == null) {
//				throw new UnsupportedOperationException("meter id is mandatory");
//			}
//			return query(target.path("meters").path(name)).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Sample>>() {});
		}

	}

	public class Statistics extends QueriableCeilometerCommand<Statistics, java.util.List<Statistics>> {

		private String name;
			
		public Statistics name(String name) {
			this.name = name;
			return this;
		}
		
		public Statistics() {
//			if(name == null) {
//				throw new UnsupportedOperationException("meter id is mandatory");
//			}
//			return query(target.path("meters").path(name).path("statistics")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Statistics>>(){});
		}

	}

}
