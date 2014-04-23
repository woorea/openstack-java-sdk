package com.woorea.openstack.quantum.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hamcrest.CustomMatcher;
import org.junit.Before;
import org.junit.Test;

import com.woorea.openstack.quantum.model.Port.Ip;

public class PortTest {

    private static final String TENANT_ID = "tenantId";

    private static final String STATUS = "status";

    private static final String NETWORK_ID = "networkId";

    private static final String NAME = "name";

    private static final String MAC_ADDRESS = "macAddress";

    private static final String DEVICE_OWNER = "deviceOwner";

    private static final String DEVICE_ID = "deviceId";

    private static final String IP_SUBNET_ID = "ipSubnetId";

    private static final String IP_ADDRESS = "10.0.0.1";

    private static final boolean ADMIN_STATE_UP = true;

    private static final String SEC_GROUP = "secGroup";

    private static final String ID = "testId";

    /**
     * JSON with read only attributes.
     */
    private static final String PORT_JSON = "{"
            + "  \"port\" : {"
            + "    \"id\" : \"" + ID + "\","
            + "    \"status\" : \"" + STATUS + "\""
            + "  }"
            + "}";

    private ObjectMapper objectMapper;

    private String serializedPort;

    @Before
    public void setUp() throws Exception {
        objectMapper = initializeObjectMapper();
    }

    public static ObjectMapper initializeObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Inclusion.NON_NULL)
                .enable(SerializationConfig.Feature.INDENT_OUTPUT)
                .enable(SerializationConfig.Feature.WRAP_ROOT_VALUE)
                .enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE)
                .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return objectMapper;
    }

    @Test
    public void testSerialization() throws Exception {
        Port port = new Port();
        port.setId(ID);
        port.setAdminStateUp(ADMIN_STATE_UP);
        port.setSecurityGroups(Arrays.asList(SEC_GROUP));
        port.setDeviceId(DEVICE_ID);
        port.setDeviceOwner(DEVICE_OWNER);
        port.setMacAddress(MAC_ADDRESS);
        port.setName(NAME);
        port.setNetworkId(NETWORK_ID);
        port.setStatus(STATUS);
        port.setTenantId(TENANT_ID);

        List<Ip> ips = new ArrayList<Port.Ip>();
        Ip ip = new Ip();
        ip.setAddress(IP_ADDRESS);
        ip.setSubnetId(IP_SUBNET_ID);
        ips.add(ip);
        port.setList(ips);

        serializedPort = objectMapper.writeValueAsString(port);
        assertThat(serializedPort, not(containsString(ID)));
        assertThat(serializedPort, not(containsString(STATUS)));
        assertThat(serializedPort, containsString("\"admin_state_up\" : " + ADMIN_STATE_UP));
        assertThat(serializedPort, containsString(SEC_GROUP));
        assertThat(serializedPort, containsString(IP_ADDRESS));
        assertThat(serializedPort, containsString(DEVICE_ID));
        assertThat(serializedPort, containsString(DEVICE_OWNER));
        assertThat(serializedPort, containsString(MAC_ADDRESS));
        assertThat(serializedPort, containsString(NAME));
        assertThat(serializedPort, containsString(NETWORK_ID));
        assertThat(serializedPort, containsString(TENANT_ID));
    }

    @Test
    public void testSerializationEmpty() throws Exception {
        Port port = new Port();
        serializedPort = objectMapper.writeValueAsString(port);

        assertThat(serializedPort, containsString("\"port\" : { }"));
    }

    @Test
    public void testDeserializationReadOnlyFields() throws Exception {
        Port port = objectMapper.readValue(PORT_JSON, Port.class);

        assertThat(port.getId(), is(equalTo(ID)));
        assertThat(port.getStatus(), is(equalTo(STATUS)));
    }

    @Test
    public void testDeserializationAfterSerialization() throws Exception {
        testSerialization();
        Port port = objectMapper.readValue(serializedPort, Port.class);

        assertThat(port.getAdminStateUp(), is(equalTo(ADMIN_STATE_UP)));
        assertThat(port.getDeviceId(), is(equalTo(DEVICE_ID)));
        assertThat(port.getDeviceOwner(), is(equalTo(DEVICE_OWNER)));
        assertThat(port.getMacAddress(), is(equalTo(MAC_ADDRESS)));
        assertThat(port.getName(), is(equalTo(NAME)));
        assertThat(port.getNetworkId(), is(equalTo(NETWORK_ID)));
        assertThat(port.getTenantId(), is(equalTo(TENANT_ID)));

        assertThat(port.getSecurityGroups(), hasItem(equalTo(SEC_GROUP)));
        assertThat(port.getList(), hasItem(new CustomMatcher<Ip>(
                "an Ip object with address " + IP_ADDRESS + " and subnet id " + IP_SUBNET_ID) {

            @Override
            public boolean matches(Object ip) {
                return ip instanceof Ip
                        && IP_ADDRESS.equals(((Ip) ip).getAddress())
                        && IP_SUBNET_ID.equals(((Ip) ip).getSubnetId());
            }
        }));
    }
}
