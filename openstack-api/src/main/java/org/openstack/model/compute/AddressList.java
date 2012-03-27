package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.compute.nova.NovaAddressList.Network;

public interface AddressList {

	List<Network> getNetworks();

}