package org.openstack.client.compute;

import javax.ws.rs.client.Entity;

import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaKeyPair;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ITConfigDrive extends ComputeIntegrationTest {

	@Test
	public void testCreateAndDeleteServer() throws Exception {
		

		//Image image = getUecImage();
		//NovaImage image = findImageByName("DebianSqueeze_20120226");
		NovaImage image = Iterables.find(compute.images().get().getList(), new Predicate<NovaImage>() {

			@Override
			public boolean apply(NovaImage image) {
				return "cirros-0.3.0-x86_64-blank".equals(image.getName());
			}
		});
		if (image == null) {
			throw new SkipException("Cannot find image for test");
		}
		NovaFlavor bestFlavor = findSmallestFlavor();

		NovaServerForCreate serverForCreate = new NovaServerForCreate();
		serverForCreate.setName(random.randomAlphanumericString(10));
		serverForCreate.setFlavorRef(bestFlavor.getId());
		serverForCreate.setImageRef(image.getId());

		// TODO: We may require iso9660
		/*
		File homeDir = new File(System.getProperty("user.home"));
		File publicKeyFile = new File(homeDir, ".ssh" + File.separator + "id_rsa.pub");
		String publicKey = FileUtils.readFileToString(publicKeyFile);
		publicKey = publicKey.replace("\r", "");
		publicKey = publicKey.replace("\n", "");
		publicKey = publicKey.replace("\t", " ");

		String keyName = random.randomAlphanumericString(10);

		NovaKeyPair keyPair = new NovaKeyPair();
		keyPair.setPublicKey(publicKey);
		keyPair.setName(keyName);
		

		compute.keyPairs().post(new HashMap<String, Object>(), Entity.json(keyPair));
		*/
		NovaKeyPair keyPair = compute.keyPairs().post(Entity.json(new NovaKeyPair("test")));

		serverForCreate.setKeyName(keyPair.getName());
		serverForCreate.setConfigDrive(true);

		NovaServer server = compute.servers().post(Entity.json(serverForCreate));

		// Wait for the server to be ready
		// AsyncServerOperation async = AsyncServerOperation.wrapServerCreate(client.compute(), server);
		// NovaServer ready = async.get();

		// Assert.assertEquals("ACTIVE", ready.getStatus());

		// Delete the server
		System.out.println("Deleting server: " + server);
		compute.servers().server(server.getId()).delete();
		compute.keyPairs().keypair("test").delete();
	}

}
