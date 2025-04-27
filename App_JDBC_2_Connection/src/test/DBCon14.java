/*DB Table : Bank72(accNo,name,bal,accType)
Primary Key:accNo

create table Bank72(accno number(15),name varchar2(15),bal number(10,2),accType
varchar2(15),
primary key(accno));

insert into Bank72 values(6123456,&#39;Alex&#39;,12000,&#39;Savings&#39;);
insert into Bank72 values(313131,&#39;Ram&#39;,500,&#39;Savings&#39;);

ACCNO NAME BAL ACCTYPE
---------- --------------- ---------- ---------------
6123456 Alex 12000 Savings
313131 Ram 500 Savings

Transaction : Transfer amt:5000/- from accNo:6123456 to accNo:313131

Statement-1 : Subtract amt:5000/- from accNo:6123456
Statement-2 : Add amt:5000/- to accNo:313131
 * output:-
 * Commit-Status:true
Commit-Status:false
Enter the Home-AccNo:
6123456
Enter the benificieryAccNo:
3131310
enter the amount to be Transferred:
5000
Transaction successful..


 */

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBCon14 {

	public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        try(s;){
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
        	PreparedStatement ps1=con.prepareStatement("select * from Bank72 where accno=?");
        	PreparedStatement ps2=con.prepareStatement("update Bank72 set bal=bal+?where accNo=?");
        	
        	System.out.println("Commit-Status:"+con.getAutoCommit());
        	con.setAutoCommit(false);
        	System.out.println("Commit-Status:"+con.getAutoCommit());
        	System.out.println("Enter the Home-AccNo:");
        	long hAccNo=s.nextLong();
        	ps1.setLong(1, hAccNo);
        	ResultSet rs1=ps1.executeQuery();
        	if(rs1.next()) {
        		Float bl=rs1.getFloat(3);
        		System.out.println("Enter the benificieryAccNo:");
        		long bAccNo=s.nextLong();
        		ps1.setLong(1, bAccNo);
        		
        		ResultSet rs2=ps1.executeQuery();
        		if(rs2.next()) {
        			System.out.println("enter the amount to be Transferred:");
        			float amt=s.nextFloat();
        			if(amt<=bl) {
        				
        				// statement 1: Subtract amt:5000
        				ps2.setFloat(1, -amt);
        				ps2.setLong(2, hAccNo);
        				int p=ps2.executeUpdate();// update in buffer
        				
        				
        				//statement 2: Add amt:5000/- to accNo:313131
        				ps2.setFloat(1, +amt);
        				ps2.setLong(2, bAccNo);
        				int q=ps2.executeUpdate();// Updated in buffer
        				if(p==1 && q==1) {
        					System.out.println("Transaction successful..");
        					con.commit();
        					
        				}else {
        					System.out.println("Transaction failed..");
        					con.rollback();
        				}
        				
        			}
        			else {
        				System.out.println("Insufficient fund..");
        				
        			}
        		}
        		else {
        			System.out.println("Invalid bAccNo..");
        		}

        	}
        	else {
        		System.out.println("Invalid HomeAccNo..");
        	}
        	con.close();
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
