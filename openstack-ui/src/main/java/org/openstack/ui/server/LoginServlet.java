package org.openstack.ui.server;

import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneService;
import org.openstack.model.identity.KeyStoneServiceEndpoint;
import org.openstack.ui.server.mock.LoginServiceMock;

public class LoginServlet extends HttpServlet {
	
	private LoginService service = new LoginServiceImpl();
	
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
		
		String wan = req.getParameter("wan");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		KeyStoneAccess access = service.login(String.format("http://%s:5000/v2.0", wan), username, password);
		
		for(KeyStoneService svc : access.getServices()) {
			for(KeyStoneServiceEndpoint endpoint : svc.getEndpoints()) {
				endpoint.setPublicURL(endpoint.getPublicURL().replace(URI.create(endpoint.getPublicURL()).getHost(), wan));
				endpoint.setInternalURL(endpoint.getInternalURL().replace(URI.create(endpoint.getPublicURL()).getHost(), wan));
				endpoint.setAdminURL(endpoint.getAdminURL().replace(URI.create(endpoint.getPublicURL()).getHost(), wan));
			}
		}
		
		req.getSession().setAttribute(Constants.OPENSTACK_ACCESS, access);
		
		//resp.sendRedirect(String.format("%s/openstack.html?gwt.codesvr=127.0.0.1:9997",req.getContextPath()));
		resp.sendRedirect(String.format("%s/openstack.html",req.getContextPath()));
	}

}
