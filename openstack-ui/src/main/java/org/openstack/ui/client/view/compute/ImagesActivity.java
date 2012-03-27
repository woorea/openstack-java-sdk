package org.openstack.ui.client.view.compute;

import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;
import org.openstack.model.compute.nova.NovaServerForCreate;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;
import org.openstack.ui.client.view.compute.wizards.CreateServerActivity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class ImagesActivity extends AbstractActivity implements ImagesView.Presenter {
	
	private static final ImagesView VIEW = new ImagesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<Image> dataProvider;

	private MultiSelectionModel<Image> selectionModel = new MultiSelectionModel<Image>();

	private DefaultSelectionEventManager<Image> selectionManager = DefaultSelectionEventManager
			.<Image> createCheckboxManager(0);

	public ImagesActivity(OpenStackPlace place) {
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
		NovaServerForCreate serverForCreate = new NovaServerForCreate();
		serverForCreate.setImageRef(id);
		CreateServerActivity createServerActivity = new CreateServerActivity(serverForCreate);
		createServerActivity.onStart();
	}

}
