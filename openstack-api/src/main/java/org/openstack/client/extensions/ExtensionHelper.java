package org.openstack.client.extensions;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

import org.openstack.model.common.ExtensionData;

public class ExtensionHelper<T> {

    final Class<T> clazz;

    public ExtensionHelper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T parse(ExtensionData extensionData) {
        // TODO: Can JAXB can do this for us?? We could try constructing a fake document...
        T o = newInstance();

        Map<QName, Object> extensionAttributes = extensionData.getExtensionAttributes();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            XmlAttribute xmlAttribute = field.getAnnotation(XmlAttribute.class);
            if (xmlAttribute == null)
                continue;

            String namespaceURI = XmlUtils.getNamespace(field, xmlAttribute);
            String attributeName = XmlUtils.getAttributeName(field, xmlAttribute);
            QName qname = new QName(namespaceURI, attributeName);

            Object attributeValue = extensionAttributes.get(qname);
            if (attributeValue == null)
                continue;

            setField(o, field, attributeValue);
        }

        return o;
    }

    private void setField(T o, Field field, Object attributeValue) {
        if ((field.getModifiers() & Modifier.PUBLIC) == 0) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
        }

        try {
            field.set(o, attributeValue);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error setting field", e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Error setting field", e);
        }
    }

    private T newInstance() {
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Error building instance", e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Error building instance", e);
        }
    }

    public static <T> ExtensionHelper<T> build(Class<T> clazz) {
        return new ExtensionHelper<T>(clazz);
    }

}
