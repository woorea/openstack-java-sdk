package org.openstack.ui.client.view.compute.wizards;

import org.openstack.model.compute.NovaServerForCreate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class FirewallStep extends Composite implements WizardStep, Editor<NovaServerForCreate> {

	private static FirewallStepUiBinder uiBinder = GWT
			.create(FirewallStepUiBinder.class);

	interface FirewallStepUiBinder extends UiBinder<Widget, FirewallStep> {
	}
	
	interface Presenter extends SecurityGroupEditor.Presenter {
		SecurityGroupEditor onAddSecurityGroup();
	}
	
	private Presenter presenter; 
	
	@UiField ListBoxEditor<NovaServerForCreate.SecurityGroup> securityGroups;
	
	@UiField Button add;
	
	@UiField ScrollPanel securityGroup;

	public FirewallStep() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getDescription() {
		return "Configure the firewall rules";
	}

	@Override
	public Widget getWidet() {
		return this;
	}
	
	@UiHandler("add")
	void onAddSecurityGroup(ClickEvent event) {
		SecurityGroupEditor editor = presenter.onAddSecurityGroup();
		securityGroup.setWidget(editor);
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
