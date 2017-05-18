package rent;

import java.sql.*;
import java.util.ArrayList;

import product.proDTO;

public class rentDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	rentDTO dto;
	ArrayList<rentDTO> rent_list = new ArrayList<rentDTO>();
	ArrayList<rentDTO> rent_list2 = new ArrayList<rentDTO>();
	
	public rentDAO(){
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
	}
	
	public void insert_rent(String guest,int pronum,String message,String way,int startdate,int rentday,int total){
		connect();
		try{
			String sql="insert into rent(guest,pronum,message,way,startdate,rentday,total) values('"+guest+"',"+pronum+",'"+message+"','"+way+"',"+startdate+","+rentday+","+total+")";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public String select_rent(int pronum){
		connect();
		String nickname="";
		try{
			String sql="select nickname from product where pronum='"+pronum+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				nickname = rs.getString("nickname");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		return nickname;
	}
	
	public void insert_nickname(String nickname,String guest,int pronum){
		connect();
		try{
			String sql="update rent set hoster='"+nickname+"' where guest='"+guest+"' and pronum="+pronum+"";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public ArrayList<rentDTO> rent_list(String nickname){
		try{
			connect();
			String sql = "select * from rent where hoster='"+nickname+"' order by rentnum desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int rentnum = rs.getInt("rentnum");
				String hoster = rs.getString("hoster");
				String guest = rs.getString("guest");
				int pronum = rs.getInt("pronum");
				String way = rs.getString("way");
				int startdate = rs.getInt("startdate");
				int rentday = rs.getInt("rentday");
				String message = rs.getString("message");
				int total = rs.getInt("total");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new rentDTO(rentnum, hoster, guest, pronum, way, startdate, rentday, message, total,curtime);
				rent_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return rent_list;
	}
	//위는 hoster 아래는 guest
	public ArrayList<rentDTO> rent_list2(String nickname){
		try{
			connect();
			String sql = "select * from rent where guest='"+nickname+"' order by rentnum desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int rentnum = rs.getInt("rentnum");
				String hoster = rs.getString("hoster");
				String guest = rs.getString("guest");
				int pronum = rs.getInt("pronum");
				String way = rs.getString("way");
				int startdate = rs.getInt("startdate");
				int rentday = rs.getInt("rentday");
				String message = rs.getString("message");
				int total = rs.getInt("total");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new rentDTO(rentnum, hoster, guest, pronum, way, startdate, rentday, message, total,curtime);
				rent_list2.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return rent_list2;
	}
}
