package backup;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDBParse {

	public static void main(String[] args) throws Exception {

		List<String> getCol = null;

		Connection conn = getSQLiteConnection();
		System.out.println("Got Connection");
		System.out.println("");
		Statement st = conn.createStatement();

		ResultSet rs = null;
		DatabaseMetaData meta = conn.getMetaData();

		rs = meta.getTables(null, null, null, new String[] { "TABLE" });

		while (rs.next()) {
			String tableName = rs.getString("TABLE_NAME");
			System.out.println("tableName=" + tableName);

			ArrayList<String> allFields = new ArrayList<String>();
			ResultSet columnsResultSet = meta.getColumns(null, null, tableName,
					null);
			while (columnsResultSet.next()) {
				allFields.add(columnsResultSet.getString("COLUMN_NAME"));
				getCol = allFields;
			}
			System.out.println("Columns Name=" + getCol);
			
			

		}

		// st.close();
		conn.close();
	}

	private static Connection getSQLiteConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
		System.out.println("Driver Loaded.");
		String url = "jdbc:sqlite:flikart_app.db";
		return DriverManager.getConnection(url);
	}

}
