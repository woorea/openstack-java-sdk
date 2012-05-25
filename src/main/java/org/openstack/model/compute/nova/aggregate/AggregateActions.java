package org.openstack.model.compute.nova.aggregate;

public class AggregateActions {

	public static final AddHostAction addHost(String name) {
		return new AddHostAction();
	}
	
	public static final RemoveHostAction removeHost(String name) {
		return new RemoveHostAction();
	}
	
	public static final SetMetadataAction setMetadata(String key, String value) {
		return new SetMetadataAction();
	}
	
}
