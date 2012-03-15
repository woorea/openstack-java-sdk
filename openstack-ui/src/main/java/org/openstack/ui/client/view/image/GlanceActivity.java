package org.openstack.ui.client.view.image;

import org.openstack.ui.client.OpenStackPlace;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Label;

public class GlanceActivity extends AbstractActivity implements
		GlanceView.Presenter {

	private static final GlanceView VIEW = new GlanceView();

	private OpenStackPlace place;

	public GlanceActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		if (place.getPlace() == null || place.getPlace().length() == 0) {
			ImagesActivity activity = new ImagesActivity(place);
			activity.start(VIEW.content, eventBus);
		} else {
			VIEW.content.setWidget(new Label(place.getPlace()));
		}
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}

}
