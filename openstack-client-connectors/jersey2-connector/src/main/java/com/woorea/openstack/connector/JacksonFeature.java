package com.woorea.openstack.connector;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/**
 * Feature used to register Jackson JSON providers.
 *
 * @author Stepan Kopriva (stepan.kopriva at oracle.com)
 */
public class JacksonFeature implements Feature {

    @Override
    public boolean configure(final FeatureContext context) {
    	/*
        final String disableMoxy = CommonProperties.MOXY_JSON_FEATURE_DISABLE + '.'
                + context.getConfiguration().getRuntimeType().name().toLowerCase();
        context.property(disableMoxy, true);
		*/
        context.register(JacksonJaxbJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
        return true;
    }
}