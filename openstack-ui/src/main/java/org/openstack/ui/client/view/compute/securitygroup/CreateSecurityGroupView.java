package org.openstack.ui.client.view.compute.securitygroup;

import org.openstack.model.compute.SecurityGroup;
import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CreateSecurityGroupView extends Composite {

	private static CreateVolumeViewUiBinder uiBinder = GWT
			.create(CreateVolumeViewUiBinder.class);

	interface CreateVolumeViewUiBinder extends
			UiBinder<Widget, CreateSecurityGroupView> {
	}
	
	public interface Presenter extends SecurityGroupEditor.Presenter {

		void createSecurityGroup(SecurityGroup securityGroup);
		
	}
	
	private Presenter presenter;
	
	@UiField SecurityGroupEditor securityGroup;
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public CreateSecurityGroupView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler({ "cancel", "close" })
	public void onCancel(ClickEvent event) {
		UI.MODAL.hide(true);
	}

}
