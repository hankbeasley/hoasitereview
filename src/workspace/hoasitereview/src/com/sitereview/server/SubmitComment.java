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
import com.sitereview.server.dao.UserComment;
import com.sitereview.server.dao.Provider;


public class SubmitComment extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SubmitComment.class.getName());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		UserComment comment = new UserComment();
		comment.setComment(req.getParameter("comment"));
		comment.setName(req.getParameter("name"));
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Provider provider = pm.getObjectById(Provider.class, Integer.parseInt(req.getParameter("providerId")));
			pm.makePersistent(comment);
			provider.getUserComments().add(comment);
			//pm.makePersistent(provider);
			
		}finally{
			pm.close();
		}
		
		Provider objectById = PMF.get().getPersistenceManager().getObjectById(Provider.class, Integer.parseInt(req.getParameter("providerId")));
		
		String referer = req.getHeader("Referer");
		resp.sendRedirect(referer);
	}

	
}
