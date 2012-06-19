package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.User;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("user")
public class KeystoneUser implements Serializable, User {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String username;

    @XmlAttribute
    private String password;

    @XmlAttribute
    private String email;

    @XmlAttribute
    private boolean enabled;
    
    @XmlAttribute
    private String tenantId;
    
    @XmlElement(name = "roles")
    @JsonDeserialize(as=List.class, contentAs=KeystoneRole.class)
    private List<Role> roles;

    @JsonProperty("roles_links")
    private List<String> rolesLinks;

    @JsonProperty
    private Map<String, Object> extra;

    public KeystoneUser() {
    	
    }
    
    public KeystoneUser(String id, String name) {
    	this.id = id;
    	this.name = name;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#getId()
	 */
	@Override
	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#getName()
	 */
	@Override
	public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#getPassword()
	 */
	@Override
	public String getPassword() {
        return password;
    }

	public void setPassword(String password) {
        this.password = password;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#getEmail()
	 */
	@Override
	public String getEmail() {
        return email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
        return enabled;
    }

	public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#getUsername()
	 */
    @Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public List<String> getRolesLinks() {
		return rolesLinks;
	}

	public void setRolesLinks(List<String> rolesLinks) {
		this.rolesLinks = rolesLinks;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#getRoles()
	 */
	@Override
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}

	@Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", enabled=" + enabled + "]";
    }

}
