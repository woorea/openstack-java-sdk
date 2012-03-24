package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeystoneService;
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

public class ServicesView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, ServicesView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateService();

		void onDeleteService();
	}

	@UiField(provided = true)
	DataGrid<KeystoneService> grid = new DataGrid<KeystoneService>();

	private Presenter presenter;

	public ServicesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<KeystoneService, Boolean> checkboxColumn = new Column<KeystoneService, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(KeystoneService object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<KeystoneService> typeColumn = new TextColumn<KeystoneService>() {
			@Override
			public String getValue(KeystoneService object) {
				return object.getType();
			}
		};
		grid.setColumnWidth(typeColumn, "120px");
		grid.addColumn(typeColumn, "Type");
		TextColumn<KeystoneService> nameColumn = new TextColumn<KeystoneService>() {
			@Override
			public String getValue(KeystoneService object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<KeystoneService> descriptionColumn = new TextColumn<KeystoneService>() {
			@Override
			public String getValue(KeystoneService object) {
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
		presenter.onCreateService();
	}
	
	@UiHandler("delete")
	void onDeleteTenant(ClickEvent event) {
		presenter.onDeleteService();
	}

}
