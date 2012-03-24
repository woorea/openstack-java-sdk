package org.openstack.ui.client.view.identity.tenant;

import org.openstack.ui.client.UI;
import org.openstack.ui.client.view.identity.tenant.CreateServiceView.Presenter;

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

public class CreateRoleView extends Composite {

	private static CreateRoleViewUiBinder uiBinder = GWT
			.create(CreateRoleViewUiBinder.class);

	interface CreateRoleViewUiBinder extends UiBinder<Widget, CreateRoleView> {
	}

	public interface Presenter {
		
	}
	
	private Presenter presenter;
	
	public CreateRoleView() {
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
