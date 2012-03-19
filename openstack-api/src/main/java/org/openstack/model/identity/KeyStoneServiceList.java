package org.openstack.model.identity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.api.common.Namespaces;
import org.openstack.model.common.ListWithAtomLinks;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name="services", namespace=Namespaces.NS_OPENSTACK_IDENTITY_ADM_1_0)
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneServiceList extends ListWithAtomLinks {

	@XmlElement(name="service", namespace="http://docs.openstack.org/identity/api/ext/OS-KSADM/v1.0")
	@SerializedName("OS-KSADM:services")
	private List<KeyStoneService> list = new ArrayList<KeyStoneService>();

	public List<KeyStoneService> getList() {
		return list;
	}

	public void setList(List<KeyStoneService> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "KeyStoneServiceList [list=" + list + "]";
	}
	
}
