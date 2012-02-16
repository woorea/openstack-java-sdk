package org.openstack.model.common;

import java.util.Iterator;

public abstract class PagingListBase<T> extends ListWithAtomLinks {
    public abstract Iterator<T> iterateItemsOnPage();
}
