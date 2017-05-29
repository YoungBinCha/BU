package category;
import java.sql.*;
import java.util.*;

public class cateDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	cateDTO dto;
	ArrayList<cateDTO> categorybig_list = new ArrayList<cateDTO>();
	ArrayList<cateDTO> categorysmall_list = new ArrayList<cateDTO>();
	ArrayList<cateDTO> categorynumber_list = new ArrayList<cateDTO>();
	
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
	
	public ArrayList<cateDTO> categorybig_list(){
		try{
			connect();
			String sql = "select distinct categorybig from category";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String categorybig = rs.getString("categorybig");
				
				dto = new cateDTO(categorybig);
				categorybig_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return categorybig_list;
	}
	
	public ArrayList<cateDTO> categorysmall_list(){
		try{
			connect();
			String sql = "select * from category";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String categorybig = rs.getString("categorybig");
				String categorysmall = rs.getString("categorysmall");
				
				dto = new cateDTO(categorybig,categorysmall);
				categorysmall_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		 
		return categorysmall_list;
	}
	
	public ArrayList<cateDTO> categorynumber(int categorynumber){
		try{
			connect();
			String sql = "select * from category where categorynumber = "+categorynumber+"";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String categorybig = rs.getString("categorybig");
				String categorysmall = rs.getString("categorysmall");
				
				dto = new cateDTO(categorybig,categorysmall);
				categorynumber_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		 
		return categorynumber_list;
	}
	
	public String receivecategorysmall(int categorynumber){
		String categorysmall = "";
		try{
			connect();
			String sql = "select categorysmall from category where categorynumber = "+categorynumber+";";
			rs = stmt.executeQuery(sql);
			rs.next();
			categorysmall = rs.getString("categorysmall");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return categorysmall;
	}
}
