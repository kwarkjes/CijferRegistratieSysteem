/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStorageLayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Christian Kooiman
 */
public class DatabaseConnection {
    public Connection connection;
    private Statement statement;

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    private boolean connectionEstablished = false;

    public void setConnectionEstablished(boolean connectionEstablished) {
        this.connectionEstablished = connectionEstablished;
    }


    private DatabaseProperties databaseProperties = new DatabaseProperties();
   
    public DatabaseConnection(){
        openConnection();
    }
    
    private void openConnection() {
        
        if(connectionEstablished) {
            return;
        }
        
        String databaseVendor = databaseProperties.getDatabaseVendor();
        String hostName = databaseProperties.getHostName();
        String databaseName = databaseProperties.getDatabaseName();
        String userName = databaseProperties.getUserName();
        String password = databaseProperties.getPassword();

        try {
            String url = "jdbc:" + databaseVendor + "://" + hostName + "/" + databaseName;
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
            connectionEstablished = true;
        }
        catch(Exception e) {
              throw new RuntimeException("connection could not be established: " + e);
        }
    }
    
    /**
     * Meant to be used with SELECT, as it returns a Resultset. However it will 
     * also work with DELETE, INSERT or UPDATE SQL statements.
     * @param queryText
     * @return results of the SQL statement, typically the result of a SQL query
     */
    public ResultSet executeSqlStatement(String queryText){
        openConnection();
        ResultSet resultSet = null;
        try {  
            resultSet = statement.executeQuery(queryText);
            
        }
        catch(Exception e) {
              throw new RuntimeException("sql statement could not be executed: " + e);
        }
       return resultSet;
    }
    
    /**
     * Meant to be used with DELETE, INSERT or UPDATE. This method returns the
     * number of affected rows, however only if the executed SQL statement 
     * returns this information. Refer to the database documentation to find
     * out if the executed SQL statement returns the number of affected rows.
     * @param queryText
     * @return the number of affected rows
     */
    public int executeSqlUpdate(String queryText){
        openConnection();
        int nrAffectedRows = 0;
        try {  
            nrAffectedRows = statement.executeUpdate(queryText);
        }
        catch(Exception e) {
              throw new RuntimeException("insert/update statement could not be executed: " + e);
        }
        return nrAffectedRows;
    }
        
    /**
     *
     */
    public void closeConnection(){
        try {  
            statement.close();
            connection.close();
        }
        catch(Exception e) {
              throw new RuntimeException("exception occurred while attempting to close the database connection: " + e);
        }
    }
  
}