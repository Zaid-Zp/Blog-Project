package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.FactoryProvider;
import com.entities.Blog;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int newid = Integer.parseInt(request.getParameter("bid"));
		String name = request.getParameter("bname");
		String content = request.getParameter("content");
				
		Session session = FactoryProvider.getFactory().openSession();
		Blog obj = session.get(Blog.class, newid);
		obj.setBlogname(name);
		obj.setContent(content);		
		Transaction tx = session.beginTransaction();
		session.update(obj);
		tx.commit();
		response.sendRedirect("all_blogs.jsp");
		
	}

}
