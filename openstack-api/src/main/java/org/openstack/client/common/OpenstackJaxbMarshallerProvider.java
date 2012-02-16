package org.openstack.client.common;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Provider
public class OpenstackJaxbMarshallerProvider implements ContextResolver<Marshaller> {

    @Context
    private Providers providers;

    @Override
    public Marshaller getContext(Class<?> type) {
        Marshaller marshaller;
        try {
            marshaller = getJAXBContext(type).createMarshaller();
        } catch (JAXBException e) {
            throw new IllegalStateException("Error building JAXB context / marshaller", e);
        }

        // try {
        // marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new OpenstackApiNamespacePrefixMapper());
        // } catch (PropertyException e) {
        // throw new IllegalStateException("Error setting namespace mapper", e);
        // }

        // if (formattedOutput)
        // m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput);
        return marshaller;
    }

    private JAXBContext getJAXBContext(Class type) throws JAXBException {
        MediaType mt = null; // ??
        return getJAXBContext(type, mt);
    }

    private JAXBContext getJAXBContext(Class type, MediaType mt) throws JAXBException {
        final ContextResolver<JAXBContext> cr = providers.getContextResolver(JAXBContext.class, mt);
        if (cr != null) {
            JAXBContext c = cr.getContext(type);
            if (c != null)
                return c;
        }

        // For simplicity, we rely on the context resolver being around as well
        throw new IllegalStateException("Cannot find JAXB context resolver");
    }

}
