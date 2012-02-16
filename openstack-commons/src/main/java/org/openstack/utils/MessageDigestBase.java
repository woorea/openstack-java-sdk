package org.openstack.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class MessageDigestBase {
    public byte[] hash(String a) {
        return hash(toBytesUtf8(a));
    }

    public byte[] hash(byte[] data) {
        MessageDigest digest = buildDigest();

        byte[] hash = digest.digest(data);
        return hash;
    }

    public byte[] hash(InputStream is) throws IOException, DigestException {
        MessageDigest digest = buildDigest();

        byte[] buffer = new byte[8192];
        while (true) {
            int available = is.read(buffer);
            if (available == -1)
                break;
            digest.update(buffer, 0, available);
        }
        byte[] hash = digest.digest();
        return hash;

    }

    protected abstract MessageDigest buildDigest();

    public static byte[] toBytesUtf8(String s) {
        try {
            return s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Error getting utf-8 bytes", e);
        }
    }

    public static MessageDigest buildDigest(String name) {
        try {
            MessageDigest digest = MessageDigest.getInstance(name);
            return digest;
        } catch (NoSuchAlgorithmException e) {
            // should not happen
            throw new IllegalStateException("Could not find message digest algorithm: " + name, e);
        }
    }

}
