package com.woorea.openstack.ceilometer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.woorea.openstack.base.client.OpenStackRequest;

public abstract class QueriableCeilometerCommand<T,R> extends OpenStackRequest<R> {
	
	protected List<String> fields = new ArrayList<String>();
	
	protected List<String> ops = new ArrayList<String>();
	
	protected List<Serializable> values = new ArrayList<Serializable>();
	
	private T filter(String field, String op, Serializable value) {
		fields.add(field);
		ops.add(op);
		values.add(value);
		return (T) this;
	}
	
	public T lt(String field, Serializable value) {
		return filter(field, "lt", value);
	}
	
	public T le(String field, Serializable value) {
		return filter(field, "le", value);
	}
	
	public T eq(String field, Serializable value) {
		return filter(field, "eq", value);
	}
	
	public T ne(String field, Serializable value) {
		return filter(field, "ne", value);
	}
	
	public T ge(String field, Serializable value) {
		return filter(field, "ge", value);
	}
	
	public T gt(String field, Serializable value) {
		return filter(field, "gt", value);
	}

	/*
	public WebTarget query(WebTarget target) {
		if(fields.size() > 0) {
			target = target.queryParam("q.field", fields.toArray());
			target = target.queryParam("q.op", ops.toArray());
			target = target.queryParam("q.value", values.toArray());
		}
		return target;
	}
	*/
}
