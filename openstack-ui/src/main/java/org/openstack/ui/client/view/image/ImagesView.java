package org.openstack.ui.client.view.image;

import org.openstack.model.compute.NovaImage;
import org.openstack.ui.client.view.compute.LogoCell;

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
import com.google.gwt.user.client.ui.Widget;

public class ImagesView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, ImagesView> {
	}

	public interface Presenter {

		void refresh();

		void onLaunchImage(String id);
	}

	@UiField(provided = true)
	DataGrid<NovaImage> grid = new DataGrid<NovaImage>();

	private Presenter presenter;

	public ImagesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<NovaImage, Boolean> checkboxColumn = new Column<NovaImage, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(NovaImage object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<NovaImage> statusColumn = new TextColumn<NovaImage>() {
			@Override
			public String getValue(NovaImage object) {
				return object.getStatus();
			}
		};
		grid.setColumnWidth(statusColumn, "120px");
		grid.addColumn(statusColumn);
		Column<NovaImage, String> logoColumn = new Column<NovaImage, String>(new LogoCell()) {

			@Override
			public String getValue(NovaImage object) {
				return "";
			}
		};
		grid.setColumnWidth(logoColumn, "60px");
		grid.addColumn(logoColumn);
		TextColumn<NovaImage> nameColumn = new TextColumn<NovaImage>() {
			@Override
			public String getValue(NovaImage object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn);
		TextColumn<NovaImage> minDiskColumn = new TextColumn<NovaImage>() {
			@Override
			public String getValue(NovaImage object) {
				return String.valueOf(object.getMinDisk());
			}
		};
		grid.setColumnWidth(minDiskColumn, "120px");
		grid.addColumn(minDiskColumn);
		ButtonCell previewButton = new ButtonCell();
		Column<NovaImage,String> preview = new Column<NovaImage,String>(previewButton) {
		  public String getValue(NovaImage object) {
		    return "Launch";
		  }
		};
		preview.setFieldUpdater(new FieldUpdater<NovaImage, String>() {
		  @Override
		  public void update(int index, NovaImage securityGroup, String value) {
		    presenter.onLaunchImage(securityGroup.getId());
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

}
