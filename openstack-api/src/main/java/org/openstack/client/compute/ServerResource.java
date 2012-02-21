package org.openstack.client.compute;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.client.compute.ext.ComputeResourceBase;
import org.openstack.client.compute.ext.FloatingIpsResource;
import org.openstack.client.compute.ext.SecurityGroupsResource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.server.action.AddFixedIpAction;
import org.openstack.model.compute.server.action.AddFloatingIpAction;
import org.openstack.model.compute.server.action.ChangePasswordAction;
import org.openstack.model.compute.server.action.ConfirmResizeAction;
import org.openstack.model.compute.server.action.Console;
import org.openstack.model.compute.server.action.CreateBackupAction;
import org.openstack.model.compute.server.action.ForceDeleteAction;
import org.openstack.model.compute.server.action.GetConsoleOutputAction;
import org.openstack.model.compute.server.action.GetVncConsoleAction;
import org.openstack.model.compute.server.action.InjectNetworkInfoAction;
import org.openstack.model.compute.server.action.LockAction;
import org.openstack.model.compute.server.action.MigrateAction;
import org.openstack.model.compute.server.action.Output;
import org.openstack.model.compute.server.action.PauseAction;
import org.openstack.model.compute.server.action.RebootAction;
import org.openstack.model.compute.server.action.RebuildAction;
import org.openstack.model.compute.server.action.RemoveFixedIpAction;
import org.openstack.model.compute.server.action.RemoveFloatingIpAction;
import org.openstack.model.compute.server.action.ResetNetworkAction;
import org.openstack.model.compute.server.action.ResizeAction;
import org.openstack.model.compute.server.action.RestoreAction;
import org.openstack.model.compute.server.action.ResumeAction;
import org.openstack.model.compute.server.action.RevertResize;
import org.openstack.model.compute.server.action.SuspendAction;
import org.openstack.model.compute.server.action.UnlockAction;
import org.openstack.model.compute.server.action.UnpauseAction;

public class ServerResource extends ComputeResourceBase {

	private Server representation;

	public static class IpsResource extends Resource {

		public String list(String networkId) {
			return resource("ips").get(String.class);
		}

	}

	public ServerResource get(boolean eager) {
		representation = resource().get(Server.class);
		if (eager) {
			representation.setImage(getImage().get().show());
			representation.setFlavor(getFlavor().get().show());
		}
		return this;
	}

	public ServerResource get() {
		return get(false);
	}

	public ImageResource getImage() {
		if (representation == null) {
			get();
		}
		Image image = representation.getImage();
		return image != null ? new ImageResource(session, image) : null;
	}

	public FlavorResource getFlavor() {
		if (representation == null) {
			get();
		}
		Flavor flavor = representation.getFlavor();
		return flavor != null ? new FlavorResource(session, flavor) : null;
	}

	public Server show() {
		if (representation == null) {
			get();
		}
		return representation;
	}

	public Server update(Server server) {
		return put(Server.class, server);
	}

	public void delete() {
		resource().delete();
	}

	/**
	 * Restore a previously deleted instance.
	 * 
	 */
	public void restore() {
		executeAction(String.class, new RestoreAction());
	}

	/**
	 * Force delete of instance before deferred cleanup.
	 * 
	 */
	public void forceDelete() {
		executeAction(String.class, new ForceDeleteAction());
	}

	/**
	 * Update the password for a server.
	 * 
	 * @param adminPass
	 */
	public void changePassword(String adminPass) {
		ChangePasswordAction changePasswordAction = new ChangePasswordAction();
		changePasswordAction.setAdminPass(adminPass);
		executeAction(String.class, changePasswordAction);
	}

	/**
	 * Reboot a server.
	 * 
	 * @param type
	 *            either REBOOT_SOFT for a software-level reboot, or REBOOT_HARD for a virtual power cycle hard reboot.
	 */
	public void reboot(String type) {
		RebootAction rebootAction = new RebootAction();
		executeAction(String.class, rebootAction);
	}

	/**
	 * Rebuild -- shut down and then re-image -- a server.
	 * 
	 * @param rebuildAction
	 */
	public void rebuild(RebuildAction rebuildAction) {
		executeAction(String.class, rebuildAction);
	}

	public void resize(ResizeAction resizeAction) {
		executeAction(String.class, resizeAction);
	}

	/**
	 * Confirm that the resize worked, thus removing the original server.
	 * 
	 */
	public void confirmResize() {
		executeAction(String.class, new ConfirmResizeAction());
	}

	/**
	 * Revert a previous resize, switching back to the old server.
	 * 
	 */
	public void revertResize() {
		executeAction(String.class, new RevertResize());
	}

	/**
	 * Snapshot a server.
	 * 
	 * @param name
	 *            Name to give the snapshot image
	 * @param metadata
	 *            to give newly-created image entity
	 * 
	 */
	public void createImage(String name, Map<String, String> metadata) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public void pause() {
		executeAction(String.class, new PauseAction());
	}

	public void unpause() {
		executeAction(String.class, new UnpauseAction());
	}

	public void suspend() {
		executeAction(String.class, new SuspendAction());
	}

	public void resume() {
		executeAction(String.class, new ResumeAction());
	}

	/**
	 * Resize a server's resources.
	 * 
	 * flavor: the :class:`Flavor` (or its ID) to resize to.
	 * 
	 * Until a resize event is confirmed with :meth:`confirm_resize`, the old server will be kept around and you'll be
	 * able to roll back to the old flavor quickly with :meth:`revert_resize`. All resizes are automatically confirmed
	 * after 24 hours.
	 */
	public void resize(String flavorId) {
		ResizeAction resizeAction = new ResizeAction();
		// resizeAction.setAutoDiskConfig(autoDiskConfig);
		resizeAction.setFlavorRef(flavorId);
		executeAction(String.class, resizeAction);
	}

	/**
	 * Migrate a server to a new host in the same zone.
	 * 
	 */
	public void migrate() {
		executeAction(String.class, new MigrateAction());
	}

	public void resetNetwork() {
		executeAction(String.class, new ResetNetworkAction());
	}

	public void injectNetworkInfo() {
		executeAction(String.class, new InjectNetworkInfoAction());
	}

	public void lock() {
		executeAction(String.class, new LockAction());
	}

	public void unlock() {
		executeAction(String.class, new UnlockAction());
	}

	/**
	 * Allow Admins to view pending server actions
	 * 
	 * @return
	 */
	public String pendingActions() {
		return resource("actions").get(String.class);
	}

	public String virtualInterfaces() {
		return resource("os-virtual-interfaces").get(String.class);
	}

	public void createBackup(CreateBackupAction createBackupAction) {

	}

	/**
	 * Allow Admins to view server diagnostics through server action
	 * 
	 * @return
	 */
	public String diagnostics() {
		return resource("diagnostics").get(String.class);
	}

	public IpsResource ips() {
		return getChildResource("ips", IpsResource.class);
	}

	public MetadataResource metadata() {
		return getChildResource("metadata", MetadataResource.class);
	}

	/**
	 * Adds an IP on a given network to an instance.
	 * 
	 * @return
	 */
	public String addFixedIp(String networkId) {
		AddFixedIpAction addFixedIpAction = new AddFixedIpAction();
		addFixedIpAction.setNetworkId(networkId);
		return executeAction(String.class, addFixedIpAction);
	}

	/**
	 * Removes an IP from an instance.
	 * 
	 * @return
	 */
	public String removeFixedIp(String address) {
		RemoveFixedIpAction removeFixedIpAction = new RemoveFixedIpAction();
		removeFixedIpAction.setAddress(address);
		return executeAction(String.class, removeFixedIpAction);
	}

	/**
	 * Attaches a floating IP to the instance.
	 */
	public void addFloatingIp(String ip) {
		AddFloatingIpAction action = new AddFloatingIpAction();
		action.setAddress(ip);
		executeAction(String.class, action);
	}

	/**
	 * Detaches a floating IP from the instance
	 */
	public void removeFloatingIp(String ip) {
		RemoveFloatingIpAction action = new RemoveFloatingIpAction();
		action.setAddress(ip);
		executeAction(String.class, action);
	}

	/**
	 * Get text console log output from Server.
	 * 
	 * @return
	 */
	public Console getVncConsole(String type) {
		GetVncConsoleAction action = new GetVncConsoleAction();
		action.setType(type);
		Console console = executeAction(Console.class, action);
		return console;
	}

	/**
	 * Get text console output.
	 * 
	 * @return
	 */
	public String getConsoleOutput(Integer length) {
		GetConsoleOutputAction action = new GetConsoleOutputAction();
		action.setLength(length);
		Output output = executeAction(Output.class, action);
		return output.getContent();
	}

	private <T> T executeAction(Class<T> c, Object action) {
		return resource("action").type(MediaType.APPLICATION_XML).post(c, action);
	}

	public void createAttachment() {
		// "os-volume_attachments"
	}

	public void delteAttachment() {
		// "os-volume_attachments"
	}

	public FloatingIpsResource floatingIps() {
		return getChildResource("os-floating-ips", FloatingIpsResource.class);
	}

	public ConsolesResource consoles() {
		return getChildResource("consoles", ConsolesResource.class);
	}

	public SecurityGroupList listSecurityGroups() {
		return getChildResource("os-security-groups", SecurityGroupsResource.class).list();
	}

}
