package org.openstack.model.common;

import java.util.Map;

import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.storage.OpenstackStorageClient;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;

public interface OpenstackService {
	<T> Iterable<T> listItems(Class<T> itemClass, boolean details);

	Map<Object, Object> getExtensions();

	@Deprecated
	OpenstackStorageClient getStorageClient();

	@Deprecated
	OpenstackComputeClient getComputeClient();

	@Deprecated
	OpenstackImageClient getImageClient();

	NovaFlavor resolveFlavor(NovaFlavor flavor);

	NovaImage resolveImage(NovaImage image);

	<T> void delete(T item);
}
