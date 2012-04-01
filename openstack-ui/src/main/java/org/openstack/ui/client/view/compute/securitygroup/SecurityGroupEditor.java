package org.openstack.ui.client.view.compute.securitygroup;

import org.openstack.model.compute.SecurityGroupForCreate;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupForCreate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SecurityGroupEditor extends Composite implements Editor<SecurityGroupForCreate> {
	
	interface SecurityGroupDriver extends SimpleBeanEditorDriver<SecurityGroupForCreate, SecurityGroupEditor> {

	}
	
	private static final SecurityGroupDriver driver = GWT.create(SecurityGroupDriver.class);

	TextBox name = new TextBox();

	TextBox description = new TextBox();

	public SecurityGroupEditor() {
		VerticalPanel sg = new VerticalPanel();
		sg.add(new Label("Name"));
		sg.add(name);
		sg.add(new Label("Description"));
		sg.add(description);
		initWidget(sg);
		driver.initialize(this);
	}
	
	public void edit() {
		SecurityGroupForCreate securityGroup = new NovaSecurityGroupForCreate();
		driver.edit(securityGroup);
	}
	
	public SecurityGroupForCreate flush() {
		return driver.flush();
	}

}
