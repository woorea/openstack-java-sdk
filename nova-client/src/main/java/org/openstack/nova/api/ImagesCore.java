package org.openstack.nova.api;

import java.util.Map;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
		public Images execute(WebTarget target) {
			String path = detail ? "images/detail" : "images";
			return target.path(path).request(MediaType.APPLICATION_JSON).get(Images.class);
		}

	}
	
	public static class ShowImage implements NovaCommand<Image> {

		private String id;
		
		public ShowImage(String id) {
			this.id = id;
		}

		@Override
		public Image execute(WebTarget target) {
			return target.path("images").path(id).request(MediaType.APPLICATION_JSON).get(Image.class);
		}
		
	}

	public static class ShowImageMetadata implements NovaCommand<Map<String, String>> {

		private String id;
		
		public ShowImageMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(WebTarget target) {
			Metadata metadata = target.path("images").path(id).path("metadata").request(MediaType.APPLICATION_JSON).get(Metadata.class);
			return metadata.getMetadata();
		}
		
	}


	public static class DeleteImage implements NovaCommand<Void> {

		private String id;
		
		public DeleteImage(String id) {
			this.id = id;
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("images").path(id).request(MediaType.APPLICATION_JSON).delete();
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
