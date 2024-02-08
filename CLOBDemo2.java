import java.sql.*;
import java.io.*;
public class CLOBDemo2
{
	public static void main(String[] args) throws Exception
	{
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott";
		String pwd="tiger";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		PreparedStatement ps = con.prepareStatement("select * from cities");
		ResultSet rs =ps.executeQuery();
		FileWriter fw = new FileWriter("hyd_history_new.txt");
		if(rs.next())
		{
			String name=rs.getString(1);
			Reader r = rs.getCharacterStream(2);
			/*char[] buffer = new char[1024];
			while(r.read(buffer)>0)
			{
				fw.write(buffer);
			}*/
			int i=r.read();
			while(i != -1)
			{
				fw.write(i);
				i = r.read();
			}
			fw.flush();
			System.out.println("Retrieved Successfully file :hyd_history_new.txt");
		}
		con.close();
	}
}
