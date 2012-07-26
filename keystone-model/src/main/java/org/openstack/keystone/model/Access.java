package org.openstack.keystone.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("access")
public class Access implements Serializable {

	public static final class Token {
		
		public static final class Tenant {
			
			private String id;
			
			private String name;
			
			private String description;
			
			private Boolean enabled;

			/**
			 * @return the id
			 */
			public String getId() {
				return id;
			}

			/**
			 * @return the name
			 */
			public String getName() {
				return name;
			}

			/**
			 * @return the description
			 */
			public String getDescription() {
				return description;
			}

			/**
			 * @return the enabled
			 */
			public Boolean getEnabled() {
				return enabled;
			}

			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "Tenant [id=" + id + ", name=" + name + ", description="
						+ description + ", enabled=" + enabled + "]";
			}
			
			
		}
		
		private String id;
		
		private Calendar expires;
		
		private Tenant tenant;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @return the expires
		 */
		public Calendar getExpires() {
			return expires;
		}

		/**
		 * @return the tenant
		 */
		public Tenant getTenant() {
			return tenant;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Token [id=" + id + ", expires=" + expires + ", tenant="
					+ tenant + "]";
		}
		
	}
	
	public static final class Service {
		
		@JsonIgnoreProperties(ignoreUnknown=true)
		public static final class Endpoint {
			
			private String region;
			
			private String publicURL;
			
			private String internalURL;
			
			private String adminURL;

			/**
			 * @return the region
			 */
			public String getRegion() {
				return region;
			}

			/**
			 * @return the publicURL
			 */
			public String getPublicURL() {
				return publicURL;
			}

			/**
			 * @return the internalURL
			 */
			public String getInternalURL() {
				return internalURL;
			}

			/**
			 * @return the adminURL
			 */
			public String getAdminURL() {
				return adminURL;
			}

			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "Endpoint [region=" + region + ", publicURL="
						+ publicURL + ", internalURL=" + internalURL
						+ ", adminURL=" + adminURL + "]";
			}
			
		}
		
		private String type;
		
		private String name;
		
		private List<Endpoint> endpoints;
		
		@JsonProperty("endpoints_links")
		private List<Link> endpointsLinks;

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the endpoints
		 */
		public List<Endpoint> getEndpoints() {
			return endpoints;
		}

		/**
		 * @return the endpointsLinks
		 */
		public List<Link> getEndpointsLinks() {
			return endpointsLinks;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Service [type=" + type + ", name=" + name + ", endpoints="
					+ endpoints + ", endpointsLinks=" + endpointsLinks + "]";
		}
		
	}
	
	public static final class User {
		
		@JsonIgnoreProperties(ignoreUnknown=true)
		public static final class Role {
			
			private String id;
			
			private String name;

			/**
			 * @return the id
			 */
			public String getId() {
				return id;
			}

			/**
			 * @return the name
			 */
			public String getName() {
				return name;
			}

			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "Role [id=" + id + ", name=" + name + "]";
			}
			
		}
		
		private String id;
		
		private String name;
		
		private String username;
		
		private List<Role> roles;
		
		@JsonProperty("roles_links")
		private List<Link> rolesLinks;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * @return the roles
		 */
		public List<Role> getRoles() {
			return roles;
		}

		/**
		 * @return the rolesLinks
		 */
		public List<Link> getRolesLinks() {
			return rolesLinks;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", username="
					+ username + ", roles=" + roles + ", rolesLinks="
					+ rolesLinks + "]";
		}
		
	}
	
	private Token token;
	
	private List<Service> serviceCatalog;
	
	private User user;

	/**
	 * @return the token
	 */
	public Token getToken() {
		return token;
	}

	/**
	 * @return the serviceCatalog
	 */
	public List<Service> getServiceCatalog() {
		return serviceCatalog;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Access [token=" + token + ", serviceCatalog=" + serviceCatalog
				+ ", user=" + user + "]";
	}

	
	
}
