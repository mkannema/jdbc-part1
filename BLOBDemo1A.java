import java.sql.*;
import java.io.*;
public class BLOBDemo1A
{
	public static void main(String[] args) throws Exception
	{
		String driver="oracle.jdbc.OracleDriver";
		Class.forName(driver);
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott";
		String pwd="tiger";
		String sqlQuery="insert into persons values(?,?)";
		 Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1,"katrina");
		File f = new File("katrina.jpg");
		byte[] bytes = new byte[(int)f.length()];
		FileInputStream fis = new FileInputStream(f);
		fis.read(bytes);
		Blob b = con.createBlob();
		b.setBytes(0,bytes);
		ps.setBlob(2,b);
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
