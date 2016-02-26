package Demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDB {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:flikart_app.db";
	static DatabaseMetaData metadata = null;

	public static void main(String[] args) throws Exception {
		Connection connection = null;
		try {

			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL);
			ResultSet rs = null;
			DatabaseMetaData meta = connection.getMetaData();
			rs = meta.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
			//	System.out.println("tables Name=" + tableName);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM "
						+ tableName);

				
				ResultSetMetaData metadata = resultSet.getMetaData();
				int columnCount = metadata.getColumnCount();
			 //   System.out.println("total Column count: " + columnCount);

				List<String> columns = new ArrayList<String>();
				List<String> coltype = new ArrayList<String>();
				for (int i = 1; i <= metadata.getColumnCount(); i++) {
                    //System.out.println(metadata.getColumnTypeName(i)+"\t\t"+metadata.getColumnName(i));
                    columns.add(metadata.getColumnName(i));
                    coltype.add(metadata.getColumnTypeName(i));
				}
				System.out.println("COlumn names :" + columns);
				System.out.println("COlumn coltype :" + coltype);
				
				while (resultSet.next()) {
					for (String columnName : columns) {
						
				   String value = resultSet.getString(columnName);
			       System.out.println("Value Of columns :" + value);
				   
				   /*Blob blob = null; 
			        try { 
			            blob = rs.getBlob(value); 
			            byte[] bdata =blob.getBytes(1, (int) blob.length());
			            System.out.println("Blob========" +bdata); 
			        } 
			        finally { 
			            if (blob != null) { 
			                blob.free(); 
			            } 
			        } */
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			connection.close();
		}
	}

	public static void getColumnsMetadata(ArrayList tables) throws SQLException {

		ResultSet rs = null;
		List<String> listS = (List<String>) tables;
		// Print the columns properties of the actual table
		for (String actualTable : listS) {
			rs = metadata.getColumns(null, null, actualTable, null);
			System.out.println(actualTable.toUpperCase());
			while (rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME") + " "
						+ rs.getString("TYPE_NAME") + " "
						+ rs.getString("COLUMN_SIZE"));
			}
			System.out.println("\n");
		}
	}
	
	 

	public static ArrayList getTablesMetadata() throws SQLException {
		String table[] = { "TABLE" };
		ResultSet rs = null;
		ArrayList tables = null;
		// receive the Type of the object in a String array.
		rs = metadata.getTables(null, null, null, table);
		tables = new ArrayList();
		while (rs.next()) {
			tables.add(rs.getString("TABLE_NAME"));
		}
		return tables;
	}
}
