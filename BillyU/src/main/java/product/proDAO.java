package product;

import java.sql.*;
import java.util.*;

import regist.registDTO;

public class proDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	proDTO dto;
	boolean check = false;
	
	
	ArrayList<proDTO> pro_list = new ArrayList<proDTO>();
	ArrayList<proDTO> pro_mylist = new ArrayList<proDTO>();
	
	
	public proDAO(){
		try{Class.forName("com.mysql.jdbc.Driver");}
		catch(Exception e){e.printStackTrace();}
		}
	
	public void connect(){
		try{
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/BillyU",
					"root",
					"1234"
					);		
			stmt = conn.createStatement();
		}catch(Exception e){e.printStackTrace();}
	}
	
	public void disconnect(){
		if(stmt != null){try{stmt.close();}catch(Exception e){e.printStackTrace();}}
		if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		if(pstmt != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
	}
	
	public ArrayList<proDTO> pro_list(){
		try{
			connect();
			String sql = "select * from product order by pronum desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int pronum = rs.getInt("pronum");
				String nickname = rs.getString("nickname");
				int catnum = rs.getInt("catnum");
				String title = rs.getString("title");
				String proinfo = rs.getString("proinfo");
				String procondition = rs.getString("procondition");
				String traway = rs.getString("traway");
				String tratype = rs.getString("tratype");
				int renprice = rs.getInt("renprice");
				int renday = rs.getInt("renday");
				int deposit = rs.getInt("deposit");
				int salprice = rs.getInt("salprice");
				String img = rs.getString("img");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new proDTO(pronum,nickname,catnum,title,proinfo,procondition,traway,tratype,renprice,renday,deposit,salprice,img,curtime);
				pro_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return pro_list;
	}
	
	public ArrayList<proDTO> MyPage(Object id){
		try{
			connect();
			String sql = "select * from product where nickname='"+id+"' order by pronum desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int pronum = rs.getInt("pronum");
				String nickname = rs.getString("nickname");
				int catnum = rs.getInt("catnum");
				String title = rs.getString("title");
				String proinfo = rs.getString("proinfo");
				String procondition = rs.getString("procondition");
				String traway = rs.getString("traway");
				String tratype = rs.getString("tratype");
				int renprice = rs.getInt("renprice");
				int renday = rs.getInt("renday");
				int deposit = rs.getInt("deposit");
				int salprice = rs.getInt("salprice");
				String img = rs.getString("img");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new proDTO(pronum,nickname,catnum,title,proinfo,procondition,traway,tratype,renprice,renday,deposit,salprice,img,curtime);
				pro_mylist.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return pro_mylist;
	}
	public void delete_product(String pronum){
		try {
			connect();
			String sql="delete from product where pronum='"+pronum+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 여기부터 상품등록할 때 사용하는 메소드 -- Capstone_prodctDAO에서 온 것들
	 */
	
	//판매상품 등록할 때 사용하는 메소드
	public boolean insertSaleProduct(registDTO dto){
		
		connect();
		String query = "insert into product (nickname, catnum, title, proinfo, procondition, traway, tratype, salprice) values (?, ?, ?, ?, ?, ?, ?, ?);";		
		try{
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickname());
			pstmt.setInt(2, dto.getCatnum());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getProinfo());
			pstmt.setString(5, dto.getProcondition());
			pstmt.setString(6, dto.getTraway());
			pstmt.setString(7, dto.getTratype());
			pstmt.setInt(8, dto.getSalprice());
			
			pstmt.executeUpdate();			//UPDATE, DELETE 사용 할 때 사용 
			check = true;
		}catch(SQLException ex){
			System.out.println("SQL insertSaleProduct 오류 : " + ex.getLocalizedMessage());
		}finally{
			disconnect();
		}
		return check;
	}
	
	//대여상품 등록할 때 사용하는 메소드
	public boolean insertRentProduct(registDTO dto){
		
		connect();
		String query = "insert into product (nickname, catnum, title, proinfo, procondition, traway, tratype, renprice, deposit, renday) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try{
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickname());
			pstmt.setInt(2, dto.getCatnum());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getProinfo());
			pstmt.setString(5, dto.getProcondition());
			pstmt.setString(6, dto.getTraway());
			pstmt.setString(7, dto.getTratype());
			pstmt.setInt(8, dto.getRenprice());
			pstmt.setInt(9, dto.getDeposit());
			pstmt.setInt(10, dto.getRenday());
			
			pstmt.executeUpdate();			//UPDATE, DELETE 할 때 사용
			check = true;
		}catch(SQLException ex){
			System.out.println("SQL insertRentProduct 오류 : " + ex.getLocalizedMessage());
		}finally{
			disconnect();
		}	
		return check;
	}
	
	//이미지 테이블 채우는 메소드
	public boolean insertImage(registDTO dto, int pronum){
		connect();
		//String query = "insert into product (nickname, catnum, title, proinfo, procondition, traway, tratype, salprice) values (?, ?, ?, ?, ?, ?, ?, ?);";
		String query = "insert into image (pronum, path,path2,path3,path4) value (?, 'img/"+ '?' +"','img/"+ '?' +"','img/"+ '?' +"','img/"+ '?' +"')";

		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pronum);
			pstmt.setString(2, dto.getImg());
			pstmt.setString(3, dto.getImg2());
			pstmt.setString(4, dto.getImg3());
			pstmt.setString(5, dto.getImg4());
			
			pstmt.executeUpdate();			
			check = true;
		}catch(SQLException ex){
			System.out.println("SQL insertSaleProduct ���� : " + ex.getLocalizedMessage());
		}finally{
			disconnect();
		}	
		return check;
	}
	
		//pronum을 찾을 때 사용
	public int selectPronum(){
		connect();
		String query = "SELECT * FROM product ORDER BY pronum DESC LIMIT 1";		//마지막 1개,
		int pronum = 0 ; 
		try{
			rs = stmt.executeQuery(query);		
				
			rs.next();
			pronum = Integer.parseInt(rs.getString("pronum"));
			
		}catch(SQLException ex){
			System.out.println("SQL selectCatnum 오류 : " + ex.getLocalizedMessage());
		}finally{
			disconnect();
		}	
		return pronum;
	}
	
	//카테고리이름을 통해 카테고리번호 갖고오는 메소드
	public int selectCatnum(String catname){
		String query = "SELECT catnum FROM category WHERE small = " + "'" + catname +"'";
		int catnum = 0 ; 
		try{
			rs = stmt.executeQuery(query);		
			
			rs.next();
			catnum = Integer.parseInt(rs.getString("catnum"));
			
		}catch(SQLException ex){
			System.out.println("SQL selectCatnum 오류 : " + ex.getLocalizedMessage());
		}finally{
			disconnect();
		}	
		return catnum;
	}
	//카테고리를 arrayList형태로  리턴 하는 메소드
	public ArrayList<String> selectCategory(){
		String query = "SELECT DISTINCT small FROM category";		//DISTINCT 중복이면 1개만 
		ArrayList<String> big = new ArrayList<String>();
		try{
			rs = stmt.executeQuery(query);	
			
			while(rs.next()){
				big.add(rs.getString("small"));
			}
			
			
		}catch(SQLException ex){
			System.out.println("SQL select 오류 : " + ex.getLocalizedMessage());
		}finally{
			disconnect();
		}		
		return big;
	}
	//product 번호통해 상품 갖고오는 메소드
	public ArrayList<String> selectProduct(int pronum){
		String query = "SELECT * FROM product where pronum="+pronum+"";
		ArrayList<String> al = new ArrayList<String>();
		try{
			rs = stmt.executeQuery(query);		
			
			rs.last();
			
			al.add(rs.getString("title"));
			al.add(rs.getString("proinfo"));
			al.add(rs.getString("procondition"));
			al.add(rs.getString("traway"));
			al.add(rs.getString("tratype"));
			al.add(rs.getString("renprice"));
			al.add(rs.getString("renday"));
			al.add(rs.getString("deposit"));
			al.add(rs.getString("salprice"));
			al.add(rs.getString("catnum"));
			
			
		}catch(SQLException ex){
			System.out.println("SQL selectCatnum 오류 : " + ex.getLocalizedMessage());
		}finally{
			disconnect();
		}	
		return al;
	}

}

