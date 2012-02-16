package org.openstack.client.common;

import java.util.concurrent.ConcurrentMap;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.google.common.collect.Maps;

@Provider
public class OpenstackJaxbContextProvider implements ContextResolver<JAXBContext> {

    final ConcurrentMap<Class<?>, JAXBContext> jaxbContexts = Maps.newConcurrentMap();

    @Override
    public JAXBContext getContext(Class<?> type) {
        JAXBContext jaxb = jaxbContexts.get(type);
        if (jaxb == null) {
            try {
                jaxb = JAXBContext.newInstance(type);
            } catch (JAXBException e) {
                throw new IllegalStateException("Error building JAXB context", e);
            }
            JAXBContext already = jaxbContexts.putIfAbsent(type, jaxb);
            if (already != null)
                jaxb = already;
        }
        return jaxb;

    }

}
