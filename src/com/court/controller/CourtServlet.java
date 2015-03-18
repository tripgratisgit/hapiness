package com.court.controller;

import java.io.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.court.model.*;



public class CourtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		PrintWriter out = res.getWriter();
		
		//test
		
		
		//getAll
		if("getAll".equals(action)){
			CourtService coSvc = new CourtService();
			List<CourtVO> list = coSvc.getAll();
			
			HttpSession session = req.getSession();
			session.setAttribute("list", list);
			
			String url = "/court/listAllCourt_getFromSession.jsp";
			RequestDispatcher successV = req.getRequestDispatcher(url);
			successV.forward(req, res); 
			return;
		}
		
		if("getOne_For_Display".equals(action)){
			out.print("forwarding to getOne_For_Display .... Please wait..... 轉址中~");
		}

		if("insert".equals(action)){
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				System.out.println("0-0");
				
				String cname = req.getParameter("cname").trim();
				String csite = req.getParameter("csite").trim();
				String cfee = req.getParameter("cfee").trim();
				String copen = req.getParameter("copen").trim();
				String ccity = req.getParameter("ccity").trim();
				String caddr = req.getParameter("caddr").trim();
				String ctel = req.getParameter("ctel").trim();
				String ccon = req.getParameter("ccon").trim();
				String cdesc = req.getParameter("cdesc").trim();
				
				System.out.println("0-1");
				
				//需要再改
				InputStream in = new FileInputStream("C:/image/Logo.jpg");
				byte[] cimg = new byte[in.available()];
				in.read(cimg);
				in.close();
				
				System.out.println("0-2");
				
				Double clat = null;
				try {
					clat = new Double(req.getParameter("clat").trim());
				} catch (NumberFormatException e) {
					clat = 0.0;
					errorMsgs.add("COURT_LAT請填數字.");
					System.err.println("clat ERROR");
				}
				
				Double clng = null;
				try {
					clng = new Double(req.getParameter("clng").trim());
				} catch (NumberFormatException e) {
					clng = 0.0;
					errorMsgs.add("COURT_LONG請填數字.");
					System.err.println("COURT_LAT請填數字.");
				}
				
//				java.sql.Date COURT_DATE = null;
//				try {
//					COURT_DATE = java.sql.Date.valueOf(req.getParameter("COURT_DATE").trim());
//				} catch (IllegalArgumentException e) {
//					COURT_DATE=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
				

				System.out.println("1-1");
	
				CourtVO courtVO = new CourtVO();
				courtVO.setCname(cname);
				courtVO.setCsite(csite);
				courtVO.setCfee(cfee);
				courtVO.setCopen(copen);
				courtVO.setCcity(ccity);
				courtVO.setCaddr(caddr);
				courtVO.setCtel(ctel);
				courtVO.setCcon(ccon);
				courtVO.setCdesc(cdesc);
				courtVO.setClat(clat);
				courtVO.setClng(clng);
				
				System.out.println("1-2");

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("courtVO", courtVO); // 含有輸入格式錯誤的courtVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/court/addCourt.jsp");
					failureView.forward(req, res);
					System.err.println("!errorMsgs.isEmpty()");
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				CourtService courtSvc = new CourtService();
				
				System.out.println("2-1");
				
				courtVO = courtSvc.addCourt(cname, csite, cfee, copen,  ccity,  caddr,  clat,  clng, 
						ctel, ccon, cimg, cdesc);
				
				System.out.println("2-2");
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/court/listAllCourt_getFromSession.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllCourt_getFromSession.jsp
				
				System.out.println("3-1");
				successView.forward(req, res);				
				
				System.out.println("3-2");
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				System.err.println("其他可能的錯誤處理");
				RequestDispatcher failureView = req
						.getRequestDispatcher("/court/addCourt.jsp");
				failureView.forward(req, res);
			}
		}
		
	}

}
