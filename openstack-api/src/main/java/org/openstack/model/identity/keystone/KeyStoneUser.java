package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.User;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneUser implements Serializable, User {

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

    @JsonProperty("roles_links")
    private List<String> rolesLinks;

    @XmlElement(name = "roles")
    private List<Role> roles;

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#getId()
	 */
    @Override
	public String getId() {
        return id;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#setId(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#setName(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#setPassword(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#setEmail(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.User#setEnabled(boolean)
	 */
    @Override
	public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", enabled=" + enabled + "]";
    }

}
