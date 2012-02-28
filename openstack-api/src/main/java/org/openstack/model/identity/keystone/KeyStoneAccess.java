package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.identity.Access;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.User;

import com.google.common.collect.Lists;

@XmlRootElement(name = "access")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneAccess implements Access, Serializable {
    @XmlElement(nillable = true, name = "service")
    @XmlElementWrapper(name = "serviceCatalog")
    private List<Service> serviceCatalog;

    @XmlAccessorType(XmlAccessType.NONE)
    public static class Token implements Access.Token {

        @XmlAttribute
        private String id;

        @XmlAttribute
        private String expires;
        
        @XmlElement
        private Tenant tenant;

        @XmlElementWrapper(name = "tenants")
        @XmlElement(name = "tenant")
        private List<Tenant> tenants;

        /* (non-Javadoc)
		 * @see org.openstack.model.identity.keystone.Token#getId()
		 */
        @Override
		public String getId() {
            return id;
        }

        /* (non-Javadoc)
		 * @see org.openstack.model.identity.keystone.Token#setId(java.lang.String)
		 */
        @Override
		public void setId(String id) {
            this.id = id;
        }

        /* (non-Javadoc)
		 * @see org.openstack.model.identity.keystone.Token#getExpires()
		 */
        @Override
		public String getExpires() {
            return expires;
        }

        /* (non-Javadoc)
		 * @see org.openstack.model.identity.keystone.Token#setExpires(java.lang.String)
		 */
        @Override
		public void setExpires(String expires) {
            this.expires = expires;
        }

		/* (non-Javadoc)
		 * @see org.openstack.model.identity.keystone.Token#getTenant()
		 */
		@Override
		public Tenant getTenant() {
			return tenant;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.identity.keystone.Token#setTenant(org.openstack.model.identity.Tenant)
		 */
		@Override
		public void setTenant(Tenant tenant) {
			this.tenant = tenant;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.identity.keystone.Token#getTenants()
		 */
		@Override
		public List<Tenant> getTenants() {
			return tenants;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.identity.keystone.Token#setTenants(java.util.List)
		 */
		@Override
		public void setTenants(List<Tenant> tenants) {
			this.tenants = tenants;
		}

		@Override
		public String toString() {
			return "Token [id=" + id + ", expires=" + expires + ", tenant=" + tenant + ", tenants=" + tenants + "]";
		}

    }

    @XmlElement
    private Access.Token token;

    @XmlElement
    public User user;

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Access#getToken()
	 */
    @Override
	public Access.Token getToken() {
        return token;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Access#setToken(org.openstack.model.identity.keystone.KeyStoneAccess.Token)
	 */
    @Override
	public void setToken(Access.Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Access [token=" + token + "]";
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Access#getServiceCatalog()
	 */
    @Override
	public List<Service> getServiceCatalog() {
        if (serviceCatalog == null) {
            serviceCatalog = Lists.newArrayList();
        }
        return serviceCatalog;
    }

}
