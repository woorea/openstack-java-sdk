package com.woorea.openstack.quantum.model;

import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * @deprecated Please use {@link Port} directly.
 */
@SuppressWarnings("serial")
@JsonRootName("port")
@Deprecated
public class PortForCreate extends Port {
}
