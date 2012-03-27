package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.Tenant;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TenantsView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, TenantsView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateTenant();

		void onDeleteTenant();
	}

	@UiField(provided = true)
	DataGrid<Tenant> grid = new DataGrid<Tenant>();

	private Presenter presenter;

	public TenantsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<Tenant, Boolean> checkboxColumn = new Column<Tenant, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(Tenant object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<Tenant> nameColumn = new TextColumn<Tenant>() {
			@Override
			public String getValue(Tenant object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<Tenant> descriptionColumn = new TextColumn<Tenant>() {
			@Override
			public String getValue(Tenant object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(descriptionColumn, "120px");
		grid.addColumn(descriptionColumn, "Description");
		TextColumn<Tenant> enabledColumn = new TextColumn<Tenant>() {
			@Override
			public String getValue(Tenant object) {
				return object.isEnabled() ? "ENABLED" : "DISABLED";
			}
		};
		grid.setColumnWidth(enabledColumn, "120px");
		grid.addColumn(enabledColumn, "STATUS");
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("create")
	void onCreateServer(ClickEvent event) {
		presenter.onCreateTenant();
	}
	
	@UiHandler("delete")
	void onDeleteTenant(ClickEvent event) {
		presenter.onDeleteTenant();
	}

	@UiHandler("refresh")
	void onRefresh(ClickEvent event) {
		presenter.refresh();
	}

}
