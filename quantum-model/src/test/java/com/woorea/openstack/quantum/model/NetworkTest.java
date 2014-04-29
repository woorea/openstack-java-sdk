package com.woorea.openstack.quantum.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

public class NetworkTest {

    private static final String ID = "testId";

    private static final boolean ADMIN_STATE_UP = true;

    private static final String NAME = "name";

    private static final String TENANT_ID = "tenantId";

    private static final String SHARED = "shared";

    private static final String STATUS = "status";

    private static final String SUBNET = "subnet";

    private static final String PROVIDER_NETWORK_TYPE = "vlan";

    private static final String PROVIDER_PHYSICAL_NETWORK = "physicalNetwork";

    private static final int PROVIDER_SEGMENTATION_ID = 100;

    private static final String ROUTER_EXTERNAL = "routerExternal";

    /**
     * JSON with read only attributes.
     */
    private static final String NETWORK_JSON = "{"
            + "  \"network\" : {"
            + "    \"id\" : \"" + ID + "\","
            + "    \"status\" : \"" + STATUS + "\","
            + "    \"subnets\" : [ \"" + SUBNET + "\" ]"
            + "  }"
            + "}";

    private ObjectMapper objectMapper;

    private String serializedNetwork;

    @Before
    public void setUp() throws Exception {
        objectMapper = PortTest.initializeObjectMapper();
    }

    @Test
    public void testSerialization() throws Exception {
        Network network = new Network();
        network.setId(ID);
        network.setProviderNetworkType(PROVIDER_NETWORK_TYPE);
        network.setProviderPhysicalNetwork(PROVIDER_PHYSICAL_NETWORK);
        network.setProviderSegmentationId(PROVIDER_SEGMENTATION_ID);
        network.setAdminStateUp(ADMIN_STATE_UP);
        network.setSubnets(Arrays.asList(SUBNET));
        network.setRouterExternal(ROUTER_EXTERNAL);
        network.setName(NAME);
        network.setShared(SHARED);
        network.setTenantId(TENANT_ID);

        serializedNetwork = objectMapper.writeValueAsString(network);
        assertThat(serializedNetwork, not(containsString(ID)));
        assertThat(serializedNetwork, not(containsString(STATUS)));
        assertThat(serializedNetwork, not(containsString(SUBNET)));
        assertThat(serializedNetwork, containsString("\"admin_state_up\" : " + ADMIN_STATE_UP));
        assertThat(serializedNetwork, containsString(NAME));
        assertThat(serializedNetwork, containsString(SHARED));
        assertThat(serializedNetwork, containsString(TENANT_ID));
        assertThat(serializedNetwork, containsString(ROUTER_EXTERNAL));
        assertThat(serializedNetwork, containsString(PROVIDER_NETWORK_TYPE));
        assertThat(serializedNetwork, containsString(PROVIDER_PHYSICAL_NETWORK));
        assertThat(serializedNetwork, containsString(Integer.toString(PROVIDER_SEGMENTATION_ID)));
    }

    @Test
    public void testSerializationEmpty() throws Exception {
        Network network = new Network();
        serializedNetwork = objectMapper.writeValueAsString(network);

        assertThat(serializedNetwork, containsString("\"network\" : { }"));
    }

    @Test
    public void testDeserializationReadOnlyFields() throws Exception {
        Network network = objectMapper.readValue(NETWORK_JSON, Network.class);

        assertThat(network.getId(), is(equalTo(ID)));
        assertThat(network.getSubnets(), hasItem(equalTo(SUBNET)));
        assertThat(network.getStatus(), is(equalTo(STATUS)));
    }

    @Test
    public void testDeserialization() throws Exception {
        testSerialization();
        Network network = objectMapper.readValue(serializedNetwork, Network.class);

        assertThat(network.getName(), is(equalTo(NAME)));
        assertThat(network.isAdminStateUp(), is(equalTo(ADMIN_STATE_UP)));
        assertThat(network.getShared(), is(equalTo(SHARED)));
        assertThat(network.getTenantId(), is(equalTo(TENANT_ID)));
        assertThat(network.getRouterExternal(), is(equalTo(ROUTER_EXTERNAL)));
        assertThat(network.getProviderNetworkType(), is(equalTo(PROVIDER_NETWORK_TYPE)));
        assertThat(network.getProviderPhysicalNetwork(), is(equalTo(PROVIDER_PHYSICAL_NETWORK)));
        assertThat(network.getProviderSegmentationId(), is(equalTo(PROVIDER_SEGMENTATION_ID)));
    }
}
