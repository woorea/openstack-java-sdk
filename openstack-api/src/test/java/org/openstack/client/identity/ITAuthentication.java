package org.openstack.client.identity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openstack.client.common.OpenstackSession;
import org.openstack.model.compute.Flavor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;

public class ITAuthentication extends KeystoneIntegrationTest {

	/*
	 * Check that an OpenstackSession can be serialized and deserialized and still works!
	 */
	@Test
	public void testSerializable() throws Exception {
		OpenstackSession session = context.session;
		List<Flavor> flavors1 = Lists.newArrayList(session.getComputeClient().root().flavors().list());

		// Serialize it
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(session);
		oos.close();
		baos.close();

		// This is about 1500 bytes when I tried it.
		// The bulk of the size is all those links to the services.
		// However, the URLs do vary per-user, so I don't think this can easily be cut
		System.out.println("BYTE SIZE OF SERIALIZED SESSION: " + baos.toByteArray().length);

		// Deserialize it
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		OpenstackSession session2 = (OpenstackSession) ois.readObject();
		ois.close();
		bais.close();

		// Check it still works
		List<Flavor> flavors2 = Lists.newArrayList(session2.getComputeClient().root().flavors().list());
		
		sortFlavors(flavors1);
		sortFlavors(flavors2);
		
		Assert.assertEquals(flavors1.size(), flavors2.size());
		for (int i = 0; i < flavors1.size(); i++) {
			Flavor flavor1 = flavors1.get(i);
			Flavor flavor2 = flavors2.get(i);
			
			Assert.assertEquals(flavor1.getId(), flavor2.getId());
		}
	}

	private void sortFlavors(List<Flavor> list) {
		Collections.sort(list, new Comparator<Flavor>() {
			@Override
			public int compare(Flavor o1, Flavor o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});

	}
}
