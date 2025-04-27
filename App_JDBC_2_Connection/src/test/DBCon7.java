/*
 * Ex:
Construct JDBC Application to perform the following operations on Choice based on AccNo
1.UpdateBankCustomer
2.DeleteBankCustomer

OUTPUT:
--------
o/p:(Update)
Enter the Cust-AccNo to perform Update/Delete operation:
454541234
*******Operation Choice*****
1.UpdateBankCustomer
2.DeleteBankCustomer
Enter your Choice:
1
Existing balance:16000.0

Enter the new balance:
20000
Customer Updated Successfully...

o/p:(Delete)
Enter the Cust-AccNo to perform Update/Delete operation:
454541234
*******Operation Choice*****
1.UpdateBankCustomer
2.DeleteBankCustomer
Enter your Choice:
2
Customer deleted Successfully....

 */

package test;
import java.sql.*;
import java. util.*;

public class DBCon7 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
			  PreparedStatement ps1=con.prepareStatement("select * from BankCustomer72 where accno=?");
			  //compilation process
			  
			  PreparedStatement ps2=con.prepareStatement("update BankCustomer72 set balance=? where accno=?");
			  //compilation process
			  
			  PreparedStatement ps3=con.prepareStatement("delete from BankCustomer72 where accno=?");
			  // compilation process
			  System.out.println("Enter the Cust-AccNo to perform Update/Delete operation:");
			  String accNo=s.nextLine();
			  ps1.setString(1,accNo);
			  ResultSet rs = ps1.executeQuery();
			  if(rs.next()) {
				  System.out.println("*****Operation Choice****");
				  System.out.println("\t1.UpdateBankCustomer"
						              +"\n\t2.DeleteBankCustomer");
				  System.out.println("Enter Your Choice:");
				  int choice=s.nextInt();
				  switch(choice) {
				  case 1:
					  System.out.println("Existing balance:"+rs.getFloat(4));
					  System.out.println("Enter the new balance:");
                       float nBal=s.nextFloat();
                       ps2.setFloat(1, nBal);
                       ps2.setString(2, accNo);
                       int k1=ps2.executeUpdate();
                       if(k1>0) {
                    	   System.out.println("Customer Updated Successfully...");
                    	   
                       }
                       break;
				  case 2:
					  ps3.setString(1,accNo);
					  int k2=ps3.executeUpdate();
					  if(k2>0) {
						  System.out.println("Customer deleted Successfully...");
						  
					  }
					  break;
				default:
					System.out.println("Invalid Choice...");
						
 				  } // end of switch
			  }else
			  {
				  System.out.println("Invalid Accno...");
			  }
			  con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
