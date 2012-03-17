package org.openstack.client.identity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openstack.client.common.OpenStackSession;
import org.openstack.model.compute.NovaFlavor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;

public class ITAuthentication extends KeystoneIntegrationTest {

	/*
	 * Check that an OpenstackSession can be serialized and deserialized and still works!
	 */
	@Test
	public void testSerializable() throws Exception {
		OpenStackSession session = context.session;
		List<NovaFlavor> flavors1 = Lists.newArrayList(session.getComputeClient().root().flavors().list().getList());

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
		OpenStackSession session2 = (OpenStackSession) ois.readObject();
		ois.close();
		bais.close();

		// Check it still works
		List<NovaFlavor> flavors2 = Lists.newArrayList(session2.getComputeClient().root().flavors().list().getList());
		
		sortFlavors(flavors1);
		sortFlavors(flavors2);
		
		Assert.assertEquals(flavors1.size(), flavors2.size());
		for (int i = 0; i < flavors1.size(); i++) {
			NovaFlavor flavor1 = flavors1.get(i);
			NovaFlavor flavor2 = flavors2.get(i);
			
			Assert.assertEquals(flavor1.getId(), flavor2.getId());
		}
	}

	private void sortFlavors(List<NovaFlavor> list) {
		Collections.sort(list, new Comparator<NovaFlavor>() {
			@Override
			public int compare(NovaFlavor o1, NovaFlavor o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});

	}
}
