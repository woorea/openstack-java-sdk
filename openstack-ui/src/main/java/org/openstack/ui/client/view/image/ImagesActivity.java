package org.openstack.ui.client.view.image;

import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaImageList;
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

public class ImagesActivity extends AbstractActivity implements ImagesView.Presenter {
	
	private static final ImagesView VIEW = new ImagesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<NovaImage> dataProvider;

	private MultiSelectionModel<NovaImage> selectionModel = new MultiSelectionModel<NovaImage>();

	private DefaultSelectionEventManager<NovaImage> selectionManager = DefaultSelectionEventManager
			.<NovaImage> createCheckboxManager(0);

	public ImagesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<NovaImage>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<NovaImage> display) {
				OpenStackClient.COMPUTE.listImages(new DefaultAsyncCallback<NovaImageList>() {

					@Override
					public void onSuccess(NovaImageList result) {
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
