package org.openstack.ui.client.view.identity;

import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.view.identity.tenant.TenantsActivity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Label;

public class IdentityActivity extends AbstractActivity implements
		IdentityView.Presenter {

	private static final IdentityView VIEW = new IdentityView();

	private OpenStackPlace place;

	public IdentityActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		if ("".equals(place.getPlace())) {
			TenantsActivity activity = new TenantsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("users".equals(place.getPlace())) {
			TenantsActivity activity = new TenantsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("roles".equals(place.getPlace())) {
			TenantsActivity activity = new TenantsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("services".equals(place.getPlace())) {
			TenantsActivity activity = new TenantsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("endpointTemplates".equals(place.getPlace())) {
			TenantsActivity activity = new TenantsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else {
			VIEW.content.setWidget(new Label(place.getPlace()));
		}
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}

}
