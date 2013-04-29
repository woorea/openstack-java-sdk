package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.openstack.console.utils.Column;
import org.openstack.console.utils.Table;
import org.openstack.console.utils.TableModel;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.model.Tenant;

import com.google.common.collect.Lists;

public class KeystoneTenantCreate extends KeystoneCommand {
	
	public KeystoneTenantCreate() {
		super("tenant-create");
	}

	@Override
	public void execute(KeystoneClient keystone, CommandLine cmd) {
		
		Tenant tenant = new Tenant();
		tenant.setName(cmd.getOptionValue("name"));
		tenant.setDescription(cmd.getOptionValue("description"));
		if(cmd.getOptionValue("enabled") != null) {
			tenant.setEnabled(Boolean.TRUE);
		}
		
		tenant = keystone.tenants().create(tenant).execute();
		
		Table t = new Table(new TableModel<Tenant>(Lists.newArrayList(tenant)) {

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
			public String[] getRow(Tenant tenant) {
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
