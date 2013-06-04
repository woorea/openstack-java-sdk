package com.woorea.openstack.console.keystone;

import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.woorea.openstack.console.utils.Column;
import com.woorea.openstack.console.utils.Table;
import com.woorea.openstack.console.utils.TableModel;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.User;

public class KeystoneUserCreate extends KeystoneCommand {
	
	public KeystoneUserCreate() {
		super("user-create");
	}

	@Override
	public void execute(Keystone keystone, CommandLine cmd) {
		
		User user = new User();
		user.setName(cmd.getOptionValue("name"));
		user.setPassword(cmd.getOptionValue("password"));
		user.setEmail(cmd.getOptionValue("email"));
		user.setTenantId(cmd.getOptionValue("tenant"));
		if(cmd.getOptionValue("enabled") != null) {
			user.setEnabled(Boolean.TRUE);
		}
		
		user = keystone.users().create(user).execute();
		
		Table t = new Table(new TableModel<User>(Arrays.asList(user)) {

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
