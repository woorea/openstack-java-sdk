package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;
import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AttachVolumeView extends Composite {

	private static CreateVolumeViewUiBinder uiBinder = GWT
			.create(CreateVolumeViewUiBinder.class);

	interface CreateVolumeViewUiBinder extends
			UiBinder<Widget, AttachVolumeView> {
	}
	
	public interface Presenter {

		void attachVolume(String serverId, NovaVolumeAttachment attachment);
		
	}
	
	private Presenter presenter;
	
	@UiField ListBox serverId;
	
	@UiField TextBox device;

	public AttachVolumeView() {
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
		NovaVolumeAttachment attachment = new NovaVolumeAttachment();
		attachment.setDevice(device.getValue());
		presenter.attachVolume(serverId.getValue(serverId.getSelectedIndex()), attachment);
	}

}
