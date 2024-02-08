import java.sql.*;
import javax.sql.rowset.*;
public class CachedRowSetDemo {
    public static void main(String[] args)throws Exception {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
		Statement st =con.createStatement();
		ResultSet rs =st.executeQuery("select * from employees");
        RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet crs=rsf.createCachedRowSet();
		crs.populate(rs);
		con.close();
		//Now we cannot access RS but we can access CRS
		//if(rs.next()){}//RE:SQLException:Operation not allowed after ResultSet closed
        System.out.println("ENO\tENAME\tESAL\tEADDR");
	    System.out.println("-----------------------------");
        while(crs.next()){
            System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getFloat(3)+"\t"+crs.getString(4));
        }
    }
}