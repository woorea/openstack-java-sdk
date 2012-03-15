package org.openstack.ui.client.view.compute.snapshot;

import org.openstack.model.compute.NovaSnapshot;
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

public class SnapshotsView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, SnapshotsView> {
	}

	public interface Presenter {

		void refresh();
	}

	@UiField(provided = true)
	DataGrid<NovaSnapshot> grid = new DataGrid<NovaSnapshot>();

	private Presenter presenter;

	public SnapshotsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<NovaSnapshot, Boolean> checkboxColumn = new Column<NovaSnapshot, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(NovaSnapshot object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		Column<NovaSnapshot, String> logoColumn = new Column<NovaSnapshot, String>(new LogoCell()) {

			@Override
			public String getValue(NovaSnapshot object) {
				return "";
			}
		};
		grid.setColumnWidth(logoColumn, "60px");
		grid.addColumn(logoColumn);
		TextColumn<NovaSnapshot> nameColumn = new TextColumn<NovaSnapshot>() {
			@Override
			public String getValue(NovaSnapshot object) {
				return "";
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
