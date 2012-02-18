package org.openstack.client.common;

import java.util.Iterator;
import java.util.List;

import org.openstack.model.atom.Link;
import org.openstack.model.common.PagingListBase;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.sun.jersey.api.client.Client;

/**
 * 
 * @author justinsb
 * 
 * @param <M>
 *            Model class
 * @param <R>
 *            Representation class
 */
public abstract class PagingList<M, R> implements Iterable<R> {
    protected final Client client;
    private final PagingListBase<M> page;

    public PagingList(Client client, PagingListBase<M> page) {
        this.client = client;
        this.page = page;
    }

    @Override
    public Iterator<R> iterator() {
        return Iterators.transform(getModelsIterator(), new Function<M, R>() {
            @Override
            public R apply(M model) {
                return mapToRepresentation(model);
            }
        });
    }

    public List<R> asList() {
        return Lists.newArrayList(this);
    }

    public Iterable<M> asModels() {
        return new ModelsCollection();
    }

    Iterator<M> getModelsIterator() {
        return new ModelIterator(this);
    }

    class ModelsCollection implements Iterable<M> {

        @Override
        public Iterator<M> iterator() {
            return getModelsIterator();
        }
    }

    public PagingList<M, R> getNextPage() {
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
        PagingList<M, R> currentPage;
        Iterator<M> items;

        public ModelIterator(PagingList<M, R> startPage) {
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

    protected abstract R mapToRepresentation(M model);

}
