package org.openstack.client.compute;

import java.util.HashMap;
import java.util.List;

import org.openstack.api.compute.ComputeResource;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.client.OpenStackComputeClient;
import org.openstack.model.common.Extension;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.SkipException;
import org.testng.annotations.Test;

@Test
public class ComputeApiTest extends AbstractOpenStackTest {
	
	protected ComputeResource compute;
	
	public OpenStackComputeClient getComputeClient() throws OpenstackException {
		return context.session.getComputeClient();
	}

	protected NovaFlavor findSmallestFlavor() {
		OpenStackComputeClient nova = getComputeClient();

		NovaFlavor bestFlavor = null;
		for (NovaFlavor flavor : nova.root().flavors().get(new HashMap<String, Object>()).getList()) {
			if (bestFlavor == null || bestFlavor.getRam() > flavor.getRam()) {
				bestFlavor = flavor;
			}
		}
		return bestFlavor;
	}

	protected NovaImage findUecImage() {
		OpenStackComputeClient nova = getComputeClient();

		Iterable<NovaImage> images = nova.root().images().get(new HashMap<String, Object>()).getList();
		for (NovaImage i : images) {
			// Some UEC images
			if (i.getName().equals("lucid-server-cloudimg-amd64") || i.getName().equals("natty-server-cloudimg-amd64")) {
				return i;
			}
		}
		return null;
	}

	protected NovaImage findImageByName(String name) {
		OpenStackComputeClient nova = getComputeClient();

		Iterable<NovaImage> images = nova.root().images().get(new HashMap<String, Object>()).getList();
		for (NovaImage i : images) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}

	protected NovaImage getUecImage() {
		NovaImage image = findUecImage();
		if (image == null) {
			throw new SkipException("Skipping test because image not found");
		}

		System.out.println("Using image: " + image);

		return image;
	}

	protected void skipIfNoSecurityGroups() {
		if (!supportsSecurityGroups())
			throw new SkipException("Security group support not found");
	}

	protected void skipIfNoKeyPairs() {
		if (!supportsPublicKeys()) {
			throw new SkipException("KeyPair support not found");
		}
	}

	public boolean supportsPublicKeys() {
		return supportsExtension("http://docs.openstack.org/ext/keypairs/api/v1.1") || supportsExtension("http://docs.openstack.org/compute/ext/keypairs/api/v1.1");
	}

	public boolean supportsSecurityGroups() {
		return supportsExtension("http://docs.openstack.org/ext/securitygroups/api/v1.1") || supportsExtension("http://docs.openstack.org/compute/ext/securitygroups/api/v1.1");
	}

	List<Extension> extensions;

	private boolean supportsExtension(String namespace) {
		if (extensions == null) {
			extensions = getComputeClient().root().extensions().get(new HashMap<String, Object>()).getList();
		}
		for (Extension extension : extensions) {
			if (namespace.equals(extension.getNamespace()))
				return true;
		}
		return false;
	}
}
