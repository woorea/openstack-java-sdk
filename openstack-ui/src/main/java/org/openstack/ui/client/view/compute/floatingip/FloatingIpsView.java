package org.openstack.ui.client.view.compute.floatingip;

import org.openstack.model.compute.FloatingIp;

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

public class FloatingIpsView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, FloatingIpsView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateFloatingIp();

		void onDeleteFloatingIp();
	}

	@UiField(provided = true)
	DataGrid<FloatingIp> grid = new DataGrid<FloatingIp>();

	private Presenter presenter;

	public FloatingIpsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<FloatingIp, Boolean> checkboxColumn = new Column<FloatingIp, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(FloatingIp object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<FloatingIp> ipColumn = new TextColumn<FloatingIp>() {
			@Override
			public String getValue(FloatingIp object) {
				return object.getIp();
			}
		};
		grid.setColumnWidth(ipColumn, "120px");
		grid.addColumn(ipColumn, "Name");
		TextColumn<FloatingIp> instanceIdColumn = new TextColumn<FloatingIp>() {
			@Override
			public String getValue(FloatingIp object) {
				return object.getInstanceId();
			}
		};
		grid.setColumnWidth(instanceIdColumn, "120px");
		grid.addColumn(instanceIdColumn, "Instance Id");
		TextColumn<FloatingIp> fixedIpColumn = new TextColumn<FloatingIp>() {
			@Override
			public String getValue(FloatingIp object) {
				return object.getFixedIp();
			}
		};
		grid.setColumnWidth(fixedIpColumn, "120px");
		grid.addColumn(fixedIpColumn, "Fixed Ip");
		TextColumn<FloatingIp> poolColumn = new TextColumn<FloatingIp>() {
			@Override
			public String getValue(FloatingIp object) {
				return object.getPool();
			}
		};
		grid.setColumnWidth(poolColumn, "120px");
		grid.addColumn(poolColumn, "Pool");
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
		presenter.onCreateFloatingIp();
	}
	
	@UiHandler("delete")
	void onDeleteTenant(ClickEvent event) {
		presenter.onDeleteFloatingIp();
	}

}
