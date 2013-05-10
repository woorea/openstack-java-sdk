package org.openstack.nova;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.nova.api.ExtensionsResource;
import org.openstack.nova.api.FlavorsResource;
import org.openstack.nova.api.ImagesResource;
import org.openstack.nova.api.ServersResource;
import org.openstack.nova.api.extensions.AggregatesExtension;
import org.openstack.nova.api.extensions.FloatingIpsExtension;
import org.openstack.nova.api.extensions.KeyPairsExtension;
import org.openstack.nova.api.extensions.SecurityGroupsExtension;
import org.openstack.nova.api.extensions.SnapshotsExtension;
import org.openstack.nova.api.extensions.VolumesExtension;

public class Nova extends OpenStackClient {
	
	private final ExtensionsResource EXTENSIONS;
	
	private final ServersResource SERVERS;
	
	private final ImagesResource IMAGES;
	
	private final FlavorsResource FLAVORS;
	
	private final KeyPairsExtension KEY_PAIRS;
	
	private final FloatingIpsExtension FLOATING_IPS;
	
	private final SecurityGroupsExtension SECURITY_GROUPS;
	
	private final SnapshotsExtension SNAPSHOTS;
	
	private final VolumesExtension VOLUMES;
	
	private final AggregatesExtension AGGREGATES;
	
	public Nova(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		EXTENSIONS = new ExtensionsResource(this);
		SERVERS = new ServersResource(this);
		IMAGES = new ImagesResource(this);
		FLAVORS = new FlavorsResource(this);
		KEY_PAIRS = new KeyPairsExtension(this);
		FLOATING_IPS = new FloatingIpsExtension(this);
		SECURITY_GROUPS = new SecurityGroupsExtension(this);
		SNAPSHOTS = new SnapshotsExtension(this);
		VOLUMES = new VolumesExtension(this);
		AGGREGATES = new AggregatesExtension(this);
	}
	
	public Nova(String endpoint) {
		this(endpoint, null);
	}
	
	public ExtensionsResource extensions() {
		return EXTENSIONS;
	}
	
	public ServersResource servers() {
		return SERVERS;
	}
	
	public ImagesResource images() {
		return IMAGES;
	}
	
	public FlavorsResource flavors() {
		return FLAVORS;
	}
	
	public KeyPairsExtension keyPairs() {
		return KEY_PAIRS;
	}
	
	public FloatingIpsExtension floatingIps() {
		return FLOATING_IPS;
	}
	
	public SecurityGroupsExtension securityGroups() {
		return SECURITY_GROUPS;
	}
	
	public SnapshotsExtension snapshots() {
		return SNAPSHOTS;
	}
	
	public VolumesExtension volumes() {
		return VOLUMES;
	}

}
