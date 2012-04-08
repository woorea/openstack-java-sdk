package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.compute.nova.NovaMetadata;
import org.openstack.model.compute.nova.NovaServerForCreate.File;
import org.openstack.model.compute.nova.NovaServerForCreate.SecurityGroup;

public interface ServerForCreate {

	String getName();

	void setName(String name);

	Integer getMin();

	void setMin(Integer min);

	Integer getMax();

	void setMax(Integer max);

	String getImageRef();

	void setImageRef(String imageRef);

	String getFlavorRef();

	void setFlavorRef(String flavorRef);

	String getZone();

	void setZone(String zone);

	String getKeyName();

	void setKeyName(String keyName);

	String getAccessIpV4();

	void setAccessIpV4(String accessIpV4);

	String getAccessIpV6();

	void setAccessIpV6(String accessIpV6);

	List<NovaMetadata.Item> getMetadata();

	void setMetadata(List<NovaMetadata.Item> metadata);

	List<File> getPersonality();

	void setPersonality(List<File> personality);

	List<SecurityGroup> getSecurityGroups();

	void setSecurityGroups(List<SecurityGroup> securityGroups);

	void addUploadFile(String path, String contents);

	boolean getConfigDrive();

	void setConfigDrive(boolean configDrive);

}