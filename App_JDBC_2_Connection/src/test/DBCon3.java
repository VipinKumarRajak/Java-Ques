/*
 * Construct JDBC Application to read Customer details from Console and insert into Customer72
 * table(Insert Operation)
 */

package test;
import java.sql.*;
import java.util.*;

public class DBCon3 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sachin");
		Statement stm=con.createStatement();
		System.out.println("Enter the Cust-Phno:");
		long phno= Long.parseLong(s.nextLine());
		String custid="HM"+phno;
		System.out.println("Enter the Customer Name :");
		String name=s.nextLine();
		System.out.println("Enter Cust - City :");
		String city=s.nextLine();
		System.out.println("Enter cust-mid :");
		String mid=s.nextLine();
		int k=stm.executeUpdate("insert into Customer72 values("+phno+",'"+custid+"','"+name+"','"+city+"','"+mid+"')");
		if(k>0) {
			System.out.println("Customer details added Successfully...");
		}
		con.close();
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

}
