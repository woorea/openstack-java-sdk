package org.openstack.model.identity.keystone;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.EndpointList;

@XmlRootElement(name="endpointTemplates", namespace="http://docs.openstack.org/identity/api/ext/OS-KSCATALOG/v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneEndpointList extends ListWithAtomLinks implements EndpointList {

	@XmlElement(name="endpointTemplate", namespace="http://docs.openstack.org/identity/api/ext/OS-KSCATALOG/v1.0", type = KeystoneEndpoint.class)
	private List<KeystoneEndpoint> list;

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.EndpointList#getList()
	 */
	@Override
	public List<Endpoint> getList() {
		return (List<Endpoint>) (List<?>) list;
	}

	public void setList(List<KeystoneEndpoint> list) {
		this.list = list;
	}
	
}
