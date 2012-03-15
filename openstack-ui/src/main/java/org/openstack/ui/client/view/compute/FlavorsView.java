package org.openstack.ui.client.view.compute;

import org.openstack.model.compute.NovaFlavor;

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

public class FlavorsView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, FlavorsView> {
	}

	public interface Presenter {

		void refresh();
	}

	@UiField(provided = true)
	DataGrid<NovaFlavor> grid = new DataGrid<NovaFlavor>();

	private Presenter presenter;

	public FlavorsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<NovaFlavor, Boolean> checkboxColumn = new Column<NovaFlavor, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(NovaFlavor object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<NovaFlavor> nameColumn = new TextColumn<NovaFlavor>() {
			@Override
			public String getValue(NovaFlavor object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "NAME");
		TextColumn<NovaFlavor> vcpusColumn = new TextColumn<NovaFlavor>() {
			@Override
			public String getValue(NovaFlavor object) {
				return String.valueOf(object.getVcpus());
			}
		};
		grid.setColumnWidth(vcpusColumn, "60px");
		grid.addColumn(vcpusColumn, "vCPU");
		TextColumn<NovaFlavor> ramColumn = new TextColumn<NovaFlavor>() {
			@Override
			public String getValue(NovaFlavor object) {
				return String.valueOf(object.getRam());
			}
		};
		grid.setColumnWidth(ramColumn, "60px");
		grid.addColumn(ramColumn, "RAM");
		TextColumn<NovaFlavor> diskColumn = new TextColumn<NovaFlavor>() {
			@Override
			public String getValue(NovaFlavor object) {
				return String.valueOf(object.getDisk());
			}
		};
		grid.setColumnWidth(diskColumn, "60px");
		grid.addColumn(diskColumn, "DISK");
		TextColumn<NovaFlavor> rxtxColumn = new TextColumn<NovaFlavor>() {
			@Override
			public String getValue(NovaFlavor object) {
				return String.valueOf(object.getRxTxFactor());
			}
		};
		grid.setColumnWidth(rxtxColumn, "60px");
		grid.addColumn(rxtxColumn, "RX/TX");
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("refresh")
	void onRefresh(ClickEvent event) {
		presenter.refresh();
	}

}
