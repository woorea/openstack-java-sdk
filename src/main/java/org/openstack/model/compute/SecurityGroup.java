package org.openstack.model.compute;

import java.util.List;

public interface SecurityGroup {

	void setRules(List<SecurityGroupRule> rules);

	List<SecurityGroupRule> getRules();

	void setDescription(String description);

	String getDescription();

	void setName(String name);

	String getName();

	void setTenantId(String tenantId);

	String getTenantId();

	void setId(Integer id);

	Integer getId();

}
