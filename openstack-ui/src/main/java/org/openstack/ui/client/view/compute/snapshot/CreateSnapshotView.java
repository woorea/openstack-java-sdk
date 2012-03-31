package org.openstack.ui.client.view.compute.snapshot;

import org.openstack.model.compute.nova.snapshot.NovaSnapshotForCreate;
import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CreateSnapshotView extends Composite {

	private static Binder uiBinder = GWT
			.create(Binder.class);

	interface Binder extends
			UiBinder<Widget, CreateSnapshotView> {
	}
	
	public interface Presenter {

		void createSnapshot(NovaSnapshotForCreate volume);
		
	}
	
	private Presenter presenter;

	public CreateSnapshotView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiField ListBox volumeId;
	
	@UiField TextBox name;
	
	@UiField TextArea description;
	
	@UiHandler({ "cancel", "close" })
	public void onCancel(ClickEvent event) {
		UI.MODAL.hide(true);
	}
	
	@UiHandler({ "save" })
	public void onSave(ClickEvent event) {
		NovaSnapshotForCreate s = new NovaSnapshotForCreate();
		s.setVolumeId(Integer.parseInt(volumeId.getValue(volumeId.getSelectedIndex())));
		s.setName(name.getValue());
		s.setDescription(description.getValue());
		presenter.createSnapshot(s);
	}

}
