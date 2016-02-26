package Demo;

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

public class BlobParse {

		
		
		
		private static final String DRIVER = "org.sqlite.JDBC";
		private static final String URL = "jdbc:sqlite:flikart_app.db";
		static DatabaseMetaData metadata = null;

		public static void main(String[] args) throws Exception {
			Connection connection = null;
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * from flipkartproductinfo");
					
					
					byte[] ar = null;
					resultSet.next();
			        ar = resultSet.getBytes("response");
			        System.out.println("====DDDDDDDDDDDDDd======="+ar);
					
					/*Blob blob = resultSet.getBlob("response");
					byte[] bdata = blob.getBytes(1, (int) blob.length());
					String s = new String(bdata);
					System.out.println("++++++++"+s);*/
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connection.close();
			}
		}
}
