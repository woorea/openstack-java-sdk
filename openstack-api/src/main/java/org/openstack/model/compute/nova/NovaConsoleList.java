package org.openstack.model.compute.nova;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.common.ListWithAtomLinks;
import org.openstack.model.compute.Console;
import org.openstack.model.compute.ConsoleList;

@XmlRootElement(name="consoles", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class NovaConsoleList extends ListWithAtomLinks implements ConsoleList {

	@XmlElement(name="console", namespace="")
	private List<NovaConsole> list = new ArrayList<NovaConsole>();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.ConsoleList#getList()
	 */
	@Override
	public List<Console> getList() {
		return (List<Console>) (List<?>) list;
	}

	public void setList(List<NovaConsole> list) {
		this.list = list;
	}
	
}
