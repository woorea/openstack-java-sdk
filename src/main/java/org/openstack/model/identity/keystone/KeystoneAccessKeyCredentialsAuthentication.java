package org.openstack.model.identity.keystone;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("auth")
public class KeystoneAccessKeyCredentialsAuthentication extends KeystoneAuthentication {
	
	@XmlElement(namespace= "", name="apiAccessKeyCredentials")
    @JsonProperty
    private KeystoneAccessKeyCredentials apiAccessKeyCredentials;

	public KeystoneAccessKeyCredentialsAuthentication(String accessKey, String secretKey) {
		apiAccessKeyCredentials = new KeystoneAccessKeyCredentials();
		apiAccessKeyCredentials.setAccessKey(accessKey);
		apiAccessKeyCredentials.setSecretKey(secretKey);
	}

}
