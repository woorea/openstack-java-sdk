package org.openstack.ceilometer.collector.handlers;

import org.openstack.ceilometer.model.MeterEvent;

public interface MeterEventListener {

	public void onMeterEvent(MeterEvent meterEvent);
	
}
