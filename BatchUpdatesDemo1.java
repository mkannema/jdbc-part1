import java.sql.*;
public class BatchUpdatesDemo1 
{
	public static void main(String[] args) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
		Statement st = con.createStatement();
		st.addBatch("select * from employees");
		st.addBatch("insert into employees values(100,'Mallika',4500,'Chennai')");
		st.addBatch("update employees set esal=esal+777 where esal<4000");
		st.addBatch("delete from employees where esal>5000");
		int[] count=st.executeBatch();
		int updateCount=0;
		for(int x: count)
		{
			updateCount=updateCount+x;
		}
		System.out.println("The number of rows updated :"+updateCount);
		con.close();
	}
}