package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.identity.Service;

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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class ServicesView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, ServicesView> {
	}

	public interface Presenter {

		void refresh();

		void onCreateService();

		void onDeleteService();

		void onShowService(Service id);
	}

	@UiField(provided = true)
	DataGrid<Service> grid = new DataGrid<Service>();
	@UiField
	SimpleLayoutPanel detail;

	private Presenter presenter;

	public ServicesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<Service, Boolean> checkboxColumn = new Column<Service, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(Service object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<Service> idColumn = new TextColumn<Service>() {
			@Override
			public String getValue(Service object) {
				return object.getId();
			}
		};
		grid.setColumnWidth(idColumn, "120px");
		grid.addColumn(idColumn, "Id");
		TextColumn<Service> typeColumn = new TextColumn<Service>() {
			@Override
			public String getValue(Service object) {
				return object.getType();
			}
		};
		grid.setColumnWidth(typeColumn, "120px");
		grid.addColumn(typeColumn, "Type");
		TextColumn<Service> nameColumn = new TextColumn<Service>() {
			@Override
			public String getValue(Service object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "Name");
		TextColumn<Service> descriptionColumn = new TextColumn<Service>() {
			@Override
			public String getValue(Service object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(descriptionColumn, "120px");
		grid.addColumn(descriptionColumn, "Description");
		ButtonCell previewButton = new ButtonCell();
		Column<Service,String> preview = new Column<Service,String>(previewButton) {
		  public String getValue(Service object) {
		    return "Preview";
		  }
		};
		preview.setFieldUpdater(new FieldUpdater<Service, String>() {
		  @Override
		  public void update(int index, Service service, String value) {
		    presenter.onShowService(service);
		  }
		});
		grid.setColumnWidth(preview, "100px");
		grid.addColumn(preview);
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
		presenter.onCreateService();
	}
	
	@UiHandler("delete")
	void onDeleteTenant(ClickEvent event) {
		presenter.onDeleteService();
	}

}
