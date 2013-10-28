package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Server;
import com.woorea.openstack.nova.model.Server.Addresses;
import com.woorea.openstack.nova.model.ServerAction.ChangePassword;
import com.woorea.openstack.nova.model.ServerAction.ConfirmResize;
import com.woorea.openstack.nova.model.ServerAction.ConsoleOutput;
import com.woorea.openstack.nova.model.ServerAction.CreateBackup;
import com.woorea.openstack.nova.model.ServerAction.CreateImage;
import com.woorea.openstack.nova.model.ServerAction.GetConsoleOutput;
import com.woorea.openstack.nova.model.ServerAction.GetVncConsole;
import com.woorea.openstack.nova.model.ServerAction.Lock;
import com.woorea.openstack.nova.model.ServerAction.Pause;
import com.woorea.openstack.nova.model.ServerAction.Reboot;
import com.woorea.openstack.nova.model.ServerAction.Rebuild;
import com.woorea.openstack.nova.model.ServerAction.Rescue;
import com.woorea.openstack.nova.model.ServerAction.Resize;
import com.woorea.openstack.nova.model.ServerAction.Resume;
import com.woorea.openstack.nova.model.ServerAction.RevertResize;
import com.woorea.openstack.nova.model.ServerAction.Start;
import com.woorea.openstack.nova.model.ServerAction.Stop;
import com.woorea.openstack.nova.model.ServerAction.Suspend;
import com.woorea.openstack.nova.model.ServerAction.Unlock;
import com.woorea.openstack.nova.model.ServerAction.Unpause;
import com.woorea.openstack.nova.model.ServerAction.Unrescue;
import com.woorea.openstack.nova.model.ServerAction.VncConsole;
import com.woorea.openstack.nova.model.ServerForCreate;
import com.woorea.openstack.nova.model.Servers;
import com.woorea.openstack.nova.model.VolumeAttachment;
import com.woorea.openstack.nova.model.VolumeAttachments;

public class ServersResource {

	private final OpenStackClient CLIENT;

	public ServersResource(OpenStackClient client) {
		CLIENT = client;
	}

	public List list(boolean detail) {
		return new List(detail);
	}

	public Boot boot(ServerForCreate server) {
		return new Boot(server);
	}

	public Show show(String id) {
		return new Show(id);
	}

	public ShowMetadata showMetadata(String id) {
		return new ShowMetadata(id);
	}
	
	public CreateOrUpdateMetadata createOrUpdateMetadata(String id,Metadata metadata) {
		return new CreateOrUpdateMetadata(id,metadata);
	}
	
	public ReplaceMetadata replaceMetadata(String id,Metadata metadata) {
		return new ReplaceMetadata(id,metadata);
	}


	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Servers> {

		public List(boolean detail) {
			super(CLIENT, HttpMethod.GET, detail ? "/servers/detail" : "/servers", null, Servers.class);
		}

	}

	public class Boot extends OpenStackRequest<Server> {

		private ServerForCreate server;

		public Boot(ServerForCreate server) {
			super(CLIENT, HttpMethod.POST, "/servers", Entity.json(server), Server.class);
			this.server = server;
		}

	}

	public class Show extends OpenStackRequest<Server> {

		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id), null, Server.class);
		}

	}

	public class ShowMetadata extends OpenStackRequest<Metadata> {

		public ShowMetadata(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).append("/metadata"), null, Metadata.class);
		}

	}
	
	public class CreateOrUpdateMetadata extends OpenStackRequest<Metadata> {

		public CreateOrUpdateMetadata(String id,Metadata metadata) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/metadata"), Entity.json(metadata), Metadata.class);
		}

	}
	public class ReplaceMetadata extends OpenStackRequest<Metadata> {

		public ReplaceMetadata(String id,Metadata metadata) {
			super(CLIENT, HttpMethod.PUT, new StringBuilder("/servers/").append(id).append("/metadata"), Entity.json(metadata), Metadata.class);
		}

	}
	
	
	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/servers/").append(id), null, Void.class);
		}

	}

	public class ShowServerAddresses extends OpenStackRequest<Addresses> {

		public ShowServerAddresses(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).append("/ips"), null, Addresses.class);
		}

	}

	public class UpdateServer extends OpenStackRequest<Server> {

		private Server server;

		public UpdateServer(String id, Server server) {
			super(CLIENT, HttpMethod.PUT, new StringBuilder("/servers/").append(id), Entity.json(server), Server.class);
			this.server = server;
		}

	}

	public abstract class Action<T> extends OpenStackRequest<T> {

		public Action(String id, Entity<?> entity, Class<T> returnType) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), entity, returnType);
		}

	}

	public class ChangePasswordAction extends Action<Server> {

		private ChangePassword action;

		public ChangePasswordAction(String id, ChangePassword action) {
			super(id, Entity.json(action), Server.class);
		}

	}

	public class RebootAction extends Action<Void> {

		private Reboot action;

		public RebootAction(String id, Reboot action) {
			super(id, Entity.json(action), Void.class);
		}

	}

	public class RebuildAction extends Action<Server> {

		private Rebuild action;

		public RebuildAction(String id, Rebuild action) {
			super(id, Entity.json(action), Server.class);
		}

	}

	public class ResizeAction extends Action<Server> {

		private Resize action;

		public ResizeAction(String id, Resize action) {
			super(id, Entity.json(action), Server.class);
		}

	}

	public class ConfirmResizeAction extends Action<Server> {

		public ConfirmResizeAction(String id) {
			super(id, Entity.json(new ConfirmResize()), Server.class);
		}

	}

	public class ReverResizeAction extends Action<Server> {

		public ReverResizeAction(String id) {
			super(id, Entity.json(new RevertResize()), Server.class);
		}

	}

	public class CreateImageAction extends Action<Server> {

		private CreateImage action;

		public CreateImageAction(String id) {
			super(id, Entity.json(new CreateImage()), Server.class);
		}

	}

	public class StartServer extends OpenStackRequest<Void> {

		private Start action;

		private String id;

		public StartServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Start()), Void.class);
		}

	}

	public class StopServer extends OpenStackRequest<Void> {

		private Stop action;

		private String id;

		public StopServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Stop()), Void.class);
		}

	}

	public StartServer start(String id) {
		return new StartServer(id);
	}

	public StopServer stop(String id) {
		return new StopServer(id);
	}

	public class GetVncConsoleServer extends OpenStackRequest<VncConsole> {

		private GetVncConsole action;

		private String id;

		public GetVncConsoleServer(String id, GetVncConsole action) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(action), VncConsole.class);
		}

	}

	public GetVncConsoleServer getVncConsole(String id, String type) {
		GetVncConsole action = new GetVncConsole(type);
		return new GetVncConsoleServer(id, action);
	}

	public class GetConsoleOutputServer extends OpenStackRequest<ConsoleOutput> {

		public GetConsoleOutputServer(String id, GetConsoleOutput action) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(action), ConsoleOutput.class);
		}

	}

	public GetConsoleOutputServer getConsoleOutput(String id, int length) {
		GetConsoleOutput action = new GetConsoleOutput(length);
		return new GetConsoleOutputServer(id, action);
	}

	public class PauseServer extends OpenStackRequest<Void> {

		public PauseServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Pause()), Void.class);
		}

	}

	public class UnpauseServer extends OpenStackRequest<Void> {

		public UnpauseServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Unpause()), Void.class);
		}


	}

	public class LockServer extends OpenStackRequest<Void> {

		private Lock action;

		private String id;

		public LockServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Lock()), Void.class);
		}

	}

	public class UnlockServer extends OpenStackRequest<Void> {

		private Unlock action;

		private String id;

		public UnlockServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Unlock()), Void.class);
		}

	}

	public class SuspendServer extends OpenStackRequest<Void> {

		public SuspendServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Suspend()), Void.class);
		}

	}

	public class ResumeServer extends OpenStackRequest<Void> {

		public ResumeServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Resume()), Void.class);
		}

	}

	public class CreateBackupServer extends OpenStackRequest<Void> {

		public CreateBackupServer(String id, CreateBackup action) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(action), Void.class);
		}

	}

	public PauseServer pause(String serverId) {
		return new PauseServer(serverId);
	}

	public UnpauseServer unpause(String serverId) {
		return new UnpauseServer(serverId);
	}

	public LockServer lock(String serverId) {
		return new LockServer(serverId);
	}

	public UnlockServer unlock(String serverId) {
		return new UnlockServer(serverId);
	}

	public SuspendServer suspend(String serverId) {
		return new SuspendServer(serverId);
	}

	public ResumeServer resume(String serverId) {
		return new ResumeServer(serverId);
	}

	public CreateBackupServer createBackup(String serverId, CreateBackup action) {
		return new CreateBackupServer(serverId, action);
	}

	public class RescueServer extends OpenStackRequest<Void> {

		public RescueServer(String id, Rescue action) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(action), Void.class);
		}

	}

	public class UnrescueServer extends OpenStackRequest<Void> {

		public UnrescueServer(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(new Unrescue()), Void.class);
		}

	}

	public RescueServer rescue(String serverId, String adminPass) {
		Rescue action = new Rescue(adminPass);
		return new RescueServer(serverId, action);
	}

	public UnrescueServer unrescue(String serverId) {
		return new UnrescueServer(serverId);
	}

	public class AssociateFloatingIp extends OpenStackRequest<Void> {

		public AssociateFloatingIp(String id, com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(action), Void.class);
		}

	}

	public class DisassociateFloatingIp extends OpenStackRequest<Void> {

		public DisassociateFloatingIp(String id, com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action"), Entity.json(action), Void.class);
		}

	}

	public AssociateFloatingIp associateFloatingIp(String serverId, String floatingIpAddress) {
		com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action = new com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp(floatingIpAddress);
		return new AssociateFloatingIp(serverId, action);
	}

	public DisassociateFloatingIp disassociateFloatingIp(String serverId, String floatingIpAddress) {
		com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action = new com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp(floatingIpAddress);
		return new DisassociateFloatingIp(serverId, action);
	}

	public  class AttachVolume extends OpenStackRequest<Void> {

		public AttachVolume(String serverId, final VolumeAttachment volumeAttachment) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(serverId).append("/os-volume_attachments"), Entity.json(volumeAttachment), Void.class);
		}

	}

	public class DetachVolume extends OpenStackRequest<Void> {

		public DetachVolume(String serverId, String volumeId) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/servers/").append(serverId).append("/os-volume_attachments/").append(volumeId), null, Void.class);
		}

	}

	public  class ListVolumeAttachments extends OpenStackRequest<VolumeAttachments> {

		public ListVolumeAttachments(String serverId) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(serverId).append("/os-volume_attachments"), null, VolumeAttachments.class);
		}

	}

	public  class ShowVolumeAttachment extends OpenStackRequest<VolumeAttachment> {

		public ShowVolumeAttachment(String serverId, String volumeAttachmentId) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(serverId).append("/os-volume_attachments/").append(volumeAttachmentId), null, VolumeAttachment.class);
		}

	}

	public AttachVolume attachVolume(String serverId, String volumeId, String device) {
		VolumeAttachment volumeAttachment = new VolumeAttachment();
		volumeAttachment.setVolumeId(volumeId);
		volumeAttachment.setDevice(device);
		return new AttachVolume(serverId, volumeAttachment);
	}

	public DetachVolume detachVolume(String serverId, String volumeId) {
		return new DetachVolume(serverId, volumeId);
	}

	public ListVolumeAttachments listVolumeAttachments(String serverId) {
		return new ListVolumeAttachments(serverId);
	}

	public ShowVolumeAttachment showVolumeAttachment(String serverId, String volumeAttachmentId) {
		return new ShowVolumeAttachment(serverId, volumeAttachmentId);
	}

}

