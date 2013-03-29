package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.Console;
import org.openstack.console.utils.Column;
import org.openstack.console.utils.Table;
import org.openstack.console.utils.TableModel;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.ShowUser;
import org.openstack.keystone.model.User;

import com.google.common.collect.Lists;

public class KeystoneUserShow extends KeystoneCommand {
	
	public KeystoneUserShow(KeystoneClient client) {
		super(client, "user-show");
	}

	@Override
	public void execute(Console console, CommandLine cmd) {
		
		String[] args = cmd.getArgs();
		if(args.length == 1) {
			User user = keystone.execute(new ShowUser(args[0]));
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
	}

}
