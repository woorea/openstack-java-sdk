package org.openstack.nova.api;

import java.util.Map;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Image;
import org.openstack.nova.model.Images;
import org.openstack.nova.model.Metadata;

public class ImagesCore {
	
	public static class ListImages implements NovaCommand<Images>{

		boolean detail;
		
		public ListImages(boolean detail) {
			this.detail = detail;
		}
		
		public ListImages() {
			this(false);
		}

		@Override
		public Images execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path(detail ? "/images/detail" : "/images");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Images.class);
		}

	}
	
	public static class ShowImage implements NovaCommand<Image> {

		private String id;
		
		public ShowImage(String id) {
			this.id = id;
		}

		@Override
		public Image execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/images/").path(id);
		    request.header("Accept", "application/json");
		    return connector.execute(request, Image.class);
		}
		
	}

	public static class ShowImageMetadata implements NovaCommand<Map<String, String>> {

		private String id;
		
		public ShowImageMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/images/").path(id).path("metadata");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Metadata.class).getMetadata();
		}
		
	}


	public static class DeleteImage implements NovaCommand<Void> {

		private String id;
		
		public DeleteImage(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/images/").path(id);
		    request.header("Accept", "application/json");
		    connector.execute(request, Metadata.class);
		    return null;
		}
		
	}
	
	public static ListImages listImages(boolean detail) {
		return new ListImages(detail);
	}

	public static ListImages listImages() {
		return listImages(false);
	}
	
	public static ShowImage showImage(String id) {
		return new ShowImage(id);
	}
	
	public static ShowImageMetadata showImageMetadata(String id) {
		return new ShowImageMetadata(id);
	}
	
	public static DeleteImage deleteImage(String id) {
		return new DeleteImage(id);
	}
	
}
