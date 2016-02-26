package backup;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDB  {

	public static void main(String[] args) throws Exception {
		
        String strr="";
        String st="/home/rahul/truecaller/databases/truecaller.data.LogEvent.s3db";
		final String driver = "org.sqlite.JDBC";
		final String url = "jdbc:sqlite:"+st;
		Connection connection = null;
		try {
			/**
			 * load the driver class and get connection from database.
			 */
			Class.forName(driver);
			connection = DriverManager.getConnection(url);

			ResultSet rs = null;
			DatabaseMetaData meta = connection.getMetaData();
			rs = meta.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
				System.out.println("tables Name=" + tableName);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM "
						+ tableName);

				/**
				 * The ResultSetMetaData is where all meta data related
				 * information for a result set is stored.
				 */
				ResultSetMetaData metadata = resultSet.getMetaData();
				int columnCount = metadata.getColumnCount();
				System.out.println("total Column count: " + columnCount);

				/**
				 * To get the column names and types we do a loop for a number
				 * of column count returned above.
				 */
				List<String> columns = new ArrayList<String>();
				List<String> coltype = new ArrayList<String>();
				for (int i = 1; i <= metadata.getColumnCount(); i++) {
					// System.out.println(metadata.getColumnTypeName(i)+"\t\t"+metadata.getColumnName(i));
					columns.add(metadata.getColumnName(i));
					coltype.add(metadata.getColumnTypeName(i));
				}
				System.out.println("COlumn names :" + columns);
				System.out.println("COlumn coltype :" + coltype);

				/**
				 * we use the collected column names and types above and to get
				 * the value of the column it self.
				 */
				while (resultSet.next()) {
					for (String columnName : columns) {

						String value = resultSet.getString(columnName);
						strr=value;
						System.out.println("Value Of columns :" + value);
					}
				}
			}
		
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/**
			 * close connection
			 */
			connection.close();
		}
	}

}
