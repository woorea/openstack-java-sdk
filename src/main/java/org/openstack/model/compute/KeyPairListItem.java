package org.openstack.model.compute;

import org.openstack.model.compute.nova.keypair.NovaKeyPair;

public interface KeyPairListItem {

	NovaKeyPair getKeypair();

}