package org.openstack.quantum.api;

import org.openstack.quantum.api.subnets.CreateSubnet;
import org.openstack.quantum.api.subnets.DeleteSubnet;
import org.openstack.quantum.api.subnets.ListSubnets;
import org.openstack.quantum.api.subnets.ShowSubnet;
import org.openstack.quantum.model.SubnetForCreate;

public class SubnetsCore {
	
	public static ListSubnets listSubnets() {
		return new ListSubnets();
	}
	
	public static CreateSubnet createSubnet(SubnetForCreate net){
		return new CreateSubnet(net);
	}
	
	public static DeleteSubnet deleteSubnet(String netId){
		return new DeleteSubnet(netId);
	}

	public static ShowSubnet showSubnet(String netId){
		return new ShowSubnet(netId);
	}
	

}
