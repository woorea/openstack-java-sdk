package org.openstack.ui.client.view.identity.tenant;

import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CreateEndpointTemplatesView extends Composite {

	private static CreateEndpointTemplatesViewUiBinder uiBinder = GWT
			.create(CreateEndpointTemplatesViewUiBinder.class);

	interface CreateEndpointTemplatesViewUiBinder extends
			UiBinder<Widget, CreateEndpointTemplatesView> {
	}

	public interface Presenter {

	}

	private Presenter presenter;

	public CreateEndpointTemplatesView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler({ "cancel", "close" })
	public void onCancel(ClickEvent event) {
		UI.MODAL.hide(true);
	}
}
