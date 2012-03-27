package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.User;

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
	DataGrid<User> grid = new DataGrid<User>();

	private Presenter presenter;

	public UsersView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<User, Boolean> checkboxColumn = new Column<User, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(User object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<User> nameColumn = new TextColumn<User>() {
			@Override
			public String getValue(User object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<User> descriptionColumn = new TextColumn<User>() {
			@Override
			public String getValue(User object) {
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
