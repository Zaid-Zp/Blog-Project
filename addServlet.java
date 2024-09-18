package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.connection.FactoryProvider;
import com.entities.Blog;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name = request.getParameter("bname");
		String content = request.getParameter("content");
		
		Blog b1 = new Blog();
		b1.setBlogname(name);
		b1.setContent(content);
		
		Session session = FactoryProvider.getFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(b1);
		tx.commit();
		session.close();
//		response.sendRedirect("all_blogs.jsp");
//		out.println("<h1 style='text-align:center;'>Blog Added sucessfully</h1>");
//		out.println("<h1 style='text-align:center;'><a href='all_blogs.jsp'>View all blogs</a></h1>");
	  }

}
