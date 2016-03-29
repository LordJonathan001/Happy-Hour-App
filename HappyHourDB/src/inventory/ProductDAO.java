package inventory;

import java.util.List;

/**
 * Inteface for the Data Access Object used by the Inventory program. Taken from
 * our Java program. The Groovy implementation of this interface,
 * DAOSQLiteProductGroovy, could be a drop in replacement for the Java
 * implementation, DAOSQLiteProduct, as both implement this same interface.
 * 
 * @author Reid Parker
 * @version 1.0 on 2/25/2016
 */
public interface ProductDAO {

	public void createTable();

	public void deleteTable();

	public void populateTable();

	public List<Product> retrieveAllRecords(String columnName);
	
	public Product findRecordById(int id);

	public int insertRecord(Product p);
	
	public void updateRecord(Product p);

	public void deleteRecord(int id);

}
