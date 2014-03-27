/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import dataStorageLayer.DatabaseConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chris
 */
public class BeoordelingModel extends BasicModel {
    private boolean HasChanged;
    private String gebruikersnaam;

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }
    
    protected Date datumtijd;
    protected double cijfer;
    protected String document;
    protected String tentamencode;
    protected Integer gebruikerID;


    public BeoordelingModel() {
	  TableName = "evaluatie";
	  KeyFieldName = "ID";
	  // toekomst muziek.. waar gemaakt :D
	  for (java.lang.reflect.Field T : getClass().getDeclaredFields()){
              if (java.lang.reflect.Modifier.isProtected(T.getModifiers())){
                AddMapping(T.getName());       
            }
              
 
          }
          gebruikerID = 1;
    }


    public Date getDatumtijd() {
        return datumtijd;
    }

    public void setDatumtijd(Date datumtijd) {
        this.datumtijd = datumtijd;
    }

    public double getCijfer() {
        return cijfer;
    }

    public void setCijfer(double cijfer) {
        this.cijfer = cijfer;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTentamencode() {
        return tentamencode;
    }

    public void setTentamencode(String tentamencode) {
        this.tentamencode = tentamencode;
    }

    public Integer getGebruikerID() {
        return gebruikerID;
    }

    public void setGebruikerID(Integer gebruikerID) {
        this.gebruikerID = gebruikerID;
    }

    public boolean GetHasChanged() {
        return HasChanged;
    }

    public void setHasChanged(boolean HasChanged) {
        this.HasChanged = HasChanged;
    }
        
        

    public static ArrayList<BeoordelingModel> GetBeoordeling(DatabaseConnection databaseconnection, String Tentamencode){
            String SQLString;
            
            
            
            SQLString = " SELECT e.ID, datumtijd, cijfer, document, tentamenCode, gebruikerID, CONCAT_WS (' ', g.voornaam, g.tussenvoegsel, g.achternaam ) As gebruikersnaam " +
                        " FROM evaluatie e " +
                        " LEFT JOIN gebruiker g on (e.gebruikerID = g.ID) " +
                        " WHERE e.tentamenCode = '" + Tentamencode + "'";

            ArrayList<BeoordelingModel> Beoordelingen;


            Beoordelingen = new ArrayList<BeoordelingModel>();

            java.sql.ResultSet rs = databaseconnection.executeSqlStatement(SQLString);

            BeoordelingModel beoordeling;

            try {        
                while (rs.next()) { 
                    beoordeling = new BeoordelingModel();
                    beoordeling.KeyValue = rs.getInt("ID");
                    beoordeling.setGebruikerID(rs.getInt("gebruikerID"));
                    beoordeling.setDatumtijd(rs.getDate("datumtijd"));
                    beoordeling.setCijfer(rs.getDouble("cijfer"));
                    beoordeling.setDocument(rs.getString("document"));
                    beoordeling.setTentamencode(rs.getString("tentamenCode"));
                    beoordeling.setHasChanged(false);
                    beoordeling.setGebruikersnaam(rs.getString("gebruikersnaam"));

                    Beoordelingen.add(beoordeling);
                }       	        	

            }
            catch(SQLException e) {
                throw new RuntimeException("result set could not be read: " + e);
            }

            return Beoordelingen;
        }   
    
    public void Delete(DatabaseConnection databaseconnection ){
        if (this.KeyValue != null){
            String SQLString;
            
            
            
            SQLString = " DELETE FROM evaluatie " +
                        " WHERE ID = '" + KeyValue.toString() + "'";

            databaseconnection.executeSqlUpdate(SQLString); 
            
        
        }
    
    
    }
}
