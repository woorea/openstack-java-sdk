package org.openstack.ui.client.view.compute;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

public class ComputeNavigation extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, ComputeNavigation> {
	}
	
	@UiField Tree tree;

	public ComputeNavigation() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setTenantId(String id) {
		Iterator<TreeItem> items = tree.treeItemIterator();
		while(items.hasNext()) {
			TreeItem item = items.next();
			if(item.getWidget() instanceof Hyperlink) {
				Hyperlink link = (Hyperlink) item.getWidget();
				link.setTargetHistoryToken(link.getTargetHistoryToken().replace("tenantId", id));
			}
		}
	}

}
