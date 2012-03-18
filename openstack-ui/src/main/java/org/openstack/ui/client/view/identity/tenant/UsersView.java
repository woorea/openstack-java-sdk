package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeyStoneUser;
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
	}

	@UiField(provided = true)
	DataGrid<KeyStoneUser> grid = new DataGrid<KeyStoneUser>();

	private Presenter presenter;

	public UsersView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<KeyStoneUser, Boolean> checkboxColumn = new Column<KeyStoneUser, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(KeyStoneUser object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<KeyStoneUser> nameColumn = new TextColumn<KeyStoneUser>() {
			@Override
			public String getValue(KeyStoneUser object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<KeyStoneUser> descriptionColumn = new TextColumn<KeyStoneUser>() {
			@Override
			public String getValue(KeyStoneUser object) {
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

}
