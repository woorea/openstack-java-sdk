package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Server;
import com.woorea.openstack.nova.model.ServerForCreate;
import com.woorea.openstack.nova.model.Servers;
import com.woorea.openstack.nova.model.VolumeAttachment;
import com.woorea.openstack.nova.model.Server.Addresses;
import com.woorea.openstack.nova.model.ServerAction.ChangePassword;
import com.woorea.openstack.nova.model.ServerAction.ConfirmResize;
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
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).toString(), null, Server.class);
		}

	}
	
	public class ShowMetadata extends OpenStackRequest<Metadata> {
		
		public ShowMetadata(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).append("/metadata").toString(), null, Metadata.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/servers/").append(id).toString(), null, Void.class);
		}
		
	}
	
	public class ShowServerAddresses extends OpenStackRequest<Addresses> {

		public ShowServerAddresses(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).append("/ips").toString(), null, Addresses.class);
		}

	}

	public class UpdateServer extends OpenStackRequest {

		private Server server;
		
		public UpdateServer(String id, Server server) {
			super(CLIENT, HttpMethod.PUT, new StringBuilder("/servers/").append(id).toString(), Entity.json(server), Server.class);
			this.server = server;
		}

	}
	
	public abstract class Action<T> extends OpenStackRequest<T> {

		public Action(String id, Entity<?> entity, Class<T> returnType) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/").append(id).append("/action").toString(), entity, returnType);
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
	
	//
	
	public class StartServer extends OpenStackRequest {
		
		private Start action;

		private String id;
		
		public StartServer(String id) {
			this.id = id;
			this.action = new Start();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public class StopServer extends OpenStackRequest {
		
		private Stop action;

		private String id;
		
		public StopServer(String id) {
			this.id = id;
			this.action = new Stop();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public StartServer start(String id) {
		return new StartServer(id);
	}
	
	public StopServer stop(String id) {
		return new StopServer(id);
	}

	public static class GetVncConsoleServer extends OpenStackRequest {
		
		private GetVncConsole action;

		private String id;
		
		public GetVncConsoleServer(String id, GetVncConsole action) {
			this.id = id;
			this.action = action;
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		    returnType(VncConsole.class);
		}

	}
	
	public static GetVncConsoleServer getVncConsole(String id, String type) {
		GetVncConsole action = new GetVncConsole(type);
		return new GetVncConsoleServer(id, action);
	}
	
	public static class GetConsoleOutputServer extends OpenStackRequest {
		
		private GetConsoleOutput action;

		private String id;
		
		public GetConsoleOutputServer(String id, GetConsoleOutput action) {
			this.id = id;
			this.action = action;
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public static GetConsoleOutputServer getConsoleOutput(String id, int length) {
		GetConsoleOutput action = new GetConsoleOutput(length);
		return new GetConsoleOutputServer(id, action);
	}
	
	public class PauseServer extends OpenStackRequest {
		
		private Pause action;

		private String id;
		
		public PauseServer(String id) {
			this.id = id;
			this.action = new Pause();
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public class UnpauseServer extends OpenStackRequest {
		
		private Unpause action;

		private String id;
		
		public UnpauseServer(String id) {
			this.id = id;
			this.action = new Unpause();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}


	}

	public class LockServer extends OpenStackRequest {
		
		private Lock action;

		private String id;
		
		public LockServer(String id) {
			this.id = id;
			this.action = new Lock();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class UnlockServer extends OpenStackRequest {
		
		private Unlock action;

		private String id;
		
		public UnlockServer(String id) {
			this.id = id;
			this.action = new Unlock();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class SuspendServer extends OpenStackRequest {
		
		private Suspend action;

		private String id;
		
		public SuspendServer(String id) {
			this.id = id;
			this.action = new Suspend();
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class ResumeServer extends OpenStackRequest {
		
		private Resume action;

		private String id;
		
		public ResumeServer(String id) {
			this.id = id;
			this.action = new Resume();
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class CreateBackupServer extends OpenStackRequest {
		
		private	CreateBackup action;

		private String id;
		
		public CreateBackupServer(String id, CreateBackup action) {
			this.id = id;
			this.action = action;
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
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
	
	public class RescueServer extends OpenStackRequest {
		
		private Rescue action;

		private String id;
		
		public RescueServer(String id, Rescue action) {
			this.id = id;
			this.action = action;
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class UnrescueServer extends OpenStackRequest {
		
		private Unrescue action;
		
		public UnrescueServer(String id) {
			
			this.action = new Unrescue();
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}
		
	}
	
	public RescueServer rescue(String serverId, String adminPass) {
		Rescue action = new Rescue(adminPass);
		return new RescueServer(serverId, action);
	}
	
	public UnrescueServer unrescue(String serverId) {
		return new UnrescueServer(serverId);
	}
	
	public static class AssociateFloatingIp extends OpenStackRequest {
		
		private com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action;

		private String id;
		
		public AssociateFloatingIp(String id, com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action) {
			this.action = action;
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public static class DisassociateFloatingIp extends OpenStackRequest {
		
		private com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action;
		
		public DisassociateFloatingIp(String id, com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action) {
			this.action = action;
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public static AssociateFloatingIp associateFloatingIp(String serverId, String floatingIpAddress) {
		com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action = new com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp(floatingIpAddress);
		return new AssociateFloatingIp(serverId, action);
	}
	
	public static DisassociateFloatingIp disassociateFloatingIp(String serverId, String floatingIpAddress) {
		com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action = new com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp(floatingIpAddress);
		return new DisassociateFloatingIp(serverId, action);
	}
	
	public  class AttachVolume extends OpenStackRequest<Void> {
		
		private String serverId;
		
		private VolumeAttachment volumeAttachment;
		
		public AttachVolume(String serverId, String volumeId, String device) {
			this.serverId = serverId;
			volumeAttachment = new VolumeAttachment();
			volumeAttachment.setVolumeId(volumeId);
			volumeAttachment.setDevice(device);
//			target.path("servers").path(serverId).path("os-volume_attachments").request(MediaType.APPLICATION_JSON).post(Entity.json(volumeAttachment));
		}

	}
	
	public class DetachVolume extends OpenStackRequest<Void> {
		
		private String serverId;
		
		private String volumeId;
		
		public DetachVolume(String serverId, String volumeId) {
			this.serverId = serverId;
			this.volumeId = volumeId;

//			target.path("servers").path(serverId).path("os-volume_attachments").path(volumeId).request(MediaType.APPLICATION_JSON).delete();
		}

	}

	public AttachVolume attachVolume(String serverId, String volumeId, String device) {
		return new AttachVolume(serverId, volumeId, device);
	}
	
	public DetachVolume detachVolume(String serverId, String volumeId) {
		return new DetachVolume(serverId, volumeId);
	}
	
}

