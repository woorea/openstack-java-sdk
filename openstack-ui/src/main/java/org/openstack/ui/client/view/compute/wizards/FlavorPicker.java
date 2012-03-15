package org.openstack.ui.client.view.compute.wizards;

import java.util.List;

import org.openstack.model.compute.NovaFlavor;
import org.openstack.ui.client.view.compute.widgets.PopupPicker;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;

public class FlavorPicker extends PopupPicker<String> {

	private List<NovaFlavor> flavors;

	private FlexTable grid;

	public interface Presenter {
		void onChangeFlavor(String value);
	}

	private Presenter presenter;

	public FlavorPicker() {
		dropdown.setWidth("165px");
		grid = new FlexTable();
		grid.setCellPadding(4);
		grid.setCellSpacing(2);
		grid.getElement().setAttribute("style", "width: 165px");
		grid.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Cell cell = grid.getCellForEvent(event);
				if (cell != null && cell.getRowIndex() > 0) {
					popup.hide(true);
					NovaFlavor f = flavors.get(cell.getRowIndex() - 1);
					setValue(f.getId());
					setText(f.getName());
					if (presenter != null) {
						presenter.onChangeFlavor("" + cell.getRowIndex());
					}
				}
			}
		});
	}

	public void setOptions(final List<NovaFlavor> flavors) {
		this.flavors = flavors;
		setText("Select a Flavor");
		grid.setHTML(0, 0, "      NAME");
		grid.setHTML(0, 1, "     vCPUs");
		grid.setHTML(0, 2, "  RAM (MB)");
		grid.setHTML(0, 3, " DISK (GB)");
		int row = 1;
		for (NovaFlavor flavor : flavors) {
			grid.setHTML(row, 0, flavor.getName());
			grid.setHTML(row, 1, String.valueOf(flavor.getVcpus()));
			grid.setHTML(row, 2, String.valueOf(flavor.getRam()));
			grid.setHTML(row, 3, String.valueOf(flavor.getDisk()));
			grid.getRowFormatter().getElement(row).setAttribute("style", "border-bottom: 1px solid #EAEAEA; cursor: pointer");
			row++;
		}
		popup.setWidget(grid);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}