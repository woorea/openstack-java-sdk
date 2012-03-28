package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.User;
import org.openstack.model.identity.keystone.KeystoneUser;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.view.identity.tenant.CreateUserView.CreateUserViewUiBinder;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateUserActivity extends AbstractActivity implements CreateUserView.Presenter {

	private static final CreateUserView VIEW = new CreateUserView();

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}
	
	//@Override
			public void createUser(String name, String username, String password, String email, Boolean enabled) {
				KeystoneUser user = new KeystoneUser();
				user.setName(name);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				
				user.setEnabled(enabled);
				OpenStackClient.IDENTITY.createUser(user, new DefaultAsyncCallback<User>() {

					@Override
					public void onSuccess(User result) {
						//refresh
						UI.MODAL.hide(true);
						
					}
				});
			}

}
