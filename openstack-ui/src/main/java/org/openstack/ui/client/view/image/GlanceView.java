package org.openstack.ui.client.view.image;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class GlanceView extends Composite {

	private static ComputeViewUiBinder uiBinder = GWT
			.create(ComputeViewUiBinder.class);

	interface ComputeViewUiBinder extends UiBinder<Widget, GlanceView> {
	}
	
	public interface Presenter {
		
	}
	
	private Presenter presenter;

	public GlanceView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiField SimpleLayoutPanel content;

}
