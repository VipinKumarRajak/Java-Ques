/*
 * 
Program Statement01:
====================
step-1 : Create the following DB Tables
StuData(stuId,stuRollNo,stuName,stuBranch)
StuAddress(stuId,stuHno,city,pincode)
StuContact(stuId,mid,phno)

step-2 :Construct Procedure to display the complete details of student based on stuId.
step-3 :Construct JDBC Application to execute Procedure.

output:
Enter Student Id : 
102
enter rollNo :
1000192
Enter sName :
indra
Enter Branch :
cs
Enter Hounse No :
nh23
Enter city :
nagpur
Enter pincode:
876598
Enter mail id :
ind@gmail.com
Enter Phno:
8765498765
Inserted succcessfully...

 */

package nit.advjava.statement2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Students {
 public static void main(String[] args) {
	Scanner s= new Scanner(System.in);
	try(s;){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
		CallableStatement c1 = con.prepareCall("{call StudentDetails(?,?,?,?,?,?,?,?,?)}");
		
		System.out.println("Enter Student Id : ");
		int sid=s.nextInt();
		
		System.out.println("enter rollNo :");
		int rno=s.nextInt();
		
		System.out.println("Enter sName :");
		String sname=s.nextLine();
		sname=s.nextLine();
		
		System.out.println("Enter Branch :");
		String sbranch=s.nextLine();
		
		System.out.println("Enter Hounse No :");
		String hno=s.nextLine();
		
		System.out.println("Enter city :");
		String city=s.nextLine();
		
		System.out.println("Enter pincode:");
		int pcode=s.nextInt();
		
		System.out.println("Enter mail id :");
		String mid=s.nextLine();
		s.nextLine();
		
		System.out.println("Enter Phno:");
		long phno=s.nextLong();
		
		c1.setInt(1,sid);
		c1.setInt(2, rno);
		c1.setString(3,sname);
		c1.setString(4, sbranch);
		c1.setString(5, hno);
		c1.setString(6, city);
		c1.setInt(7,pcode );
		c1.setString(8,mid);
		c1.setLong(9, phno);
		c1.execute();
		System.out.println("Inserted succcessfully...");
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
