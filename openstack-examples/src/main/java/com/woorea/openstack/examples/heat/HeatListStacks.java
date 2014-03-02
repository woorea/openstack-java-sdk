package com.woorea.openstack.examples.heat;

import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.heat.Heat;
import com.woorea.openstack.heat.model.CreateStackParam;
import com.woorea.openstack.heat.model.Stack;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.Access.Service;
import com.woorea.openstack.keystone.model.Access.Service.Endpoint;
import com.woorea.openstack.keystone.utils.KeystoneTokenProvider;

import java.util.Collections;

public class HeatListStacks {

    private static  String template = "{\n" +
            "    \"HeatTemplateFormatVersion\": \"2012-12-12\",\n" +
            "    \"Parameters\": {},\n" +
            "    \"Mappings\": {},\n" +
            "    \"Resources\": {\n" +
            "        \"my-test-server\": {\n" +
            "            \"Type\": \"OS::Nova::Server\",\n" +
            "            \"Properties\": {\n" +
            "                \"flavor\": \"m1.small\",\n" +
            "                \"image\": \"centos:latest\"\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        KeystoneTokenProvider keystone = new KeystoneTokenProvider(
                "http://10.129.184.5:35357/v2.0/",
                "admin",
                "aa2f03a2c4c2414c");

        Access access = keystone.getAccessByTenant(ExamplesConfiguration.TENANT_NAME);

        Service heatService = getService(access);

        for (Endpoint endpoint : heatService.getEndpoints()) {

            Heat heat = new Heat(endpoint.getPublicURL());
            heat.setTokenProvider(keystone
                    .getProviderByTenant(ExamplesConfiguration.TENANT_NAME));

            CreateStackParam param = new CreateStackParam();
            param.setStackName("helloWorld");
            param.setTimeoutMinutes(1);
            param.setParameters(Collections.<String, String>emptyMap());
            param.setTemplate(template);

            System.out.printf("Create: " + heat.getStacks().create(param).execute());
            Thread.sleep(3000);


            for (Stack s : heat.getStacks().list().execute()) {
                System.out.println(s.getDescription());
                System.out.println(s.getId());
                System.out.println(s.getStackName());
                System.out.println(s.getStackStatus());
                System.out.println(s.getCreationTime());
                System.out.println(s.getUpdatedTime());
                System.out.println(s.getLinks());

                System.out.println(heat.getStacks().byName(s.getStackName()).execute());

                System.out.println("Delete: " + heat.getStacks().deleteByName(s.getStackName()).execute());

            }
        }
    }

    private static Service getService(Access access) {
        Service heatService = null;
        for (Service service : access.getServiceCatalog()) {
            if (service.getType().equals("orchestration")) {
                heatService = service;
                break;
            }
        }

        if (heatService == null) {
            throw new RuntimeException("Glance service not found");
        }
        return heatService;
    }

}
