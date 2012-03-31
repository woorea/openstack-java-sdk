package org.openstack.ui.client.view.compute.securitygroup;

import java.io.IOException;

import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupRule;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRule;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.TableLayout;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SecurityGroupEditor extends Composite implements Editor<SecurityGroup> {

	public static class SecurityGroupRuleEditor implements Editor<SecurityGroupRule> {

		ValueListBox<String> ipProtocol;

		IntegerBox fromPort;

		IntegerBox toPort;

		@Path("ipRange.cidr")
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

	public interface Presenter {
		void onSaveSecurityGroup();
	}

	Presenter presenter;

	TextBox name = new TextBox();

	TextBox description = new TextBox();

	FlexTable table = new FlexTable();

	ListEditor<SecurityGroupRule, SecurityGroupRuleEditor> rules = ListEditor.<SecurityGroupRule, SecurityGroupRuleEditor> of(new EditorSource<SecurityGroupRuleEditor>() {

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

	public SecurityGroupEditor() {

		table = new FlexTable();
		table.setWidth("100%");
		table.setHTML(0, 0, "Protocol");
		table.setHTML(0, 1, "From Port");
		table.setHTML(0, 2, "To Port");
		table.setHTML(0, 3, "Source IP (CIDR)");
		table.setHTML(0, 4, "");

		Grid layout = new Grid(1,2);
		layout.setWidth("100%");
		layout.getCellFormatter().getElement(0, 0).getStyle().setWidth(40, Unit.PC);
		layout.getCellFormatter().getElement(0, 0).getStyle().setVerticalAlign(VerticalAlign.TOP);
		layout.getCellFormatter().getElement(0, 1).getStyle().setWidth(60, Unit.PC);
		layout.getCellFormatter().getElement(0, 1).getStyle().setVerticalAlign(VerticalAlign.TOP);

		VerticalPanel sg = new VerticalPanel();
		sg.add(new Label("Name"));
		sg.add(name);
		sg.add(new Label("Description"));
		sg.add(description);
		HorizontalPanel buttons = new HorizontalPanel();
		buttons.setWidth("100%");
		buttons.getElement().getStyle().setTableLayout(TableLayout.FIXED);
		buttons.add(new Button("Add Rule", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SecurityGroupRule rule = new NovaSecurityGroupRule();
				System.out.println(rules + "!!!!");
				rules.getList().add(rule);

			}
		}));
		buttons.getWidget(0).getElement().getStyle().setFloat(Float.LEFT);
		buttons.add(new Button("Save Security Group", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.onSaveSecurityGroup();

			}
		}));
		buttons.getWidget(1).getElement().getStyle().setFloat(Float.RIGHT);
		sg.add(buttons);
		layout.setWidget(0,0,sg);
		SimplePanel sgr = new SimplePanel(table);
		sgr.setHeight("250px");
		sgr.getElement().getStyle().setProperty("border","2px solid #E8E8E8");
		sgr.getElement().getStyle().setProperty("overflowY","scroll");
		layout.setWidget(0,1,sgr);

		initWidget(layout);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
