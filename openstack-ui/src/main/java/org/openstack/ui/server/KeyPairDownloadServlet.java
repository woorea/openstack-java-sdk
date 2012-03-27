package org.openstack.ui.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.client.JerseyClientFactory;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.nova.keypair.NovaKeyPair;

public class KeyPairDownloadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UriBuilder uriBuilder = UriBuilder.fromPath(
				req.getParameter("computeURL")).path("/os-keypairs");
		KeyPair keyPair = new NovaKeyPair(req.getParameter("keyPairName"));
		keyPair = JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", req.getParameter("token"))
				.post(Entity.xml(keyPair), KeyPair.class);

		ServletOutputStream out = resp.getOutputStream();
		// resp.setContentLength(responseBytes.length);
		resp.setHeader("Content-disposition",
				"attachment; filename=" + keyPair.getName() + ".pem");
		resp.setContentType("text/plain; charset=UTF-8");
		resp.setStatus(HttpServletResponse.SC_OK);
		IOUtils.write(keyPair.getPrivateKey(), out, "UTF-8");
		out.flush();
		IOUtils.closeQuietly(out);
		System.out.println("WRITED");
	}

}