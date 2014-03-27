/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStorageLayer;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Erco
 */
public class DatabaseProperties {
    
    private String databaseVendor;
    private String hostName;
    private String databaseName;        
    private String userName;
    private String password;

    public DatabaseProperties() {
        loadProperties();
    }
    private void loadProperties() {
        Properties prop = new Properties();
        try {
            
//             String currentDirectory = System.getProperty("user.dir");
//             System.out.println("Current directory is: " + currentDirectory);
            
            prop.load(new FileInputStream("databaseConnection.properties"));
            databaseVendor = prop.getProperty("databasevendor");
            hostName = prop.getProperty("hostname");
            databaseName = prop.getProperty("databasename");
            userName = prop.getProperty("username").trim();
            password = prop.getProperty("password");
        }
        catch (Exception e) {
            throw new RuntimeException("database connection properties could not be loaded from configuration file: " + e);
        }
    }
    
    public String getDatabaseVendor(){
        return databaseVendor;
    }    

    public String getHostName(){
        return hostName;
    }
    
    public String getDatabaseName(){
        return databaseName;
    }    

    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
}