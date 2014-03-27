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
public class PlanningModel extends BasicModel {

    protected Date datumtijd;
    protected String TentamenCode; 
    protected Integer gebruikerID;

    public Integer getGebruikerID() {
        return gebruikerID;
    }

    public void setGebruikerID(Integer gebruikerID) {
        this.gebruikerID = gebruikerID;
    }
    protected String Lokaalcode;        

    public Date getDatumtijd() {
        return datumtijd;
    }

    public void setDatumtijd(Date datumtijd) {
        this.datumtijd = datumtijd;
    }

    public String getTentamenCode() {
        return TentamenCode;
    }

    public void setTentamenCode(String TentamenCode) {
        this.TentamenCode = TentamenCode;
    }

    public String getlokaalcode() {
        return Lokaalcode;
    }

    public void setlokaalcode(String Vak) {
        this.Lokaalcode = Vak;
    } 
   
 
	public PlanningModel() {
	  TableName = "planning";
	  KeyFieldName = "ID";
	  for (java.lang.reflect.Field T : getClass().getDeclaredFields()){
            AddMapping(T.getName());
            } 
	}       
        
    @Override
        public String GetAdditionalJoin(){
            return "LEFT JOIN tentamen T on (tentamencode = T.code) ";
        } ;     
        
        
        public static ArrayList<PlanningModel> GetPlanningen(DatabaseConnection databaseconnection){
                        
            String SQLString;
            SQLString = "SELECT P.ID, P.datumtijd, P.tentamencode, T.vak  " +
                        "FROM planning P " +
                        "LEFT JOIN tentamen T on (tentamencode = T.code) ";


            ArrayList<PlanningModel> Planningen;

            Planningen = new ArrayList<PlanningModel>();

            java.sql.ResultSet rs = databaseconnection.executeSqlStatement(SQLString);

            PlanningModel planning;

            try {        
                while (rs.next()) { 
                    planning = new PlanningModel();
                    planning.KeyValue =  rs.getInt("ID");
                    planning.setDatumtijd(rs.getDate("datumtijd"));
                    planning.setTentamenCode(rs.getString("tentamencode"));
                    planning.setlokaalcode(rs.getString("vak"));    
                    Planningen.add(planning);
                }       	        	

            }
            catch(SQLException e) {
                throw new RuntimeException("result set could not be read: " + e);
            }

            return Planningen;
            
        }
        
}

