package org.openstack.ui.client.view.compute.keypair;

import java.util.List;

import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairList;
import org.openstack.model.compute.KeyPairListItem;
import org.openstack.model.compute.Volume;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;
import org.openstack.ui.client.view.compute.snapshot.CreateSnapshotActivity;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;

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
		ui();
		panel.setWidget(VIEW);
	}
	
	private void ui() {
		VIEW.delete.setEnabled(false);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				switch(selectionModel.getSelectedSet().size()) {
					case 1:
						VIEW.delete.setEnabled(true);
						break;
					default:
						VIEW.delete.setEnabled(false);
				}
				
			}
		});
	}

	@Override
	public void refresh() {
		dataProvider.refresh();
		ui();
	}

	@Override
	public void createKeyPair() {
		CreateKeyPairActivity activity = new CreateKeyPairActivity();
		activity.start(UI.MODAL, null);
		
	}

	@Override
	public void deleteKeyPair() {
		try {
			KeyPair kp = selectionModel.getSelectedSet().iterator().next();
			//vol.getAttachments()
			OpenStackClient.COMPUTE.deleteKeyPair(kp.getName(), new DefaultAsyncCallback<Void>() {
	
				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		} catch (Exception e) {
			
		}
	}

}
