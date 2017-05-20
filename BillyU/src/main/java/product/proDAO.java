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
	ArrayList<proDTO> jang_mylist = new ArrayList<proDTO>();
	ArrayList<proDTO> search_list = new ArrayList<proDTO>();
	ArrayList<proDTO> search_list2 = new ArrayList<proDTO>();
	ArrayList<proDTO> search_list3 = new ArrayList<proDTO>();
	ArrayList<proDTO> search_all_cate = new ArrayList<proDTO>();
	
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
	
	public ArrayList<proDTO> MyJang(int pro){
		try{
			connect();
			String sql = "select * from product where pronum='"+pro+"'";
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
				jang_mylist.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return jang_mylist;
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
	
	public ArrayList<proDTO> Select_Title(String search){
		try{
			connect();
			String sql = "select * from product where title like '%"+search+"%'";
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
				search_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return search_list;
	}
	
	public ArrayList<proDTO> Select_Pronum(int product_number){
		try{
			connect();
			String sql = "select * from product where pronum = '"+product_number+"'";
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
				search_list2.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return search_list2;
	}
	
	public ArrayList<proDTO> Select_Nicknamae(String nick){
		try{
			connect();
			String sql = "select * from product where nickname = '"+nick+"'";
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
				search_list3.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return search_list3;
	}
	
	public ArrayList<proDTO> Select_Catnum(int cat){
		try{
			connect();
			String sql = "select * from product where catnum = "+cat+"";
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
				search_all_cate.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return search_all_cate;
	}
	/*
	 * 여기부터 상품등록할 때 사용하는 메소드 -- Capstone_prodctDAO에서 온 것들
	 */
	
	

}

