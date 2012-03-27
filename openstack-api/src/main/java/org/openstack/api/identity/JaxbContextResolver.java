package org.openstack.api.identity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;

import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneEndpointTemplates;
import org.openstack.model.identity.KeystoneEndpointTemplatesList;
import org.openstack.model.identity.KeystoneRole;
import org.openstack.model.identity.KeystoneRoleList;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;
import org.openstack.model.identity.KeystoneServiceList;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.model.identity.KeystoneToken;
import org.openstack.model.identity.KeystoneUser;
import org.openstack.model.identity.KeystoneUserList;

public class JaxbContextResolver implements ContextResolver<JAXBContext> {

	private final JAXBContext context;
	private final Set<Class<?>> types;
	private final Class<?>[] cTypes = {
		KeystoneAccess.class, KeystoneAuthentication.class, 
		KeystoneEndpointTemplates.class, KeystoneEndpointTemplatesList.class,
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
