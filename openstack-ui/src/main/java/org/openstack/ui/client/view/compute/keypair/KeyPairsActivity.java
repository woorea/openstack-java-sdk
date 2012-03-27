package org.openstack.ui.client.view.compute.keypair;

import java.util.List;

import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairList;
import org.openstack.model.compute.KeyPairListItem;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class KeyPairsActivity extends AbstractActivity implements KeyPairsView.Presenter {
	
	private static final KeyPairsView VIEW = new KeyPairsView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<KeyPair> dataProvider;

	private MultiSelectionModel<KeyPair> selectionModel = new MultiSelectionModel<KeyPair>();

	private DefaultSelectionEventManager<KeyPair> selectionManager = DefaultSelectionEventManager
			.<KeyPair> createCheckboxManager(0);

	public KeyPairsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<KeyPair>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<KeyPair> display) {
				OpenStackClient.COMPUTE.listKeyPairs(new DefaultAsyncCallback<KeyPairList>() {

					@Override
					public void onSuccess(KeyPairList result) {
						updateRowCount(result.getList().size(), true);
						List<KeyPair> kpl = Lists.transform(result.getList(), new Function<KeyPairListItem, KeyPair>() {

							@Override
							public KeyPair apply(KeyPairListItem item) {
								return item.getKeypair();
							}
							
						});
						updateRowData(0, kpl);

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
