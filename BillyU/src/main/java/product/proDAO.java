package product;

import java.sql.*;
import java.util.*;

public class proDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	proDTO dto;
	
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

}

