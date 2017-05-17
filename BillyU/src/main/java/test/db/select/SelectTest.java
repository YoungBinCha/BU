package test.db.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {

	private String title;
	private String cetegory;
	private String quantity;
	private String info;
	private String condition;
	
	private String rentalfee;
	private String deposit;
	private String period;
	private String trade;

	public void selectProduct() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/testbox";
			Connection conn = DriverManager.getConnection(url, "root", "skshboris2");
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM product";

			ResultSet rs = stmt.executeQuery(sql);
				
			rs.next();
			title = rs.getString("title");
			cetegory = rs.getString("cetegory");
			quantity = rs.getString("quantity");
			condition = rs.getString("condition");
			info = rs.getString("info");


			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectRental() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/testbox";
			Connection conn = DriverManager.getConnection(url, "root", "skshboris2");
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM testinput";

			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			rentalfee = rs.getString("rentalfee");
			deposit = rs.getString("deposit");
			period = rs.getString("period");
			trade = rs.getString("trade");

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getTitle() {
		return title;
	}

	public String getCetegory() {
		return cetegory;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getInfo() {
		return info;
	}

	public String getCondition() {
		return condition;
	}

	
	public String getRentalfee() {
		return rentalfee;
	}

	public String getDeposit() {
		return deposit;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public String getTrade() {
		return trade;
	}
}
