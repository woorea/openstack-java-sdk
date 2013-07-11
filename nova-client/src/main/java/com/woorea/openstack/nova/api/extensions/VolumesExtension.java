package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Volume;
import com.woorea.openstack.nova.model.VolumeForCreate;
import com.woorea.openstack.nova.model.Volumes;

public class VolumesExtension {
	
	private final OpenStackClient CLIENT;
	
	public VolumesExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list(boolean detail) {
		return new List(detail);
	}
	
	public Create create(VolumeForCreate volumeForCreate) { 
		return new Create(volumeForCreate);
	}
	
	public Show show(String id) {
		return new Show(id);
	}
	
	public ShowMetadata showMetadata(String id) {
		return new ShowMetadata(id);
	}

	
	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Volumes> {
		
		public List(boolean detail) {
			super(CLIENT, HttpMethod.GET, detail ? "/os-volumes/detail" : "/os-volumes", null, Volumes.class);
		}

	}
	
	public class Create extends OpenStackRequest<Volume> {

		public Create(VolumeForCreate volumeForCreate) { 
			super(CLIENT, HttpMethod.POST, "/os-volumes", Entity.json(volumeForCreate), Volume.class);
		}
		
	}
	
	public class Show extends OpenStackRequest<Volume> {
		
		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/os-volumes/").append(id).toString(), null, Volume.class);
		}

	}
	
	public class ShowMetadata extends OpenStackRequest<Metadata> {
		
		public ShowMetadata(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/os-volumes/").append(id).append("/metadata").toString(), null, Metadata.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-volumes/").append(id).toString(), null, Void.class);
		}
		
	}
	
}

