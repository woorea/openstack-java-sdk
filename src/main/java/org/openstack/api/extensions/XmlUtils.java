package org.openstack.api.extensions;

import java.lang.reflect.Field;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;

public class XmlUtils {
    public static String getAttributeName(Field field, XmlAttribute xmlAttribute) {
        String name = xmlAttribute.name();
        if ("##default".equals(name)) {
            name = null;
        }

        if (name == null) {
            name = field.getName();
        }

        return name;
    }

    public static String getNamespace(Class<?> clazz) {
        XmlType xmlType = clazz.getAnnotation(XmlType.class);

        String namespace = null;

        if (xmlType != null) {
            namespace = xmlType.namespace();
            if ("##default".equals(namespace)) {
                namespace = null;
            }
        }

        if (namespace == null) {
            Package itemPackage = clazz.getPackage();
            XmlSchema xmlSchema = itemPackage.getAnnotation(XmlSchema.class);
            if (xmlSchema != null) {
                namespace = xmlSchema.namespace();
            }
        }

        return namespace;
    }

    public static String getNamespace(Field field, XmlAttribute xmlAttribute) {
        String namespace = xmlAttribute.namespace();
        if ("##default".equals(namespace)) {
            namespace = null;
        }

        if (namespace == null) {
            namespace = getNamespace(field.getDeclaringClass());
        }

        return namespace;
    }

}
