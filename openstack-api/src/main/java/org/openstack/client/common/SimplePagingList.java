package org.openstack.client.common;

import java.util.Iterator;
import java.util.List;

import org.openstack.model.atom.Link;
import org.openstack.model.common.PagingListBase;

import com.google.common.collect.Lists;
import com.sun.jersey.api.client.Client;

/**
 * 
 * @author justinsb
 * 
 * @param <M>
 *            Model class
 */
public class SimplePagingList<M> implements Iterable<M> {
    protected final OpenstackSession session;
    private final PagingListBase<M> page;

    public SimplePagingList(OpenstackSession session, PagingListBase<M> page) {
        this.session = session;
        this.page = page;
    }

    @Override
    public Iterator<M> iterator() {
        return new ModelIterator(this);
    }

    public List<M> asList() {
        return Lists.newArrayList(this);
    }

    public SimplePagingList<M> getNextPage() {
        List<Link> links = page.getLinks();
        if (links == null || links.isEmpty())
            return null;
        // TODO: Make an abstract method once we have an example!
        throw new UnsupportedOperationException();
        // FlavorList tenantList = client.resource(
        // model.getLinks().get(0).getHref()).get(FlavorList.class);
        // return new FlavorsRepresentation(client, tenantList);
    }

    class ModelIterator implements Iterator<M> {
        SimplePagingList<M> currentPage;
        Iterator<M> items;

        public ModelIterator(SimplePagingList<M> startPage) {
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
                items = currentPage.page.iterateItemsOnPage();
            }

            if (items != null) {
                return items.hasNext();
            }

            return false;
        }

        @Override
        public M next() {
            return items.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }


}
