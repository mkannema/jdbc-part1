import java.sql.*;
import java.io.*;
public class BLOBDemo2
{
	public static void main(String[] args) throws Exception
	{
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott";
		String pwd="tiger";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		PreparedStatement ps = con.prepareStatement("select * from persons");
		ResultSet rs =ps.executeQuery();
		FileOutputStream os = new FileOutputStream("katrina_new.jpeg");
		if(rs.next())
		{
			String name=rs.getString(1);
			InputStream is = rs.getBinaryStream(2);
			byte[] buffer = new byte[2048];
			while(is.read(buffer)>0)
			{
				os.write(buffer);
			}
			os.flush();
			System.out.println("image is available in :katrina_new.jpeg");
		}
		con.close();
	}
}
