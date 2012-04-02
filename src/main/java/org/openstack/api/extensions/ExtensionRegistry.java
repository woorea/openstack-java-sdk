package org.openstack.api.extensions;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ExtensionRegistry {
    static final Logger log = Logger.getLogger(ExtensionRegistry.class.getName());

    final Map<String, Extension> extensionsByNamespace = Maps.newHashMap();

    public Extension findExtensionByNamespace(String namespace) {
        return extensionsByNamespace.get(namespace);
    }

    public ExtensionValues parseAllExtensions(Map<QName, String> extensionAttributes) {
    	ExtensionValues results = new ExtensionValues();
        
        if (extensionAttributes != null) {
	        Set<String> namespaces = Sets.newHashSet();
	        for (QName qname : extensionAttributes.keySet()) {
	            namespaces.add(qname.getNamespaceURI());
	        }
	
	        for (String namespace : namespaces) {
	            Extension extension = findExtensionByNamespace(namespace);
	            if (extension == null) {
	                // TODO: We could have a generic placeholder...
	                log.info("Ignoring unknown namespace: " + namespace);
	
	                continue;
	            }
	            Class<?> attributeClass = extension.getAttributeClass();
	            if (attributeClass != null) {
	            	Object o = parseExtensionAttributes(extensionAttributes, attributeClass);
	                results.add(o);
	            }
	        }
        }
        return results;
    }

    private <T> T parseExtensionAttributes(Map<QName, String> extensionAttributes, Class<T> attributeClass) {
        ExtensionHelper<T> helper = new ExtensionHelper<T>(attributeClass);
        T o = helper.parse(extensionAttributes);
        return o;
	}

	public void add(Extension extension) {
        String namespace = extension.getXmlNamespace();
        if (extensionsByNamespace.containsKey(namespace))
            throw new IllegalArgumentException("Duplicate namespace: " + namespace);

        extensionsByNamespace.put(namespace, extension);
    }
}
