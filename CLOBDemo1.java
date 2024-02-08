import java.sql.*;
import java.io.*;
public class CLOBDemo1
{
	public static void main(String[] args) throws Exception
	{
		String driver="oracle.jdbc.OracleDriver";
		Class.forName(driver);
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott";
		String pwd="tiger";
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		String sqlQuery="insert into cities values(?,?)";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1,"Hyderabad");
		File f = new File("hyd_history.txt");
		FileReader fr = new FileReader(f);
		ps.setCharacterStream(2,fr);
		System.out.println("file is inserting from :"+f.getAbsolutePath());
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
