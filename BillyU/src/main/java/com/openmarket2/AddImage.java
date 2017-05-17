package com.openmarket2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openmarket.Capstone_productDAO;
import com.openmarket.Capstone_productDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddImage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String savePath = "C:/WebSoft/eclipse/eclipse/workspace/SpringBillyU/BillyU/src/main/webapp/resources/img"; // 저장할
																					// 디렉토리
																					// (절대경로)
		int sizeLimit = 10 * 1024 * 1024; // 10메가까지 제한 넘어서면 예외발생
		String img = "";
		String img2 = "";
		String img3 = "";
		String img4 = "";
		
		
		MultipartRequest multi = new MultipartRequest(req, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames(); // 폼의 이름 반환

		String file = (String) files.nextElement();
		img = multi.getOriginalFileName(file);
		String file2 = (String) files.nextElement();
		img2 = multi.getOriginalFileName(file2);
		String file3 = (String) files.nextElement();
		img3 = multi.getOriginalFileName(file3);
		String file4 = (String) files.nextElement();
		img4 = multi.getOriginalFileName(file4);
		
		com.openmarket2.Capstone_productDAO dao = new com.openmarket2.Capstone_productDAO();
		com.openmarket2.Capstone_productDTO dto = new com.openmarket2.Capstone_productDTO();
		// 이미지 주소 입력
		dto.setImg(img);
		dto.setImg2(img2);
		dto.setImg3(img3);
		dto.setImg4(img4);

		int pronum = dao.selectPronum();
		dao.insertImage(dto, pronum);
	
		RequestDispatcher view = req.getRequestDispatcher("K_view.jsp");
		view.forward(req, resp);
	}
}
