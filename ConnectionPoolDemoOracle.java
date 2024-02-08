import java.sql.*;
import javax.sql.*;
import oracle.jdbc.pool.*;// ojdbc6.jar
class ConnectionPoolDemoOracle
{
	public static void main(String[] args) throws Exception
	{
		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
		ds.setURL("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUser("scott");
		ds.setPassword("tiger");
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