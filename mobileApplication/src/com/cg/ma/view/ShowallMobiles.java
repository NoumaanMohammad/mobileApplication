package com.cg.ma.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.ma.dto.Mobiledto;

@WebServlet("/showAllMobiles")
public class ShowallMobiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Mobiledto> mlist=(List)request.getAttribute("mlist");
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	out.print("<link rel=\"stylesheet\" href=\"table.css\">");

	out.print("<table cellspacing=0px>"
			+ "	<tr>"
			+ "		<th>Mobile Id </th>"
			+ "		<th> Mobile Name </th>"
			+ "		<th>Price </th>"
			+ "		<th> Quantity </th>"
			+ "	</tr>"
			+ "	");
	
	for(Mobiledto m:mlist) {
		out.print("<tr>");
		out.print("<td>"+m.getMobileid()+"</td>");
		out.print("<td>"+m.getMname()+"</td>");
		out.print("<td>"+m.getPrice()+"</td>");
		out.print("<td>"+m.getQuantity()+"</td>");
		out.print("</tr>");
	}
	out.print("</table>");
	out.print("<a href='index.html'>Home</a>");
	}

}
