package org.openstack.client.imagestore;

import java.util.Iterator;
import java.util.List;

import org.openstack.model.atom.Link;
import org.openstack.model.common.PagingListBase;

import com.sun.jersey.api.client.Client;

public class PagingList<T> implements Iterable<T> {
    private final Client client;
    private final PagingListBase<T> list;

    public PagingList(Client client, PagingListBase<T> list) {
        this.client = client;
        this.list = list;
    }

    @Override
    public Iterator<T> iterator() {
        return new PagingListIterator<T>(this);
    }

    public PagingList<T> getNextPage() {
        List<Link> links = list.getLinks();
        if (links == null || links.isEmpty())
            return null;
        throw new UnsupportedOperationException();
        // FlavorList tenantList = client.resource(
        // model.getLinks().get(0).getHref()).get(FlavorList.class);
        // return new FlavorsRepresentation(client, tenantList);
    }

    static class PagingListIterator<T> implements Iterator<T> {
        PagingList<T> currentPage;
        Iterator<T> items;

        public PagingListIterator(PagingList<T> startPage) {
            this.currentPage = startPage;
            this.items = null;
        }

        @Override
        public boolean hasNext() {
            if (items != null) {
                if (!items.hasNext()) {
                    items = null;
                    if (currentPage != null)
                        currentPage = currentPage.getNextPage();
                }
            }

            if (items == null && currentPage != null) {
                items = currentPage.list.iterateItemsOnPage();
            }

            if (items != null) {
                return items.hasNext();
            }

            return false;
        }

        @Override
        public T next() {
            return items.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
