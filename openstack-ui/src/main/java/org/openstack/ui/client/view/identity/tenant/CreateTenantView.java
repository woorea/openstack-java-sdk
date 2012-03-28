package org.openstack.ui.client.view.identity.tenant;

import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CreateTenantView extends Composite {

	private static CreateTenantViewUiBinder uiBinder = GWT
			.create(CreateTenantViewUiBinder.class);

	interface CreateTenantViewUiBinder extends
			UiBinder<Widget, CreateTenantView> {
	}
	
	public interface Presenter {

		void createTenant(String name, String description, Boolean enabled);
		
	}
	
	private Presenter presenter;
	
	@UiField TextBox name;
	
	@UiField TextArea description;
	
	@UiField CheckBox enabled;

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
	
	@UiHandler({ "save" })
	public void onSave(ClickEvent event) {
		presenter.createTenant(name.getValue(), description.getValue(), enabled.getValue());
	}

}
