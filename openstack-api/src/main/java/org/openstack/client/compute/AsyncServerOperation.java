/*
 * Copyright (c) 2011 Justin Santa Barbara
 *
 *    Licensed under the Apache License, Version 2.0 (the "License"); you may
 *    not use this file except in compliance with the License. You may obtain
 *    a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *    License for the specific language governing permissions and limitations
 *    under the License.
 */
package org.openstack.client.compute;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import org.openstack.client.OpenstackException;
import org.openstack.client.OpenstackNotFoundException;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.Server;

public class AsyncServerOperation implements Future<Server> {
    static final Logger log = Logger.getLogger(AsyncServerOperation.class.getName());

    private static final int POLL_INTERVAL_MILLISECONDS = 5000;

    final Server returnValue;
    final String serverId;

    final Collection<String> acceptableTransitionStates;
    final Collection<String> finishStates;

    final OpenstackComputeClient client;

    volatile boolean cancelled;
    volatile boolean done;

    public AsyncServerOperation(OpenstackComputeClient client, Server returnValue, String serverId, Collection<String> acceptableTransitionStates, Collection<String> finishStates) {
        super();
        this.client = client;
        this.returnValue = returnValue;
        this.serverId = serverId;
        this.acceptableTransitionStates = acceptableTransitionStates;
        this.finishStates = finishStates;
    }

    Server waitForState(long timeout, TimeUnit unit) throws OpenstackException {
        try {
            long timeoutAt = unit != null ? System.currentTimeMillis() + unit.toMillis(timeout) : Long.MAX_VALUE;
            while (true) {
                Server server = null;
                String status;
                try {
                    server = client.root().servers().server(serverId).show();
                    status = server.getStatus();
                } catch (OpenstackNotFoundException e) {
                    // Treat as DELETED
                    status = "DELETED";
                }

                // Some versions (Diablo?) would return additional information in the status
                // e.g. BUILD(networking).  We need to split this out.
                String subStatus = null;
                if (status.contains("(")) {
					int leftBracketIndex = status.indexOf('(');
					int rightBracketIndex = status.indexOf(')');
					if (leftBracketIndex != -1 && rightBracketIndex > leftBracketIndex) {
						subStatus = status.substring(leftBracketIndex + 1, rightBracketIndex);
						status = status.substring(0, leftBracketIndex);
					}
                }

                if (finishStates.contains(status)) {
                    log.fine("Finished polling; server status is " + status + " progess=" + server.getProgress());
                    return server;
                }

                if (!acceptableTransitionStates.contains(status)) {
                    throw new OpenstackException("Server is in unexpected state: " + status);
                }

                if (server != null) {
                    log.fine("Continuing polling; server status is " + status + " progess=" + server.getProgress());
                } else {
                    log.fine("Continuing polling; server is not found (treated as DELETED)");
                }

                if (System.currentTimeMillis() > timeoutAt)
                    throw new OpenstackException("Server did not transition to expected state within timeout");

                try {
                	Thread.sleep(POLL_INTERVAL_MILLISECONDS);
                } catch (InterruptedException e) {
					throw new OpenstackException(e.getMessage(), e);
				}
                
            }
        } finally {
            done = true;
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Server get() {
        try {
            return get(0, null);
        } catch (Exception e) {
            // TimeoutException shouldn't happen without a timeout specified!!
            throw new OpenstackException("Unexpected error", e);
        }
    }

    @Override
    public Server get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        try {
            return waitComplete(timeout, unit);
        } catch (OpenstackException e) {
            throw new ExecutionException("Error with OpenStack", e);
        }
    }

    /**
     * This method throws OpenStackComputeException instead of wrapping it in ExecutionException
     * 
     * @throws OpenstackException
     */
    public Server waitComplete(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException, OpenstackException {
        return this.waitForState(timeout, unit);
    }

    /**
     * This method throws OpenStackComputeException instead of wrapping it in ExecutionException
     */
    public Server waitComplete() throws InterruptedException, OpenstackException {
        try {
            return waitComplete(0, null);
        } catch (TimeoutException e) {
            // Shouldn't happen without a timeout specified!!
            throw new IllegalStateException("Unexpected timeout error", e);
        }
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    /**
     * The server that was initially returned by the initial async call
     * 
     * @return
     */
    public Server getReturnedServer() {
        return returnValue;
    }
}
