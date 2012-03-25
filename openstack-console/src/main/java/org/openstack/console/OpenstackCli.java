package org.openstack.console;

import org.kohsuke.args4j.CmdLineParser;
import org.openstack.console.common.CliBase;
import org.openstack.console.common.CliContext;
import org.openstack.console.common.CliHandler;
import org.openstack.console.common.CliOptions;
import org.openstack.console.common.StringWrapperOptionHandler;
import org.openstack.console.model.ContainerName;
import org.openstack.console.model.FlavorName;
import org.openstack.console.model.GlanceImageName;
import org.openstack.console.model.ImageName;
import org.openstack.console.model.InstanceName;
import org.openstack.console.model.SecurityGroupName;
import org.openstack.console.model.StoragePath;


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

		CmdLineParser.registerHandler(ContainerName.class, StringWrapperOptionHandler.class);
		CmdLineParser.registerHandler(StoragePath.class, StringWrapperOptionHandler.class);

		init(new OpenstackCliHandler());
	}

	public static void main(String[] args) {
		CliBase.main(args);
	}

}
