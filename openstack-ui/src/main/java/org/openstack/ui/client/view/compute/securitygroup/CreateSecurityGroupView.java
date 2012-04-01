package org.openstack.ui.client.view.compute.securitygroup;

import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CreateSecurityGroupView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, CreateSecurityGroupView> {
	}
	
	public interface Presenter {

		void saveSecurityGroup();
		
	}
	
	private Presenter presenter;
	
	@UiField SecurityGroupEditor securityGroup;
	
	@UiField SecurityGroupRulesEditor rules;
	
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
	
	@UiHandler({ "save" })
	public void onCreateSecurityGroup(ClickEvent event) {
		presenter.saveSecurityGroup();
	}

}
