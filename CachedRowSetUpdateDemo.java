import javax.sql.rowset.*;

public class CachedRowSetUpdateDemo {
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
            if(esal<3500){
                esal=esal+111;
                rs.updateFloat(3, esal);
                rs.updateRow();
            }
        }
        rs.moveToCurrentRow();
        rs.acceptChanges();
		System.out.println("Records Updated Successfully");
		rs.close();
    }
}