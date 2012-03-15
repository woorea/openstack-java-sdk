package org.openstack.ui.client.view.compute.wizards;

import java.util.List;

import org.openstack.model.compute.NovaImage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;

public class ImageTablePicker extends Composite implements LeafValueEditor<String> {

	public interface Presenter {

		void onSelectImage();

		void updateImages();

	}

	private Presenter presenter;

	private String value;

	private FlexTable table = new FlexTable();

	public ImageTablePicker() {
		table.setWidth("100%");
		initWidget(table);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void refresh(List<NovaImage> images) {
		int row = 0;
		for (final NovaImage image : images) {
			int col = 0;
			table.setHTML(row, col++, "<img src=\"img/logos/debian.png\" style=\"width: 60px\" />");
			table.setHTML(row, col++, "<h3>" + image.getName() + "</h3><p>Available on June 2012</p>");
			table.setHTML(row, col++, "<span class=\"label\">RECOMMENDED</span>");
			Button selectImageButton = new Button("Select this image", new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					setValue(image.getId());
					if (presenter != null) {
						presenter.onSelectImage();
					}
				}
			});
			selectImageButton.setStyleName("btn");
			table.setWidget(row, col, selectImageButton);

			row++;
		}
		table.getColumnFormatter().getElement(0).getStyle().setProperty("textAlign", "center");
		table.getColumnFormatter().getElement(1).getStyle().setProperty("textAlign", "center");
		table.getColumnFormatter().getElement(3).getStyle().setProperty("textAlign", "center");
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

}