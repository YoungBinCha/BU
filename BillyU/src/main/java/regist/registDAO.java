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
					"jdbc:mysql://localhost:3306/billyu?useUnicode=true&characterEncoding=utf8", "root", "1234");
		} catch (SQLException ex) {
			System.out.println("SQL fail(Connection) : " + ex.getLocalizedMessage());
		}
	}


	public boolean insertRentProduct(registDTO dto) {
		String query = "insert into product (nickname, categorynumber, title, productinformation, location, productstate, rentprice, rentdeposite, rentunit) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		boolean check = false;
		try {

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickname());
			pstmt.setInt(2, dto.getcategorynumber());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getproductinformation());
			pstmt.setString(5, dto.getlocation());		
			pstmt.setString(6, dto.getproductstate());
			pstmt.setInt(7, dto.getrentprice());
			pstmt.setInt(8, dto.getrentdeposite());
			pstmt.setInt(9, dto.getrentunit());

			pstmt.executeUpdate();
			check = true;
			pstmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL insertRentProduct() 오류 : " + ex.getLocalizedMessage());
		}
		return check;
	}

	public int selectcategorynumber(String catname) {
		String query = "SELECT categorynumber FROM category WHERE categorysmall = " + "'" + catname + "'";
		int categorynumber = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			categorynumber = Integer.parseInt(rs.getString("categorynumber"));

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectcategorynumber() 오류 : " + ex.getLocalizedMessage());
		}
		return categorynumber;
	}

	public ArrayList<String> selectCategory() {
		String query = "SELECT DISTINCT categorybig FROM category"; // DISTINCT 중복 제거
		ArrayList<String> categorybig = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				categorybig.add(rs.getString("categorybig"));
			}

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectCategory() 오류 : " + ex.getLocalizedMessage());
		}
		return categorybig;
	}
	
	public ArrayList<String> selectCategory2(String cate) {
		String query = "SELECT  categorysmall FROM category where categorybig='"+cate+"'"; // DISTINCT 중복 제거
		ArrayList<String> categorysmall = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				categorysmall.add(rs.getString("categorysmall"));
			}

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectCategory() 오류 : " + ex.getLocalizedMessage());
		}
		return categorysmall;
	}
	

	public ArrayList<String> selectProduct(int productnumber) {
		String query = "SELECT * FROM product where productnumber=" + productnumber + "";
		ArrayList<String> al = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			rs.last();

			al.add(rs.getString("categorynumber"));
			al.add(rs.getString("title"));
			al.add(rs.getString("productinformation"));
			al.add(rs.getString("location"));
			al.add(rs.getString("productstate"));
			al.add(rs.getString("rentprice"));
			al.add(rs.getString("rentunit"));
			al.add(rs.getString("rentdeposite"));
			

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectProduct() 오류 : " + ex.getLocalizedMessage());
		}
		return al;
	}

	// insert image
	public boolean insertImage(registDTO dto, int productnumber) {

		String query = "insert into image values (?, ?, ?, ?, ?);";
		boolean check = false;
		try {

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productnumber);
			pstmt.setString(2, "resources/img/" + dto.getImg1());
			pstmt.setString(3, "resources/img/" + dto.getImg4());
			pstmt.setString(4, "resources/img/" + dto.getImg3());
			pstmt.setString(5, "resources/img/" + dto.getImg2()); 

			pstmt.executeUpdate();
			check = true;
			pstmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL insertImage insertImge() 오류 : " + ex.getLocalizedMessage());
		}
		return check;
	}
	//메인사진을 넣지않고 서브 사진만 넣으면 사진이 안나와!!!
	public boolean updateImage(registDTO dto, int productnumber) {
		String address = "resources/img/" + dto.getImg1();
		
		String query = "update product set img='"+address+"' where productnumber = "+productnumber+" ;";
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

	public int selectproductnumber() {
		String query = "SELECT * FROM product";
		int productnumber = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.last();
			productnumber = Integer.parseInt(rs.getString("productnumber"));

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectproductnumber() 오류 : " + ex.getLocalizedMessage());
		}
		return productnumber;
	}
	
	public String receiveImage(int productnumber){
		String query = "SELECT img FROM product where productnumber = "+productnumber+" ;";
		String image = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			image = rs.getString("img");

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectproductnumber() 오류 : " + ex.getLocalizedMessage());
		}
		return image;
	}

	public ArrayList<String> selectImage(int productnumber) {
		String query = "SELECT * FROM image where productnumber = "+productnumber+";";
		ArrayList<String> arrayListImage = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			rs.next();

			arrayListImage.add(rs.getString("img1"));
			arrayListImage.add(rs.getString("img2"));
			arrayListImage.add(rs.getString("img3"));
			arrayListImage.add(rs.getString("img4"));

			stmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL selectImage() 오류 : " + ex.getLocalizedMessage());
		}
		return arrayListImage;
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException ex) {
			System.out.println("SQL 오류(close) : " + ex.getLocalizedMessage());
		}

	}
}
