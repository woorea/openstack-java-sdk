package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.Service;

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

public class EndpointsView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, EndpointsView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateEndpointTemplates();

		void onDeleteEndpointTemplates();
	}

	@UiField(provided = true)
	DataGrid<Endpoint> grid = new DataGrid<Endpoint>();

	private Presenter presenter;

	public EndpointsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<Endpoint, Boolean> checkboxColumn = new Column<Endpoint, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(Endpoint object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "30px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<Endpoint> typeColumn = new TextColumn<Endpoint>() {
			@Override
			public String getValue(Endpoint object) {
				return ""; //object.getType();
			}
		};
		/*
		TextColumn<Endpoint> idColumn = new TextColumn<Endpoint>() {
			@Override
			public String getValue(Endpoint object) {
				return object.getId();
			}
		};
		grid.setColumnWidth(idColumn, "120px");
		grid.addColumn(idColumn, "Id");
		*/
		TextColumn<Endpoint> serviceIdColumn = new TextColumn<Endpoint>() {
			@Override
			public String getValue(Endpoint object) {
				return object.getServiceId();
			}
		};
		grid.setColumnWidth(serviceIdColumn, "120px");
		grid.addColumn(serviceIdColumn, "Service Id");
		
		TextColumn<Endpoint> regionColumn = new TextColumn<Endpoint>() {
			@Override
			public String getValue(Endpoint object) {
				return ""; //object.getName();
			}
		};
		grid.setColumnWidth(regionColumn, "80px");
		grid.addColumn(regionColumn, "Region");
		TextColumn<Endpoint> publicURLColumn = new TextColumn<Endpoint>() {
			@Override
			public String getValue(Endpoint object) {
				return object.getPublicURL();
			}
		};
		grid.setColumnWidth(publicURLColumn, "130px");
		grid.addColumn(publicURLColumn, "Public URL");
		TextColumn<Endpoint> internalURLColumn = new TextColumn<Endpoint>() {
			@Override
			public String getValue(Endpoint object) {
				return object.getInternalURL();
			}
		};
		grid.setColumnWidth(internalURLColumn, "130px");
		grid.addColumn(internalURLColumn, "Internal URL");
		TextColumn<Endpoint> administrationURLColumn = new TextColumn<Endpoint>() {
			@Override
			public String getValue(Endpoint object) {
				return object.getAdminURL();
			}
		};
		grid.setColumnWidth(administrationURLColumn, "130px");
		grid.addColumn(administrationURLColumn, "Administration URL");
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
