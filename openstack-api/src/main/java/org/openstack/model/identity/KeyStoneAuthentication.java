package org.openstack.model.identity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.openstack.api.Namespaces;
import org.openstack.model.common.JsonRootElement;

@XmlType(namespace= Namespaces.NS_OPENSTACK_IDENTITY_2_0)
@XmlRootElement(name = "auth", namespace= "")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("auth")
public class KeystoneAuthentication implements Serializable {

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
    
    @XmlElement
    private KeystoneToken token;

    @XmlElement(namespace= "")
    private PasswordCredentials passwordCredentials;

    @XmlAttribute
    private String tenantId;
    
    @XmlAttribute
    private String tenantName;

    public KeystoneToken getToken() {
		return token;
	}

	public void setToken(KeystoneToken token) {
		this.token = token;
	}

	public PasswordCredentials getPasswordCredentials() {
        return passwordCredentials;
    }

    public void setPasswordCredentials(PasswordCredentials passwordCredentials) {
        this.passwordCredentials = passwordCredentials;
    }

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

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
