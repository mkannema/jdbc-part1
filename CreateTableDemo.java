import java.sql.*;
public class CreateTableDemo 
{
	public static void main(String[] args) throws Exception
	{
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott";
		String pwd="tiger";
		String sql_query="create table employees67(eno number,ename varchar2(10),esal number(10,2),eaddr varchar2(10))";
		Class.forName(driver);
       	Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
		st.executeUpdate(sql_query);
		System.out.println("Table Created Successfully");
		con.close();
	}
}
