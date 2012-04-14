package org.openstack.client.compute;

import java.util.List;

import org.openstack.api.compute.TenantResource;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.model.common.Extension;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

public abstract class ComputeIntegrationTest extends AbstractOpenStackTest {
	
	protected TenantResource compute;
	
	@BeforeClass
	public void init() {
		init("etc/openstack.public.properties");
		compute = client.getComputeEndpoint();
	}

	protected Flavor findSmallestFlavor() {
		Flavor bestFlavor = null;
		for (Flavor flavor : compute.flavors().get().getList()) {
			if (bestFlavor == null || bestFlavor.getRam() > flavor.getRam()) {
				bestFlavor = flavor;
			}
		}
		return bestFlavor;
	}

	protected Image findUecImage() {
		for (Image i : compute.images().get().getList()) {
			// Some UEC images
			if (i.getName().equals("lucid-server-cloudimg-amd64") || i.getName().equals("natty-server-cloudimg-amd64")) {
				return i;
			}
		}
		return null;
	}

	

	protected Image getUecImage() {
		Image image = findUecImage();
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
			extensions = compute.extensions().get().getList();
		}
		for (Extension extension : extensions) {
			if (namespace.equals(extension.getNamespace()))
				return true;
		}
		return false;
	}
	
}
