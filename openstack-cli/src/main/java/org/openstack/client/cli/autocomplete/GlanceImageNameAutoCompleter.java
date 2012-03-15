package org.openstack.client.cli.autocomplete;

import java.util.List;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.model.image.GlanceImage;

import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.autocomplete.SimpleArgumentAutoCompleter;
import com.google.common.collect.Lists;

public class GlanceImageNameAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext context, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext osContext = (OpenstackCliContext) context;
		for (GlanceImage image : osContext.getCache().getGlanceImages(true)) {
			strings.add(image.getName());
		}

		addSuffix(strings, " ");

		return strings;
	}

}
