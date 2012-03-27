package org.openstack.ui.client.view.compute.wizards;

import org.openstack.model.compute.nova.NovaMetadata;
import org.openstack.ui.client.view.compute.wizards.MetadataEditor.NovaMetadataItemEditor;

import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.TextBox;

public class MetadataEditor extends Composite implements IsEditor<ListEditor<NovaMetadata.Item, NovaMetadataItemEditor>> {

	public static class NovaMetadataItemEditor implements Editor<NovaMetadata.Item> {

		TextBox key;

		TextBox value;

		public NovaMetadataItemEditor() {
			key = new TextBox();
			value = new TextBox();
		}

	}

	FlexTable table;

	ListEditor<NovaMetadata.Item, NovaMetadataItemEditor> editor = ListEditor.<NovaMetadata.Item, NovaMetadataItemEditor> of(new EditorSource<NovaMetadataItemEditor>() {

		@Override
		public NovaMetadataItemEditor create(int index) {
			NovaMetadataItemEditor srcEditor = new NovaMetadataItemEditor();
			table.setWidget(index, 0, srcEditor.key);
			table.setWidget(index, 1, srcEditor.value);
			Button remove = new Button("&times", new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					Cell cell = table.getCellForEvent(event);
					if(cell != null) {
						table.removeRow(cell.getRowIndex());
						editor.getList().remove(cell.getRowIndex());
					}
				}
			});
			remove.setStyleName("btn");
			table.setWidget(index, 2, remove);
			table.getCellFormatter().getElement(index, 2).getStyle().setVerticalAlign(VerticalAlign.TOP);
			return srcEditor;
		}

	});

	public MetadataEditor() {
		FlowPanel panel = new FlowPanel();
		Button add = new Button("Add", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				editor.getList().add(new NovaMetadata.Item());
			}

		});
		panel.add(add);
		table = new FlexTable();
		table.setWidth("100%");
		panel.add(table);
		initWidget(panel);
	}

	@Override
	public ListEditor<NovaMetadata.Item, NovaMetadataItemEditor> asEditor() {
		return editor;
	}

}