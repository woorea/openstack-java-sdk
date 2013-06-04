package com.woorea.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;

import com.woorea.openstack.console.utils.Column;
import com.woorea.openstack.console.utils.Table;
import com.woorea.openstack.console.utils.TableModel;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Service;
import com.woorea.openstack.keystone.model.Services;

public class KeystoneServiceList extends KeystoneCommand {
	
	public KeystoneServiceList() {
		super("service-list");
	}

	@Override
	public void execute(Keystone keystone, CommandLine cmd) {
		
		final Services services = keystone.services().list().execute();
		
		Table t = new Table(new TableModel<Service>(services.getList()) {

			@Override
			public Column[] getHeaders() {
				return new Column[]{
					new Column("id", 32, Column.ALIGN_LEFT),
					new Column("type", 10, Column.ALIGN_LEFT),
					new Column("name", 10, Column.ALIGN_LEFT),
					new Column("description", 32, Column.ALIGN_LEFT)
				};
			}

			@Override
			public String[] getRow(Service service) {
				return new String[]{
					service.getId(),
					service.getType(),
					service.getName(),
					service.getDescription()
				};
			}
		});
		System.out.println(t.render());
	}

}
