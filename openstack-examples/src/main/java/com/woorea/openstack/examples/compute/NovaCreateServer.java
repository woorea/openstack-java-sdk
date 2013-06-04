package com.woorea.openstack.examples.compute;


import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.Tenants;
import com.woorea.openstack.nova.Nova;
import com.woorea.openstack.nova.model.Flavors;
import com.woorea.openstack.nova.model.Images;
import com.woorea.openstack.nova.model.KeyPairs;
import com.woorea.openstack.nova.model.Server;
import com.woorea.openstack.nova.model.ServerForCreate;

public class NovaCreateServer {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
    // access with unscoped token
    Access access = keystone
        .tokens()
        .authenticate()
        .withUsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD)
        .execute();

    // use the token in the following requests
    keystone.token(access.getToken().getId());

    Tenants tenants = keystone.tenants().list().execute();

    // try to exchange token using the first tenant
    if (tenants.getList().size() > 0) {

      access = keystone.tokens().authenticate()
          .withToken(access.getToken().getId())
          .withTenantId(tenants.getList().get(0).getId()).execute();

      // NovaClient novaClient = new
      // NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(),
      // "compute", null, "public"), access.getToken().getId());
      Nova nova = new Nova(ExamplesConfiguration.NOVA_ENDPOINT.concat(tenants
          .getList().get(0).getId()));
      nova.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken()
          .getId()));
      // novaClient.enableLogging(Logger.getLogger("nova"), 100 * 1024);
      // create a new keypair
      // KeyPair keyPair =
      // novaClient.execute(KeyPairsExtension.createKeyPair("mykeypair"));
      // System.out.println(keyPair.getPrivateKey());

      // create security group
      // SecurityGroup securityGroup =
      // novaClient.execute(SecurityGroupsExtension.createSecurityGroup("mysecuritygroup",
      // "description"));

      // novaClient.execute(SecurityGroupsExtension.createSecurityGroupRule(securityGroup.getId(),
      // "UDP", 9090, 9092, "0.0.0.0/0"));
      // novaClient.execute(SecurityGroupsExtension.createSecurityGroupRule(securityGroup.getId(),
      // "TCP", 8080, 8080, "0.0.0.0/0"));

      KeyPairs keysPairs = nova.keyPairs().list().execute();

      Images images = nova.images().list(true).execute();

      Flavors flavors = nova.flavors().list(true).execute();

      ServerForCreate serverForCreate = new ServerForCreate();
      serverForCreate.setName("woorea");
      serverForCreate.setFlavorRef(flavors.getList().get(0).getId());
      serverForCreate.setImageRef(images.getList().get(1).getId());
      serverForCreate.setKeyName(keysPairs.getList().get(0).getName());
      serverForCreate.getSecurityGroups()
          .add(new ServerForCreate.SecurityGroup("default"));
      // serverForCreate.getSecurityGroups().add(new
      // ServerForCreate.SecurityGroup(securityGroup.getName()));

      Server server = nova.servers().boot(serverForCreate).execute();
      System.out.println(server);

    } else {
      System.out.println("No tenants found!");
    }

  }

}
