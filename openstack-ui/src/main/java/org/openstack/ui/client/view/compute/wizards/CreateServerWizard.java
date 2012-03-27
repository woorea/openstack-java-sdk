package org.openstack.ui.client.view.compute.wizards;

import org.openstack.model.compute.nova.NovaServerForCreate;

import com.google.common.collect.Iterables;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class CreateServerWizard extends Composite implements Editor<NovaServerForCreate> {

	private static CreateServerWizardUiBinder uiBinder = GWT.create(CreateServerWizardUiBinder.class);

	interface CreateServerWizardUiBinder extends UiBinder<Widget, CreateServerWizard> {
	}

	public interface Presenter extends SelectImageStep.Presenter, ServerConfigurationStep.Presenter,
			KeyPairStep.Presenter, FirewallStep.Presenter {

		void onStart();

		void onCancel();

		void onPrevious();

		void onNext();

		void onFinish();

		void show(int index);

	}

	private Presenter presenter;

	PopupPanel popup;

	@UiField
	HorizontalPanel steps;
	@UiField
	DeckLayoutPanel body;
	@UiField
	Widget footer;

	@Path("")
	@UiField
	SelectImageStep image;
	@Path("")
	@UiField
	ServerConfigurationStep server;
	@Path("")
	@UiField
	KeyPairStep keyPair;
	@Path("")
	@UiField
	FirewallStep firewall;

	@UiField
	Button cancel;
	@UiField
	Button previous;
	@UiField
	Button next;
	@UiField
	Button finish;

	public CreateServerWizard() {
		initWidget(uiBinder.createAndBindUi(this));
		popup = new PopupPanel(false, true);
		for (int i = 0; i < body.getWidgetCount(); i++) {
			WizardStep ws = (WizardStep) body.getWidget(i);
			HTML step = new HTML("<h3>Step" + (i + 1) + "</h3><p>" + ws.getDescription() + "</p>");
			final int j = i;
			step.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					presenter.show(j);

				}
			});
			steps.add(step);
		}
		popup.setWidget(this);
	}

	private void buttonsStuff(int index) {
		previous.setEnabled(index > 0);
		next.setVisible(index != body.getWidgetCount() - 1);
		finish.setVisible(index == body.getWidgetCount() - 1);
	}

	void show(int index) {
		for(int i = 0; i < steps.getWidgetCount(); i++) {
			steps.getWidget(i).getElement().getStyle().setColor(i == index ? "black" :"#A7A7A7");
		}
		buttonsStuff(index);
		body.showWidget(index);
	}

	@UiHandler({ "cancel", "close" })
	void onCancelOrClose(ClickEvent evt) {
		presenter.onCancel();
		popup.hide(true);
	}

	@UiHandler("previous")
	void onPrevious(ClickEvent evt) {
		presenter.onPrevious();
	}

	@UiHandler("next")
	void onNext(ClickEvent evt) {
		presenter.onNext();
	}

	@UiHandler("finish")
	void onFinish(ClickEvent evt) {
		presenter.onFinish();
	}

	public void setPresenter(Presenter presenter) {
		image.setPresenter(presenter);
		server.setPresenter(presenter);
		keyPair.setPresenter(presenter);
		firewall.setPresenter(presenter);
		this.presenter = presenter;
	}

}
