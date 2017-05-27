package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class userDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	boolean check_kakaoid = true;
	
	public userDAO(){
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
	
	public void delete_user(String nickname){
		connect();
		try{
			String sql="delete from user where nickname = '"+nickname+"'";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public boolean kakaoid_check(String kakaoid){
		connect();
		try{
			String sql="select * from user where usernumber = '"+kakaoid+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				check_kakaoid = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		return check_kakaoid;
	}
}
