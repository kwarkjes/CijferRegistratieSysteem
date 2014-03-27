package Model;


import java.util.ArrayList;

import dataStorageLayer.DatabaseConnection;
import dataStorageLayer.FieldMapping;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasicModel {

    private ArrayList<FieldMapping> InternalFields;

    protected String TableName;
    protected String KeyFieldName;    
    public Integer KeyValue; 


	BasicModel() {
	  InternalFields = new ArrayList<FieldMapping>();
	}

	protected void AddMapping(String AMapping){
		InternalFields.add(new FieldMapping(AMapping));		
	}
        
        public String GetAdditionalJoin(){
            return "";
        } ;
        public String GetAdditionalWHERE(){
            return "";
        } ;        
	
	
	public boolean load(DatabaseConnection databaseConnection) {
		String SQLString;
		SQLString = "SELECT * " +
                            "FROM " +  TableName + " " +
                            GetAdditionalJoin() +
                            " WHERE "+ KeyFieldName +" = " + KeyValue.toString() +
                            GetAdditionalWHERE();
		
		
		java.sql.ResultSet rs = databaseConnection.executeSqlStatement(SQLString);

		
        try {        
        	if(rs.next()) {        	        	
        		for (FieldMapping Field : InternalFields) { 
        			java.lang.reflect.Field t = getClass().getDeclaredField(Field.FieldName);
                                t.setAccessible(true);
        			t.set(this, rs.getObject(t.getName()));
        		}
            } else
            {
            	return false;
            }
        	
            if(rs.next()) {
                throw new RuntimeException("duplicate identities in table");
            }
        }
        catch(SQLException e) {
            throw new RuntimeException("result set could not be read: " + e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("result set could not be read: " + e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("result set could not be read: " + e);
        } catch (RuntimeException e) {
            throw new RuntimeException("result set could not be read: " + e);
        }
		
		return true;
	}
	
	
	public boolean Save(DatabaseConnection databaseConnection) throws SQLException{
		String SQLString;
		SQLString = "";

                ArrayList array = new ArrayList();
  
		for (FieldMapping Field : InternalFields) { 
                    try {

                        java.lang.reflect.Field t = getClass().getDeclaredField(Field.FieldName);

                        if (t != null) {

                            
                            
                            
                            try {
                                if (KeyValue == null) {
                                    if (SQLString.equals("")) {
                                            SQLString = "INSERT INTO " + TableName +  " Values ( null, ?";// + t.get(this); 
                                    } else
                                    {
                                            SQLString += ", ? "; // + t.get(this);	
                                    }
                                 
                                    
                                } else //als het een bestaande is dan een update
                                {
                                    if (SQLString.equals("")) {
                                            SQLString = "UPDATE " + TableName +  " SET " + t.getName()+ "= ?";// + t.get(this); 
                                    } else
                                    {
                                            SQLString += ", " + t.getName()+ "= ?"; // + t.get(this);	
                                    }
                                }
                                
                                
                                
                                
                                array.add(t.get(this));
                                
                                
                            } catch (IllegalArgumentException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                            }
                        }
                    } catch (SecurityException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }

                }
		
		if (!SQLString.isEmpty() ) {
                    
                        if (KeyValue == null){
                            SQLString += ")"; 
                        } else{
                            SQLString += " WHERE " + KeyFieldName + "=" + KeyValue;
                        }    
                        
                    PreparedStatement prepStmt = databaseConnection.connection.prepareStatement(SQLString, PreparedStatement.RETURN_GENERATED_KEYS);
                    
                    for (int i = 0; i < array.size(); i++) { 
                        prepStmt.setObject(i +1, array.get(i));
                    }
                    
                    prepStmt.executeUpdate();
                    
                        //prepStmt.executeUpdate(prepStmt.RETURN_GENERATED_KEYS);
                    if (KeyValue == null){   
                        ResultSet rs = prepStmt.getGeneratedKeys();
                        if (rs.next()){
                            KeyValue=rs.getInt(1);
                        }  
                    }

//                    if (KeyValue == null){   
//                        KeyValue = prepStmt.getGeneratedKeys();
//                    }
//                    
                    


        
		}


		
		return true;
	}
	
        
        public void Delete(DatabaseConnection databaseConnection) throws SQLException{
		String SQLString;
		SQLString = "DELETE FROM " + TableName + 
                            " WHERE " + KeyFieldName + " = " + KeyValue.toString() ;
                
                databaseConnection.executeSqlUpdate(SQLString);
        }
}
