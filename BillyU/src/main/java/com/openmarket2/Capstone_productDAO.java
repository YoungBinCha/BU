package com.openmarket2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.openmarket.*;

public class Capstone_productDAO {
private static Connection conn;
	
	//DB占쏙옙占쏙옙
	public Capstone_productDAO() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex){
			System.out.println("JDBD load fail");
		}
		try{
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/billyu?useUnicode=true&characterEncoding=euckr","root","1234");
		}catch(SQLException ex){
			System.out.println("SQL fail(Connection) : " + ex.getLocalizedMessage());
		}
	}
	
	
	
	//insert image
	public boolean insertImage(Capstone_productDTO dto, int pronum){
		
		String query = "insert into image values (?, ?, ?, ?, ?);";
		boolean check = false;			
		try{
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pronum);
			pstmt.setString(2, "resources/img/"+dto.getImg());
			pstmt.setString(3, "resources/img/"+dto.getImg2());
			pstmt.setString(4, "resources/img/"+dto.getImg3());
			pstmt.setString(5, "resources/img/"+dto.getImg4());
			
			pstmt.executeUpdate();			//UPDATE, DELETE 占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙 占쏙옙占�
			check = true;
			pstmt.close();
		}catch(SQLException ex){
			System.out.println("SQL insertImage 占쏙옙占쏙옙 : " + ex.getLocalizedMessage());
		}	
		return check;
	}
	public boolean updateImage(Capstone_productDTO dto, int pronum){
		
		String query = "update product set img='?' where pronum = ? ;";
		boolean check = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pronum);
			pstmt.setString(2, "resources/img/"+dto.getImg());
			
			pstmt.executeUpdate();			//UPDATE, DELETE 占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙 占쏙옙占�
			check = true;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		
	}
		public int selectPronum(){
			String query = "SELECT * FROM product";
			int pronum = 0 ; 
			try{
				Statement stmt = conn.createStatement();		
				ResultSet rs = stmt.executeQuery(query);		
				rs.last();
				pronum = Integer.parseInt(rs.getString("pronum"));
				
				stmt.close();
			}catch(SQLException ex){
				System.out.println("SQL selectCatnum 占쏙옙占쏙옙 : " + ex.getLocalizedMessage());
			}	
			return pronum;
		}
	
	

	public int selectCatnum(String catname){
		String query = "SELECT catnum FROM category WHERE small = " + "'" + catname +"'";
		int catnum = 0 ; 
		try{
			Statement stmt = conn.createStatement();		//占쏙옙占쌘울옙 sql占쏙옙占쏙옙 sql 占쏙옙占쏙옙占신놂옙占� 占쌍댐옙 statement占쏙옙占쏙옙
			ResultSet rs = stmt.executeQuery(query);		//select占쏙옙 占쏙옙占쏙옙
			
			rs.next();
			catnum = Integer.parseInt(rs.getString("catnum"));
			
			stmt.close();
		}catch(SQLException ex){
			System.out.println("SQL selectCatnum 占쏙옙占쏙옙 : " + ex.getLocalizedMessage());
		}	
		return catnum;
	}
	
	public ArrayList<String> selectCategory(){
		String query = "SELECT DISTINCT small FROM category";		//DISTINCT 占쌩븝옙占쏙옙占쏙옙 占싹놂옙占쏙옙 占쏙옙占�
		ArrayList<String> big = new ArrayList<String>();
		try{
			Statement stmt = conn.createStatement();		//占쏙옙占쌘울옙 sql占쏙옙占쏙옙 sql 占쏙옙占쏙옙占신놂옙占� 占쌍댐옙 statement占쏙옙占쏙옙
			ResultSet rs = stmt.executeQuery(query);		//select占쏙옙 占쏙옙占쏙옙
			
			while(rs.next()){
				big.add(rs.getString("small"));
			}
			
			stmt.close();
		}catch(SQLException ex){
			System.out.println("SQL select 占쏙옙占쏙옙 : " + ex.getLocalizedMessage());
		}	
		return big;
	}
	
	public ArrayList<String> selectProduct(){
		String query = "SELECT * FROM product";
		ArrayList<String> al = new ArrayList<String>();
		try{
			Statement stmt = conn.createStatement();		//占쏙옙占쌘울옙 sql占쏙옙占쏙옙 sql 占쏙옙占쏙옙占신놂옙占� 占쌍댐옙 statement占쏙옙占쏙옙
			ResultSet rs = stmt.executeQuery(query);		//select占쏙옙 占쏙옙占쏙옙
			
			rs.last();
			
			al.add(rs.getString("title"));
			al.add(rs.getString("proinfo"));
			al.add(rs.getString("procondition"));
			al.add(rs.getString("traway"));
			al.add(rs.getString("tratype"));
			al.add(rs.getString("renprice"));
			al.add(rs.getString("renday"));
			al.add(rs.getString("deposit"));
			al.add(rs.getString("salprice"));
			al.add(rs.getString("catnum"));
			
			
			stmt.close();
		}catch(SQLException ex){
			System.out.println("SQL selectCatnum 占쏙옙占쏙옙 : " + ex.getLocalizedMessage());
		}	
		return al;
	}
		public ArrayList<String> selectImage(){
			String query = "SELECT * FROM image";
			ArrayList<String> al = new ArrayList<String>();
			try{
				Statement stmt = conn.createStatement();		//占쏙옙占쌘울옙 sql占쏙옙占쏙옙 sql 占쏙옙占쏙옙占신놂옙占� 占쌍댐옙 statement占쏙옙占쏙옙
				ResultSet rs = stmt.executeQuery(query);		//select占쏙옙 占쏙옙占쏙옙
				
				rs.last();

				al.add(rs.getString("img"));
				al.add(rs.getString("img2"));
				al.add(rs.getString("img3"));
				al.add(rs.getString("img4"));

				
				
				stmt.close();
			}catch(SQLException ex){
				System.out.println("SQL selectCatnum 占쏙옙占쏙옙 : " + ex.getLocalizedMessage());
			}	
			return al;
		}
	public void close(){
		try{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}catch(SQLException ex){
			System.out.println("SQL 占쏙옙占쏙옙(close) : " + ex.getLocalizedMessage());
		}
		
	}
}
