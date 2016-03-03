package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object for inventory table. Written using Java 7 and MySQL.
 * 
 * @author Reid Parker
 * @version 1.1 on 2/25/2016
 */
public class DAOMySQLProduct extends AbstractProductDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/rparker?user=rparker&password=secret";

	public DAOMySQLProduct() {
		super(DRIVER, URL);
	}

	public void createTable() {
		String q = "create table if not exists product ("
				+ "id integer primary key auto_increment, "
				+ "city varchar(55) not null, " 
				+ "barName varchar(55) not null, " 
				+ "drinkName varchar(55) not null, "
				+ "price double not null)";
		myUpdate(q);
	}

	@Override
	public int insertRecord(Product p) {
		String q = "INSERT INTO product (id, city, barName, drinkName, price) VALUES (null, ?, ?, ?, ?)";
		int id = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(q);
			ps.setString(1, p.getCity());
			ps.setString(2, p.getBarName());
			ps.setString(3, p.getDrinkName());
			ps.setDouble(4, p.getPrice());
			ps.executeUpdate();
			// mysql: last_insert_id vs. sqlite: last_insert_rowid
			ps = conn.prepareStatement("select last_insert_id()");
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("insertRecord SQL exception " + e.getMessage());
			System.out.println("\nQuery: " + ps.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
}
