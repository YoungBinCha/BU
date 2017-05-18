package regist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import product.proDTO;

public class registDAO {
	private static Connection conn;

	public registDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("JDBD load fail");
		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/billyu?useUnicode=true&characterEncoding=euckr", "root", "1234");
		} catch (SQLException ex) {
			System.out.println("SQL fail(Connection) : " + ex.getLocalizedMessage());
		}
	}

	public boolean insertSaleProduct(registDTO dto) {
		String query = "insert into product (nickname, catnum, title, proinfo, procondition, traway, tratype, salprice) values (?, ?, ?, ?, ?, ?, ?, ?);";
		boolean check = false;
		try {

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickname());
			pstmt.setInt(2, dto.getCatnum());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getProinfo());
			pstmt.setString(5, dto.getProcondition());
			pstmt.setString(6, dto.getTraway());
			pstmt.setString(7, dto.getTratype());
			pstmt.setInt(8, dto.getSalprice());

			pstmt.executeUpdate(); // UPDATE, DELETE 할 때 사용
			check = true;
			pstmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL insertSaleProduct() 오류  : " + ex.getLocalizedMessage());
		}
		return check;
	}

	public boolean insertRentProduct(registDTO dto) {
		String query = "insert into product (nickname, catnum, title, proinfo, procondition, traway, tratype, renprice, deposit, renday) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		boolean check = false;
		try {

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

			pstmt.executeUpdate();
			check = true;
			pstmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL insertRentProduct() 오류 : " + ex.getLocalizedMessage());
		}
		return check;
	}

	public int selectCatnum(String catname) {
		String query = "SELECT catnum FROM category WHERE small = " + "'" + catname + "'";
		int catnum = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			catnum = Integer.parseInt(rs.getString("catnum"));

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectCatnum() 오류 : " + ex.getLocalizedMessage());
		}
		return catnum;
	}

	public ArrayList<String> selectCategory() {
		String query = "SELECT DISTINCT small FROM category"; // DISTINCT 중복 제거
		ArrayList<String> big = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				big.add(rs.getString("small"));
			}

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectCategory() 오류 : " + ex.getLocalizedMessage());
		}
		return big;
	}

	public ArrayList<String> selectProduct(int pronum) {
		String query = "SELECT * FROM product where pronum=" + pronum + "";
		ArrayList<String> al = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

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
		} catch (SQLException ex) {
			System.out.println("SQL selectProduct() 오류 : " + ex.getLocalizedMessage());
		}
		return al;
	}

	// insert image
	public boolean insertImage(registDTO dto, int pronum) {

		String query = "insert into image values (?, ?, ?, ?, ?);";
		boolean check = false;
		try {

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pronum);
			pstmt.setString(2, "resources/img/" + dto.getImg());
			pstmt.setString(3, "resources/img/" + dto.getImg2());
			pstmt.setString(4, "resources/img/" + dto.getImg3());
			pstmt.setString(5, "resources/img/" + dto.getImg4());

			pstmt.executeUpdate();
			check = true;
			pstmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL insertImage insertImge() 오류 : " + ex.getLocalizedMessage());
		}
		return check;
	}

	public boolean updateImage(registDTO dto, int pronum) {
		String address = "resources/img/" + dto.getImg();
		
		String query = "update product set img='"+address+"' where pronum = "+pronum+" ;";
		boolean check = false;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			check = true;
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL updateImage() 오류 : " + e.getLocalizedMessage());
		}
		return check;

	}

	public int selectPronum() {
		String query = "SELECT * FROM product";
		int pronum = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.last();
			pronum = Integer.parseInt(rs.getString("pronum"));

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectPronum() 오류 : " + ex.getLocalizedMessage());
		}
		return pronum;
	}
	
	public String receiveImage(int pronum){
		String query = "SELECT img FROM product where pronum = "+pronum+" ;";
		String image = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			image = rs.getString("img");

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectPronum() 오류 : " + ex.getLocalizedMessage());
		}
		return image;
	}

	public ArrayList<String> selectImage() {
		String query = "SELECT * FROM image";
		ArrayList<String> al = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			rs.last();

			al.add(rs.getString("img"));
			al.add(rs.getString("img2"));
			al.add(rs.getString("img3"));
			al.add(rs.getString("img4"));

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectImage() 오류 : " + ex.getLocalizedMessage());
		}
		return al;
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException ex) {
			System.out.println("SQL ����(close) : " + ex.getLocalizedMessage());
		}

	}
}
