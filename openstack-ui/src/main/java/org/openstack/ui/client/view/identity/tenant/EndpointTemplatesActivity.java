package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeyStoneEndpointTemplates;
import org.openstack.model.identity.KeyStoneEndpointTemplatesList;
import org.openstack.model.identity.KeyStoneService;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class EndpointTemplatesActivity extends AbstractActivity implements EndpointTemplatesView.Presenter {
	
	private static final EndpointTemplatesView VIEW = new EndpointTemplatesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<KeyStoneEndpointTemplates> dataProvider;

	private MultiSelectionModel<KeyStoneEndpointTemplates> selectionModel = new MultiSelectionModel<KeyStoneEndpointTemplates>();

	private DefaultSelectionEventManager<KeyStoneEndpointTemplates> selectionManager = DefaultSelectionEventManager
			.<KeyStoneEndpointTemplates> createCheckboxManager(0);

	public EndpointTemplatesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<KeyStoneEndpointTemplates>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<KeyStoneEndpointTemplates> display) {
				OpenStackClient.IDENTITY.listEndpontTemplates(new DefaultAsyncCallback<KeyStoneEndpointTemplatesList>() {

					@Override
					public void onSuccess(KeyStoneEndpointTemplatesList result) {
						updateRowCount(result.getList().size(), true);
						updateRowData(0, result.getList());

					}
				});
			}

		};
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
