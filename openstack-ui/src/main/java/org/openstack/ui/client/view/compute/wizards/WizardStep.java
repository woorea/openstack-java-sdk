package org.openstack.ui.client.view.compute.wizards;

import com.google.gwt.user.client.ui.Widget;

public interface WizardStep {

	public String getTitle();
	
	public String getDescription();
	
	public Widget getWidet();
	
}
