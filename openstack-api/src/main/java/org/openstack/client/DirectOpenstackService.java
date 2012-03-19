//package org.openstack.client;
//import java.util.Map;
//
//import org.openstack.api.compute.ComputeResource;
//import org.openstack.api.imagestore.GlanceRootResource;
//import org.openstack.model.common.OpenstackService;
//import org.openstack.model.compute.NovaFlavor;
//import org.openstack.model.compute.NovaImage;
//
//import com.google.common.collect.Maps;
// 
//public class DirectOpenstackService implements OpenstackService {
//	final OpenStackSession session;
//	final Map<Object, Object> extensions = Maps.newHashMap();
// 
//	public DirectOpenstackService(OpenStackSession session) {
//		super();
//		this.session = session;
//	}
// 
//	private ComputeResource computeRoot() {
//		return session.getComputeClient().root();
//	}
// 
//	private GlanceRootResource imageRoot() {
//		return session.getImageClient().root();
//	}
// 
//	@Override
//	public Map<Object, Object> getExtensions() {
//		return extensions;
//	}
// 
//	
//	public <T> Iterable<T> listItems(Class<T> itemClass, boolean details) {
//		/*
//		if (itemClass == NovaServer.class) {
//			return (Iterable<T>) computeRoot().servers().list(details);
//		}
// 
//		if (itemClass == NovaImage.class) {
//			return (Iterable<T>) computeRoot().images().list();
//		}
// 
//		if (itemClass == NovaSecurityGroup.class) {
//			return (Iterable<T>) computeRoot().securityGroups().list().getList();
//		}
// 
//		if (itemClass == NovaKeyPair.class) {
//			return (Iterable<T>) computeRoot().keyPairs().list();
//		}
// 
//		if (itemClass == org.openstack.model.image.GlanceImage.class) {
//			return (Iterable<T>) imageRoot().images().list(true);
//		}
// 
//		if (itemClass == NovaFlavor.class) {
//			return (Iterable<T>) computeRoot().flavors().list(true);
//		}
// 
//		if (itemClass == KeyStoneService.class) {
//			return (Iterable<T>) session.getData().getAccess().getServiceCatalog();
//		}
// 
//		if (itemClass == Extension.class) {
//			return (Iterable<T>) computeRoot().extensions().list();
//		}
// 
//		if (itemClass == NovaFloatingIp.class) {
//			return (Iterable<T>) computeRoot().floatingIps().list();
//		}
// 
//		throw new IllegalArgumentException("Unknown type: " + itemClass);
//		*/
//		return null;
//	}
// 
//	@Override
//	public OpenstackStorageClient getStorageClient() {
//		//return session.getStorageClient();
//		return null;
//	}
// 
//	@Override
//	public OpenstackComputeClient getComputeClient() {
//		return session.getComputeClient();
//	}
// 
//	@Override
//	public OpenstackImageClient getImageClient() {
//		return session.getImageClient();
//	}
// 
//	@Override
//	public NovaFlavor resolveFlavor(NovaFlavor flavor) {
//		return session.resolveFlavor(flavor);
//	}
// 
//	@Override
//	public NovaImage resolveImage(NovaImage image) {
//		return session.resolveImage(image);
//	}
// 
//	/*
//	public <T> void delete(T item) {
//		
//		Class<? extends Object> itemClass = item.getClass();
// 
//		if (itemClass == NovaImage.class) {
//			NovaImage image = (NovaImage) item;
//			computeRoot().images().image(image.getId()).delete();
//		}
// 
//		if (itemClass == org.openstack.model.image.GlanceImage.class) {
//			org.openstack.model.image.GlanceImage image = (org.openstack.model.image.GlanceImage) item;
//			computeRoot().images().image(image.getId()).delete();
//		}
// 
//		if (itemClass == NovaSecurityGroup.class) {
//			NovaSecurityGroup securityGroup = (NovaSecurityGroup) item;
//			computeRoot().securityGroups().securityGroup(securityGroup.getId()).delete();
//		}
// 
//		throw new IllegalArgumentException("Unknown type: " + itemClass);
//		
//	}
//	 */
//}