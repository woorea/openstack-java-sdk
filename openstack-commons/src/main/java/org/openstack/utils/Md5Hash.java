package org.openstack.utils;

import java.security.MessageDigest;

public class Md5Hash extends MessageDigestBase {

    @Override
    protected MessageDigest buildDigest() {
        return buildDigest("MD5");
    }

}
