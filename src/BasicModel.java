
import java.util.ArrayList;

import dataStorageLayer.DatabaseConnection;
import dataStorageLayer.FieldMapping;

public class BasicModel {

    private ArrayList<FieldMapping> InternalFields;
    private DatabaseConnection databaseConnection;
    
    protected String TableName;
    protected Integer KeyValue = 1; 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.out.println("Test");
		  
		  BasicModel Basic = new BasicModel();
		  Basic.load();
		  
	}
	
	
	BasicModel() {
		  TableName = "Test";
     	  KeyValue = 1;		
     	  databaseConnection = new DatabaseConnection();
	}

	
	
	public boolean load() {
		String SQLString;
		SQLString = "SELECT * FROM " + TableName + " WHERE ID = " + KeyValue.toString();
		
		
		java.sql.ResultSet rs = databaseConnection.executeSqlStatement(SQLString);

		
        try {        
        	if(rs.next()) {        	        	
        		for (FieldMapping Field : InternalFields) { 
        			java.lang.reflect.Field t = getClass().getDeclaredField(Field.FieldName);
        			t.set(this, rs.getObject(t.getName()) );
        		}
            }
            if(rs.next()) {
                throw new RuntimeException("duplicate identities in table");
            }
        }
        catch(Exception e) {
            throw new RuntimeException("result set could not be read: " + e);
        }
		
		return true;
	}
	
}
