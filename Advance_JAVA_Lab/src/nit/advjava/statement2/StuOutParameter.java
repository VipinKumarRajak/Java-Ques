package nit.advjava.statement2;
import java.util.*;
import java.sql.*;

public class StuOutParameter {
 public static void main(String[] args) {
	Scanner s= new Scanner(System.in);
	try(s;){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","sachin");
		CallableStatement c1 = con.prepareCall("{call StudentDetails(?,?,?,?,?,?,?,?,?)}");

		System.out.println("Enter Students Id to retrieve details :");
		int eId=s.nextInt();
		
		c1.setInt(1, eId);
		c1.registerOutParameter(2, Types.INTEGER);
		c1.registerOutParameter(3, Types.INTEGER);
		c1.registerOutParameter(4, Types.VARCHAR);
		c1.registerOutParameter(5, Types.VARCHAR);
		c1.registerOutParameter(6, Types.VARCHAR);
		c1.registerOutParameter(7, Types.INTEGER);
		c1.registerOutParameter(8, Types.VARCHAR);
		c1.registerOutParameter(9, Types.BIGINT);
       c1.execute();
       System.out.println("*****Details*****");
       System.out.println("student Id"+eId);
       System.out.println("Student Roll No :"+c1.getInt(2));
       System.out.println("Student Name :"+c1.getString(3));
       System.out.println("Student Branch :"+c1.getString(4));
       System.out.println("Student House No :"+c1.getString(5));
       System.out.println("City :"+c1.getString(6));
       System.out.println("Pincode :"+c1.getString(7));
       System.out.println("Mail Id"+c1.getString(8));
       System.out.println("Phone No :"+c1.getLong(9));
       con.close();
	}catch(Exception e) {
		e.printStackTrace();
		
	}
}
}
