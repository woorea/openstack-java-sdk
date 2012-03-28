package org.openstack.ui.client.view.compute.floatingip;

import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AttachFloatingIpView extends Composite {

	private static CreateRoleViewUiBinder uiBinder = GWT
			.create(CreateRoleViewUiBinder.class);

	interface CreateRoleViewUiBinder extends UiBinder<Widget, AttachFloatingIpView> {
	}

	public interface Presenter {

		void createRole(String name);
		
	}
	
	private Presenter presenter;
	
	@UiField TextBox name;
	
	public AttachFloatingIpView() {
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
		presenter.createRole(name.getValue());
	}

}
