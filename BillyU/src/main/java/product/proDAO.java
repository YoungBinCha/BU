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
	
	public void select(){
		try {
			int productnumber = rs.getInt("productnumber");
			String nickname = rs.getString("nickname");
			int categorynumber = rs.getInt("categorynumber");
			String title = rs.getString("title");
			String productinformation = rs.getString("productinformation");
			String location = rs.getString("location");
			String productstate = rs.getString("productstate");
			int rentprice = rs.getInt("rentprice");
			int rentmaxdate = rs.getInt("rentmaxdate");
			int rentdeposite = rs.getInt("rentdeposite");
			String img = rs.getString("img");
			Timestamp curtime = rs.getTimestamp("curtime");
			dto = new proDTO(productnumber, nickname, categorynumber, title, location, productinformation, productstate, rentmaxdate, rentmaxdate, rentdeposite, img, curtime);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<proDTO> pro_list(){
		try{
			connect();
			String sql = "select * from product order by productnumber desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				select();
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
			String sql = "select * from product where nickname='"+id+"' order by productnumber desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				select();
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
			String sql = "select * from product where productnumber='"+pro+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				select();
				jang_mylist.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return jang_mylist;
	}
	
	public void delete_product(String productnumber){
		try {
			connect();
			String sql="delete from product where productnumber='"+productnumber+"'";
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
				select();
				search_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return search_list;
	}
	
	public ArrayList<proDTO> Select_productnumber(int product_number){
		try{
			connect();
			String sql = "select * from product where productnumber = '"+product_number+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				select();
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
				select();
				search_list3.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return search_list3;
	}
	
	public ArrayList<proDTO> Select_categorynumber(String categorysmall){
		try{
			connect();
			String sql = "select * from product p,category c where p.categorynumber = c.categorynumber and c.categorysmall='"+categorysmall+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				select();
				search_all_cate.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return search_all_cate;
	}
}

