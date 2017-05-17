package com.openmarket;

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
	
	//DB����
	public Capstone_productDAO() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex){
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		}
		try{
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/billyu?useUnicode=true&characterEncoding=euckr","root","1234");
		}catch(SQLException ex){
			System.out.println("SQL ����(Connection) : " + ex.getLocalizedMessage());
		}
	}
	
	public boolean insertSaleProduct(Capstone_productDTO dto){
		String query = "insert into product (nickname, catnum, title, proinfo, procondition, traway, tratype, salprice) values (?, ?, ?, ?, ?, ?, ?, ?);";
		boolean check = false;			//insert�� �����ߴ��� Ȯ���ϱ����� boolean
		try{
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickname());
			pstmt.setInt(2, dto.getCatnum());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getProinfo());
			pstmt.setString(5, dto.getProcondition());
			pstmt.setString(6, dto.getTraway());
			pstmt.setString(7, dto.getTratype());
			pstmt.setInt(8, dto.getSalprice());
			
			pstmt.executeUpdate();			//UPDATE, DELETE �� ����� ���� �� ���
			check = true;
			pstmt.close();
		}catch(SQLException ex){
			System.out.println("SQL insertSaleProduct ���� : " + ex.getLocalizedMessage());
		}	
		return check;
	}
	
	//����� ��ǰ�� �Ÿ������� '�뿩'�� ���
	public boolean insertRentProduct(Capstone_productDTO dto){
		String query = "insert into product (nickname, catnum, title, proinfo, procondition, traway, tratype, renprice, deposit, renday) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		boolean check = false;		//insert�� �����ߴ��� Ȯ���ϱ����� boolean
		try{
			//stament�� �ƴ� preparedStatemint�� ������ values�� ?�� ����ؼ� �ؿ��� �������� �ϳ��ϳ� �־��ֱ� ���ؼ�!!!!
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickname());
			pstmt.setInt(2, dto.getCatnum());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getProinfo());
			pstmt.setString(5, dto.getProcondition());
			pstmt.setString(6, dto.getTraway());
			pstmt.setString(7, dto.getTratype());
			pstmt.setInt(8, dto.getRenprice());
			pstmt.setInt(9, dto.getDeposit());
			pstmt.setInt(10, dto.getRenday());
			
			pstmt.executeUpdate();			//UPDATE, DELETE �� ����� ���� �� ���
			check = true;
			pstmt.close();
		}catch(SQLException ex){
			System.out.println("SQL insertRentProduct ���� : " + ex.getLocalizedMessage());
		}	
		return check;
	}
	
	//insert image
	public boolean insertImage(Capstone_productDTO dto, int pronum){
		//String query = "insert into product (nickname, catnum, title, proinfo, procondition, traway, tratype, salprice) values (?, ?, ?, ?, ?, ?, ?, ?);";
		String query = "insert into image (pronum, path,path2,path3,path4) value (?, 'img/"+ '?' +"','img/"+ '?' +"','img/"+ '?' +"','img/"+ '?' +"')";
		boolean check = false;			//insert�� �����ߴ��� Ȯ���ϱ����� boolean
		try{
			//stament�� �ƴ� preparedStatemint�� ������ values�� ?�� ����ؼ� �ؿ��� �������� �ϳ��ϳ� �־��ֱ� ���ؼ�!!!!
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pronum);
			pstmt.setString(2, dto.getImg());
			pstmt.setString(3, dto.getImg2());
			pstmt.setString(4, dto.getImg3());
			pstmt.setString(5, dto.getImg4());
			
			pstmt.executeUpdate();			//UPDATE, DELETE �� ����� ���� �� ���
			check = true;
			pstmt.close();
		}catch(SQLException ex){
			System.out.println("SQL insertSaleProduct ���� : " + ex.getLocalizedMessage());
		}	
		return check;
	}
	
	//select�� �̹� ���� pronum�� ��ȯ�Ѵ�
		public int selectPronum(){
			String query = "SELECT * FROM product ORDER BY pronum DESC LIMIT 1";
			int pronum = 0 ; 
			try{
				Statement stmt = conn.createStatement();		//���ڿ� sql���� sql �����ų�� �ִ� statement����
				ResultSet rs = stmt.executeQuery(query);		//select�� ����
				
				rs.next();
				pronum = Integer.parseInt(rs.getString("pronum"));
				
				stmt.close();
			}catch(SQLException ex){
				System.out.println("SQL selectCatnum ���� : " + ex.getLocalizedMessage());
			}	
			return pronum;
		}
	
	
	//�Է¹��� small(�Һз�)�� catnum ã���ִ� �Լ�
	public int selectCatnum(String catname){
		String query = "SELECT catnum FROM category WHERE small = " + "'" + catname +"'";
		int catnum = 0 ; 
		try{
			Statement stmt = conn.createStatement();		//���ڿ� sql���� sql �����ų�� �ִ� statement����
			ResultSet rs = stmt.executeQuery(query);		//select�� ����
			
			rs.next();
			catnum = Integer.parseInt(rs.getString("catnum"));
			
			stmt.close();
		}catch(SQLException ex){
			System.out.println("SQL selectCatnum ���� : " + ex.getLocalizedMessage());
		}	
		return catnum;
	}
	//��� �������� small(�Һз�)�� �����ֱ� ���ؼ� select�� ã�� �� arrayList �迭�� �������ִ� �Լ�
	public ArrayList<String> selectCategory(){
		String query = "SELECT DISTINCT small FROM category";		//DISTINCT �ߺ����� �ϳ��� ���
		ArrayList<String> big = new ArrayList<String>();
		try{
			Statement stmt = conn.createStatement();		//���ڿ� sql���� sql �����ų�� �ִ� statement����
			ResultSet rs = stmt.executeQuery(query);		//select�� ����
			
			while(rs.next()){
				big.add(rs.getString("small"));
			}
			
			stmt.close();
		}catch(SQLException ex){
			System.out.println("SQL select ���� : " + ex.getLocalizedMessage());
		}	
		return big;
	}
	//�Է��� product �Ӽ� view ���������� �����ֱ� ���� select 
	public ArrayList<String> selectProduct(int pronum){
		String query = "SELECT * FROM product where pronum="+pronum+"";
		ArrayList<String> al = new ArrayList<String>();
		try{
			Statement stmt = conn.createStatement();		//���ڿ� sql���� sql �����ų�� �ִ� statement����
			ResultSet rs = stmt.executeQuery(query);		//select�� ����
			
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
			System.out.println("SQL selectCatnum ���� : " + ex.getLocalizedMessage());
		}	
		return al;
	}
	//connection �� ��������� �ݾ��ֱ� !
	public void close(){
		try{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}catch(SQLException ex){
			System.out.println("SQL ����(close) : " + ex.getLocalizedMessage());
		}
		
	}
}
