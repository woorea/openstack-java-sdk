package org.openstack.ui.client.view.compute;

import org.openstack.model.compute.NovaServer;
import org.openstack.ui.client.view.compute.widgets.ServerActionPicker;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
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
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class ServersView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, ServersView> {
	}

	public interface Presenter extends ServerActionPicker.Presenter {
		void onCreateServer();

		void refresh();

		void onDeleteServers();

		void onShowServer(String id);

		boolean isSelected(NovaServer object);
	}

	@UiField
	Button create;
	@UiField
	ServerActionPicker actions;
	@UiField(provided = true)
	DataGrid<NovaServer> grid = new DataGrid<NovaServer>();
	@UiField
	SimpleLayoutPanel detail;

	private Presenter presenter;

	public ServersView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<NovaServer, Boolean> checkboxColumn = new Column<NovaServer, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(NovaServer object) {
				return presenter.isSelected(object);
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		Column<NovaServer, String> logoColumn = new Column<NovaServer, String>(new LogoCell()) {

			@Override
			public String getValue(NovaServer object) {
				return "";
			}
		};
		grid.setColumnWidth(logoColumn, "60px");
		grid.addColumn(logoColumn);
		TextColumn<NovaServer> statusColumn = new TextColumn<NovaServer>() {
			@Override
			public String getValue(NovaServer object) {
				return object.getStatus();
			}
		};
		grid.setColumnWidth(statusColumn, "100px");
		grid.addColumn(statusColumn, "Name");
		TextColumn<NovaServer> nameColumn = new TextColumn<NovaServer>() {
			@Override
			public String getValue(NovaServer object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<NovaServer> imageColumn = new TextColumn<NovaServer>() {
			@Override
			public String getValue(NovaServer object) {
				return object.getImage().getName();
			}
		};
		// grid.setColumnWidth(imageColumn, "120px");
		grid.addColumn(imageColumn, "Image");
		TextColumn<NovaServer> flavorColumn = new TextColumn<NovaServer>() {
			@Override
			public String getValue(NovaServer object) {
				return object.getFlavor().getName();
			}
		};
		grid.setColumnWidth(flavorColumn, "120px");
		grid.addColumn(flavorColumn, "Flavor");
		ButtonCell previewButton = new ButtonCell();
		Column<NovaServer,String> preview = new Column<NovaServer,String>(previewButton) {
		  public String getValue(NovaServer object) {
		    return "Preview";
		  }
		};
		preview.setFieldUpdater(new FieldUpdater<NovaServer, String>() {
		  @Override
		  public void update(int index, NovaServer server, String value) {
		    presenter.onShowServer(server.getId());
		  }
		});
		grid.setColumnWidth(preview, "100px");
		grid.addColumn(preview);
	}

	public void setPresenter(Presenter presenter) {
		actions.setPresenter(presenter);
		this.presenter = presenter;
	}

	@UiHandler("create")
	void onCreateServer(ClickEvent event) {
		presenter.onCreateServer();
	}
	
	@UiHandler("delete")
	void onDeleteServers(ClickEvent event) {
		presenter.onDeleteServers();
	}

	@UiHandler("refresh")
	void onRefresh(ClickEvent event) {
		presenter.refresh();
	}

}
