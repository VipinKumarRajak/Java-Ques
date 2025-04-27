/*
 * Construct JDBC Application to perform Update and Delete Operations on Customer table.
(based Customer PhoneNo)
 */

package test;
import java.util.*;
import java.sql.*;

public class DBCon5 {
 public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	try(s;){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
		Statement stm=con.createStatement();
		System.out.println("Enter the query (create/insert/update/delete)");
		String qry= s.nextLine();
		int k=stm.executeUpdate(qry);
		System.out.println("The value in k:"+k);
		if(k>=0) {
			System.out.println("Query executed Successfully...");
			
		}
		con.close();
	}
	catch(SQLSyntaxErrorException sqe) {
		System.out.println(sqe.getMessage());
		System.out.println("Error Code: "+sqe.getErrorCode());
		
	}catch(SQLIntegrityConstraintViolationException sie) {
		System.out.println(sie.getMessage());
		System.out.println("Error code"+sie.getErrorCode());
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
