package com.cg.ma.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.ma.dto.Mobiledto;


@WebServlet("/ShowMobileView")
public class ShowMobileView extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mobiledto mobile=(Mobiledto)request.getAttribute("mobile");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.print("<br>Mobile id:"+mobile.getMobileid());
		out.print("<br>Mobile Name:"+mobile.getMname());
		out.print("<br>Mobile Price:"+mobile.getPrice());
		out.print("<br>Mobile quantity:"+mobile.getQuantity());
	}

}
