package org.openstack.client.compute;

import org.openstack.client.AbstractOpenStackTest;
import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.testng.SkipException;
import org.testng.annotations.Test;

@Test
public class ComputeApiTest extends AbstractOpenStackTest {
	public OpenstackComputeClient getComputeClient() throws OpenstackException {
		return context.session.getComputeClient();
	}

	protected Flavor findSmallestFlavor() {
		OpenstackComputeClient nova = getComputeClient();

		Flavor bestFlavor = null;
		for (Flavor flavor : nova.root().flavors().list()) {
			if (bestFlavor == null || bestFlavor.getRam() > flavor.getRam()) {
				bestFlavor = flavor;
			}
		}
		return bestFlavor;
	}

	protected Image findUecImage() {
		OpenstackComputeClient nova = getComputeClient();

		Iterable<Image> images = nova.root().images().list();
		for (Image i : images) {
			// Some UEC images
			if (i.getName().equals("lucid-server-cloudimg-amd64") || i.getName().equals("natty-server-cloudimg-amd64")) {
				return i;
			}
		}
		return null;
	}
	
	protected Image findImageByName(String name) {
		OpenstackComputeClient nova = getComputeClient();

		Iterable<Image> images = nova.root().images().list();
		for (Image i : images) {
			if (i.getName().equals(name)) {
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

}
