package org.openstack.ui.server;

import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackClientFactory;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;
import org.openstack.model.identity.KeystoneTenantList;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		
		Properties properties = new Properties();
		
		properties.setProperty("verbose", "true");
		properties.setProperty("auth.endpoint", String.format("http://%s:5000/v2.0", req.getParameter("wan")));
		properties.setProperty("auth.username", req.getParameter("username"));
		properties.setProperty("auth.password", req.getParameter("password"));
		properties.setProperty("identity.endpoint.publicURL", String.format("http://%s:5000/v2.0", req.getParameter("wan")));
		properties.setProperty("identity.endpoint.internalURL", String.format("http://%s:5000/v2.0", req.getParameter("wan")));
		properties.setProperty("identity.endpoint.adminURL", String.format("http://%s:35357/v2.0", req.getParameter("wan")));
		properties.setProperty("identity.admin.token", "secret0");
		
		OpenStackClient openstack = OpenStackClientFactory.authenticate(properties);
		
		KeystoneTenantList tenants = openstack.getIdentityEndpoint().tenants().get();
		
		openstack.exchangeTokenForTenant(tenants.getList().get(0).getId());
		
		//openstack.reauthenticateOnTenant(tenants.getList().get(0).getName());
		
		for(KeystoneService svc : openstack.getAccess().getServices()) {
			for(KeystoneServiceEndpoint endpoint : svc.getEndpoints()) {
				endpoint.setPublicURL(endpoint.getPublicURL().replace(URI.create(endpoint.getPublicURL()).getHost(), req.getParameter("wan")));
				endpoint.setInternalURL(endpoint.getInternalURL().replace(URI.create(endpoint.getPublicURL()).getHost(), req.getParameter("wan")));
				endpoint.setAdminURL(endpoint.getAdminURL().replace(URI.create(endpoint.getPublicURL()).getHost(), req.getParameter("wan")));
			}
		}
		
		OpenStackSession oss = new OpenStackSession();
		oss.setAccess(openstack.getAccess());
		oss.setProperties(openstack.getProperties());
		
		req.getSession().setAttribute(Constants.OPENSTACK_SESSION, oss);
		
		if("192.168.1.52".equals(req.getParameter("wan"))) {
			resp.sendRedirect(String.format("%s/openstack.html?gwt.codesvr=127.0.0.1:9997",req.getContextPath()));
		} else {
			resp.sendRedirect(String.format("%s/openstack.html",req.getContextPath()));
		}
	}

}
