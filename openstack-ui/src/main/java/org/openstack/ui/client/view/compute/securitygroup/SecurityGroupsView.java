package org.openstack.ui.client.view.compute.securitygroup;

import org.openstack.model.compute.SecurityGroup;

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

public class SecurityGroupsView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, SecurityGroupsView> {
	}

	public interface Presenter {

		void refresh();

		void onShowSecurityGroup(Integer id);
	}

	@UiField(provided = true)
	DataGrid<SecurityGroup> grid = new DataGrid<SecurityGroup>();
	@UiField
	SimpleLayoutPanel detail;

	private Presenter presenter;

	public SecurityGroupsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<SecurityGroup, Boolean> checkboxColumn = new Column<SecurityGroup, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(SecurityGroup object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<SecurityGroup> nameColumn = new TextColumn<SecurityGroup>() {
			@Override
			public String getValue(SecurityGroup object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "");
		ButtonCell previewButton = new ButtonCell();
		Column<SecurityGroup,String> preview = new Column<SecurityGroup,String>(previewButton) {
		  public String getValue(SecurityGroup object) {
		    return "Preview";
		  }
		};
		preview.setFieldUpdater(new FieldUpdater<SecurityGroup, String>() {
		  @Override
		  public void update(int index, SecurityGroup securityGroup, String value) {
		    presenter.onShowSecurityGroup(securityGroup.getId());
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
