package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeystoneRole;

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

public class RolesView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, RolesView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateRole();

		void onDeleteRole();
	}

	@UiField(provided = true)
	DataGrid<KeystoneRole> grid = new DataGrid<KeystoneRole>();

	private Presenter presenter;

	public RolesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<KeystoneRole, Boolean> checkboxColumn = new Column<KeystoneRole, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(KeystoneRole object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<KeystoneRole> nameColumn = new TextColumn<KeystoneRole>() {
			@Override
			public String getValue(KeystoneRole object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<KeystoneRole> descriptionColumn = new TextColumn<KeystoneRole>() {
			@Override
			public String getValue(KeystoneRole object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(descriptionColumn, "120px");
		grid.addColumn(descriptionColumn, "Description");
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("refresh")
	void onRefresh(ClickEvent event) {
		presenter.refresh();
	}
	
	@UiHandler("create")
	void onCreateServer(ClickEvent event) {
		presenter.onCreateRole();
	}
	
	@UiHandler("delete")
	void onDeleteTenant(ClickEvent event) {
		presenter.onDeleteRole();
	}

}
