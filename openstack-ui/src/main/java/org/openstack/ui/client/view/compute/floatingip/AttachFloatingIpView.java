package org.openstack.ui.client.view.compute.floatingip;

import org.openstack.ui.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class AttachFloatingIpView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, AttachFloatingIpView> {
	}

	public interface Presenter {

		void attachFloatingIp(String serverId);

	}

	private Presenter presenter;

	@UiField ListBox serverId;

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
		presenter.attachFloatingIp(serverId.getValue(serverId.getSelectedIndex()));
	}

}
