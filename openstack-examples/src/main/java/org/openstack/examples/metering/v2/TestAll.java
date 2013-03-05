package org.openstack.examples.metering.v2;

import java.util.List;

import org.openstack.ceilometer.CeilometerClient;
import org.openstack.ceilometer.v2.api.MeterList;
import org.openstack.ceilometer.v2.api.MeterShow;
import org.openstack.ceilometer.v2.api.MeterStatistics;
import org.openstack.ceilometer.v2.api.ResourceList;
import org.openstack.ceilometer.v2.api.ResourceShow;
import org.openstack.ceilometer.v2.model.Meter;
import org.openstack.ceilometer.v2.model.Resource;
import org.openstack.ceilometer.v2.model.Sample;
import org.openstack.ceilometer.v2.model.Statistics;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.Authentication.PasswordCredentials;

public class TestAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Authentication authentication = new Authentication();
		PasswordCredentials passwordCredentials = new PasswordCredentials();
		passwordCredentials.setUsername(ExamplesConfiguration.KEYSTONE_USERNAME);
		passwordCredentials.setPassword(ExamplesConfiguration.KEYSTONE_PASSWORD);
		authentication.setTenantName("admin");
		authentication.setPasswordCredentials(passwordCredentials);
		
		//access with unscoped token
		Access access = keystone.execute(new Authenticate(authentication));
		
		CeilometerClient ceilometer = new CeilometerClient(ExamplesConfiguration.CEILOMETER_ENDPOINT, access.getToken().getId());

		/*
		List<Resource> resources = ceilometer.execute(new ResourceList().eq("resource_id", "23b55841eedd41e99d5f3f32149ca086"));
		
		
		for(Resource r : resources) {
			Resource resource = ceilometer.execute(new ResourceShow().id(r.getResource()));
		}
		*/
		
		List<Meter> meters = ceilometer.execute(new MeterList().eq("project_id", "948eeb593acd4223ad572c49e1ef5709"));
		
		
		for(Meter m : meters) {
			System.out.println(m);
//			List<Sample> samples = ceilometer.execute(new MeterShow().name(m.getName()));
//			for(Sample s : samples) {
//				System.out.println("\t" + s);
//			}
			
			List<Statistics> stats = ceilometer.execute(new MeterStatistics().name(m.getName()));
			for(Statistics s : stats) {
				System.out.println("\t\t" + s);
			}
			
			
		}
		
	}

}
