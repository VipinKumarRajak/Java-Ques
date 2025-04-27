/*
 * Program Statement03:
====================
Step01=>Create Table:emp_info
Columns:empId,empName,empAddress,empSalary,empPhNo.
Step02: Construct Function to retrieve Employee's name based on Employee Id.
step03: Construct JDBC Application to execute function.

output:-
Enter Employee Id to retrieve EmpName :
201
***Details***
Emp-Id :201
EmpName:Deepak
 */

package nit.advjava.statement2;
import java.util.*;
import java.sql.*;
public class Emp {
 public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	try(s;){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
		CallableStatement cs=con.prepareCall("{call ?:=getName(?)}");
		System.out.println("Enter Employee Id to retrieve EmpName :");
		String eId=s.nextLine();
		cs.setString(2, eId);
		cs.registerOutParameter(1,Types.VARCHAR);
		cs.execute();
		System.out.println("***Details***");
		System.out.println("Emp-Id :"+eId);
		System.out.println("EmpName:"+cs.getString(1));
		con.close();
	}catch(Exception e) {
		e.printStackTrace();
	 }
}
}
