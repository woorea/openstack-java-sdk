package org.openstack.ui.client.view.compute.wizards;

import org.openstack.model.compute.NovaServerForCreate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SelectImageStep extends Composite implements WizardStep, Editor<NovaServerForCreate> {

	private static SelectImageStepUiBinder uiBinder = GWT.create(SelectImageStepUiBinder.class);

	interface SelectImageStepUiBinder extends UiBinder<Widget, SelectImageStep> {
	}

	public interface Presenter extends ImageTablePicker.Presenter {

	}

	private Presenter presenter;

	@UiField
	ImageTablePicker imageRef;

	public SelectImageStep() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getDescription() {
		return "Select an image";
	}

	@Override
	public Widget getWidet() {
		return this;
	}

	public void setPresenter(Presenter presenter) {
		imageRef.setPresenter(presenter);
		this.presenter = presenter;
	}

}
