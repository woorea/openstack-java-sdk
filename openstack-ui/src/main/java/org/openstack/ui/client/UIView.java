package org.openstack.ui.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class UIView extends Composite {

	private static UIViewUiBinder uiBinder = GWT.create(UIViewUiBinder.class);

	interface UIViewUiBinder extends UiBinder<Widget, UIView> {
	}
	
	public interface Presenter {
		void onChangeTenant(String tenantId);

		void onChangeService(String value);
	}
	
	private Presenter presenter;
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	
	@UiField ListBox services;

	@UiField ListBox tenants;
	
	@UiField SimpleLayoutPanel content;

	public UIView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		UIActivityMapper activityMapper = new UIActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper, UI.EVENT_BUS);
		activityManager.setDisplay(content);
		
	}
	
	@UiHandler("services")
	void onServicesChange(ChangeEvent event) {
		presenter.onChangeService(services.getValue(services.getSelectedIndex()));
	}

	@UiHandler("tenants")
	void onTenantsChange(ChangeEvent event) {
		presenter.onChangeTenant(tenants.getValue(tenants.getSelectedIndex()));
	}

}
