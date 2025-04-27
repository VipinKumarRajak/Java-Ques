import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetaDAta {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sachin");
				DatabaseMetaData dbmd = con.getMetaData();
				System.out.println(dbmd.getDriverName());
				System.out.println(dbmd.getDriverVersion());
				PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
				System.out.println("*************8");
				ParameterMetaData pmd = ps.getParameterMetaData();
				System.out.println(pmd.getParameterCount());
				PreparedStatement ps2 = con.prepareStatement("select * from employee");
		        ResultSet rs=ps2.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
			System.currentTimeMillis();
			System.out.println(rsmd.getColumnName(2));
			//System.out.println(rsmd.getTableName(1));
				//System.out.println(pmd.getParameterType(2));
				//System.out.println(dbmd.get);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
