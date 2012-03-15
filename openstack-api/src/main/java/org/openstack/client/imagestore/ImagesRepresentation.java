package org.openstack.client.imagestore;

import org.openstack.client.common.PagingList;
import org.openstack.model.common.PagingListBase;
import org.openstack.model.image.GlanceImage;

import com.sun.jersey.api.client.Client;

public class ImagesRepresentation extends PagingList<GlanceImage, ImageRepresentation> {
    public ImagesRepresentation(Client client, PagingListBase<GlanceImage> firstPage) {
        super(client, firstPage);
    }

    @Override
    protected ImageRepresentation mapToRepresentation(GlanceImage model) {
        return new ImageRepresentation(client, model);
    }

}
