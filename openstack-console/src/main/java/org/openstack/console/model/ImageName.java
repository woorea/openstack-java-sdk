package org.openstack.console.model;

import java.util.List;

import org.openstack.console.OpenstackCliContext;
import org.openstack.console.autocomplete.ImageNameAutoCompleter;
import org.openstack.console.common.StringWrapper;
import org.openstack.console.common.autocomplete.HasAutoCompletor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.exceptions.OpenstackException;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@HasAutoCompletor(ImageNameAutoCompleter.class)
public class ImageName extends StringWrapper {
	public ImageName(String key) {
		super(key);
	}

	public NovaImage findImage(OpenstackCliContext context) throws OpenstackException {
		List<NovaImage> matches = Lists.newArrayList();
		for (NovaImage image : context.getComputeClient().getPublicEndpoint().images().get().getList()) {
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
