package org.openstack.model.common;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneService;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class OpenStackSessionData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected KeystoneAccess access;
	
	public OpenStackSessionData() {
		
	}
	
	public OpenStackSessionData(KeystoneAccess access) {
		this.access = access;
	}
	
	public KeystoneAccess getAccess() {
		return access;
	}
	
	public void setAccess(KeystoneAccess access) {
		this.access = access;
	}

	
	
	public boolean isAuthenticated() {
		return access != null;
	}
	
	
	public String getBestEndpoint(String serviceType) throws OpenstackException {
		List<KeystoneService> foundServices = Lists.newArrayList();
		Set<String> serviceTypes = Sets.newHashSet();
		for (KeystoneService service : access.getServices()) {
			serviceTypes.add(service.getType());

			if (serviceType.equals(service.getType())) {
				foundServices.add(service);
			}
		}

		if (foundServices.isEmpty()) {
			throw new OpenstackException("Cannot find service: " + serviceType + ".  Available services: "
					+ Joiner.on(",").join(serviceTypes));
		}

		KeystoneService service;
		if (foundServices.size() != 1) {
			System.out.println("Found multiple services of type: " + serviceType + ".  Found: "
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

	private KeystoneService pickBest(List<KeystoneService> services) {
		Function<KeystoneService, Float> scoreFunction = new Function<KeystoneService, Float>() {
			@Override
			public Float apply(KeystoneService s) {
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
		KeystoneService best = null;
		for (KeystoneService candidate : services) {
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
