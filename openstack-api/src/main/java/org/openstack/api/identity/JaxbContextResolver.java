package org.openstack.api.identity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;

import org.openstack.model.identity.keystone.KeystoneAccess;
import org.openstack.model.identity.keystone.KeystoneAuthentication;
import org.openstack.model.identity.keystone.KeystoneEndpoint;
import org.openstack.model.identity.keystone.KeystoneEndpointList;
import org.openstack.model.identity.keystone.KeystoneRole;
import org.openstack.model.identity.keystone.KeystoneRoleList;
import org.openstack.model.identity.keystone.KeystoneService;
import org.openstack.model.identity.keystone.KeystoneServiceEndpoint;
import org.openstack.model.identity.keystone.KeystoneServiceList;
import org.openstack.model.identity.keystone.KeystoneTenant;
import org.openstack.model.identity.keystone.KeystoneTenantList;
import org.openstack.model.identity.keystone.KeystoneToken;
import org.openstack.model.identity.keystone.KeystoneUser;
import org.openstack.model.identity.keystone.KeystoneUserList;

public class JaxbContextResolver implements ContextResolver<JAXBContext> {

	private final JAXBContext context;
	private final Set<Class<?>> types;
	private final Class<?>[] cTypes = {
		KeystoneAccess.class, KeystoneAuthentication.class, 
		KeystoneEndpoint.class, KeystoneEndpointList.class,
		KeystoneRole.class, KeystoneRoleList.class,
		KeystoneService.class, KeystoneServiceList.class,
		KeystoneServiceEndpoint.class, KeystoneServiceList.class,
		KeystoneTenant.class, KeystoneTenantList.class,
		KeystoneToken.class, KeystoneUser.class,
		KeystoneUserList.class};
	
	public JaxbContextResolver() throws Exception {
		this.types = new HashSet<Class<?>>(Arrays.asList(cTypes));
		this.context = JAXBContext.newInstance(cTypes);
	}
	
	@Override
	public JAXBContext getContext(Class<?> type) {
		return (types.contains(type)) ? context : null;
	}

}
