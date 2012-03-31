package org.openstack.model.compute;

import java.util.List;

public interface SecurityGroup {

	public abstract void setRules(List<SecurityGroupRule> rules);

	public abstract List<SecurityGroupRule> getRules();

	public abstract void setDescription(String description);

	public abstract String getDescription();

	public abstract void setName(String name);

	public abstract String getName();

	public abstract void setTenantId(String tenantId);

	public abstract String getTenantId();

	public abstract void setId(Integer id);

	public abstract Integer getId();

}
