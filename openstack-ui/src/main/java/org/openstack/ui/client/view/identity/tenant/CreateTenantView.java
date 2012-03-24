package org.openstack.ui.client.view.identity.tenant;

import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class CreateTenantView extends Composite {

	private static CreateTenantViewUiBinder uiBinder = GWT
			.create(CreateTenantViewUiBinder.class);

	interface CreateTenantViewUiBinder extends
			UiBinder<Widget, CreateTenantView> {
	}
	
	public interface Presenter {
		
	}
	
	private Presenter presenter;

	public CreateTenantView() {
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
