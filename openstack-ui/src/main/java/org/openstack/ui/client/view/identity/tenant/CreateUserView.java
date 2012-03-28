package org.openstack.ui.client.view.identity.tenant;

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

public class CreateUserView extends Composite  {

	private static CreateUserViewUiBinder uiBinder = GWT
			.create(CreateUserViewUiBinder.class);

	interface CreateUserViewUiBinder extends UiBinder<Widget, CreateUserView> {
	}

	public CreateUserView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public interface Presenter {

		void createUser(String name, String username, String password, String email, Boolean enabled);
		
	}
	
	private Presenter presenter;
	
	@UiField TextBox name;
	
	@UiField TextBox username;
	
	@UiField TextBox password;
	
	@UiField TextBox email;
	
	@UiField CheckBox enabled;
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler({ "cancel", "close" })
	public void onCancel(ClickEvent event) {
		UI.MODAL.hide(true);
	}
	
	@UiHandler({ "save" })
	public void onSave(ClickEvent event) {
		presenter.createUser(name.getValue(), username.getValue(), password.getValue(), email.getValue(), enabled.getValue());
	}

}
