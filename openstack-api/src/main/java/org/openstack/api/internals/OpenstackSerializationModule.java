package org.openstack.api.internals;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.openstack.model.compute.NovaAddresses;
import org.openstack.model.compute.NovaBadRequest;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.identity.KeyStoneAccess;

public class OpenstackSerializationModule extends SimpleModule {

	public OpenstackSerializationModule() {
		super(OpenstackSerializationModule.class.getName(), new Version(1, 0, 0, null));
		addSerializer(NovaAddresses.class, new AddressesSerializer());
		addDeserializer(NovaAddresses.class, new AddressesDeserializer());

		// Compute
		installSmartDeserializer(NovaSecurityGroup.class);
		installSmartDeserializer(NovaSecurityGroupList.class);
		installSmartDeserializer(NovaServer.class);
		installSmartDeserializer(NovaBadRequest.class);

		// Keystone (Redux)
		installSmartDeserializer(KeyStoneAccess.class);
	}

	private <T> void installSmartDeserializer(Class<T> c) {
		addDeserializer(c, new SmartDeserializer<T>(c));
	}
}
