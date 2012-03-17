package org.openstack.ui.client.view.compute.wizards;

import java.util.List;

import org.openstack.model.compute.NovaFlavorList;
import org.openstack.model.compute.NovaImageList;
import org.openstack.model.compute.NovaKeyPair;
import org.openstack.model.compute.NovaKeyPairList;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;
import org.openstack.model.compute.NovaSecurityGroupRule;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.Window;

public class CreateServerActivity implements CreateServerWizard.Presenter {
	
	private static final CreateServerWizard wizard = new CreateServerWizard();

	interface CreateServerRequestDriver extends SimpleBeanEditorDriver<NovaServerForCreate, CreateServerWizard> {

	}

	interface SecurityGroupDriver extends SimpleBeanEditorDriver<NovaSecurityGroup, SecurityGroupEditor> {

	}

	private static final CreateServerRequestDriver createServerRequestDriver = GWT.create(CreateServerRequestDriver.class);

	private static final SecurityGroupDriver securityGroupDriver = GWT.create(SecurityGroupDriver.class);

	private int index;
	
	private NovaServerForCreate serverForCreate;
	
	public CreateServerActivity(NovaServerForCreate serverForCreate) {
		this.serverForCreate = serverForCreate;
	}

	@Override
	public SecurityGroupEditor onAddSecurityGroup() {
		SecurityGroupEditor securityGroupEditor = new SecurityGroupEditor();
		securityGroupEditor.setPresenter(this);
		securityGroupDriver.initialize(securityGroupEditor);
		NovaSecurityGroup securityGroup = new NovaSecurityGroup();
		securityGroup.getRules().add(new NovaSecurityGroupRule());
		securityGroupDriver.edit(securityGroup);
		return securityGroupEditor;
	}

	@Override
	public void onStart() {
		wizard.setPresenter(this);
		updateImages();
		OpenStackClient.COMPUTE.listFlavors(new DefaultAsyncCallback<NovaFlavorList>() {

			@Override
			public void onSuccess(NovaFlavorList result) {
				GWT.log(""+result.getList().size());
				wizard.server.flavorRef.setOptions(result.getList());

			}
		});
		OpenStackClient.COMPUTE.listKeyPairs(new DefaultAsyncCallback<NovaKeyPairList>() {

			@Override
			public void onSuccess(NovaKeyPairList result) {
				List<String> names = Lists.transform(result.getList(), new Function<NovaKeyPairList.KeyPairListItem, String>() {

					@Override
					public String apply(NovaKeyPairList.KeyPairListItem input) {
						return input.getKeypair().getName();
					}
				});
				if(names != null) {
					for(String name : names) {
						wizard.keyPair.keyNameListBox.addItem(name, name);
					}
					
				}
			}
		});
		OpenStackClient.COMPUTE.listSecurityGroups(new DefaultAsyncCallback<NovaSecurityGroupList>() {

			@Override
			public void onSuccess(NovaSecurityGroupList result) {
				List<NovaServerForCreate.SecurityGroup> names = Lists.transform(result.getList(), new Function<NovaSecurityGroup, NovaServerForCreate.SecurityGroup>() {

					@Override
					public NovaServerForCreate.SecurityGroup apply(NovaSecurityGroup input) {
						return new NovaServerForCreate.SecurityGroup(input.getName());
					}
				});
				for (NovaServerForCreate.SecurityGroup kp : names) {
					wizard.firewall.securityGroups.addItem(kp.getName(), kp);
				}

			}
		});

		createServerRequestDriver.initialize(wizard);
		createServerRequestDriver.edit(new NovaServerForCreate());
		show(serverForCreate.getImageRef() == null ? 0 : 1);
		wizard.popup.center();
	}

	@Override
	public void onFinish() {
		NovaServerForCreate csr = createServerRequestDriver.flush();
		OpenStackClient.COMPUTE.saveServer(csr, new DefaultAsyncCallback<NovaServer>() {

			@Override
			public void onSuccess(NovaServer result) {
				wizard.popup.hide(true);
			}
		});
		

	}

	@Override
	public void onSaveSecurityGroup() {
		NovaSecurityGroup sg = securityGroupDriver.flush();
		NovaServerForCreate.SecurityGroup sg2 = new NovaServerForCreate.SecurityGroup(sg.getName());
		wizard.firewall.securityGroups.addItem(sg2.getName(), sg2);
		Window.alert(sg.toString());
	}

	@Override
	public void onCreateKeyPair() {
		
	}

	@Override
	public void onSelectImage() {
		onNext();
	}

	@Override
	public void onPrevious() {
		show(index - 1);

	}

	@Override
	public void onNext() {
		show(index + 1);
	}

	@Override
	public void show(int index) {
		if (index >= 0 && index < wizard.body.getWidgetCount()) {
			wizard.footer.setVisible(index != 0);
			wizard.show(index);
			this.index = index;
		}
	}

	@Override
	public void onCancel() {
	}

	@Override
	public void updateImages() {
		OpenStackClient.COMPUTE.listImages(new DefaultAsyncCallback<NovaImageList>() {

			@Override
			public void onSuccess(NovaImageList result) {
				wizard.image.imageRef.refresh(result.getList());

			}

		});
	}

	
}
