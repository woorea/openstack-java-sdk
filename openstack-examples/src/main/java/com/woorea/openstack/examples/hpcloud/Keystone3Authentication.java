package com.woorea.openstack.examples.hpcloud;


import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.v3.model.Authentication;
import com.woorea.openstack.keystone.v3.model.Authentication.Identity;
import com.woorea.openstack.keystone.v3.Keystone;
import com.woorea.openstack.keystone.v3.model.Token;

public class Keystone3Authentication {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
    
    Authentication auth = new Authentication();
    auth.setIdentity(Identity.password(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD));
    
    OpenStackResponse response = keystone.tokens().authenticate(auth).request();
    
    String tokenId = response.header("X-Subject-Token");
    
    Token token = response.getEntity(Token.class);
    
    System.out.println(tokenId);

    System.out.println(token);

  }

}
