package org.openstack.client.compute;

import org.openstack.client.compute.ext.ComputeResourceBase;
import org.openstack.model.compute.server.Server;
import org.openstack.model.compute.server.ServerForCreate;
import org.openstack.model.compute.server.ServerList;

import com.sun.jersey.api.client.WebResource.Builder;

public class ServersResource extends ComputeResourceBase {

    /**
     * Returns a list of server names and ids for a given user
     * 
     * Returns a list of servers, taking into account any search options specified.
     * 
     * If detail is true:
     * 
     * Returns a list of server details for a given user
     * 
     * @param detail
     * @return
     */
    public ServersRepresentation list(boolean detail) {
        Builder r = detail ? resource("detail") : resource();
        ServerList list = r.get(ServerList.class);

        return new ServersRepresentation(client, list);
    }

    public ServersRepresentation list() {
        return list(true);
    }

    public Server create(ServerForCreate serverForCreate) {
        return post(Server.class, serverForCreate);

        // Server server = client.resource(resource)
        // .accept(MediaType.APPLICATION_XML)
        // .type(MediaType.APPLICATION_XML)
        // .post(Server.class, serverForCreate);
        // return new ServerRepresentation(client, server);
    }

    public ServerResource server(String id) {
        return buildChildResource(id, ServerResource.class);
    }

    /**
     * Rescue an instance.
     * 
     * @return
     */
    public String rescue() {
        return null;
    }

    /**
     * Rescue an instance.
     * 
     * @return
     */
    public String unrescue() {
        return null;
    }

    /**
     * Permit Admins to pause the server
     * 
     * @return
     */
    public String pause() {
        return null;
    }

    /**
     * Permit Admins to unpause the server
     * 
     * @return
     */
    public String unpause() {
        return null;
    }

    /**
     * Permit Admins to suspend the server
     * 
     * @return
     */
    public String suspend() {
        return null;
    }

    /**
     * Permit admins to resume the server from suspend
     * 
     * @return
     */
    public String resume() {
        return null;
    }

    /**
     * Permit admins to migrate a server to a new host
     * 
     * @return
     */
    public String migrate() {
        return null;
    }

    /**
     * Permit admins to reset networking on an server
     * 
     * @return
     */
    public String resetNetwork() {
        return null;
    }

    /**
     * Permit admins to inject network info into a server
     * 
     * @return
     */
    public String injectNetworkInfo() {
        return null;
    }

    /**
     * Permit admins to lock a server
     * 
     * @return
     */
    public String lock() {
        return null;
    }

    /**
     * Permit admins to unlock a server
     * 
     * @return
     */
    public String unlock() {
        return null;
    }

    /**
     * Backup a server instance.
     * 
     * Images now have an `image_type` associated with them, which can be 'snapshot' or the backup type, like 'daily' or 'weekly'.
     * 
     * If the image_type is backup-like, then the rotation factor can be included and that will cause the oldest backups that exceed the rotation factor to be deleted.
     * 
     * @return
     */
    public String backup() {
        return null;
    }

}
