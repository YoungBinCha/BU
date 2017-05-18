package sale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import rent.rentDTO;

public class saleDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	saleDTO dto;
	ArrayList<saleDTO> sale_list = new ArrayList<saleDTO>();
	ArrayList<saleDTO> sale_list2 = new ArrayList<saleDTO>();
	
	public saleDAO(){
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
	
	public void insert_sale(String guest,int pronum,String way,String message,int total){
		connect();
		try{
			String sql="insert into sale(guest,pronum,way,message,total) values('"+guest+"',"+pronum+",'"+way+"','"+message+"',"+total+")";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public String select_sale(int pronum){
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
			String sql="update sale set hoster='"+nickname+"' where guest='"+guest+"' and pronum="+pronum+"";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public ArrayList<saleDTO> sale_list(String nickname){
		try{
			connect();
			String sql = "select * from sale where hoster='"+nickname+"' order by salenum desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int salenum = rs.getInt("salenum");
				String hoster = rs.getString("hoster");
				String guest = rs.getString("guest");
				int pronum = rs.getInt("pronum");
				String way = rs.getString("way");
				String message = rs.getString("message");
				int total = rs.getInt("total");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new saleDTO(salenum, hoster, guest, pronum, way, message, total,curtime);
				sale_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return sale_list;
	}
	
	public ArrayList<saleDTO> sale_list2(String nickname){
		try{
			connect();
			String sql = "select * from sale where guest='"+nickname+"' order by salenum desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int salenum = rs.getInt("salenum");
				String hoster = rs.getString("hoster");
				String guest = rs.getString("guest");
				int pronum = rs.getInt("pronum");
				String way = rs.getString("way");
				String message = rs.getString("message");
				int total = rs.getInt("total");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new saleDTO(salenum, hoster, guest, pronum, way, message, total,curtime);
				sale_list2.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return sale_list2;
	}
	
}
