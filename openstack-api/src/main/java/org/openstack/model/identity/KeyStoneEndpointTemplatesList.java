package org.openstack.model.identity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="endpointTemplates", namespace="http://docs.openstack.org/identity/api/ext/OS-KSCATALOG/v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneEndpointTemplatesList extends ListWithAtomLinks {

	@XmlElement(name="endpointTemplate", namespace="http://docs.openstack.org/identity/api/ext/OS-KSCATALOG/v1.0")
	private List<KeyStoneEndpointTemplates> list;

	public List<KeyStoneEndpointTemplates> getList() {
		return list;
	}

	public void setList(List<KeyStoneEndpointTemplates> list) {
		this.list = list;
	}
	
}
