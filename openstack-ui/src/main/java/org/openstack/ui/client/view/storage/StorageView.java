package org.openstack.ui.client.view.storage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class StorageView extends Composite {

	private static ComputeViewUiBinder uiBinder = GWT
			.create(ComputeViewUiBinder.class);

	interface ComputeViewUiBinder extends UiBinder<Widget, StorageView> {
	}
	
	public interface Presenter {
		
	}
	
	private Presenter presenter;

	public StorageView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiField SimpleLayoutPanel content;

}
