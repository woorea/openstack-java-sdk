package org.openstack.model.images.glance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.images.Image;
import org.openstack.model.images.ImageList;

public class GlanceImageList implements Serializable, ImageList {

	@JsonDeserialize(as=List.class, contentAs=GlanceImage.class)
    private List<Image> images = new ArrayList<Image>();
    
    public GlanceImageList() {
    	
    }
    
    public GlanceImageList(Collection<Image> collection) {
		this.images = new ArrayList<Image>(collection);
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.image.glance.ImageList#getList()
	 */
    @Override
	public List<Image> getList() {
    	return images;
    }

	@Override
	public String toString() {
		return "GlanceImageList [images=" + images + "]";
	}
    
}
