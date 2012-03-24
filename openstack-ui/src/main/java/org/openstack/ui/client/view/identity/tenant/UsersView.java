package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeystoneUser;
import org.openstack.ui.client.view.compute.LogoCell;

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

public class UsersView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, UsersView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateUser();

		void onDeleteUser();
	}

	@UiField(provided = true)
	DataGrid<KeystoneUser> grid = new DataGrid<KeystoneUser>();

	private Presenter presenter;

	public UsersView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<KeystoneUser, Boolean> checkboxColumn = new Column<KeystoneUser, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(KeystoneUser object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<KeystoneUser> nameColumn = new TextColumn<KeystoneUser>() {
			@Override
			public String getValue(KeystoneUser object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<KeystoneUser> descriptionColumn = new TextColumn<KeystoneUser>() {
			@Override
			public String getValue(KeystoneUser object) {
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
		presenter.onCreateUser();
	}
	
	@UiHandler("delete")
	void onDeleteTenant(ClickEvent event) {
		presenter.onDeleteUser();
	}

}
