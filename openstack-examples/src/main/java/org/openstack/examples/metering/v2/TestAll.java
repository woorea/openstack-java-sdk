package org.openstack.examples.metering.v2;

import java.util.List;

import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.ceilometer.Ceilometer;
import org.openstack.ceilometer.v2.model.Meter;
import org.openstack.ceilometer.v2.model.Statistics;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.authentication.UsernamePassword;

public class TestAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Access access = keystone.tokens()
				.authenticate(new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD))
				.withTenantName("admin")
				.execute();
		
		Ceilometer ceilometer = new Ceilometer(ExamplesConfiguration.CEILOMETER_ENDPOINT);
		ceilometer.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));

		/*
		List<Resource> resources = ceilometer.execute(new ResourceList().eq("resource_id", "23b55841eedd41e99d5f3f32149ca086"));
		
		
		for(Resource r : resources) {
			Resource resource = ceilometer.execute(new ResourceShow().id(r.getResource()));
		}
		*/
		
		/*
		//List<Meter> meters = ceilometer.meters().list().execute(); //execute(new MeterList().eq("project_id", "948eeb593acd4223ad572c49e1ef5709"));
		
		
		for(Meter m : meters) {
			System.out.println(m);
			
//			List<Sample> samples = ceilometer.execute(new MeterShow().name(m.getName()));
//			for(Sample s : samples) {
//				System.out.println("\t" + s);
//			}
			
			List<Statistics> stats = ceilometer.meters().statistics().execute(); // (new MeterStatistics().name(m.getName()));
			for(Statistics s : stats) {
				System.out.println("\t\t" + s);
			}
			
			
		}
		*/
		
	}

}
