package ScenarioBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBmySQLConnectionTest {

	public static void main(String[] args) throws SQLException {
		/*
		// mySQL default port 3306, Oracle default port 1521
		// Automation DB- DML - Select,Insert,Update,Delete
		// SQL- Structured Query Language, DDL - Create, Alter, Drop , 
		 * TCL - Commit, Rollback, DCL - DB Administrative command - grant and revoke

	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
	if(connection.isClosed()) {
		System.out.println("not connected to mySQL DB");
	}
	else
	{
		System.out.println("connected to mySQL DB Sucessfully");
	}

		 */

		//Connect DB, Create Statement, Execute Query, Store result in resultSet
		//Step #1 - Connect DB
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/demo", "root", "root");

		//Step #2 - Create Statement
		Statement stmt = connection.createStatement();

		//Step #3 - Execute SQL Statement
		String strQuery = "select * from table1";
		ResultSet rs= stmt.executeQuery(strQuery);
		rs.getMetaData().getColumnCount();
		rs.getRow();
		rs.isLast();
		rs.isFirst();
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  


		connection.close();

	}

}
