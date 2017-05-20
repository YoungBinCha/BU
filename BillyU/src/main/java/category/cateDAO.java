package category;
import java.sql.*;
import java.util.*;

public class cateDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	cateDTO dto;
	ArrayList<cateDTO> big_list = new ArrayList<cateDTO>();
	ArrayList<cateDTO> small_list = new ArrayList<cateDTO>();
	int cat;
	
	public cateDAO(){
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
	
	public ArrayList<cateDTO> big_list(){
		try{
			connect();
			String sql = "select distinct big from category";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String big = rs.getString("big");
				
				dto = new cateDTO(big);
				big_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return big_list;
	}
	
	public ArrayList<cateDTO> small_list(){
		try{
			connect();
			String sql = "select * from category";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String big = rs.getString("big");
				String small = rs.getString("small");
				
				dto = new cateDTO(big,small);
				small_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		 
		return small_list;
	}
	
	public String receiveSmall(int catnum){
		String small = "";
		try{
			connect();
			String sql = "select small from category where catnum = "+catnum+";";
			rs = stmt.executeQuery(sql);
			rs.next();
			small = rs.getString("small");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return small;
	}
	
	public int receivecat(String small){
		try{
			connect();
			String sql = "select * from category where small = '"+small+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
			cat = rs.getInt("catnum");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return cat;
	}
}
