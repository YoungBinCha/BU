package jang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import product.proDTO;

public class jangDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	jangDTO dto;
	ArrayList<jangDTO> jang_list = new ArrayList<jangDTO>();
	
	int pron;
	public jangDAO(){
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
	
	public void insert_jang(String nickname,int productnumber){
		connect();
		try{
			String sql="insert into cart(nickname,productnumber) values('"+nickname+"',"+productnumber+")";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public ArrayList<jangDTO> select_jang(Object nickname){
		try{
			connect();
			String sql = "select * from cart where nickname='"+nickname+"' order by cartnumber desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int cartnumber = rs.getInt("cartnumber");
				int productnumber = rs.getInt("productnumber");
				String nick = rs.getString("nickname");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new jangDTO(cartnumber, nick, productnumber, curtime);
				jang_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return jang_list;
	}
	
	public void delete_jang(String productnumber){
		try {
			connect();
			String sql="delete from cart where productnumber='"+productnumber+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
