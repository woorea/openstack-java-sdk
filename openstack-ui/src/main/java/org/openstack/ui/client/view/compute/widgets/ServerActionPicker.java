package org.openstack.ui.client.view.compute.widgets;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;

public class ServerActionPicker extends PopupPicker<ServerAction> {

	public interface Presenter {
		void onServerAction(ServerAction action);
	}

	private Presenter presenter;

	private FlexTable grid;

	public ServerActionPicker() {
		dropdown.setText("Server Actions");
		grid = new FlexTable();
		grid.setCellPadding(2);
		grid.setCellSpacing(2);
		grid.setWidth("165px");
		int row = 0;
		for (ServerAction sa : ServerAction.values()) {
			grid.setHTML(row, 0, sa.toString());
			grid.getCellFormatter().getElement(row++, 0).getStyle().setFontSize(10.0, Unit.PX);
		}
		popup.setWidget(grid);

		grid.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Cell cell = grid.getCellForEvent(event);
				if (cell != null) {
					popup.hide(true);
					if (presenter != null) {
						presenter.onServerAction(ServerAction.values()[cell.getRowIndex()]);
					}
				}
			}
		});
	}

	public void setPresenter(Presenter presenter) {

		this.presenter = presenter;

	}

	@Override
	public void setValue(ServerAction value) {
		// TODO Auto-generated method stub

	}

	@Override
	public ServerAction getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
