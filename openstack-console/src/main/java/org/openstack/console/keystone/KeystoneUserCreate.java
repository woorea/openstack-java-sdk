package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.openstack.console.utils.Column;
import org.openstack.console.utils.Table;
import org.openstack.console.utils.TableModel;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.CreateUser;
import org.openstack.keystone.model.User;

import com.google.common.collect.Lists;

public class KeystoneUserCreate extends KeystoneCommand {
	
	public KeystoneUserCreate(KeystoneClient client) {
		super("user-create");
	}

	@Override
	public void execute(KeystoneClient keystone, CommandLine cmd) {
		
		User user = new User();
		user.setName(cmd.getOptionValue("name"));
		user.setPassword(cmd.getOptionValue("password"));
		user.setEmail(cmd.getOptionValue("email"));
		user.setTenantId(cmd.getOptionValue("tenant"));
		if(cmd.getOptionValue("enabled") != null) {
			user.setEnabled(Boolean.TRUE);
		}
		
		user = keystone.execute(new CreateUser(user));
		
		Table t = new Table(new TableModel<User>(Lists.newArrayList(user)) {

			@Override
			public Column[] getHeaders() {
				return new Column[]{
					new Column("id", 32, Column.ALIGN_LEFT),
					new Column("name", 10, Column.ALIGN_LEFT),
					new Column("email", 22, Column.ALIGN_LEFT),
					new Column("tenant", 32, Column.ALIGN_LEFT),
					new Column("enabled", 7, Column.ALIGN_LEFT)
				};
			}

			@Override
			public String[] getRow(User user) {
				return new String[]{
					user.getId(),
					user.getName(),
					user.getEmail(),
					user.getTenantId(),
					user.getEnabled().toString()
				};
			}
		});
		System.out.println(t.render());
	}

	/* (non-Javadoc)
	 * @see com.billingstack.commands.Command#getOptions()
	 */
	@Override
	public Options getOptions() {
		Options opts = super.getOptions();
		opts.addOption(null, "name", true, "user name");
		opts.addOption(null, "password", true, "user password");
		opts.addOption(null, "email", true, "user email");
		opts.addOption(null, "tenant", true, "tenant id");
		opts.addOption(null, "enabled", false, "enabled");
		return opts;
	}
	
}
