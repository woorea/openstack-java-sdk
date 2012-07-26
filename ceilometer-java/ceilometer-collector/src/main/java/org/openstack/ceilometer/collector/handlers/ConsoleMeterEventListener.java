package org.openstack.ceilometer.collector.handlers;

import org.openstack.ceilometer.model.MeterEvent;

public class ConsoleMeterEventListener implements MeterEventListener {

	@Override
	public void onMeterEvent(MeterEvent meterEvent) {
		System.out.println(meterEvent);
		
	}

	

}
