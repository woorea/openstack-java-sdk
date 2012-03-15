package org.openstack.client.cli.model;

import java.util.List;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.autocomplete.ImageNameAutoCompleter;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.exceptions.OpenstackException;

import com.fathomdb.cli.StringWrapper;
import com.fathomdb.cli.autocomplete.HasAutoCompletor;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@HasAutoCompletor(ImageNameAutoCompleter.class)
public class ImageName extends StringWrapper {
	public ImageName(String key) {
		super(key);
	}

	public NovaImage findImage(OpenstackCliContext context) throws OpenstackException {
		List<NovaImage> matches = Lists.newArrayList();
		for (NovaImage image : context.getCache().getImages(true)) {
			if (Objects.equal(image.getName(), getKey())) {
				matches.add(image);
			} else if (Objects.equal(image.getId(), getKey())) {
				matches.add(image);
			}
		}

		if (matches.size() == 0)
			return null;

		if (matches.size() != 1) {
			throw new IllegalArgumentException("Image name is ambiguous");
		}

		return matches.get(0);
	}
}
