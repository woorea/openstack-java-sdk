package org.openstack.ui.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetupServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/setup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		
		File file = new File(this.getClass().getResource("/openstack.properties").getFile());
		
		Properties properties = new Properties();
		
		properties.load(new FileInputStream(file));
		
		properties.setProperty("verbose", "true");
		
		properties.setProperty("identity.endpoint.publicURL", req.getParameter("identity.endpoint.publicURL"));
		properties.setProperty("identity.endpoint.internalURL", req.getParameter("identity.endpoint.internalURL"));
		properties.setProperty("identity.endpoint.adminURL", req.getParameter("identity.endpoint.adminURL"));
		properties.setProperty("identity.admin.token", req.getParameter("identity.admin.token"));
		
		properties.store(new FileOutputStream(file), "last updated : " + new Date());
		
		System.out.println(file.getAbsolutePath());
		
		resp.sendRedirect(String.format("%s/login", req.getContextPath()));
		
	}

}
