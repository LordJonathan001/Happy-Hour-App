package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProductDAO implements ProductDAO {
	
	private static String DRIVER = "";
	private static String URL = "";

	public AbstractProductDAO(String driver, String url) {
		try {
			DRIVER = driver;
			URL = url;
			Class.forName(DRIVER);
			createTable();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}

	protected void myUpdate(String q) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(q);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("myUpdate SQL exception " + e.getMessage());
			System.out.println("\nQuery: " + ps.toString());
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract void createTable();
	
	public abstract int insertRecord(Product p);

	public void deleteTable() {
		myUpdate("drop table if exists product");
	}

	public void populateTable() {
		myUpdate("insert into product values (null, 'Mansfield', 'bar1', 'drink1', 5.99)");
		myUpdate("insert into product values (null, 'Elmira', 'bar2', 'drink2', 6.99)");
		myUpdate("insert into product values (null, 'Towanda', 'bar3', 'drink3', 12.99)");
		myUpdate("insert into product values (null, 'Troy', 'bar4', 'drink4', 9.99)");
		myUpdate("insert into product values (null, 'Corning', 'bar5', 'drink5', 13.50)");
	}

	@Override
	public Product findRecordById(int id) {
		String q = "select id, city, barName, drinkName, price from product where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product p = null;
		try {
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(q);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new Product(rs.getInt("id"), rs.getString("city"), rs.getString("barName"),
						rs.getString("drinkName"), rs.getDouble("price"));
			}
		} catch (SQLException e) {
			System.out
					.println("findRecordById SQL exception " + e.getMessage());
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
		return p;
	}

	@Override
	public List<Product> retrieveAllRecords(String columnName) {
		String q = "select id, city, barName, drinkName, price from product order by ";
		if (columnName.equalsIgnoreCase("id"))
			q += "id";
		else if (columnName.equalsIgnoreCase("city"))
			q += "city";
		else if (columnName.equalsIgnoreCase("barName"))
			q += "barName";
		else if (columnName.equalsIgnoreCase("drinkName"))
			q += "drinkName";
		else
			q += "price";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(q);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt("id"), rs.getString("city"), rs.getString("barName"), rs
						.getString("drinkName"), rs.getDouble("price")));
			}
		} catch (SQLException e) {
			System.out.println("retrieveAllRecords SQL exception "
					+ e.getMessage());
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
		return list;
	}


	@Override
	public void deleteRecord(int id) {
		String q = "delete from product where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(q);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("deleteRecord SQLException: " + ex.getMessage());
			System.out.println("\nQuery: " + ps.toString());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateRecord(Product p) {
		String q = "update product set city = ?, barName = ?, drinkName = ?, price = ? where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(q);
			ps.setString(1, p.getCity());
			ps.setString(2, p.getBarName());
			ps.setString(3, p.getDrinkName());
			ps.setDouble(4, p.getPrice());
			ps.setInt(5, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertRecord SQL exception " + e.getMessage());
			System.out.println("\nQuery: " + ps.toString());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
