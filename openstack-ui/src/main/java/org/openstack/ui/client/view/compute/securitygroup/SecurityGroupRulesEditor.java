package org.openstack.ui.client.view.compute.securitygroup;

import java.util.ArrayList;
import java.util.List;

import org.openstack.model.compute.SecurityGroupRuleForCreate;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRuleForCreate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SecurityGroupRulesEditor extends Composite implements IsEditor<ListEditor<SecurityGroupRuleForCreate, SecurityGroupRuleEditor>> {
	
	interface SecurityGroupRulesDriver extends SimpleBeanEditorDriver<List<SecurityGroupRuleForCreate>, ListEditor<SecurityGroupRuleForCreate, SecurityGroupRuleEditor>> {
		
	}
	
	private static final SecurityGroupRulesDriver driver = GWT.create(SecurityGroupRulesDriver.class);

	VerticalPanel layout = new VerticalPanel();
	
	Button addRule = new Button("Add Rule", new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			SecurityGroupRuleForCreate rule = new NovaSecurityGroupRuleForCreate();
			rules.getList().add(rule);
		}
	});
	
	SimplePanel scroll = new SimplePanel();
	
	FlexTable table = new FlexTable();

	ListEditor<SecurityGroupRuleForCreate, SecurityGroupRuleEditor> rules = ListEditor.<SecurityGroupRuleForCreate, SecurityGroupRuleEditor> of(new EditorSource<SecurityGroupRuleEditor>() {

		@Override
		public SecurityGroupRuleEditor create(int index) {
			
			SecurityGroupRuleEditor srcEditor = new SecurityGroupRuleEditor();
			table.setWidget(index + 1, 0, srcEditor.ipProtocol);
			table.setWidget(index + 1, 1, srcEditor.fromPort);
			table.setWidget(index + 1, 2, srcEditor.toPort);
			table.setWidget(index + 1, 3, srcEditor.cidr);
			Button remove = new Button("&times", new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					Cell cell = table.getCellForEvent(event);
					if(cell != null) {
						if(rules.getList().size() > 1) {
							table.removeRow(cell.getRowIndex());
							rules.getList().remove(cell.getRowIndex() - 1);
						} else {
							Window.alert("A security group must have at least one rule");
						}
					}
				}
			});
			remove.setStyleName("btn");
			table.setWidget(index + 1, 4, remove);
			table.getCellFormatter().getElement(index + 1, 4).getStyle().setVerticalAlign(VerticalAlign.TOP);
			return srcEditor;
		}

	});
	
	public SecurityGroupRulesEditor() {
		scroll.setHeight("250px");
		scroll.getElement().getStyle().setProperty("border","2px solid #E8E8E8"); 
		scroll.getElement().getStyle().setProperty("overflowY","scroll");
		table.setWidth("100%");
		table.setHTML(0, 0, "Protocol");
		table.setHTML(0, 1, "From Port");
		table.setHTML(0, 2, "To Port");
		table.setHTML(0, 3, "Source IP (CIDR)");
		table.setHTML(0, 4, "");
		scroll.add(table);
		layout.add(addRule);
		layout.add(scroll);
		initWidget(layout);
		
		driver.initialize(rules);
	
	}
	
	public void edit() {
		List<SecurityGroupRuleForCreate> rules = new ArrayList<SecurityGroupRuleForCreate>();
		driver.edit(rules);
	}
	
	public List<SecurityGroupRuleForCreate> flush() {
		return driver.flush();
	}
	

	@Override
	public ListEditor<SecurityGroupRuleForCreate, SecurityGroupRuleEditor> asEditor() {
		return rules;
	}
	
}
