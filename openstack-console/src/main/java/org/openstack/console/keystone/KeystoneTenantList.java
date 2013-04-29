package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.utils.Column;
import org.openstack.console.utils.Table;
import org.openstack.console.utils.TableModel;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.model.Tenant;
import org.openstack.keystone.model.Tenants;

public class KeystoneTenantList extends KeystoneCommand {
	
	public KeystoneTenantList() {
		super("tenant-list");
	}

	@Override
	public void execute(KeystoneClient keystone, CommandLine args) {
		
		final Tenants tenants = keystone.tenants().list().execute();
		
		Table t = new Table(new TableModel<Tenant>(tenants.getList()) {

			@Override
			public Column[] getHeaders() {
				return new Column[]{
					new Column("id", 32, Column.ALIGN_LEFT),
					new Column("name", 32, Column.ALIGN_LEFT),
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

}
