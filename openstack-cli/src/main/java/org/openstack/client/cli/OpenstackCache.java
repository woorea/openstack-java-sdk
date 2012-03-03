package org.openstack.client.cli;

import java.util.List;
import java.util.Map;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackSession;
import org.openstack.client.compute.TenantResource;
import org.openstack.client.compute.ext.SecurityGroupsResource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.Server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class OpenstackCache {

	private final OpenstackSession session;

	public OpenstackCache(OpenstackSession session) {
		this.session = session;
	}

	public Iterable<Image> getImages(boolean useCache) throws OpenstackException {
		return getCachedList(Image.class, useCache);
	}

	public Iterable<Server> getInstances(boolean useCache) throws OpenstackException {
		return getCachedList(Server.class, useCache);
	}

	public Iterable<Flavor> getFlavors(boolean useCache) throws OpenstackException {
		return getCachedList(Flavor.class, useCache);
	}

	final Map<Class<?>, List<?>> cachedLists = Maps.newHashMap();

	private <V> Iterable<V> getCachedList(Class<V> modelClass, boolean useCache) throws OpenstackException {
		List<V> cached = useCache ? (List<V>) cachedLists.get(modelClass) : null;
		if (cached == null) {
			if (modelClass == Image.class) {
				cached = (List<V>) Lists.newArrayList(computeRoot().images().list());
			} else if (modelClass == Flavor.class) {
				cached = (List<V>) Lists.newArrayList(computeRoot().flavors().list(true));
			} else if (modelClass == Server.class) {
				cached = (List<V>) Lists.newArrayList(computeRoot().servers().list(true));
			} else if (modelClass == org.openstack.model.image.Image.class) {
				cached = (List<V>) Lists.newArrayList(session.getImageClient().root().images().list(true));
			} else if (modelClass == SecurityGroup.class) {
				cached = (List<V>) Lists.newArrayList(computeRoot().extension(SecurityGroupsResource.class).list().getList());
			} else {
				throw new IllegalArgumentException();
			}
			cachedLists.put(modelClass, cached);
		}
		return cached;
	}

	private TenantResource computeRoot() {
		return session.getComputeClient().root();
	}

	public Iterable<org.openstack.model.image.Image> getGlanceImages(boolean useCache) {
		return getCachedList(org.openstack.model.image.Image.class, useCache);
	}

	public void invalidateCache(Class<?> modelClass) {
		cachedLists.remove(modelClass);
	}

	public Iterable<SecurityGroup> getSecurityGroups(boolean useCache) {
		return getCachedList(SecurityGroup.class, useCache);
	}

}
