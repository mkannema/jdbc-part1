import javax.sql.rowset.*;
public class CachedRowSetRetriveDemo {
    public static void main(String[] args)throws Exception {
        RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet rs=rsf.createCachedRowSet();
        rs.setUrl("jdbc:mysql://localhost:3306/durgadb");
        rs.setUsername("root");
        rs.setPassword("root");
        rs.setCommand("select * from employees");
        rs.execute();
		System.out.println("Data In Forward Direction");
        System.out.println("ENO\tENAME\tESAL\tEADDR");
	    System.out.println("-----------------------------");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
        }
		System.out.println("Data In Backward Direction");
        System.out.println("ENO\tENAME\tESAL\tEADDR");
	    System.out.println("--------------------------------");
        while(rs.previous()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
        }
		rs.close();
    }
}