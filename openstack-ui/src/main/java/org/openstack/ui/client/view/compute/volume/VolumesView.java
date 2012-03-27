package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.Volume;
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

public class VolumesView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, VolumesView> {
	}

	public interface Presenter {

		void refresh();
	}

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
		Column<Volume, String> logoColumn = new Column<Volume, String>(new LogoCell()) {

			@Override
			public String getValue(Volume object) {
				return "";
			}
		};
		grid.setColumnWidth(logoColumn, "60px");
		grid.addColumn(logoColumn);
		TextColumn<Volume> nameColumn = new TextColumn<Volume>() {
			@Override
			public String getValue(Volume object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("refresh")
	void onRefresh(ClickEvent event) {
		presenter.refresh();
	}

}
