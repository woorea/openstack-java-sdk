package org.openstack.ui.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openstack.client.common.OpenStackSession;
import org.openstack.client.common.OpenStackSession.Feature;
import org.openstack.client.identity.IdentityResource;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;

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
		
		String identityURL = req.getParameter("identityURL");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		KeyStoneAuthentication authentication = new KeyStoneAuthentication().withPasswordCredentials(username, password);
		
		OpenStackSession oss = OpenStackSession.create().with(Feature.VERBOSE);
		
		IdentityResource identity = new IdentityResource(oss, identityURL);
		
		KeyStoneAccess access = identity.tokens().authenticate(authentication);
		
		oss.getData().setAccess(access);
		
		KeyStoneTenantList tenants = identity.tenants().list();
		
		KeyStoneTenant tenant = tenants.getList().get(0);
		
		authentication.setTenantId(tenant.getId());
		
		access = identity.tokens().authenticate(authentication);
		
		oss.getData().setAccess(access);
		
		session = req.getSession();
		
		session.setAttribute(Constants.OPENSTACK_SESSION, oss.getData());
		
		resp.sendRedirect(String.format("%s/openstack.html?gwt.codesvr=127.0.0.1:9997",req.getContextPath()));
	}

}
