package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.api.Namespaces;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.ServiceCatalogEntry;
import org.openstack.model.identity.ServiceEndpoint;
import org.openstack.model.identity.Token;
import org.openstack.model.identity.User;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

@XmlType(namespace= Namespaces.NS_OPENSTACK_IDENTITY_2_0)
@XmlRootElement(name = "access")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("access")
public class KeystoneAccess implements Serializable, Access {
    
    @XmlElement(type = KeystoneToken.class)
    private KeystoneToken token;
    
    @XmlElementWrapper(name = "serviceCatalog")
    @XmlElement(name = "service", type = KeystoneService.class)
    @JsonProperty("serviceCatalog")
    @JsonDeserialize(as=List.class, contentAs=KeystoneServiceCatalogEntry.class)
	private List<ServiceCatalogEntry> services = new ArrayList<ServiceCatalogEntry>();

    @XmlElement(type = KeystoneUser.class)
    private KeystoneUser user;

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Access#getToken()
	 */
    @Override
	public Token getToken() {
        return token;
    }

	public void setToken(KeystoneToken token) {
        this.token = (KeystoneToken) token;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Access#getServices()
	 */
	@Override
	
	public List<ServiceCatalogEntry> getServices() {
		return services;
	}
	
	public void setServices(List<ServiceCatalogEntry> services) {
		this.services = services;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Access#getUser()
	 */
	@Override
	public User getUser() {
		return user;
	}

	public void setUser(KeystoneUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "KeyStoneAccess [token=" + token + ", services=" + services
				+ ", user=" + user + "]";
	}
	
	/* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Access#getEndpoint()
	 */
	@Override
	public ServiceEndpoint getEndpoint(final String type, final String region) {
		try {
			ServiceCatalogEntry service = Iterables.find(getServices(), new Predicate<ServiceCatalogEntry>() {

						@Override
						public boolean apply(ServiceCatalogEntry service) {
							return type.equals(service.getType());
						}

					});
			List<ServiceEndpoint> endpoints = service.getEndpoints();
			if (region != null) {
				return  Iterables.find(endpoints, new Predicate<ServiceEndpoint>() {

							@Override
							public boolean apply(ServiceEndpoint endpoint) {
								return region.equals(endpoint.getRegion());
							}
						});
			} else {
				return endpoints.get(0);
			}
		} catch (NoSuchElementException e) {
			throw new OpenstackException("Service " + type + " not found, you can try openstack.target(<endpoint>, <resource class>) method instead", e);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
