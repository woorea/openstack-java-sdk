package org.openstack.ui.client.view.storage;

import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;
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

public class ContainersActivity extends AbstractActivity implements ContainersView.Presenter {
	
	private static final ContainersView VIEW = new ContainersView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<Image> dataProvider;

	private MultiSelectionModel<Image> selectionModel = new MultiSelectionModel<Image>();

	private DefaultSelectionEventManager<Image> selectionManager = DefaultSelectionEventManager
			.<Image> createCheckboxManager(0);

	public ContainersActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<Image>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<Image> display) {
				OpenStackClient.COMPUTE.listImages(new DefaultAsyncCallback<ImageList>() {

					@Override
					public void onSuccess(ImageList result) {
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

	@Override
	public void onLaunchImage(String id) {
		// TODO Auto-generated method stub
		
	}

}
