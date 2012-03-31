package org.openstack.ui.client.view.compute.securitygroup;

import org.openstack.model.compute.nova.keypair.NovaKeyPair;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroup;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.view.compute.keypair.CreateKeyPairView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateSecurityGroupActivity extends AbstractActivity implements CreateSecurityGroupView.Presenter {
	
	private static final CreateSecurityGroupView VIEW = new CreateSecurityGroupView();
	
	public interface Presenter {
		
	}
	
	private Presenter presenter;
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		UI.MODAL.center();
	}

	@Override
	public void createSecurityGroup(NovaSecurityGroup securityGroup) {
		UI.MODAL.hide();
	}

}