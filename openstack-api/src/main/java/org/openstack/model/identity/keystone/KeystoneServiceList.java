package org.openstack.model.identity.keystone;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.api.Namespaces;
import org.openstack.model.common.JsonRootElement;
import org.openstack.model.common.ListWithAtomLinks;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name="services", namespace=Namespaces.NS_OPENSTACK_IDENTITY_ADM_1_0)
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class KeystoneServiceList extends ListWithAtomLinks implements ServiceList {

	@XmlElement(name="service", namespace="http://docs.openstack.org/identity/api/ext/OS-KSADM/v1.0", type = KeystoneService.class)
	@SerializedName("OS-KSADM:services")
	private List<KeystoneService> list = new ArrayList<KeystoneService>();

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceList#getList()
	 */
	@Override
	public List<Service> getList() {
		return (List<Service>) (List<?>) list;
	}
	
	public void setList(List<KeystoneService> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "KeyStoneServiceList [list=" + list + "]";
	}
	
}
