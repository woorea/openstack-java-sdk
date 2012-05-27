package org.openstack.model.compute.nova.aggregate;

import java.util.Map;

public class AggregateActions {

	public static final AddHostAction addHost(String name) {
		AddHostAction action =  new AddHostAction();
		action.setHost(name);
		return action;
	}
	
	public static final RemoveHostAction removeHost(String name) {
		RemoveHostAction action =  new RemoveHostAction();
		action.setHost(name);
		return action;

	}
	
	public static final SetMetadataAction setMetadata(Map<String, String> metadata) {
		SetMetadataAction action = new SetMetadataAction();
		action.setMetadata(metadata);
		return action;
	}
	
}
