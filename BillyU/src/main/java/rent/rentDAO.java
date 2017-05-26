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
	
	public void insert_rent(String productguest,int productnumber,String message,String way,int startdate,int enddate,int totalprice){
		connect();
		try{
			String sql="insert into rent(productguest,productnumber,message,startdate,enddate,totalprice) values('"+productguest+"',"+productnumber+",'"+message+"',"+startdate+","+enddate+","+totalprice+")";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public String select_rent(int productnumber){
		connect();
		String nickname="";
		try{
			String sql="select nickname from product where productnumber='"+productnumber+"'";
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
	
	public void insert_nickname(String nickname,String productguest,int productnumber){
		connect();
		try{
			String sql="update rent set producthost='"+nickname+"' where productguest='"+productguest+"' and productnumber="+productnumber+"";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public ArrayList<rentDTO> rent_list(String nickname){
		try{
			connect();
			String sql = "select * from rent where producthost='"+nickname+"' order by rentnumber desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int rentnumber = rs.getInt("rentnumber");
				String producthost = rs.getString("producthost");
				String productguest = rs.getString("productguest");
				int productnumber = rs.getInt("productnumber");
				int startdate = rs.getInt("startdate");
				int enddate = rs.getInt("enddate");
				String message = rs.getString("message");
				int totalprice = rs.getInt("totalprice");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new rentDTO(rentnumber, producthost, productguest, productnumber, startdate, enddate, message, totalprice,curtime);
				rent_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return rent_list;
	}
	
	public ArrayList<rentDTO> rent_list2(String nickname){
		try{
			connect();
			String sql = "select * from rent where productguest='"+nickname+"' order by rentnumber desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int rentnumber = rs.getInt("rentnumber");
				String producthost = rs.getString("producthost");
				String productguest = rs.getString("productguest");
				int productnumber = rs.getInt("productnumber");
				int startdate = rs.getInt("startdate");
				int enddate = rs.getInt("enddate");
				String message = rs.getString("message");
				int totalprice = rs.getInt("totalprice");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new rentDTO(rentnumber, producthost, productguest, productnumber, startdate, enddate, message, totalprice,curtime);
				rent_list2.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return rent_list2;
	}
	public void delete_rent(int rentnumber){
		connect();
		try{
			String sql="delete from rent where rentnumber="+rentnumber+"";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
}
