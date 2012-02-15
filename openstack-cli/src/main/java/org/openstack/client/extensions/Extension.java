package org.openstack.client.extensions;

public class Extension {
    final Class<?> attributeClass;

    public Extension(Class<?> attributeClass) {
        this.attributeClass = attributeClass;
    }

    public String getXmlNamespace() {
        return XmlUtils.getNamespace(attributeClass);
    }

    public Class<?> getAttributeClass() {
        return attributeClass;
    }

}
