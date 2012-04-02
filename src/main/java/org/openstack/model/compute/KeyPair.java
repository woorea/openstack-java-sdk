package org.openstack.model.compute;

public interface KeyPair {

	String getName();

	String getPublicKey();

	String getFingerprint();

	String getUserId();

	String getPrivateKey();

}