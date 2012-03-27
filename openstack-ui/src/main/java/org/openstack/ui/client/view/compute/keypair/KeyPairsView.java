package org.openstack.ui.client.view.compute.keypair;

import org.openstack.model.compute.KeyPair;

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
	DataGrid<KeyPair> grid = new DataGrid<KeyPair>();

	private Presenter presenter;

	public KeyPairsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<KeyPair, Boolean> checkboxColumn = new Column<KeyPair, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(KeyPair object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<KeyPair> nameColumn = new TextColumn<KeyPair>() {
			@Override
			public String getValue(KeyPair object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<KeyPair> userColumn = new TextColumn<KeyPair>() {
			@Override
			public String getValue(KeyPair object) {
				return object.getUserId();
			}
		};
		grid.setColumnWidth(userColumn, "120px");
		grid.addColumn(userColumn, "User");
		TextColumn<KeyPair> fingerprintColumn = new TextColumn<KeyPair>() {
			@Override
			public String getValue(KeyPair object) {
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
