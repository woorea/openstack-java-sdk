package org.openstack.client.identity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;

import com.google.common.base.Charsets;

public class TokensResource extends IdentityResourceBase {

    public KeyStoneAccess authenticate(KeyStoneAuthentication authentication) {
        // String password = authentication.getPasswordCredentials().getPassword();
        // authentication.getPasswordCredentials().setPassword(sha512(password));
        // .type(MediaType.APPLICATION_XML) ?
    	return resource().post(KeyStoneAccess.class, authentication);
    }

    private String sha512(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.reset();
            md.update(text.getBytes(Charsets.UTF_8));
            byte[] digest = md.digest();
            return Hex.encodeHexString(digest);
            // return toHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
