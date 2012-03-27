package org.openstack.ui.client.view.compute;

import org.openstack.model.compute.Image;

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
	DataGrid<Image> grid = new DataGrid<Image>();

	private Presenter presenter;

	public ImagesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<Image, Boolean> checkboxColumn = new Column<Image, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(Image object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<Image> statusColumn = new TextColumn<Image>() {
			@Override
			public String getValue(Image object) {
				return object.getStatus();
			}
		};
		grid.setColumnWidth(statusColumn, "120px");
		grid.addColumn(statusColumn);
		Column<Image, String> logoColumn = new Column<Image, String>(new LogoCell()) {

			@Override
			public String getValue(Image object) {
				return "";
			}
		};
		grid.setColumnWidth(logoColumn, "60px");
		grid.addColumn(logoColumn);
		TextColumn<Image> nameColumn = new TextColumn<Image>() {
			@Override
			public String getValue(Image object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn);
		TextColumn<Image> minDiskColumn = new TextColumn<Image>() {
			@Override
			public String getValue(Image object) {
				return String.valueOf(object.getMinDisk());
			}
		};
		grid.setColumnWidth(minDiskColumn, "120px");
		grid.addColumn(minDiskColumn);
		ButtonCell previewButton = new ButtonCell();
		Column<Image,String> preview = new Column<Image,String>(previewButton) {
		  public String getValue(Image object) {
		    return "Launch";
		  }
		};
		preview.setFieldUpdater(new FieldUpdater<Image, String>() {
		  @Override
		  public void update(int index, Image securityGroup, String value) {
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
