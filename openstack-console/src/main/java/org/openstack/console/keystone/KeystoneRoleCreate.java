package org.openstack.console.keystone;

import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.openstack.console.utils.Column;
import org.openstack.console.utils.Table;
import org.openstack.console.utils.TableModel;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.model.Role;

public class KeystoneRoleCreate extends KeystoneCommand {
	
	public KeystoneRoleCreate() {
		super( "role-create");
	}

	@Override
	public void execute(Keystone keystone, CommandLine cmd) {
		
		Role role = new Role();
		role.setName(cmd.getOptionValue("name"));
		role.setDescription(cmd.getOptionValue("description"));
		if(cmd.getOptionValue("enabled") != null) {
			role.setEnabled("True");
		}
		
		role = keystone.roles().create(role).execute();
		
		Table t = new Table(new TableModel<Role>(Arrays.asList(role)) {

			@Override
			public Column[] getHeaders() {
				return new Column[]{
					new Column("id", 32, Column.ALIGN_LEFT),
					new Column("name", 10, Column.ALIGN_LEFT),
					new Column("description", 32, Column.ALIGN_LEFT),
					new Column("enabled", 7, Column.ALIGN_LEFT)
				};
			}

			@Override
			public String[] getRow(Role tenant) {
				return new String[]{
					tenant.getId(),
					tenant.getName(),
					tenant.getDescription(),
					tenant.getEnabled().toString()
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
		opts.addOption(null, "name", true, "tenant name");
		opts.addOption(null, "description", true, "tenant description");
		opts.addOption(null, "enabled", false, "enabled");
		return opts;
	}
	
}
