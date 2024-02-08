import javax.sql.rowset.*;

public class CachedRowSetDeleteDemo {
    public static void main(String[] args)throws Exception{
        
        RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet rs=rsf.createCachedRowSet();
        rs.setUrl("jdbc:mysql://localhost:3306/durgadb?relaxAutoCommit=true");
        rs.setUsername("root");
        rs.setPassword("root");
        rs.setCommand("select * from employees");
        rs.execute();
        while(rs.next()){
            float esal=rs.getFloat(3);
            if(esal>=5000){
               rs.deleteRow();
            }
        }
        rs.moveToCurrentRow();
        rs.acceptChanges();
		rs.close();
		System.out.println("Records deleted successfully");
    }
}