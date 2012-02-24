package org.openstack.client.cli;

import org.kohsuke.args4j.CmdLineParser;
import org.openstack.client.cli.model.FlavorName;
import org.openstack.client.cli.model.GlanceImageName;
import org.openstack.client.cli.model.ImageName;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.client.cli.model.SecurityGroupName;

import com.fathomdb.cli.CliBase;
import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.CliHandler;
import com.fathomdb.cli.CliOptions;
import com.fathomdb.cli.StringWrapperOptionHandler;
import com.martiansoftware.nailgun.NGContext;

public class OpenstackCli extends CliBase {
	static class OpenstackCliHandler implements CliHandler {
		@Override
		public CliOptions buildOptionsBean() {
			return new ConfigurationOptions();
		}

		@Override
		public CliContext buildContext(CliOptions options) throws Exception {
			return new OpenstackCliContext((ConfigurationOptions) options);
		}
	}

	static {
		CmdLineParser.registerHandler(SecurityGroupName.class, StringWrapperOptionHandler.class);
		CmdLineParser.registerHandler(ImageName.class, StringWrapperOptionHandler.class);
		CmdLineParser.registerHandler(InstanceName.class, StringWrapperOptionHandler.class);
		CmdLineParser.registerHandler(FlavorName.class, StringWrapperOptionHandler.class);
		CmdLineParser.registerHandler(GlanceImageName.class, StringWrapperOptionHandler.class);

		init(new OpenstackCliHandler());
	}

	public static void main(String[] args) {
		CliBase.main(args);
	}

	public static void nailMain(NGContext nailgunContext) {
		CliBase.nailMain(nailgunContext);
	}

}
