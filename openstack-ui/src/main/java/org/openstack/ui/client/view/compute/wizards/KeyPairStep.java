package org.openstack.ui.client.view.compute.wizards;

import org.openstack.model.compute.nova.NovaServerForCreate;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class KeyPairStep extends Composite implements WizardStep, Editor<NovaServerForCreate> {

	private static KeyPairStepUiBinder uiBinder = GWT
			.create(KeyPairStepUiBinder.class);

	interface KeyPairStepUiBinder extends UiBinder<Widget, KeyPairStep> {
	}

	public interface Presenter {
		void onCreateKeyPair();
	}

	private Presenter presenter;

	@UiField
	ListBox keyNameListBox;
	
	LeafValueEditor<String> keyName = new LeafValueEditor<String>() {

		@Override
		public void setValue(String value) {
			if(value != null) {
				for(int i = 0; i< keyNameListBox.getItemCount(); i++) {
					if(value.equals(keyNameListBox.getValue(i))) {
						keyNameListBox.setSelectedIndex(i);
					}
				}
			}
			
			
		}

		@Override
		public String getValue() {
			if(keyNameListBox.getSelectedIndex() != -1) {
				return keyNameListBox.getValue(keyNameListBox.getSelectedIndex());
			}
			return "";
		}
	};
	
	@UiField
	FormPanel formPanel;

	@Ignore
	@UiField
	TextBox keyPairName;
	
	@Ignore
	@UiField
	Hidden computeURL;
	
	@Ignore
	@UiField
	Hidden token;

	public KeyPairStep() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getDescription() {
		return "Select or create a key pair";
	}

	@Override
	public Widget getWidet() {
		return this;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	@UiHandler("createKeyPair")
	void onCreateKeyPair(ClickEvent event) {
		computeURL.setValue(OpenStackClient.getComputeURL());
		token.setValue(OpenStackClient.getToken());
		formPanel.submit();
		keyNameListBox.addItem(keyPairName.getValue());
		keyName.setValue(keyPairName.getValue());
		presenter.onCreateKeyPair();
	}

}
