package org.openstack.ceilometer.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name="meters")
@XmlAccessorType(XmlAccessType.FIELD)
public class MeterEvents {

	@XmlElement(name="meter")
	@JsonProperty("meters")
	private List<MeterEvent> meterEvents = new ArrayList<MeterEvent>();

	/**
	 * @return the meterEvents
	 */
	public List<MeterEvent> getMeterEvents() {
		return meterEvents;
	}

	/**
	 * @param meterEvents the meterEvents to set
	 */
	public void setMeterEvents(List<MeterEvent> meterEvents) {
		this.meterEvents = meterEvents;
	}

}
