package org.openstack.quantum.api;

import org.openstack.quantum.api.networks.CreateNetwork;
import org.openstack.quantum.api.networks.DeleteNetwork;
import org.openstack.quantum.api.networks.ListNetworks;
import org.openstack.quantum.api.networks.ShowNetwork;
import org.openstack.quantum.model.NetworkForCreate;

public class NetworkCore {
	
	public static ListNetworks listNetworks() {
		return new ListNetworks();
	}
	
	public static CreateNetwork createNetwork(NetworkForCreate net){
		return new CreateNetwork(net);
	}
	
	public static DeleteNetwork deleteNetwork(String netId){
		return new DeleteNetwork(netId);
	}

	public static ShowNetwork showNetwork(String netId){
		return new ShowNetwork(netId);
	}
	
}
