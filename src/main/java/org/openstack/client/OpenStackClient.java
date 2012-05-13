package org.openstack.client;

import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.api.common.RestClient;
import org.openstack.api.compute.TenantResource;
import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.api.identity.IdentityInternalEndpoint;
import org.openstack.api.identity.IdentityPublicEndpoint;
import org.openstack.api.images.ImagesResource;
import org.openstack.api.storage.AccountResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.keystone.KeystoneAuthentication;

import com.google.common.base.Preconditions;

public class OpenStackClient {
	
	//private LoggingFilter loggingFilter = new LoggingFilter(Logger.getLogger(OpenStackClient.class.getPackage().getName()),false);
	
	//private LoggingFilter loggingEntityFilter = new LoggingFilter(Logger.getLogger(OpenStackClient.class.getPackage().getName()),true);
	
	private Properties properties;

	private Access access;

	private XAuthTokenFilter authFilter;

	private XAuthTokenFilter authAsAdministratorFilter;
	
	private OpenStackClient() {
		
	}
	
	public static OpenStackClient authenticate(Properties properties, Access access) {
		OpenStackClient client = new OpenStackClient();
		client.properties = properties;
		client.access = access;
		client.authFilter = new XAuthTokenFilter(access.getToken().getId());
		client.authAsAdministratorFilter = new XAuthTokenFilter(properties.getProperty("identity.admin.token"));
		return client;
	}
	
	public static OpenStackClient authenticate(Properties properties) {
		OpenStackClient client = new OpenStackClient();
		client.properties = properties;
		
		String credentials = properties.getProperty("auth.credentials");
		
		KeystoneAuthentication authentication = null;
		
		if("apiAccessKeyCredentials".equals(credentials)) {
			String accessKey = properties.getProperty("auth.accessKey");
			String secretKey = properties.getProperty("auth.secretKey");
			authentication = KeystoneAuthentication.withApiAccessKeyCredentials(accessKey, secretKey);
		} else {
			String username = properties.getProperty("auth.username");
			String password = properties.getProperty("auth.password");
			authentication = KeystoneAuthentication.withPasswordCredentials(username, password);
		}
		
		String tenantId = properties.getProperty("auth.tenantId");
		String tenantName = properties.getProperty("auth.tenantName");
		
		if(tenantId != null) {
			authentication.setTenantId(tenantId);
		} else if(tenantName != null) {
			authentication.setTenantName(tenantName);
		}
		Access access = client.getIdentityEndpoint().tokens().post(authentication);
		System.out.println(access);
		return authenticate(properties, access);
	}
	
	public static OpenStackClient authenticate() {
		try {
			Properties properties = new Properties();
			properties.load(OpenStackClient.class.getResourceAsStream("/openstack.properties"));
			return authenticate(properties);
		} catch (IOException e) {
			throw new OpenstackException("openstack.properties not found in the CLASSPATH", e);
		}
	}
	
	public void reauthenticateOnTenant(String tenantName) {
		properties.setProperty("auth.tenant.name", tenantName);
		authenticate(properties);
	}

	public void exchangeTokenForTenant(String tenantId) {
		String endpoint = properties.getProperty("identity.endpoint.publicURL");
		Authentication authentication = KeystoneAuthentication.withTokenAndTenant(access.getToken().getId(), tenantId);
		this.access = target(endpoint, IdentityPublicEndpoint.class).tokens().post(authentication);
		System.out.println("EX " + this.access);
	}
	
	public Access getAccess() {
		return this.access;
	}
	
	public IdentityClient getIdentityClient() {
		return new IdentityClient(getIdentityAdministationEndpoint());
	}
	
	public IdentityPublicEndpoint getIdentityEndpoint() {
		String url = properties.getProperty("identity.endpoint.publicURL");
		Preconditions.checkNotNull(url, "'identity.endpoint.publicURL' property not found");
		return target(url, IdentityPublicEndpoint.class);
	}
	
	public IdentityInternalEndpoint getIdentityInternalEndpoint() {
		String url = properties.getProperty("identity.endpoint.public");
		Preconditions.checkNotNull(url, "'identity.endpoint.internalURL' property not found");
		return target(url, IdentityInternalEndpoint.class);
	}

	public IdentityAdministrationEndpoint getIdentityAdministationEndpoint() {
		String url = properties.getProperty("identity.endpoint.adminURL");
		Preconditions.checkNotNull(url, "'identity.endpoint.adminURL' property not found");
		return target(url, IdentityAdministrationEndpoint.class, true);
	}
	
	public ComputeClient getComputeClient() {
		return new ComputeClient(getComputeEndpoint());
	}
	
	public TenantResource getComputeEndpoint() {
		return target(access.getEndpoint("compute", null).getPublicURL(), TenantResource.class);
	}
	
	public ComputeClient getComputeInternalClient() {
		return new ComputeClient(getComputeInternalEndpoint());
	}
	
	public TenantResource getComputeInternalEndpoint() {
		return target(access.getEndpoint("compute", null).getInternalURL(), TenantResource.class);
	}
	
	public ComputeClient getComputeAdministrationClient() {
		return new ComputeClient(getComputeAdministationEndpoint());
	}

	public TenantResource getComputeAdministationEndpoint() {
		return target(access.getEndpoint("compute", null).getAdminURL(), TenantResource.class);
	}
	
	public ImagesClient getImagesClient() {
		return new ImagesClient(getImagesEndpoint());
	}
	
	public ImagesResource getImagesEndpoint() {
		return target(access.getEndpoint("image", null).getPublicURL().concat("/images"), ImagesResource.class);
	}
	
	public ImagesResource getImagesInternalEndpoint() {
		return target(access.getEndpoint("image", null).getAdminURL().concat("/images"), ImagesResource.class);
	}

	public ImagesResource getImagesAdministationEndpoint() {
		return target(access.getEndpoint("image", null).getAdminURL().concat("/images"), ImagesResource.class);
	}
	
	public StorageClient getStorageClient() {
		return new StorageClient(getStorageEndpoint());
	}
	
	public AccountResource getStorageEndpoint() {
		return target(access.getEndpoint("object-store", null).getPublicURL(), AccountResource.class);
	}
	
	public AccountResource getStorageInternalEndpoint() {
		return target(access.getEndpoint("object-store", null).getInternalURL().replace("AUTH_", ""), AccountResource.class);
	}

	public AccountResource getStorageAdministationEndpoint() {
		return target(access.getEndpoint("object-store", null).getAdminURL().replace("AUTH_", ""), AccountResource.class);
	}
	
	public <T extends Resource> T target(String absoluteURL, Class<T> clazz) {
		return target(absoluteURL, clazz, false);
	}

	private <T extends Resource> T target(String absoluteURL, Class<T> clazz, boolean useAdministrationToken) {
		try {
			Target target = RestClient.INSTANCE.getJerseyClient().target(absoluteURL);
			if (access != null) {
				target.configuration().register(useAdministrationToken ? authAsAdministratorFilter : authFilter);
			}
			return clazz.getConstructor(Target.class, Properties.class).newInstance(target, properties);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	

}
