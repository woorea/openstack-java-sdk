package org.openstack.client.identity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;

import com.google.common.base.Charsets;

public class TokensResource extends IdentityResourceBase {

    public Access authenticate(Authentication authentication) {
        // String password = authentication.getPasswordCredentials().getPassword();
        // authentication.getPasswordCredentials().setPassword(sha512(password));
        // .type(MediaType.APPLICATION_XML) ?
    	return resource().post(Access.class, authentication);
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
