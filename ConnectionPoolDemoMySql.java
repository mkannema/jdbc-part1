import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.jdbc2.optional.*;
class ConnectionPoolDemoMySql
{
	public static void main(String[] args) throws Exception
	{
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/durgadb");
		ds.setUser("root");
		ds.setPassword("root");
		Connection con=ds.getConnection();
		Statement st =con.createStatement();
		ResultSet rs=st.executeQuery("select * from employees");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("---------------------------");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
		}
		con.close();
	}
}