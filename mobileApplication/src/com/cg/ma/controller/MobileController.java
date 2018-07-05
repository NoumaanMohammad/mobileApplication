package com.cg.ma.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.ma.dto.Mobiledto;
import com.cg.ma.exception.MobileException;
import com.cg.ma.service.MobileService;
import com.cg.ma.service.MobileServiceImpl;

@WebServlet(urlPatterns={"/insert","/search","/showAll"})
public class MobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MobileService mser=new MobileServiceImpl();
		String targeturl="";
		String url=request.getServletPath();
		
	switch(url) {
		
	case "/insert":
		String mname=request.getParameter("mname");
		double price=Double.parseDouble(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		Mobiledto mobile=new Mobiledto();
		mobile.setMname(mname);
		mobile.setPrice(price);
		mobile.setQuantity(quantity);
		
		
		int mid;
		try {
			mid = mser.insertmobile(mobile);
			request.setAttribute("mid", mid);
			targeturl="success";
		} catch (MobileException e) {
			request.setAttribute("message", e.getMessage());
			targeturl="error";
		}
       
		break;
		
	case "/search":
		int mid1=Integer.parseInt(request.getParameter("mid"));
		
		Mobiledto m;
		try {
			m =mser.SearchMobile(mid1);
			request.setAttribute("mobile", m);
			targeturl="ShowMobileView";
		} catch (MobileException e) {
			request.setAttribute("message", e.getMessage());
			targeturl="error";
		}
		break;
		
	case "/showAll":
		List<Mobiledto> mlist;
		try {
			mlist = mser.getAllMobiles();
			request.setAttribute("mlist", mlist);
			targeturl="showAllMobiles";
		} catch (MobileException e) {
			request.setAttribute("message", e.getMessage());
			targeturl="error";
		}
		
		
		
	}
		RequestDispatcher disp=request.getRequestDispatcher( targeturl);
		disp.forward(request,response);
	}
   
	
}
