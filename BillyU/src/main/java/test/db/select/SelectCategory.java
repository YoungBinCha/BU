package test.db.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectCategory {
	private int categoryNum;
	private String categoryName;
	private ResultSet rs;
	
	public void SelectCate(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/testbox";
			Connection conn = DriverManager.getConnection(url, "root", "skshboris2");
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM category";

			rs = stmt.executeQuery(sql);
				
			while(rs.next()){
				categoryNum = Integer.parseInt(rs.getString("categorynum"));
				categoryName = rs.getString("categoryname");
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	public ResultSet getResultSet(){
		return rs;
	}
	public int getCategoryNum(){
		return categoryNum;
	}
	public String getCategoryName(){
		return categoryName;
	}
}
