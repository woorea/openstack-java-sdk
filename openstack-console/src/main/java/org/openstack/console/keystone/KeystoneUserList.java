package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.utils.Column;
import org.openstack.console.utils.Table;
import org.openstack.console.utils.TableModel;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.model.User;
import org.openstack.keystone.model.Users;

public class KeystoneUserList extends KeystoneCommand {
	
	public KeystoneUserList() {
		super("user-list");
	}

	@Override
	public void execute(KeystoneClient keystone, CommandLine cmd) {
		
		final Users users = keystone.users().list().execute();
		
		Table t = new Table(new TableModel<User>(users.getList()) {

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

}
