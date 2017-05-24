package mypage_reply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import product.proDTO;


public class mypage_replyDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	mypage_replyDTO dto;
	ArrayList<mypage_replyDTO> reply_list = new ArrayList<mypage_replyDTO>();
	ArrayList<mypage_replyDTO> reply_list2 = new ArrayList<mypage_replyDTO>();
	
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
	
	public ArrayList<mypage_replyDTO> reply_list(String host){
		try{
			connect();
			String sql = "select * from mypage_reply where guest='"+host+"' order by curtime desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int pronum = rs.getInt("pronum");
				String hoster = rs.getString("hoster");
				String guest = rs.getString("guest");
				String message = rs.getString("message");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new mypage_replyDTO(hoster, guest, message, curtime, pronum);
				reply_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return reply_list;
	}
	
	public ArrayList<mypage_replyDTO> reply_list2(String host){
		try{
			connect();
			String sql = "select * from mypage_reply where hoster='"+host+"' order by curtime desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int pronum = rs.getInt("pronum");
				String hoster = rs.getString("hoster");
				String guest = rs.getString("guest");
				String message = rs.getString("message");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new mypage_replyDTO(hoster, guest, message, curtime, pronum);
				reply_list2.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return reply_list2;
	}
}
