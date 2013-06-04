package com.woorea.openstack.console.keystone;

import java.util.Arrays;

import org.apache.commons.cli.CommandLine;

import com.woorea.openstack.console.utils.Column;
import com.woorea.openstack.console.utils.Table;
import com.woorea.openstack.console.utils.TableModel;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.User;

public class KeystoneUserShow extends KeystoneCommand {
	
	public KeystoneUserShow() {
		super("user-show");
	}

	@Override
	public void execute(Keystone keystone, CommandLine cmd) {
		
		String[] args = cmd.getArgs();
		if(args.length == 1) {
			User user = keystone.users().show(args[0]).execute();
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
	}

}
