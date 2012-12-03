package org.openstack.quantum.api;

import org.openstack.quantum.api.ports.CreatePort;
import org.openstack.quantum.api.ports.DeletePort;
import org.openstack.quantum.api.ports.ListPorts;
import org.openstack.quantum.api.ports.ShowPort;
import org.openstack.quantum.model.PortForCreate;

public class PortsCore {
	
	public static ListPorts listPorts() {
		return new ListPorts();
	}
	
	public static CreatePort addPort(PortForCreate net){
		return new CreatePort(net);
	}
	
	public static DeletePort deletePort(String netId){
		return new DeletePort(netId);
	}

	public static ShowPort showPort(String netId){
		return new ShowPort(netId);
	}
	

}
