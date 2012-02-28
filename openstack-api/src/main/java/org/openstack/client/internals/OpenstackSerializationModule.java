package org.openstack.client.internals;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.openstack.model.compute.Addresses;
import org.openstack.model.compute.BadRequest;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.model.compute.Server;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceEndpoint;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.User;
import org.openstack.model.identity.keystone.KeyStoneAccess;
import org.openstack.model.identity.keystone.KeyStoneService;
import org.openstack.model.identity.keystone.KeyStoneServiceEndpoint;
import org.openstack.model.identity.keystone.KeyStoneTenant;
import org.openstack.model.identity.keystone.KeyStoneUser;

public class OpenstackSerializationModule extends SimpleModule {

	public OpenstackSerializationModule() {
		super(OpenstackSerializationModule.class.getName(), new Version(1, 0, 0, null));
		addSerializer(Addresses.class, new AddressesSerializer());
		addDeserializer(Addresses.class, new AddressesDeserializer());

		// Compute
		installSmartDeserializer(SecurityGroup.class);
		installSmartDeserializer(SecurityGroupList.class);
		installSmartDeserializer(Server.class);
		installSmartDeserializer(BadRequest.class);

		// Keystone (Redux)
		installSmartDeserializer(KeyStoneAccess.class);
		addAbstractTypeMapping(Access.Token.class, KeyStoneAccess.Token.class);
		addAbstractTypeMapping(Service.class, KeyStoneService.class);
		addAbstractTypeMapping(ServiceEndpoint.class, KeyStoneServiceEndpoint.class);
		addAbstractTypeMapping(User.class, KeyStoneUser.class);
		addAbstractTypeMapping(Tenant.class, KeyStoneTenant.class);
	}

	private <T> void installSmartDeserializer(Class<T> c) {
		addDeserializer(c, new SmartDeserializer<T>(c));
	}
}
