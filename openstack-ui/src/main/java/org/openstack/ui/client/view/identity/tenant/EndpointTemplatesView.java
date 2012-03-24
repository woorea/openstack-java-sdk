package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeystoneEndpointTemplates;

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

public class EndpointTemplatesView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, EndpointTemplatesView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateEndpointTemplates();

		void onDeleteEndpointTemplates();
	}

	@UiField(provided = true)
	DataGrid<KeystoneEndpointTemplates> grid = new DataGrid<KeystoneEndpointTemplates>();

	private Presenter presenter;

	public EndpointTemplatesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<KeystoneEndpointTemplates, Boolean> checkboxColumn = new Column<KeystoneEndpointTemplates, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(KeystoneEndpointTemplates object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<KeystoneEndpointTemplates> typeColumn = new TextColumn<KeystoneEndpointTemplates>() {
			@Override
			public String getValue(KeystoneEndpointTemplates object) {
				return object.getType();
			}
		};
		grid.setColumnWidth(typeColumn, "120px");
		grid.addColumn(typeColumn, "Type");
		TextColumn<KeystoneEndpointTemplates> nameColumn = new TextColumn<KeystoneEndpointTemplates>() {
			@Override
			public String getValue(KeystoneEndpointTemplates object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<KeystoneEndpointTemplates> descriptionColumn = new TextColumn<KeystoneEndpointTemplates>() {
			@Override
			public String getValue(KeystoneEndpointTemplates object) {
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
		presenter.onCreateEndpointTemplates();
	}
	
	@UiHandler("delete")
	void onDeleteTenant(ClickEvent event) {
		presenter.onDeleteEndpointTemplates();
	}

}
