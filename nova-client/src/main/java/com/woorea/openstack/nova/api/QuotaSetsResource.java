package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Limits;
import com.woorea.openstack.nova.model.QuotaSet;
import com.woorea.openstack.nova.model.SimpleTenantUsage;

public class QuotaSetsResource {
	
	private final OpenStackClient CLIENT;
	
	public QuotaSetsResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public ShowQuota showQuota(String tenantId) {
		return new ShowQuota(tenantId);
	}

	public UpdateQuota updateQuota(String tenantId, QuotaSet quotaSet) {
		return new UpdateQuota(tenantId, quotaSet);
	}

	public ShowUsage showUsage(String tenantId) {
		return new ShowUsage(tenantId);
	}

	public ShowUsedLimits showUsedLimits() {
		return new ShowUsedLimits();
	}

	public class ShowQuota extends OpenStackRequest<QuotaSet> {
	    public ShowQuota(String tenantId) {
	    	super(CLIENT, HttpMethod.GET, new StringBuilder("/os-quota-sets/").append(tenantId), null, QuotaSet.class);
	    }
	    
	}

	public class UpdateQuota extends OpenStackRequest<QuotaSet> {
		public UpdateQuota(String tenantId, QuotaSet quotaSet) {
			super(CLIENT, HttpMethod.PUT, new StringBuilder("/os-quota-sets/").append(tenantId), Entity.json(quotaSet), QuotaSet.class);
		}
	}

	public class ShowUsage extends OpenStackRequest<SimpleTenantUsage> {
		public ShowUsage(String tenantId) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/os-simple-tenant-usage/").append(tenantId), null, SimpleTenantUsage.class);
		}
	}

	public class ShowUsedLimits extends OpenStackRequest<Limits> {
		public ShowUsedLimits() {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/limits"), null, Limits.class);
		}
	}
}

