package test;

import java.sql.*;

public class DBCon1 {
  public static void main(String[] args) {
	try {
		
     // step 1 : Load a Driver
	Class.forName("oracle.jdbc.driver.OracleDriver");

	// step 2 : Creating Connection to Database Product
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
	
	// step 3: preparing JDBC-statement
	Statement stm =con.createStatement();
	
	// step 4: Executing the query
	ResultSet rs = stm.executeQuery("select * from Customer72");
	while(rs.next()) {
		System.out.println(rs.getLong(1)+"\t"
				+rs.getString(2)+"\t"
				+rs.getString(3)+"\t"
				+rs.getString(4)+"\t"
				+rs.getString(5));
		
	}// end of Loop
	
	// step - 5 : Closing the connection from Database
	
	con.close();
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
