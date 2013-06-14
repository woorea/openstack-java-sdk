package org.openstack.examples.compute;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.glance.GlanceClient;
import org.openstack.glance.api.ListImages;
import org.openstack.glance.api.ShowImage;
import org.openstack.glance.api.UploadImage;
import org.openstack.glance.model.Image;
import org.openstack.glance.model.ImageForUpload;
import org.openstack.glance.model.Images;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.ListTenants;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.Authentication.PasswordCredentials;
import org.openstack.keystone.model.Authentication.Token;
import org.openstack.keystone.model.Tenants;

public class NovaListImages {
	

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Authentication authentication = new Authentication();
		PasswordCredentials passwordCredentials = new PasswordCredentials();
		passwordCredentials.setUsername(ExamplesConfiguration.KEYSTONE_USERNAME);
		passwordCredentials.setPassword(ExamplesConfiguration.KEYSTONE_PASSWORD);
		authentication.setPasswordCredentials(passwordCredentials);
		
		//access with unscoped token
		Access access = keystone.execute(new Authenticate(authentication));
		
		//use the token in the following requests
		keystone.setToken(access.getToken().getId());
		
		Tenants tenants = keystone.execute(new ListTenants());
		
		//try to exchange token using the first tenant
		if(tenants.getList().size() > 0) {
			
			authentication = new Authentication();
			Token token = new Token();
			token.setId(access.getToken().getId());
			authentication.setToken(token);
			authentication.setTenantId(tenants.getList().get(0).getId());
			
			access = keystone.execute(new Authenticate(authentication));
			
			//NovaClient novaClient = new NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "compute", null, "public"), access.getToken().getId());
			GlanceClient glanceClient = new GlanceClient("http://10.214.25.186:9292/v1", access.getToken().getId());
			glanceClient.enableLogging(Logger.getLogger("glance"), 100 * 1024);
			
			Images images = glanceClient.execute(new ListImages(true));
			for(Image image : images) {
				System.out.println(image);
			}
			Image image = glanceClient.execute(new ShowImage(images.getList().get(0).getId()));
			System.out.println(image);
			
			ImageForUpload upload = new ImageForUpload();
			upload.setName("test-image");
			upload.setPublic(true);
			upload.setContainerFormat("bare");
			upload.setDiskFormat("qcow2");
			upload.setInputStream(new FileInputStream(new File("/opt/devstack-stable-grizzly/files/F16-i386-cfntools.qcow2")));
			glanceClient.execute(new UploadImage(upload));
			
		} else {
			System.out.println("No tenants found!");
		}
		
	}

}
