package org.openstack.ui.client.view.compute.snapshot;

import org.openstack.model.compute.Snapshot;
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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SnapshotsView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, SnapshotsView> {
	}

	public interface Presenter {

		void refresh();
		
		void onCreateSnapshot();
		
		void onDeleteSnapshot();
		
		void onCreateVolume();
		
	}
	
	@UiField Button delete;
	
	@UiField Button createVolume;

	@UiField(provided = true)
	DataGrid<Snapshot> grid = new DataGrid<Snapshot>();

	private Presenter presenter;

	public SnapshotsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<Snapshot, Boolean> checkboxColumn = new Column<Snapshot, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(Snapshot object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<Snapshot> nameColumn = new TextColumn<Snapshot>() {

			@Override
			public String getValue(Snapshot object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "60px");
		grid.addColumn(nameColumn,"name");
		TextColumn<Snapshot> statusColumn = new TextColumn<Snapshot>() {
			@Override
			public String getValue(Snapshot object) {
				return object.getStatus();
			}
		};
		grid.setColumnWidth(statusColumn, "120px");
		grid.addColumn(statusColumn,"status");
		TextColumn<Snapshot> descriptionColumn = new TextColumn<Snapshot>() {

			@Override
			public String getValue(Snapshot object) {
				return object.getName();
			}
		};
		grid.addColumn(descriptionColumn,"description");
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("refresh")
	void onRefresh(ClickEvent event) {
		presenter.refresh();
	}
	
	@UiHandler("create")
	void onCreateSnapshot(ClickEvent event) {
		presenter.onCreateSnapshot();
	}
	
	@UiHandler("delete")
	void onDeleteSnapshot(ClickEvent event) {
		presenter.onDeleteSnapshot();
	}
	
	@UiHandler("createVolume")
	void onCreateVolume(ClickEvent event) {
		presenter.onCreateVolume();
	}

}
