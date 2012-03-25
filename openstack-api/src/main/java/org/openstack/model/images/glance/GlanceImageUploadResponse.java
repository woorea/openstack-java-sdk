package org.openstack.model.images.glance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.images.Image;
import org.openstack.model.images.ImageUploadResponse;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement()
public class GlanceImageUploadResponse implements ImageUploadResponse {
    @XmlElement(name = "image")
    private GlanceImage image;

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.ImageUploadResponse#getImage()
	 */
    @Override
	public Image getImage() {
        return image;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.ImageUploadResponse#setImage(org.openstack.model.image.Image)
	 */
    @Override
	public void setImage(Image image) {
        this.image = (GlanceImage) image;
    }

	@Override
	public String toString() {
		return "GlanceImageUploadResponse [image=" + image + "]";
	}

}
