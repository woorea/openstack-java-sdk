package org.openstack.nova.api;

import java.util.Map;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Image;
import org.openstack.nova.model.Images;
import org.openstack.nova.model.Metadata;

public class ImagesCore {

	public static class ListImages implements NovaCommand<Images> {

		boolean detail;

		public ListImages(boolean detail) {
			this.detail = detail;
		}

		public ListImages() {
			this(false);
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path(detail ? "/images/detail" : "/images");
			request.header("Accept", "application/json");
			request.returnType(Images.class);
			return request;
		}

	}

	public static class ShowImage implements NovaCommand<Image> {

		private String id;

		public ShowImage(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/images/").path(id);
			request.header("Accept", "application/json");
			request.returnType(Image.class);
			return request;
		}

	}

	public static class ShowImageMetadata implements
			NovaCommand<Map<String, String>> {

		private String id;

		public ShowImageMetadata(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/images/").path(id).path("metadata");
			request.header("Accept", "application/json");
			request.returnType(Metadata.class);
			return request;
		}

	}

	public static class DeleteImage implements NovaCommand<Void> {

		private String id;

		public DeleteImage(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/images/").path(id);
			request.header("Accept", "application/json");
			return request;
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
