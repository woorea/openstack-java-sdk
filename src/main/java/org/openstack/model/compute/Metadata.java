package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.compute.nova.NovaMetadata.Item;

public interface Metadata {

	List<Item> getItems();

}