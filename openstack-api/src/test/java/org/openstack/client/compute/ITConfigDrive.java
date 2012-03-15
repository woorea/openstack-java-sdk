package org.openstack.client.compute;

import java.io.File;
import java.util.UUID;

import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaKeyPair;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.utils.Io;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ITConfigDrive extends ComputeApiTest {

	@Test
	public void testCreateAndDeleteServer() throws Exception {
		OpenstackComputeClient nova = getComputeClient();

		//Image image = getUecImage();
		NovaImage image = findImageByName("DebianSqueeze_20120226");
		if (image == null) {
			throw new SkipException("Cannot find image for test");
		}
		NovaFlavor bestFlavor = findSmallestFlavor();

		NovaServerForCreate serverForCreate = new NovaServerForCreate();
		serverForCreate.setName(random.randomAlphanumericString(10));
		serverForCreate.setFlavorRef(bestFlavor.getId());
		serverForCreate.setImageRef(image.getId());

		// TODO: We may require iso9660

		File homeDir = new File(System.getProperty("user.home"));
		File publicKeyFile = new File(homeDir, ".ssh" + File.separator + "id_rsa.pub");
		String publicKey = Io.readAll(publicKeyFile);
		publicKey = publicKey.replace("\r", "");
		publicKey = publicKey.replace("\n", "");
		publicKey = publicKey.replace("\t", " ");

		String keyName = random.randomAlphanumericString(10);

		NovaKeyPair keyPair = new NovaKeyPair();
		keyPair.setPublicKey(publicKey);
		keyPair.setName(keyName);

		nova.root().keyPairs().create(keyPair);

		serverForCreate.setKeyName(keyName);
		serverForCreate.setConfigDrive(true);

		NovaServer server = nova.root().servers().create(serverForCreate);

		// Wait for the server to be ready
		AsyncServerOperation async = AsyncServerOperation.wrapServerCreate(nova, server);
		NovaServer ready = async.get();

		Assert.assertEquals("ACTIVE", ready.getStatus());

		// Delete the server
		System.out.println("Deleting server: " + server);
		nova.root().servers().server(server.getId()).delete();
	}

}
