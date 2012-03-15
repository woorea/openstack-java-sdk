package org.openstack.ui.client.view.compute.keypair;

import org.openstack.model.compute.NovaKeyPair;

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

public class KeyPairsView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, KeyPairsView> {
	}

	public interface Presenter {

		void refresh();
	}

	@UiField(provided = true)
	DataGrid<NovaKeyPair> grid = new DataGrid<NovaKeyPair>();

	private Presenter presenter;

	public KeyPairsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<NovaKeyPair, Boolean> checkboxColumn = new Column<NovaKeyPair, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(NovaKeyPair object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<NovaKeyPair> nameColumn = new TextColumn<NovaKeyPair>() {
			@Override
			public String getValue(NovaKeyPair object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<NovaKeyPair> userColumn = new TextColumn<NovaKeyPair>() {
			@Override
			public String getValue(NovaKeyPair object) {
				return object.getUserId();
			}
		};
		grid.setColumnWidth(userColumn, "120px");
		grid.addColumn(userColumn, "User");
		TextColumn<NovaKeyPair> fingerprintColumn = new TextColumn<NovaKeyPair>() {
			@Override
			public String getValue(NovaKeyPair object) {
				return object.getFingerprint();
			}
		};
		grid.setColumnWidth(fingerprintColumn, "120px");
		grid.addColumn(fingerprintColumn, "Fingerprint");
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("refresh")
	void onRefresh(ClickEvent event) {
		presenter.refresh();
	}

}
