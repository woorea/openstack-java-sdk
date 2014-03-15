package com.woorea.openstack.keystone.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("user")
public class User implements Serializable {
    private String id;
    private String username;
    private String OS_KSADM_password;
    private String password;
    private String tenantId;
    private String name;
    private String email;

    //@JsonProperty("extra")
    private Extra extra;
    private Boolean enabled;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * @param tenantId the tenantId to set
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" +
        password + ", tenantId=" + tenantId + ", name=" + name + ", email=" +
        email + ", enabled=" + enabled +
        ((extra != null) ? (", " + extra.toString()) : "") + "]";
    }

    public String getOS_KSADM_password() {
        return password;
    }

    public void setOS_KSADM_password(String oS_KSADM_password) {
        password = oS_KSADM_password;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }
}
