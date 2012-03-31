package org.openstack.ui.client.view.compute.keypair;

import org.openstack.model.compute.nova.keypair.NovaKeyPair;
import org.openstack.ui.client.UI;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateKeyPairActivity extends AbstractActivity implements CreateKeyPairView.Presenter {
	
	private static final CreateKeyPairView VIEW = new CreateKeyPairView();

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		UI.MODAL.center();
	}

	@Override
	public void createKeyPair(NovaKeyPair keypair) {
		UI.MODAL.hide();
	}

}
