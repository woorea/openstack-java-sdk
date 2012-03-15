package org.openstack.model.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.openstack.client.common.OpenStackSession;
import org.openstack.client.common.OpenstackCredentials;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneService;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class OpenStackSessionData implements Serializable {
	
	static final Logger log = Logger.getLogger(OpenStackSessionData.class.getName());

	protected final Map<Object, Object> extensions = Maps.newHashMap();
	
	protected KeyStoneAccess access;
	
	
	
	public OpenStackSessionData() {
		
	}
	
	public OpenStackSessionData(KeyStoneAccess access) {
		this.access = access;
	}
	
	public KeyStoneAccess getAccess() {
		return access;
	}
	
	public void setAccess(KeyStoneAccess access) {
		this.access = access;
	}

	
	
	public boolean isAuthenticated() {
		return access != null;
	}
	

	public Map<Object, Object> getExtensions() {
		return extensions;
	}
	
	public String getBestEndpoint(String serviceType) throws OpenstackException {
		List<KeyStoneService> foundServices = Lists.newArrayList();
		Set<String> serviceTypes = Sets.newHashSet();
		for (KeyStoneService service : access.getServiceCatalog()) {
			serviceTypes.add(service.getType());

			if (serviceType.equals(service.getType())) {
				foundServices.add(service);
			}
		}

		if (foundServices.isEmpty()) {
			throw new OpenstackException("Cannot find service: " + serviceType + ".  Available services: "
					+ Joiner.on(",").join(serviceTypes));
		}

		KeyStoneService service;
		if (foundServices.size() != 1) {
			log.fine("Found multiple services of type: " + serviceType + ".  Found: "
					+ Joiner.on(',').join(foundServices));
			service = pickBest(foundServices);
		} else {
			service = foundServices.get(0);
		}

		if (service.getEndpoints().size() != 1) {
			throw new OpenstackException("Unhandled number of endpoints");
		}

		String bestUrl = service.getEndpoints().get(0).getPublicURL();

		if (bestUrl == null) {
			throw new OpenstackException("Cannot find endpoint URL for image service");
		}

		return bestUrl;
	}

	private KeyStoneService pickBest(List<KeyStoneService> services) {
		Function<KeyStoneService, Float> scoreFunction = new Function<KeyStoneService, Float>() {
			@Override
			public Float apply(KeyStoneService s) {
				float score = 0;
				if (s.getName().endsWith("OpenStack")) {
					score += 10;
				}
				if (s.getName().endsWith("CDN")) {
					score -= 10;
				}
				return score;
			}
		};

		Float bestScore = null;
		KeyStoneService best = null;
		for (KeyStoneService candidate : services) {
			Float score = scoreFunction.apply(candidate);
			if (bestScore == null || bestScore.floatValue() < score.floatValue()) {
				bestScore = score;
				best = candidate;
			} else if (bestScore.floatValue() == score.floatValue()) {
				throw new IllegalArgumentException("Cannot choose between candidates: " + best + " vs " + candidate);
			}
		}

		return best;
	}

}
