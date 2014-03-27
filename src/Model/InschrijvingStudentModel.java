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
public class InschrijvingStudentModel {

	protected Integer ID;
	protected String voornaam;
	protected String tussenvoegsel;
	protected String achternaam;
	protected String geslacht;
        protected Date geboortedatum;
        protected Integer beoordeling;
        protected Boolean Aanwezig;
        protected Integer planningID;

    public Integer getPlanningID() {
        return planningID;
    }

    public void setPlanningID(Integer planningID) {
        this.planningID = planningID;
    }

    public Integer getGebruikerID() {
        return gebruikerID;
    }

    public void setGebruikerID(Integer gebruikerID) {
        this.gebruikerID = gebruikerID;
    }
        protected Integer gebruikerID;

    public Boolean isAanwezig() {
        return Aanwezig;
    }

    public void setAanwezig(Boolean Aanwezig) {
        this.Aanwezig = Aanwezig;
    }

    public Integer getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(Integer beoordeling) {
        this.beoordeling = beoordeling;
    }
        protected Double cijfer;


    public Double getCijfer() {
        return cijfer;
    }

    public void setCijfer(Double cijfer) {
        this.cijfer = cijfer;
    }

	
    public Integer getID() {
        return ID;
    }


    public void setID(Integer iD) {		
            ID = iD;
    }


    public String getVoornaam() {
            return voornaam;
    }


    public void setVoornaam(String voornaam) {
            this.voornaam = voornaam;
    }


    public String getTussenvoegsel() {
            return tussenvoegsel;
    }


    public void setTussenvoegsel(String tussenvoegsel) {
            this.tussenvoegsel = tussenvoegsel;
    }


    public String getAchternaam() {
            return achternaam;
    }


    public void setAchternaam(String achternaam) {
            this.achternaam = achternaam;
    }


    public String getGeslacht() {
            return geslacht;
    }


    public void setGeslacht(String geslacht) {
            this.geslacht = geslacht;
    }


    public Date getGeboortedatum() {
            return geboortedatum;
    }


    public void setGeboortedatum(Date geboortedatum) {
            this.geboortedatum = geboortedatum;
    }

    public static ArrayList<InschrijvingStudentModel> GetInschrijvingen(DatabaseConnection databaseconnection, Integer PlanningID){
            String SQLString;
            SQLString = "SELECT gebruikerID, i.datumtijd, cijfer, beoordeling, i.aanwezig, i.planningID ,g.voornaam, g.tussenvoegsel, g.achternaam, g.geslacht, g.geboortedatum " +
                        "FROM inschrijving i " +
                        "LEFT JOIN gebruiker g on (g.ID = i.gebruikerID) " +
                        "WHERE i.planningID = " + String.valueOf(PlanningID) + " AND rolID = 1"; //1 = student

            ArrayList<InschrijvingStudentModel> Inschrijvingen;


            Inschrijvingen = new ArrayList<InschrijvingStudentModel>();

            java.sql.ResultSet rs = databaseconnection.executeSqlStatement(SQLString);

            InschrijvingStudentModel Inschrijving;

            try {        
                while (rs.next()) { 
                    Inschrijving = new InschrijvingStudentModel();
                    Inschrijving.setPlanningID(rs.getInt("planningID"));
                    Inschrijving.setGebruikerID(rs.getInt("gebruikerID"));
                    Inschrijving.setVoornaam(rs.getString("voornaam"));
                    Inschrijving.setTussenvoegsel(rs.getString("tussenvoegsel"));
                    Inschrijving.setAchternaam(rs.getString("achternaam"));
                    Inschrijving.setGeslacht(rs.getString("geslacht"));
                    Inschrijving.setGeboortedatum(rs.getDate("geboortedatum"));
                    Inschrijving.setBeoordeling(rs.getInt("beoordeling"));
                    Inschrijving.setAanwezig(rs.getBoolean("Aanwezig"));
                    Inschrijving.setCijfer(rs.getDouble("cijfer"));

                    Inschrijvingen.add(Inschrijving);
                }       	        	

            }
            catch(SQLException e) {
                throw new RuntimeException("result set could not be read: " + e);
            }

            return Inschrijvingen;
        }   
    
    public void SaveAanwezig(DatabaseConnection databaseconnection){
        String SQLString;
        SQLString = " UPDATE inschrijving SET aanwezig = " + isAanwezig().toString()+
                    " WHERE planningID = " + planningID.toString() + " AND gebruikerID = " + gebruikerID.toString() ;
        databaseconnection.executeSqlUpdate(SQLString);
    }
    
}
