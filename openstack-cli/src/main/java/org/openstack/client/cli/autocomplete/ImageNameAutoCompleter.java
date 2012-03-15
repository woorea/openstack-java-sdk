package org.openstack.client.cli.autocomplete;

import java.util.List;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.model.compute.NovaImage;

import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.autocomplete.SimpleArgumentAutoCompleter;
import com.google.common.collect.Lists;

public class ImageNameAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext context, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext osContext = (OpenstackCliContext) context;
		for (NovaImage image : osContext.getCache().getImages(true)) {
			strings.add(image.getName());
			strings.add(image.getId());
		}

		addSuffix(strings, " ");

		return strings;
	}
}
