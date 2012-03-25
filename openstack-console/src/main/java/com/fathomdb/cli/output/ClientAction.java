package com.fathomdb.cli.output;

public class ClientAction {
	public enum ClientActionType {
		BROWSER
	}

	final ClientActionType action;
	final String parameter;

	public ClientAction(ClientActionType action, String parameter) {
		this.action = action;
		this.parameter = parameter;
	}

	public ClientActionType getAction() {
		return action;
	}

	public String getParameter() {
		return parameter;
	}

}
