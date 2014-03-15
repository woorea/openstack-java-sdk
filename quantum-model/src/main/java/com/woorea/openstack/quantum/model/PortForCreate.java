package com.woorea.openstack.quantum.model;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @deprecated Please use {@link Port} directly.
 */
@SuppressWarnings("serial")
@JsonRootName("port")
@Deprecated
public class PortForCreate extends Port {
}
