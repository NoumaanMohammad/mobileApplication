package com.cg.ma.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Billid=(Integer)request.getAttribute("Billid");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.print("<h1> Electricity Bill for Consumer no"+Billid);
		out.print("</h1>");
		out.print("<a href='index.html'>Home</a>");
	}

}
