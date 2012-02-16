package org.openstack.client.common;

import java.util.logging.Logger;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class OpenstackApiNamespacePrefixMapper extends NamespacePrefixMapper {
    static final Logger log = Logger.getLogger(OpenstackApiNamespacePrefixMapper.class.getName());

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if (namespaceUri.equals(Namespaces.NS_OPENSTACK_API_1_1)) {
            if (requirePrefix) {
                return suggestion;
            } else {
                // Nova Bug #887191 - it doesn't cope well with non-empty namespaces for the root element (I think)
                return "";
            }
        }

        if (namespaceUri.equals(Namespaces.NS_OPENSTACK_IDENTITY_2_0)) {
            return "osid";
        }

        if (namespaceUri.equals(Namespaces.ATOM)) {
            return "atom";
        }

        log.warning("Unknown Namespace URI: " + namespaceUri);
        return suggestion;
    }

}
