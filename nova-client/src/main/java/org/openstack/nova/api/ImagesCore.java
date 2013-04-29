package org.openstack.nova.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Image;
import org.openstack.nova.model.Images;
import org.openstack.nova.model.Metadata;

public class ImagesCore {

	public static class ListImages extends OpenStackRequest {

		public ListImages(boolean detail) {
			method(HttpMethod.GET);
			path(detail ? "/images/detail" : "/images");
			header("Accept", "application/json");
			returnType(Images.class);
		}

		public ListImages() {
			this(false);
		}

	}

	public static class ShowImage extends OpenStackRequest {

		public ShowImage(String id) {
			method(HttpMethod.GET);
			path("/images/").path(id);
			header("Accept", "application/json");
			returnType(Image.class);
		}
		
	}

	public static class ShowImageMetadata extends OpenStackRequest {

		public ShowImageMetadata(String id) {
			method(HttpMethod.GET);
			path("/images/").path(id).path("metadata");
			header("Accept", "application/json");
			returnType(Metadata.class);
		}

	}

	public static class DeleteImage extends OpenStackRequest {

		public DeleteImage(String id) {
			method(HttpMethod.GET);
			path("/images/").path(id);
			header("Accept", "application/json");
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
