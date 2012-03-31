package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.Volume;

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

public class VolumesView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, VolumesView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateVolume();

		void onDeleteVolume();

		void onAttachVolume();

		void onDetachVolume();
	}
	
	@UiField Button delete;
	
	@UiField Button attach;
	
	@UiField Button detach;
	
	@UiField Button createSnapshot;

	@UiField(provided = true)
	DataGrid<Volume> grid = new DataGrid<Volume>();

	private Presenter presenter;

	public VolumesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<Volume, Boolean> checkboxColumn = new Column<Volume, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(Volume object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<Volume> statusColumn = new TextColumn<Volume>() {

			@Override
			public String getValue(Volume object) {
				return object.getStatus();
			}
		};
		grid.setColumnWidth(statusColumn, "120px");
		grid.addColumn(statusColumn,"status");
		TextColumn<Volume> nameColumn = new TextColumn<Volume>() {

			@Override
			public String getValue(Volume object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "name");
		TextColumn<Volume> sizeColumn = new TextColumn<Volume>() {
			@Override
			public String getValue(Volume object) {
				return object.getSizeInGB().toString();
			}
		};
		grid.setColumnWidth(sizeColumn, "120px");
		grid.addColumn(sizeColumn, "size");
		TextColumn<Volume> descriptionColumn = new TextColumn<Volume>() {

			@Override
			public String getValue(Volume object) {
				return object.getDescription();
			}
		};
		//grid.setColumnWidth(descriptionColumn, "120px");
		grid.addColumn(descriptionColumn, "description");
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("create")
	void onCreateVolume(ClickEvent event) {
		presenter.onCreateVolume();
	}
	
	@UiHandler("delete")
	void onDeleteVolume(ClickEvent event) {
		presenter.onDeleteVolume();
	}
	
	@UiHandler("attach")
	void onAttachVolume(ClickEvent event) {
		presenter.onAttachVolume();
	}
	
	@UiHandler("detach")
	void onDetachVolume(ClickEvent event) {
		presenter.onDetachVolume();
	}

	@UiHandler("refresh")
	void onRefresh(ClickEvent event) {
		presenter.refresh();
	}

}
