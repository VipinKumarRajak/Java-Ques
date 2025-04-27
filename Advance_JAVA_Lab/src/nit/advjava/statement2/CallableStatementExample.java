
/*Program Statement02:
====================
Write a Java program named CallableStatementExample that connects to a Oracle database using JDBC. The program should include the following functionalities:

Establish a connection to the database using the provided JDBC URL, username, and password.
Define a method named callFunction() that executes a stored function named getTotalEmployees in the database. This method should use a CallableStatement to call the function and retrieve the total number of employees. Print the total number of employees obtained from the function call.
Implement a main() method that demonstrates the usage of the connect() and callFunction() methods. The main() method should:
Call the connect() method to establish a connection to the database.
Call the callFunction() method to execute the stored function and retrieve the total number of employees.
Close the CallableStatement and the database connection after executing the function call.
Ensure appropriate exception handling for potential database connectivity issues and SQL errors.

Note: Replace "jdbc:oracle:thin:@localhost:1521:xe", "username", and "password" with your actual database URL, username, and password respectively. Additionally, ensure that the stored function getTotalEmployees exists in your database and returns an integer value.

 * output :
 * Total Employees :5 
 */
package nit.advjava.statement2;
import java.util.*;
import java.sql.*;
public class CallableStatementExample {

	public static void main(String[] args) {
         Scanner s=new Scanner(System.in);
         try(s;){
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
        	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
        	 CallableStatement cs=con.prepareCall("{call ?:=getTotalEmployees}");
        	callFunction(cs);
        	con.close();
         }catch(Exception e) {
        	 e.printStackTrace();
         }
	}
	
	public static void callFunction(CallableStatement c) throws SQLException{
		c.registerOutParameter(1, Types.INTEGER);
		 c.execute();
		 System.out.println("Total Employees :"+c.getInt(1));
	}

}
