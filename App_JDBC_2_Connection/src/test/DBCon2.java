/*
 * Construct JDBC Application to display Customer details based on PhoneNo.
 */

package test;
import java.util.*;
import java.sql.*;
public class DBCon2 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sachin");
			Statement stm=con.createStatement();
			System.out.println("Enter the Cust-phoneNo to display details:");
			long pNo =s.nextLong();
			ResultSet rs=stm.executeQuery("Select * from Customer72 where phno="+pNo+"");
			if(rs.next()) {
				System.out.println(rs.getLong(1)+"\t"
						+rs.getString(2)+"\t"
						+rs.getString(2)+"\t"
						+rs.getString(4)+"\t"
						+rs.getString(5));
			}
			else {
				System.out.println("Invalid Cust-PhNo....");
			}
			con.close();
			// end of try
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
