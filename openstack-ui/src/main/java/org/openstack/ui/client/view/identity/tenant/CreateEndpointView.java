package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.keystone.KeystoneEndpoint;
import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CreateEndpointView extends Composite {

	private static CreateEndpointViewUiBinder uiBinder = GWT
			.create(CreateEndpointViewUiBinder.class);

	interface CreateEndpointViewUiBinder extends
			UiBinder<Widget, CreateEndpointView> {
	}

	public interface Presenter {

		void createEndpoint(Endpoint endpoint);

	}

	private Presenter presenter;
	
	@UiField TextBox serviceId;
	
	@UiField TextBox region;
	
	@UiField TextBox publicURL;
	
	@UiField TextBox internalURL;
	
	@UiField TextBox adminURL;

	public CreateEndpointView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler({ "cancel", "close" })
	public void onCancel(ClickEvent event) {
		UI.MODAL.hide(true);
	}
	
	@UiHandler({ "save" })
	public void onSave(ClickEvent event) {
		KeystoneEndpoint endpoint = new KeystoneEndpoint();
		endpoint.setServiceId(serviceId.getValue());
		endpoint.setRegion(region.getValue());
		endpoint.setPublicURL(publicURL.getValue());
		endpoint.setInternalURL(internalURL.getValue());
		endpoint.setAdminURL(adminURL.getValue());
		presenter.createEndpoint(endpoint);
	}
}
