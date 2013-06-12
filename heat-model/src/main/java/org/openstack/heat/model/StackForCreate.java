package org.openstack.heat.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class StackForCreate {
	@JsonProperty("stack_name")
	private String name;
	@JsonProperty("timeout_mins")
	private String timeout;
	//@JsonProperty("disable_rollback")
	//private boolean disableRollback;
	private String template;
	private Map<String,String> parameters;
	
	
	public StackForCreate(String name, Map<String, String> parameters, String template ,String keyName) {
		super();
		this.name = name;
		this.timeout = "10";
		//this.disableRollback = true;
		this.parameters = new HashMap<String,String>(parameters);
		this.parameters.put("KeyName", keyName);
		this.template = template;
	}
	
	public StackForCreate(String name, String timeout, boolean disableRollback,
			Map<String, String> parameters, String template ,String keyName) {
		super();
		this.name = name;
		this.timeout = timeout;
		//this.disableRollback = disableRollback;
		this.parameters = new HashMap<String,String>(parameters);
		this.parameters.put("KeyName", keyName);
		this.template = template;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
//	public boolean isDisableRollback() {
//		return disableRollback;
//	}
//	public void setDisableRollback(boolean disableRollback) {
//		this.disableRollback = disableRollback;
//	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	public void setKeyName(String keyName){
		this.parameters.put("KeyName", keyName);
	}
	public String getKeyName(){
		return this.parameters.get("KeyName");
	}
	public void setInstanceType(String instanceType){
		this.parameters.put("InstanceType", instanceType);
	}
	public String getInstanceType(){
		return this.parameters.get("InstanceType");
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	/*@Override
	public String toString() {
		return "{name=" + name + ", timeout=" + timeout
				+ ", disableRollback=" + disableRollback + ", parameters="
				+ parameters + ", template=" + template + "}";
	}*/
}
