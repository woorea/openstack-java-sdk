package org.openstack.ui.client.view.compute.wizards;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;

public class ListBoxEditor<T> extends Composite implements LeafValueEditor<List<T>> {

	private ListBox widget = new ListBox(true);

	private List<T> model = new ArrayList<T>();

	public ListBoxEditor() {
		initWidget(widget);
	}

	public void addItem(String label, T value) {
		model.add(value);
		widget.addItem(label);
	}

	@Override
	public void setValue(List<T> values) {
		for(T value : values) {
			int i = 0;
			for(T valueInModel : model) {
				if(value.equals(valueInModel)) {
					widget.setItemSelected(i, true);
					break;
				}
			}
		}
	}

	@Override
	public List<T> getValue() {
		List<T> selected = new ArrayList<T>();
		for(int i = 0; i < widget.getItemCount(); i++) {
			if(widget.isItemSelected(i)) {
				selected.add(model.get(i));
			}
		}
		return selected;
	}

}