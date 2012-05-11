package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.api.Namespaces;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.Credentials;
import org.openstack.model.identity.Token;

@XmlType(namespace= Namespaces.NS_OPENSTACK_IDENTITY_2_0)
@XmlRootElement(name = "auth", namespace= "")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("auth")
public class KeystoneAuthentication implements Serializable, Authentication {
    
    @XmlElement(type = KeystoneToken.class)
    private KeystoneToken token;

    @XmlElement(namespace= "", name="passwordCredentials")
    @JsonProperty
    private KeystonePasswordCredentials passwordCredentials;
    
    @XmlElement(namespace= "", name="apiAccessKeyCredentials")
    @JsonProperty
    private KeystoneApiAccessKeyCredentials apiAccessKeyCredentials;

    @XmlAttribute
    private String tenantId;
    
    @XmlAttribute
    private String tenantName;
    
    private KeystoneAuthentication() { }
    
    public static KeystoneAuthentication withPasswordCredentials(String username, String password) {
    	KeystoneAuthentication auth = new KeystoneAuthentication();
    	auth.passwordCredentials = new KeystonePasswordCredentials();
    	auth.passwordCredentials.setUsername(username);
    	auth.passwordCredentials.setPassword(password);
		return auth;
	}
	
	public static KeystoneAuthentication withApiAccessKeyCredentials(String accessKey, String secretKey) {
		KeystoneAuthentication auth = new KeystoneAuthentication();
		auth.apiAccessKeyCredentials = new KeystoneApiAccessKeyCredentials();
		auth.apiAccessKeyCredentials.setAccessKey(accessKey);
		auth.apiAccessKeyCredentials.setSecretKey(secretKey);
		return auth;
	}
	
	public static KeystoneAuthentication withTokenAndTenant(String tokenId, String tenantId) {
		KeystoneAuthentication auth = new KeystoneAuthentication();
		auth.token = new KeystoneToken();
		auth.token.setId(tokenId);
		auth.tenantId = tenantId;
		return auth;
	}

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Authentication#getToken()
	 */
    @Override
	public Token getToken() {
		return token;
	}

	public void setToken(KeystoneToken token) {
		this.token = token;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Authentication#getPasswordCredentials()
	 */
	@Override
	public Credentials getCredentials() {
        return passwordCredentials;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Authentication#getTenantId()
	 */
	@Override
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Authentication#getTenantName()
	 */
	@Override
	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	
	
	

	@Override
	public String toString() {
		return "KeyStoneAuthentication [token=" + token
				+ ", passwordCredentials=" + passwordCredentials
				+ ", tenantId=" + tenantId + ", tenantName=" + tenantName + "]";
	}

	

}
