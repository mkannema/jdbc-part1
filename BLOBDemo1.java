import java.sql.*;
import java.io.*;
public class BLOBDemo1
{
	public static void main(String[] args) throws Exception
	{
		String driver="oracle.jdbc.OracleDriver";
		Class.forName(driver);
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott";
		String pwd="tiger";
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		String sqlQuery="insert into persons values(?,?)";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1,"Katrina");
		File f = new File("katrina.jpg");
		FileInputStream fis = new FileInputStream(f);
		ps.setBinaryStream(2,fis);
		System.out.println("inserting image from :"+f.getAbsolutePath());
		int updateCount=ps.executeUpdate();
		if(updateCount==1)
		{
			System.out.println("Record Inserted");
		}
		else
		{
			System.out.println("Record Not Inserted");
		}

	}
}
