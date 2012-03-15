package org.openstack.ui.client.api;

import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

public abstract class RefreshableDataProvider<T> extends AsyncDataProvider<T> {

	private HasData<T> display;

	public RefreshableDataProvider(HasData<T> display) {
		addDataDisplay(display);
		this.display = display;
	}

	public void refresh() {
		onRangeChanged(display);
	}

}
