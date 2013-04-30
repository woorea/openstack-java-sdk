package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Certificate;

public class CredentialsExtension {
	
	private final OpenStackClient CLIENT;
	
	public CredentialsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public Create createCertificate(String id) {
		return new Create(id);
	}

	public Show showCertificate(String id) {
		return new Show();
	}

	public class Create extends OpenStackRequest<Certificate> {

		public Create(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuffer("/os-certificates").append(id).toString(), null, Certificate.class);
		}

	}

	public class Show extends OpenStackRequest<Certificate> {

		public Show() {
			super(CLIENT, HttpMethod.GET, "/os-certificates", null, Certificate.class);
		}

	}

	

}
