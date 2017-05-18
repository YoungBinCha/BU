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
	
	int pron;//상품번호 가져오는거
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
	
	public void insert_jang(String nickname,int pronum){
		connect();
		try{
			String sql="insert into jang(nickname,pronum) values('"+nickname+"',"+pronum+")";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public ArrayList<jangDTO> select_jang(Object nickname){
		try{
			connect();
			String sql = "select * from jang where nickname='"+nickname+"' order by jangnum desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int jangnum = rs.getInt("jangnum");
				int pronum = rs.getInt("pronum");
				String nick = rs.getString("nickname");
				Timestamp curtime = rs.getTimestamp("curtime");

				dto = new jangDTO(jangnum, nick, pronum, curtime);
				jang_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return jang_list;
	}
	
	public void delete_jang(String pronum){
		try {
			connect();
			String sql="delete from jang where pronum='"+pronum+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
