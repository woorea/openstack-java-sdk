package org.openstack.model.identity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="services", namespace="http://docs.openstack.org/identity/api/ext/OS-KSADM/v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneServiceList extends ListWithAtomLinks {

	@XmlElement(name="service", namespace="http://docs.openstack.org/identity/api/ext/OS-KSADM/v1.0")
	private List<KeyStoneService> list = new ArrayList<KeyStoneService>();

	public List<KeyStoneService> getList() {
		return list;
	}

	public void setList(List<KeyStoneService> list) {
		this.list = list;
	}
	
}
