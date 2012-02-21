package org.openstack.model.common;

import java.util.Iterator;

public abstract class PagingListBase<T> extends ListWithAtomLinks {
	public abstract Iterator<T> iterateItemsOnPage();
	
	// Note: It's not safe to give access to the items on the page
	// because otherwise callers will invariably forget to page.
	// Wrap these objects in e.g. SimplePagingList
	
}
