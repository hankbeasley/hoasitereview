package com.sitereview.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitereview.server.dao.PMF;
import com.sitereview.server.dao.Provider;
import com.sitereview.server.dao.UserComment;

public class Admin extends HttpServlet {
		private static final long serialVersionUID = 3992372581180787771L;
		private static final Logger log = Logger.getLogger(SubmitComment.class.getName());
		
		
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String command = req.getParameter("cmd");

//			UserComment comment = new UserComment();
//			comment.setComment("pos");
//			
			Object entity = null;
			if (command.equals("provider")){
				Provider e = new Provider();
				e.setName("hoa-sites");
				e.setUrl("http://www.hoa-sites.com");
				e.setConsensus("Established service provider with a lots of features. Different price plans for scaling benefits.");
				e.setPrice("setup:$50\nmonthly:$50");
				//e.getUserComments().add(comment);
				entity = e;
			}
			
			
			if (entity == null){
				throw new ServletException("Invalid command");
			}
			PersistenceManager pm = PMF.get().getPersistenceManager();
			try {
				
				pm.makePersistent(entity);
			}finally{
				pm.close();
			}
			String referer = req.getHeader("Referer");
			resp.sendRedirect(referer);
		}

		
	}

