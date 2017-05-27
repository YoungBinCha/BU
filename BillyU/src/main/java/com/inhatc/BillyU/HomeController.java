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
import user.userDAO;
import mypage_reply.mypage_replyDTO;
import mypage_reply.mypage_replyDAO;
import rent.rentDAO;


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
	@RequestMapping(value="/Index")
	public String Index(){
		return "Index";
	}
	@RequestMapping(value="/UserLoginForm")
	public String UserLoginForm(){
		return "User/UserLoginForm";
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
	@RequestMapping(value="/UserLoginSuccess")
	public String UserLoginSuccess(){
		return "User/UserLoginSuccess";
	}
	@RequestMapping(value="/UserCheckID")
	public String UserCheckID(){
		return "User/UserCheckID";
	}
	@RequestMapping(value="/UserNicknameForm")
	public String UserNicknameForm(){
		return "User/UserNicknameForm";
	}
	@RequestMapping(value="/UserJoinSuccess")
	public String UserJoinSuccess(){
		return "User/UserJoinSuccess";
	}
	@RequestMapping(value="/UserJoinForm")
	public String UserJoinForm(){
		return "User/UserJoinForm";
	}
	@RequestMapping(value="/MypageMainForm")
	public String MypageMainForm(){
		return "MyPage/MypageMainForm";
	}
	@RequestMapping(value="/MypageEnrollProduct")
	public String MypageEnrollProduct(){
		return "MyPage/MypageEnrollProduct";
	}
	@RequestMapping(value="/MypageReceiveMessage")
	public String MypageReceiveMessage(){
		return "MyPage/MypageReceiveMessage";
	}
	@RequestMapping(value="/MypagePrivacyInformation")
	public String MypagePrivacyInformation(){
		return "MyPage/MypagePrivacyInformation";
	}
	@RequestMapping(value="/MypageSendMessage")
	public String MypageSendMessage(){
		return "MyPage/MypageSendMessage";
	}
	@RequestMapping(value="/MypageDeleteProduct")
	public String MypageDeleteProduct(){
		return "MyPage/MypageDeleteProduct";
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
	@RequestMapping(value = "/CartInsertJang")
	public String CartInsertJang(){
		return "Cart/CartInsertJang";
	}
	@RequestMapping(value = "/CartViewMyJangPage")
	public String CartViewMyJangPage(){
		return "Cart/CartViewMyJangPage";
	}
	@RequestMapping(value = "/CartDeleteMyJang")
	public String CartDeleteMyJang(){
		return "Cart/CartDeleteMyJang";
	}
	@RequestMapping(value = "/CartLeftbarJang")
	public String CartLeftbarJang(){
		return "Cart/CartLeftbarJang";
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
	@RequestMapping(value = "/Y_Scroll")
	public String Y_Scroll(){
		return "Y_Scroll";
	}
	@RequestMapping(value = "/Y_Reply",method = RequestMethod.POST)
	public String Y_Reply(HttpServletRequest request,HttpSession session,Model model,HttpServletResponse response){
		mypage_replyDAO replyDAO = new mypage_replyDAO();
		Object host = session.getAttribute("id");
		String hoster = host.toString();
		String guest = request.getParameter("guest");
		String message = request.getParameter("content");
		String pro = request.getParameter("productnumber");
		int productnumber = Integer.parseInt(pro);
		replyDAO.insert_reply(productnumber,hoster, guest, message);
		try {
			response.sendRedirect("Y_Main");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Y_Main";
	}
	@RequestMapping(value = "/Y_Logout")
	public String Y_Logout(HttpSession session){
		session.invalidate();
		return "Y_Main";
	}
	@RequestMapping(value = "/Y_Delete_User")
	public String Y_Delete_User(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		userDAO userDAO = new userDAO();
		Object user = session.getAttribute("id");
		String nickname = user.toString();
		userDAO.delete_user(nickname);
		session.invalidate();
		return "Y_Main";
	}
	@RequestMapping(value = "/Y_Delete_toMail")
	public String Y_Delete_toMail(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		rentDAO rentDAO = new rentDAO();
		String rent = request.getParameter("rentnum");
		if(rent != null){
			int rentnum = Integer.parseInt(rent);
			rentDAO.delete_rent(rentnum);
		}
		return "Y_MyPage";
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
		int categorynumber = dao.selectcategorynumber(category); 
		String title = req.getParameter("title");
		String productinformation = req.getParameter("productinformation");
		String location = req.getParameter("location");
		String productstate = req.getParameter("productstate");			//판매냐 대여냐

		String rentprice_s = req.getParameter("rentprice");
		String rentdeposite_s = req.getParameter("rentdeposite");
		String rentunit_s = req.getParameter("rentunit");
		
	/*	if(rentprice_s == ""){
			rentprice_s ="0";
			rentdeposite_s = "0";
			rentunit_s = "0";
		}
*/
		int rentprice = Integer.parseInt(rentprice_s);
		int rentdeposite = Integer.parseInt(rentdeposite_s);
		int rentunit = Integer.parseInt(rentunit_s);
		
		HttpSession ses = req.getSession();
		String nickname = (String)ses.getAttribute("id");
		ses.setAttribute("checkId", nickname);
		
		registDTO dto = new registDTO(nickname, categorynumber, title, productinformation, location, productstate, rentprice, rentdeposite, rentunit);

			dao.insertRentProduct(dto); 
		
		
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
		String img1 = "";
		String img2 = "";
		String img3 = "";
		String img4 = "";
		
		MultipartRequest multi = new MultipartRequest(req, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames(); 

		String file = (String) files.nextElement();
		img1 = multi.getOriginalFileName(file);
		String file2 = (String) files.nextElement();
		img2 = multi.getOriginalFileName(file2);
		String file3 = (String) files.nextElement();
		img3 = multi.getOriginalFileName(file3);
		String file4 = (String) files.nextElement();
		img4 = multi.getOriginalFileName(file4);
		
		registDAO dao = new registDAO();
		registDTO dto = new registDTO(img1, img2, img3, img4);
		
		int productnumber = dao.selectproductnumber();
		
		HttpSession ses = req.getSession();
		String id = (String)ses.getAttribute("id");
		String checkId = (String)ses.getAttribute("checkId");
		/*
		if(id.equals(checkId)){
			dao.insertImage(dto, productnumber);
			dao.updateImage(dto, productnumber);
		}else{
			System.out.println("로그인한 id와 상품등록한 id가 다릅니다.");
		}*/
		
		dao.insertImage(dto, productnumber);
		dao.updateImage(dto, productnumber);
//		RequestDispatcher view = req.getRequestDispatcher("K_view.jsp");
//		view.forward(req, resp);
		
		return "Y_MyPage";
		
	}
}
