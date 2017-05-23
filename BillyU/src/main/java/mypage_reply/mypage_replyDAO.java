package mypage_reply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class mypage_replyDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	mypage_replyDTO dto;
	
	public mypage_replyDAO(){
		try{Class.forName("com.mysql.jdbc.Driver");}
		catch(Exception e){e.printStackTrace();}
		}
	
	public void connect(){
		try{
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/billyu",
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
	
	public void insert_reply(int pronum,String hoster,String guest,String message){
		connect();
		try{
			String sql="insert into mypage_reply(pronum,hoster,guest,message) values("+pronum+",'"+hoster+"','"+guest+"','"+message+"')";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
}
