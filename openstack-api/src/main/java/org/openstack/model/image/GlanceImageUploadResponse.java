package org.openstack.model.image;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement()
public class GlanceImageUploadResponse {
    @XmlElement(name = "image")
    private GlanceImage image;

    public GlanceImage getImage() {
        return image;
    }

    public void setImage(GlanceImage image) {
        this.image = image;
    }

	@Override
	public String toString() {
		return "GlanceImageUploadResponse [image=" + image + "]";
	}

}
