package org.openstack.client.compute;

import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.nova.NovaServerForCreate;
import org.openstack.model.compute.nova.keypair.NovaKeyPair;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ConfigDriveIT extends ComputeIntegrationTest {

	@Test
	public void testCreateAndDeleteServer() throws Exception {
		

		//Image image = getUecImage();
		//NovaImage image = findImageByName("DebianSqueeze_20120226");
		Image image = Iterables.find(compute.images().get().getList(), new Predicate<Image>() {

			@Override
			public boolean apply(Image image) {
				return "cirros-0.3.0-x86_64-uec".equals(image.getName());
			}
		});
		if (image == null) {
			throw new SkipException("Cannot find image for test");
		}
		Flavor bestFlavor = findSmallestFlavor();

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
		KeyPair keyPair = compute.keyPairs().post(new NovaKeyPair(random.randomAlphanumericString(5)));

		serverForCreate.setKeyName(keyPair.getName());
		serverForCreate.setConfigDrive(true);

		Server server = compute.servers().post(serverForCreate);

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
