package org.openstack.ui.client.api;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class DefaultAsyncCallback<T> implements AsyncCallback<T> {

	@Override
	public void onFailure(Throwable caught) {
		caught.printStackTrace();
		Window.alert(caught.getMessage());
		
	}

}
