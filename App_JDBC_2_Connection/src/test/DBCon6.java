/*
 * Ex:(Demonstrating PreparedStatement)

DBTable : BankCustomer72(accno,cid,cname,balance,acctype)
primary key : accno

create table BankCustomer72(accno number(15),cid varchar2(15),cname varchar2(15),
balance number(10,2),acctype varchar2(15),primary key(accno));

Construct JDBC Application to perform the following operations based on Choice:
1.AddBankCustomer
2.ViewAllBankCustomers
3.Exit

Note:
repeat the process until we perform exit operation
o/p:
******Operations Choice******
1.AddBankCustomer
2.ViewAllBankCustomers
3.Exit
Enter Your Choice:

2
6123456 SB6123456 Alex 12000.0 Savings
454541234 SB454541234 Ram 16000.0 Savings
******Operations Choice******
1.AddBankCustomer
2.ViewAllBankCustomers
3.Exit
Enter Your Choice:
3
Operations Stopped...

 */

package test;
import java.util.*;
import java.sql.*;
public class DBCon6 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
			
			PreparedStatement ps1=con.prepareStatement("insert into BankCustomer72 values(?,?,?,?,?");
			//Comilation Process
			PreparedStatement ps2=con.prepareStatement("select * from BankCustomer72");//Compilation Process
			
			while(true) {
				System.out.println("**** Operations Choice *****");
				System.out.println("\t1.AddBankCustomer"
				                      +"\n\t2.ViewAllBankCustomers"
						               +"\n\t3.Exit");
				System.out.println("Enter Your Choice:");
				int choice= Integer.parseInt(s.nextLine());
				switch(choice) {
				case 1:
					// read data from console into Local Variables
					System.out.println("Enter the CustAccNo:");
					Long accNo = Long.parseLong(s.nextLine());
					String cId="SB"+accNo;
					System.out.println("Enter the CustName:");
					String cName=s.nextLine();
					System.out.println("Enter the Cust-BAlance");
					float balance=Float.parseFloat(s.nextLine());
					System.out.println("Enter rhe Cust-AccType");
					String accType=s.nextLine();
					
					//Load data to PreparedStatement Object using setter methods
					ps1.setLong(1, accNo);
					ps1.setString(2,cId);
					ps1.setString(3, cName);
					ps1.setFloat(4,balance);
					ps1.setString(5, accType);
					
					int k=ps1.executeUpdate();//Execution Process
					if(k>0) {
						System.out.println("BankCustomer Added Successfully....");
						
					}
					break;
				case 2:
					ResultSet rs= ps2.executeQuery();//Execution Process
					while(rs.next()) {
						System.out.println(rs.getString(1)+"\t"
								          +rs.getLong(2)+"\t"
								          +rs.getString(3)+"\t"
								          +rs.getFloat(4)+"\t"
						                  +rs.getString(5));
					} // end of loop
					break;
					
				case 3:
					System.out.println("Operations Stopped..");
					System.exit(0);
				default:
					System.out.println("Invalid Choice...");
				}//end of Switch
			}// end ofwhile
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
