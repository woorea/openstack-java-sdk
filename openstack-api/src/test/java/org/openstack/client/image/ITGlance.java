package org.openstack.client.image;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestException;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.utils.RandomDataInputStream;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.openstack.model.image.GlanceImage;
import org.openstack.model.image.GlanceImageProperties;
import org.openstack.utils.Md5Hash;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;

public class ITGlance extends GlanceIntegrationTest {

	@Test
	public void testListImagesAndDetails() throws OpenstackException {
		skipIfNoGlance();

		OpenstackImageClient glance = getImageClient();
		List<GlanceImage> images = Lists.newArrayList(glance.root().images().list());

		for (GlanceImage image : images) {
			GlanceImage details = glance.root().images().image(image.getId()).show();

			assertImageEquals(details, image);
		}
	}

	private void assertImageEquals(GlanceImage actual, GlanceImage expected) {
		assertEquals(actual.getId(), expected.getId());
		assertEquals(actual.getChecksum(), expected.getChecksum());
		assertEquals(actual.getContainerFormat(), expected.getContainerFormat());
		assertEquals(actual.getCreatedAt(), expected.getCreatedAt());
		assertEquals(actual.getDeletedAt(), expected.getDeletedAt());
		assertEquals(actual.getDiskFormat(), expected.getDiskFormat());
		assertEquals(actual.getMinDisk(), expected.getMinDisk());
		assertEquals(actual.getMinRam(), expected.getMinRam());
		assertEquals(actual.getName(), expected.getName());
		assertEquals(actual.getOwner(), expected.getOwner());
		assertEquals(actual.getSize(), expected.getSize());
		assertEquals(actual.getStatus(), expected.getStatus());

		assertPropertiesEquals(actual.getProperties(), expected.getProperties());
	}

	// Heap size problems should be fixed now!
	static final int MAX_LENGTH = 16 * 1024 * 1024;

	@Test
	public void testImageUploadAndDelete() throws Exception {
		skipIfNoGlance();

		OpenstackImageClient glance = getImageClient();

		String containerFormat = "bare";
		String diskFormat = "raw";

		int imageLength = random.uniform(1, MAX_LENGTH);
		long seed = random.nextLong();

		RandomDataInputStream stream = new RandomDataInputStream(imageLength, seed);

		GlanceImage template = new GlanceImage();
		template.setName(random.randomAlphanumericString(1, 64).trim());
		template.setDiskFormat(diskFormat );
		template.setContainerFormat(containerFormat);

		GlanceImage uploaded = glance.root().images().addImage(stream, imageLength, template);
		assertEquals(uploaded.getSize(), Long.valueOf(imageLength));
		assertEquals(uploaded.getName(), template.getName());
		assertNull(uploaded.getDeletedAt());
		assertNotNull(uploaded.getCreatedAt());
		assertNotNull(uploaded.getUpdatedAt());
		assertNotNull(uploaded.getId());
		assertEquals(uploaded.isDeleted(), Boolean.FALSE);
		assertEquals(uploaded.getDiskFormat(), diskFormat);
		assertEquals(uploaded.getContainerFormat(), containerFormat);
		assertNotNull(uploaded.getOwner());
		assertEquals(uploaded.getStatus(), "active");

		{
			Md5Hash md5 = new Md5Hash();
			byte[] hash = md5.hash(stream.clone());
			assertEquals(uploaded.getChecksum(), Hex.encodeHexString(hash));
		}

		List<GlanceImage> allImages = Lists.newArrayList(glance.root().images().list());

		GlanceImage foundInAll = findImageById(allImages, uploaded.getId());
		assertNotNull(foundInAll);
		assertImageEquals(foundInAll, uploaded);

		GlanceImage details = glance.root().images().image(uploaded.getId()).show();
		assertImageEquals(details, uploaded);

		{
			InputStream is = glance.root().images().image(uploaded.getId()).openStream();
			assertStreamsTheSame(is, stream.clone());
			is.close();
		}

		glance.root().images().image(uploaded.getId()).delete();

		for (int i = 0; i < 60; i++) {
			// Wait for up to 60 seconds for the image to be deleted
			allImages = Lists.newArrayList(glance.root().images().list());
			foundInAll = findImageById(allImages, uploaded.getId());
			if (foundInAll == null)
				break;
			Thread.sleep(1000);
		}

		assertNull(foundInAll);

		try {
			glance.root().images().image(uploaded.getId()).show();
			Assert.fail();
		} catch (OpenstackNotFoundException e) {
			// Expected!
		}
	}

	@Test(expectedExceptions= { OpenstackException.class, SkipException.class} )
	public void testNullFormatsFails() throws Exception {
		skipIfNoGlance();

		// https://bugs.launchpad.net/glance/+bug/933702
		// The patch for this landed about Feb 23, 2012
		skipUntilBugFixed(933702);

		OpenstackImageClient glance = getImageClient();

		int imageLength = 128;
		long seed = random.nextLong();

		RandomDataInputStream stream = new RandomDataInputStream(imageLength, seed);

		GlanceImage template = new GlanceImage();
		template.setName(random.randomAlphanumericString(1, 64).trim());

		GlanceImage uploaded = glance.root().images().addImage(stream, imageLength, template);
		assertNull(uploaded.getDiskFormat());
		assertNull(uploaded.getContainerFormat());
	}

	@Test
	public void testNullNameFails() throws Exception {
		skipIfNoGlance();

		// It's not clear whether a null name is supposed to fail or not
		// https://bugs.launchpad.net/glance/+bug/934492
		skipUntilBugFixed(934492);

		OpenstackImageClient glance = getImageClient();

		int imageLength = 128;
		long seed = random.nextLong();

		RandomDataInputStream stream = new RandomDataInputStream(imageLength, seed);

		GlanceImage template = new GlanceImage();

		GlanceImage uploaded = glance.root().images().addImage(stream, imageLength, template);
		System.out.println(uploaded);
		Assert.fail("Image upload without a name should fail");
	}

	private GlanceImage findImageById(List<GlanceImage> images, String id) {
		for (GlanceImage image : images) {
			if (id.equals(image.getId()))
				return image;
		}
		return null;
	}

	private void assertPropertiesEquals(GlanceImageProperties actual, GlanceImageProperties expected) {
		Map<String, Object> actualMap = actual.asMap();
		Map<String, Object> expectedMap = expected.asMap();

		assertEquals(actualMap, expectedMap);
	}
}
