package org.openstack.client.cli;

import java.util.List;
import java.util.Map;

import org.openstack.client.OpenStackClient;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.exceptions.OpenstackException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class OpenstackCache {

	private final OpenStackClient service;

	public OpenstackCache(OpenStackClient service) {
		this.service = service;
	}

	public Iterable<NovaImage> getImages(boolean useCache) throws OpenstackException {
		return getCachedList(NovaImage.class, useCache);
	}

	public <V> Iterable<V> listItems(Class<V> modelClass, boolean useCache) throws OpenstackException {
		return getCachedList(modelClass, useCache);
	}

	final Map<Class<?>, List<?>> cachedLists = Maps.newHashMap();

	private <V> Iterable<V> getCachedList(Class<V> modelClass, boolean useCache) throws OpenstackException {
		List<V> cached = useCache ? (List<V>) cachedLists.get(modelClass) : null;
		if (cached == null) {
			cached = (List<V>) Lists.newArrayList(service.listItems(modelClass, true));
			cachedLists.put(modelClass, cached);
		}
		return cached;
	}

	public Iterable<org.openstack.model.image.GlanceImage> getGlanceImages(boolean useCache) {
		return getCachedList(org.openstack.model.image.GlanceImage.class, useCache);
	}

	public void invalidateCache(Class<?> modelClass) {
		cachedLists.remove(modelClass);
	}

	public Iterable<NovaSecurityGroup> getSecurityGroups(boolean useCache) {
		return getCachedList(NovaSecurityGroup.class, useCache);
	}

}
