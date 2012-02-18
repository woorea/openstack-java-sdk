package org.openstack.client.compute;

import org.openstack.client.common.PagingList;
import org.openstack.model.common.PagingListBase;
import org.openstack.model.compute.Image;

import com.sun.jersey.api.client.Client;

public class ImagesRepresentation extends
		PagingList<Image, ImageRepresentation> {

	public ImagesRepresentation(Client client, PagingListBase<Image> page) {
		super(client, page);
	}

	@Override
	protected ImageRepresentation mapToRepresentation(Image model) {
		return new ImageRepresentation(client, model);
	}

	// public void fetch(int index) {
	// Image image =
	// client.resource(model.getList().get(index).getLinks().get(0).getHref()).accept(MediaType.APPLICATION_XML).get(Image.class);
	// model.getList().set(index, image);
	// }
	//
	// public void fetchAll() {
	// for (int i = 0; i < model.getList().size(); i++) {
	// fetch(i);
	// }
	// }
	//
	// public ImagesRepresentation next() {
	// ImageList tenantList =
	// client.resource(model.getLinks().get(0).getHref()).get(ImageList.class);
	// return new ImagesRepresentation(client, tenantList);
	// }

}
