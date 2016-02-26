package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws Exception {

		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement stat = conn.createStatement();
		stat.executeUpdate("drop table if exists people;");
		stat.executeUpdate("create table people (name, occupation);");
		PreparedStatement prep = conn
				.prepareStatement("insert into people values (?, ?);");

		prep.setString(1, "Ram");
		prep.setString(2, "Businessman");
		prep.addBatch();
		prep.setString(1, "Shyam");
		prep.setString(2, "Teacher");
		prep.addBatch();
		prep.setString(1, "Geeta");
		prep.setString(2, "Student");
		prep.addBatch();
		
		

		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);

		ResultSet rs = stat.executeQuery("select * from people;");
		System.out.println("============FETCH DATA :::::");
		while (rs.next()) {
			
			System.out.println("name = " + rs.getString("name"));
			System.out.println("job = " + rs.getString("occupation"));
		}
		rs.close();
		conn.close();

		
		
	}
	
	//////////
	
	
	
	
	
	
	/*
	public ArrayList<String> readFileFromSQLite() {

        fileName = new ArrayList<String>();

        fileSQLiteAdapter = new FileSQLiteAdapter(FileChooser.this);
        fileSQLiteAdapter.openToRead();
        cursor = fileSQLiteAdapter.queueAll();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    fileName.add(cursor.getString(cursor
                            .getColumnIndex(FileSQLiteAdapter.KEY_CONTENT1)));
                } while (cursor.moveToNext());

            }
            cursor.close();

        }
        fileSQLiteAdapter.close();
        return fileName;

    }*/
	
	
	
	
	
	
	
}