package com.inhatc.BillyU;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.proDAO;
import product.proDTO;
import regist.registDAO;
import regist.registDTO;
import mypage_reply.mypage_replyDTO;
import mypage_reply.mypage_replyDAO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/Y_Main")
	public String Y_Main(){
		return "Y_Main";
	}
	@RequestMapping(value="/Y_Login")
	public String Y_Login(){
		return "Y_Login";
	}
	@RequestMapping(value="/K_view")
	public String K_view(){
		return "K_view";
	}
	@RequestMapping(value="/Y_All_Category")
	public String Y_All_Category(){
		return "Y_All_Category";
	}
	@RequestMapping(value="/Y_Submit_Product")
	public String Y_Submit_Product(){
		return "Y_Submit_Product";
	}
	@RequestMapping(value="/Y_Login_OK")
	public String Y_Login_OK(){
		return "Y_Login_OK";
	}
	@RequestMapping(value="/Y_ID_Check")
	public String Y_ID_Check(){
		return "Y_ID_Check";
	}
	@RequestMapping(value="/Y_Join_NickName")
	public String Y_Join_NickName(){
		return "Y_Join_NickName";
	}
	@RequestMapping(value="/Y_Join_OK")
	public String Y_Join_OK(){
		return "Y_Join_OK";
	}
	@RequestMapping(value="/Y_JoinForm")
	public String Y_JoinForm(){
		return "Y_JoinForm";
	}
	@RequestMapping(value="/Y_MyPage")
	public String Y_MyPage(){
		return "Y_MyPage";
	}
	@RequestMapping(value="/Y_MyProduct")
	public String Y_MyProduct(){
		return "Y_MyProduct";
	}
	@RequestMapping(value="/Y_MyMail")
	public String Y_MyMail(){
		return "Y_MyMail";
	}
	@RequestMapping(value="/Y_MyPerson")
	public String Y_MyPerson(){
		return "Y_MyPerson";
	}
	@RequestMapping(value="/Y_MyWait")
	public String Y_MyWait(){
		return "Y_MyWait";
	}
	@RequestMapping(value="/Y_Delete_MyProduct")
	public String Y_Delete_MyProduct(){
		return "Y_Delete_MyProduct";
	}
	@RequestMapping(value="/Y_Rent")
	public String Y_Rent(){
		return "Y_Rent";
	}
	@RequestMapping(value = "/K_product")
	public String K_product(){
		return "K_product";
	}
	@RequestMapping(value = "/Y_Submit_Sale")
	public String Y_Submit_Sale(){
		return "Y_Submit_Sale";
	}
	@RequestMapping(value = "/Y_Sale")
	public String Y_Sale(){
		return "Y_Sale";
	}
	@RequestMapping(value = "/Y_Submit_Jang")
	public String Y_Submit_Jang(){
		return "Y_Submit_Jang";
	}
	@RequestMapping(value = "/Y_MyJang")
	public String Y_MyJang(){
		return "Y_MyJang";
	}
	@RequestMapping(value = "/Y_Delete_MyJang")
	public String Y_Delete_MyJang(){
		return "Y_Delete_MyJang";
	}
	@RequestMapping(value = "/Y_Jang")
	public String Y_Jang(){
		return "Y_Jang";
	}
	@RequestMapping(value = "/Y_Introduce")
	public String Y_Introduce(){
		return "Y_Introduce";
	}
	@RequestMapping(value = "/Y_Information")
	public String Y_Information(){
		return "Y_Information";
	}
	@RequestMapping(value = "/Y_ReturnCategory")
	public String Y_ReturnCategory(){
		return "Y_ReturnCategory";
	}
	@RequestMapping(value = "/Y_Search_Result")
	public String Y_Search_Result(){
		return "Y_Search_Result";
	}
	
	@RequestMapping(value = "/Y_Reply",method = RequestMethod.POST)
	public String Y_Reply(HttpServletRequest request,HttpSession session,Model model,HttpServletResponse response){
		mypage_replyDAO replyDAO = new mypage_replyDAO();
		Object host = session.getAttribute("id");
		String hoster = host.toString();
		String guest = request.getParameter("guest");
		String message = request.getParameter("content");
		String pro = request.getParameter("pronum");
		int pronum = Integer.parseInt(pro);
		replyDAO.insert_reply(pronum,hoster, guest, message);
		try {
			response.sendRedirect("Y_Main");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Y_Main";
	}
	//상품등록정보 입력 Mapping
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String registdo(HttpServletRequest req, Model model){
		//DB 한글깨짐 방지 
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		registDAO dao = new registDAO();
		String category = req.getParameter("category"); 
		int catnum = dao.selectCatnum(category); 
		String title = req.getParameter("title");
		String productinfo = req.getParameter("productinfo");
		String productcondition = req.getParameter("procondition");
		String tratype = req.getParameter("tratype");			//판매냐 대여냐
		
	//	String traway = req.getParameter("traway");				//직거래냐 택배냐
		
		String[] traway = req.getParameterValues("traway");
		
		String salprice_s = req.getParameter("salprice");
		String renprice_s = req.getParameter("renprice");
		String deposit_s = req.getParameter("deposit");
		String renday_s = req.getParameter("renday");
		
		if(salprice_s == ""){
			salprice_s = "0";
		}else if(renprice_s == ""){
			renprice_s ="0";
			deposit_s = "0";
			renday_s = "0";
		}
		
		int salprice = Integer.parseInt(salprice_s);

	
		int renprice = Integer.parseInt(renprice_s);
		int deposit = Integer.parseInt(deposit_s);
		int renday = Integer.parseInt(renday_s);
		
		HttpSession ses = req.getSession();
		String nickname = (String)ses.getAttribute("id");
		ses.setAttribute("checkId", nickname);
		
		registDTO dto = new registDTO(nickname, catnum, title, productinfo, productcondition, tratype, traway, salprice, renprice, deposit, renday);

		if (dto.getTratype().equals("대여")) {
			dao.insertRentProduct(dto); 
		} else if (dto.getTratype().equals("판매")) {
			dao.insertSaleProduct(dto); 
		}
		
//		RequestDispatcher view = req.getRequestDispatcher("K_addImg.jsp");
//		view.forward(req, resp);
		return "K_addImg";
	}
	@RequestMapping(value = "/K_addImg")
	public String K_addImg(){
		return "K_addImg";
	}
	//상품사진등록 Mapping
	@RequestMapping(value = "/regist.ro", method = RequestMethod.POST)
	public String registro(HttpServletRequest req, Model model) throws IOException{
		
		//DB 한글깨짐 방지 
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String savePath = "C:/Bro/BillyU/src/main/webapp/resources/img";
		
		int sizeLimit = 10 * 1024 * 1024; 
		String img = "";
		String img2 = "";
		String img3 = "";
		String img4 = "";
		
		MultipartRequest multi = new MultipartRequest(req, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames(); 

		String file = (String) files.nextElement();
		img = multi.getOriginalFileName(file);
		String file2 = (String) files.nextElement();
		img2 = multi.getOriginalFileName(file2);
		String file3 = (String) files.nextElement();
		img3 = multi.getOriginalFileName(file3);
		String file4 = (String) files.nextElement();
		img4 = multi.getOriginalFileName(file4);
		
		registDAO dao = new registDAO();
		registDTO dto = new registDTO(img, img2, img3, img4);
		
		int pronum = dao.selectPronum();
		
		HttpSession ses = req.getSession();
		String id = (String)ses.getAttribute("id");
		String checkId = (String)ses.getAttribute("checkId");
		
		if(id.equals(checkId)){
			dao.insertImage(dto, pronum);
			dao.updateImage(dto, pronum);
		}else{
			System.out.println("로그인한 id와 상품등록한 id가 다릅니다.");
		}
		
//		RequestDispatcher view = req.getRequestDispatcher("K_view.jsp");
//		view.forward(req, resp);
		
		return "Y_MyPage";
	}
}
