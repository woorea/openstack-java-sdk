package org.openstack.ui.client.view.compute.wizards;

import org.openstack.model.compute.nova.NovaServerForCreate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ServerConfigurationStep extends Composite implements WizardStep, Editor<NovaServerForCreate> {

	private static ServerConfigurationStepUiBinder uiBinder = GWT.create(ServerConfigurationStepUiBinder.class);

	interface ServerConfigurationStepUiBinder extends UiBinder<Widget, ServerConfigurationStep> {
	}

	public interface Presenter {

	}

	private Presenter presenter;

	@UiField
	TextBox name;

	@UiField
	FlavorPicker flavorRef;

	@UiField
	IntegerBox min;

	@UiField
	IntegerBox max;

	@UiField
	MetadataEditor metadata;

	@UiField
	PersonalityEditor personality;

	public ServerConfigurationStep() {
		initWidget(uiBinder.createAndBindUi(this));
		name.getElement().setAttribute("placeholder", "Write a short description of the server");
		min.getElement().setAttribute("type", "number");
		max.getElement().setAttribute("type", "number");
	}

	@Override
	public String getDescription() {
		return "Server configuration";
	}

	@Override
	public Widget getWidet() {
		return this;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
