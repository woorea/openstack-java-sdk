package org.openstack.ui.client.view.identity.tenant;

import org.openstack.ui.client.UI;
import org.openstack.ui.client.view.identity.tenant.CreateUserView.Presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CreateServiceView extends Composite {

	private static CreateServiceViewUiBinder uiBinder = GWT
			.create(CreateServiceViewUiBinder.class);

	interface CreateServiceViewUiBinder extends
			UiBinder<Widget, CreateServiceView> {
	}

	public interface Presenter {

		void createService(String type, String name, String description);
		
	}
	
	private Presenter presenter;
	
	@UiField TextBox type;
	
	@UiField TextBox name;
	
	@UiField TextArea description;
	
	public CreateServiceView() {
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
		presenter.createService(type.getValue(), name.getValue(), description.getValue());
	}

}
