package org.openstack.ui.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String identityURL = req.getParameter("identityURL");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		req.getSession().setAttribute(Constants.OPENSTACK_ACCESS, service.login(identityURL, username, password));
		
		resp.sendRedirect(String.format("%s/openstack.html?gwt.codesvr=127.0.0.1:9997",req.getContextPath()));
	}

}
