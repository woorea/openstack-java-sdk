package org.openstack.model.compute;

import java.util.List;
import java.util.Map;

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

	String getAccessIPv4();

	void setAccessIPv4(String accessIPv4);

	String getAccessIPv6();

	void setAccessIPv6(String accessIPv6);

	Map<String, String> getMetadata();

	void setMetadata(Map<String, String> metadata);

	List<File> getPersonality();

	void setPersonality(List<File> personality);

	List<SecurityGroup> getSecurityGroups();

	void setSecurityGroups(List<SecurityGroup> securityGroups);

	void addUploadFile(String path, String contents);

	boolean getConfigDrive();

	void setConfigDrive(boolean configDrive);

}