package org.openstack.model.identity;

import java.util.List;

import org.openstack.model.atom.Link;

public interface TenantList {

	List<Tenant> getList();

	//void setList(List<? extends Tenant> list);

	List<Link> getLinks();

	//void setLinks(List<Link> links);

}