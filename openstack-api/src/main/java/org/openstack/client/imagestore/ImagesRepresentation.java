package org.openstack.client.imagestore;

import org.openstack.client.common.PagingList;
import org.openstack.model.common.PagingListBase;
import org.openstack.model.image.Image;

import com.sun.jersey.api.client.Client;

public class ImagesRepresentation extends PagingList<Image, ImageRepresentation> {
    public ImagesRepresentation(Client client, PagingListBase<Image> firstPage) {
        super(client, firstPage);
    }

    @Override
    protected ImageRepresentation mapToRepresentation(Image model) {
        return new ImageRepresentation(client, model);
    }

}
