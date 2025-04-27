



package nit.task20march ;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Onlinesystemdata {

	public static Connection con=null;
	public static long senderAccount=12345,receiverAccount=54321;
	public static double tAmount=10000;
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sachin");
			PreparedStatement ps=con.prepareStatement
					("insert into employe values(?,?,?,?)");
			 File f=new File
					("C:\\Users\\Dell\\Downloads\\MOCK_DATA.csv");
			if(f.exists())
			{
				 FileInputStream fis=new FileInputStream(f);
				 Scanner sc=new Scanner(fis);
				 sc.nextLine();
				 while(sc.hasNext())
				 {
					String[] split = sc.nextLine().split(",");
					ps.setInt(1, Integer.parseInt(split[0]));
					ps.setString(2, split[1]);
					ps.setString(3, split[2]);
					ps.setString(4, split[3]);
//					for(int i=0;i<split.length;i++)
//					{
//					ps.setString(i+1, split[i]);
//					}
					ps.executeUpdate();
				 }
				 System.out.println("Success");
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
