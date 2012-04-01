package org.openstack.ui.client.view.compute.securitygroup;

import java.io.IOException;
import java.util.Arrays;

import org.openstack.model.compute.SecurityGroupRuleForCreate;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;

public class SecurityGroupRuleEditor implements Editor<SecurityGroupRuleForCreate> {

	ValueListBox<String> ipProtocol;

	IntegerBox fromPort;

	IntegerBox toPort;
	
	TextBox cidr;

	public SecurityGroupRuleEditor() {
		ipProtocol = new ValueListBox<String>(new Renderer<String>() {

			@Override
			public String render(String object) {
				return object;
			}

			@Override
			public void render(String object, Appendable appendable)
					throws IOException {
				appendable.append(object);

			}
		});
		ipProtocol.setAcceptableValues(Arrays.asList("", "TCP","UDP","ICMP"));
		ipProtocol.setWidth("100px");

		fromPort = new IntegerBox();
		fromPort.setWidth("60px");
		fromPort.getElement().setAttribute("type", "number");

		toPort = new IntegerBox();
		toPort.setWidth("60px");
		toPort.getElement().setAttribute("type", "number");

		cidr = new TextBox();
		cidr.getElement().setAttribute("placeholder", "0.0.0.0/24");
	}

}
