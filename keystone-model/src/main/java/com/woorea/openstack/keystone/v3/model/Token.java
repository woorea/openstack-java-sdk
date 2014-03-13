package com.woorea.openstack.keystone.v3.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("token")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Token implements Serializable {
	
	private String id;
	
	@JsonProperty("expires_at")
	private Calendar expiresAt;
	
	@JsonProperty("issued_at")
	private Calendar issuedAt;
	
	private List<String> methods;
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	private static final class Domain {
		
		private String id;
		
		private String name;
		
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static final class User {
		
		@JsonIgnoreProperties(ignoreUnknown=true)
		private static final class Domain {
			
			private String id;
			
			private String name;
			
		}
		
		private String id;
		
		private String name;
		
	}
	
	private User user;
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static final class Role {
		
		private String id;
		
		private String name;
		
	}
	
	private List<Role> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Calendar expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Calendar getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Calendar issuedAt) {
		this.issuedAt = issuedAt;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", expiresAt=" + expiresAt.getTime() + ", issuedAt="
				+ issuedAt.getTime() + ", methods=" + methods + ", user=" + user
				+ ", roles=" + roles + "]";
	}
	
}
