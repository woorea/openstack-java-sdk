package org.openstack.ui.client.view.compute.keypair;

import org.openstack.model.compute.nova.keypair.NovaKeyPair;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

public class CreateKeyPairView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, CreateKeyPairView> {
	}

	public CreateKeyPairView() {
		initWidget(uiBinder.createAndBindUi(this));
		formPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				Window.alert("OK");
				GWT.log(event.getResults());
				UI.MODAL.hide();	
			}
		});
	}

	public interface Presenter {

		void createKeyPair(NovaKeyPair keypair);

	}

	private Presenter presenter;

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiField
	FormPanel formPanel;

	@UiField
	TextBox keyPairName;
	
	@UiHandler("createKeyPair")
	void onCreateKeyPair(ClickEvent event) {
		
		formPanel.submit();
		
	}

}
