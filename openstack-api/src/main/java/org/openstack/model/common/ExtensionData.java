package org.openstack.model.common;

import java.util.Map;

import javax.xml.namespace.QName;

public class ExtensionData {

    private final Map<QName, Object> extensionAttributes;

    public ExtensionData(Map<QName, Object> extensionAttributes) {
        this.extensionAttributes = extensionAttributes;
    }

    public Map<QName, Object> getExtensionAttributes() {
        return extensionAttributes;
    }

    @Override
    public String toString() {
        return "ExtensionData [extensionAttributes=" + extensionAttributes + "]";
    }

}
