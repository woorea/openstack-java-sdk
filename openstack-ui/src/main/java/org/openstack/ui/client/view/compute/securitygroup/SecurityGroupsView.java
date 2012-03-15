package org.openstack.ui.client.view.compute.securitygroup;

import org.openstack.model.compute.NovaSecurityGroup;

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
	DataGrid<NovaSecurityGroup> grid = new DataGrid<NovaSecurityGroup>();
	@UiField
	SimpleLayoutPanel detail;

	private Presenter presenter;

	public SecurityGroupsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	private void initGrid() {
		Column<NovaSecurityGroup, Boolean> checkboxColumn = new Column<NovaSecurityGroup, Boolean>(new CheckboxCell()) {

			@Override
			public Boolean getValue(NovaSecurityGroup object) {
				return false;
			}
		};
		grid.setColumnWidth(checkboxColumn, "40px");
		grid.addColumn(checkboxColumn, "");
		TextColumn<NovaSecurityGroup> nameColumn = new TextColumn<NovaSecurityGroup>() {
			@Override
			public String getValue(NovaSecurityGroup object) {
				return object.getName();
			}
		};
		grid.setColumnWidth(nameColumn, "120px");
		grid.addColumn(nameColumn, "");
		ButtonCell previewButton = new ButtonCell();
		Column<NovaSecurityGroup,String> preview = new Column<NovaSecurityGroup,String>(previewButton) {
		  public String getValue(NovaSecurityGroup object) {
		    return "Preview";
		  }
		};
		preview.setFieldUpdater(new FieldUpdater<NovaSecurityGroup, String>() {
		  @Override
		  public void update(int index, NovaSecurityGroup securityGroup, String value) {
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
