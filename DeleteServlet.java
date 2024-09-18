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


public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int newid = Integer.parseInt(request.getParameter("id"));
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		Blog obj = session.get(Blog.class, newid);
		session.delete(obj);
		tx.commit();
		response.sendRedirect("all_blogs.jsp");	
	}

}
