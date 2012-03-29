package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.nova.volume.NovaVolume;
import org.openstack.model.identity.keystone.KeystoneEndpoint;
import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CreateVolumeView extends Composite {

	private static CreateVolumeViewUiBinder uiBinder = GWT
			.create(CreateVolumeViewUiBinder.class);

	interface CreateVolumeViewUiBinder extends
			UiBinder<Widget, CreateVolumeView> {
	}
	
	public interface Presenter {

		void createVolume(NovaVolume volume);
		
	}
	
	private Presenter presenter;

	public CreateVolumeView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiField IntegerBox sizeInGB;
	
	@UiField TextBox availabilityZone;
	
	@UiField TextBox type;
	
	@UiField TextBox name;
	
	@UiField TextArea description;
	
	@UiHandler({ "cancel", "close" })
	public void onCancel(ClickEvent event) {
		UI.MODAL.hide(true);
	}
	
	@UiHandler({ "save" })
	public void onSave(ClickEvent event) {
		NovaVolume volume = new NovaVolume();
		volume.setSizeInGB(sizeInGB.getValue());
		volume.setAvailabilityZone(0);
		volume.setName(name.getValue());
		volume.setType(type.getValue());
		volume.setDescription(description.getValue());
		presenter.createVolume(volume);
	}

}
