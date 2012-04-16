package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.api.Namespaces;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.Token;

@XmlType(namespace= Namespaces.NS_OPENSTACK_IDENTITY_2_0)
@XmlRootElement(name = "auth", namespace= "")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("auth")
public class KeystoneAuthentication implements Serializable, Authentication {

    @XmlAccessorType(XmlAccessType.NONE)
    public static class PasswordCredentials implements Serializable {

        @XmlAttribute
        private String username;

        @XmlAttribute
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }
    
    @XmlElement(type = KeystoneToken.class)
    private KeystoneToken token;

    @XmlElement(namespace= "")
    private PasswordCredentials passwordCredentials;

    @XmlAttribute
    private String tenantId;
    
    @XmlAttribute
    private String tenantName;

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
	public PasswordCredentials getPasswordCredentials() {
        return passwordCredentials;
    }

	public void setPasswordCredentials(PasswordCredentials passwordCredentials) {
        this.passwordCredentials = passwordCredentials;
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
	
	public KeystoneAuthentication withPasswordCredentials(String username, String password) {
		passwordCredentials = new PasswordCredentials();
		passwordCredentials.username = username;
		passwordCredentials.password = password;
		return this;
	}
	
	public KeystoneAuthentication withTokenAndTenant(String tokenId, String tenantId) {
		KeystoneToken token = new KeystoneToken();
		token.setId(tokenId);
		this.token = token;
		this.tenantId = tenantId;
		return this;
	}

	@Override
	public String toString() {
		return "KeyStoneAuthentication [token=" + token
				+ ", passwordCredentials=" + passwordCredentials
				+ ", tenantId=" + tenantId + ", tenantName=" + tenantName + "]";
	}

	

}
