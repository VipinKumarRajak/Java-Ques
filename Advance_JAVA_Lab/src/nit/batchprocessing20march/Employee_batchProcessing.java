/*
 * Program01::Write a jdbc program as follows:
===========
Table Name:Employee_Info.
Table Columns:-empId,empName,empSalary,empAddress,empMailId,empPhNo.
Note::-Using Batch Processing you have to execute following querries.
       1.Insert data into Employee Table.
       2.Update employee salary with the help of eid.
       3.delete employee who is getting maximum salary.  

 */

package nit.batchprocessing20march;
import java.util.*;
import java.sql.*;
public class Employee_batchProcessing {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;){
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
		  
		  Statement stm=con.createStatement();
		  System.out.println("*** Insert on Employee_Info ***");
		  System.out.println("Enter the Id:");
		  int id=s.nextInt();
		  System.out.println("Enter the Emp Name:");
		  String name=s.nextLine();
		  name=s.nextLine();
		  System.out.println("Enter the Emp salary:");
		  double sal=s.nextDouble();
		  System.out.println("Enter the Emp Address:");
		  String addr=s.nextLine();
		  addr=s.nextLine();
		  System.out.println("Enter Emp MailId :");
		  String mid=s.nextLine();
		  System.out.println("Enter Emp Phno : ");
		  Long phno=s.nextLong();
		  
		  stm.addBatch("insert into Employee_Info values("+id+",'"+name+"',"+sal+",'"+addr+"','"+mid+"',"+phno+")");
		  System.out.println("-- Employee data Inserted successfully --");

		  System.out.println("*** Update Emp sal with the help of Id ***");
          System.out.println("Enter Emp Id to update salary:");
          int id1=s.nextInt();
          System.out.println("enter updated salary:");
          double salr=s.nextDouble();
          
          
          stm.addBatch("update Employee_info set EMPSALARY="+salr+" where empid="+id1+"");
          System.out.println("Updated successfully");
          
          
         
          stm.addBatch("DELETE FROM employee_Info WHERE EMPSALARY = (SELECT MAX(EMPSALARY) FROM employee_Info)");
          System.out.println("data deleted succesfully:");
          
		  int k[]=stm.executeBatch();
		 // System.out.println(k.length);
		  for(int i:k) {
			  System.out.println("query Executed :"+i);
		  }
		  
		  
		  stm.clearBatch();
		 
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
