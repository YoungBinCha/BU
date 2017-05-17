package com.openmarket;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.openmarket.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Capstone_Process extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 신경쓰지마 super.doPost(req, resp); String uri = req.getRequestURI();
		 * System.out.println("uri = " + uri); String command =
		 * uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".do"));
		 * if(command != null && command.trim().equals("regist")){
		 */

		// DAO 객체 생성 (입력받은 정보 DB와 연동하기위해)
		Capstone_productDAO dao = new Capstone_productDAO();
		// 상품 공통 입력 변수
		String category = req.getParameter("category"); // category num 다시 찾아야되,
		int catnum = dao.selectCatnum(category); // 입력받은 category로 catnum 찾아옴.
		String title = req.getParameter("title");
		String productinfo = req.getParameter("productinfo");
		String productcondition = req.getParameter("procondition");
		String tratype = req.getParameter("tratype");
		String traway = req.getParameter("traway");
		String salprice_s = req.getParameter("salprice");
		String renprice_s = req.getParameter("renprice");
		String deposit_s = req.getParameter("deposit");
		String renday_s = req.getParameter("renday");
		
		
		

		//판매 상품 등록 , 대여 상품 등록할 때 다른 값이 null이 되니까 0으로 채워줌.
		if(salprice_s == ""){
			salprice_s = "0";
		}else if(renprice_s == ""){
			renprice_s ="0";
			deposit_s = "0";
			renday_s = "0";
		}
		
		// sale판매상품 입력 받을 때 필요한 변수
		int salprice = Integer.parseInt(salprice_s);

		// rent대여상품 입력 받을 때 필요한 변수
		int renprice = Integer.parseInt(renprice_s);
		int deposit = Integer.parseInt(deposit_s);
		int renday = Integer.parseInt(renday_s);

		// DTO객체 생성 (변수 SET/GET 하기위함)
		Capstone_productDTO dto = new Capstone_productDTO();
		
		
		HttpSession ses = req.getSession();
		String nickname = (String)ses.getAttribute("id");
		// 상품 공통 정보 입력
		dto.setNickname(nickname); // 이것도 회원 세션으로 바꿔야되!
		dto.setCatnum(catnum);
		dto.setTitle(title);
		dto.setProinfo(productinfo);
		dto.setProcondition(productcondition);
		dto.setTraway(traway);
		dto.setSalprice(salprice);

		/* 판매 정보 입력 */
		dto.setTratype(tratype);

		/* 대여 정보 입력 */
		dto.setRenprice(renprice);
		dto.setDeposit(deposit);
		dto.setRenday(renday);
		
		
		
		
		if (dto.getTratype().equals("rent")) {
			dao.insertRentProduct(dto); // 거래유형이 대여라면 ...
		} else if (dto.getTratype().equals("sale")) {
			dao.insertSaleProduct(dto); // 거래유형이 판매라면 ...
		}

		
		
		RequestDispatcher view = req.getRequestDispatcher("K_addImg.jsp");
		view.forward(req, resp);

	}
}
