package org.openstack.client.compute;

import org.testng.annotations.Test;

public class ITFluent extends ComputeApiTest {
    @Test
    public void checkFluency() throws Exception {
        // The original 'test case':
        // context.client.getComputeClient().root().servers().list().get(1).getImage().getName();
    	
    	/*
        ServersRepresentation servers = context.client.getComputeClient().root().servers().list();
        // This is iterable, we have to copy to a list
        List<ServerRepresentation> serverList = servers.asList();
        // Then it works
        ImageRepresentation image = serverList.get(0).fetchImage();
        System.out.println(image);
		
    	
        // All in one:
        image = context.client.getComputeClient().root().servers().list().asList().get(0).fetchImage();
        */
    }
}
