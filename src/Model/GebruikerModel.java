package Model;

import dataStorageLayer.DatabaseConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GebruikerModel extends BasicModel  {

    
	//protected Integer ID;
	protected String voornaam;
	protected String tussenvoegsel;
	protected String achternaam;
	protected String geslacht;
	protected Date geboortedatum; 
        protected String gebruikersnaam;        
	protected String wachtwoord;
	protected Integer rolID;

	
//    public Integer getID() {
//		return ID;
//	}
//
//
//	public void setID(Integer iD) {		
//		ID = iD;
//	}


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


	public String getGebruikersnaam() {
		return gebruikersnaam;
	}


	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}


	public String getWachtwoord() {
		return wachtwoord;
	}


	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}


	public Integer getRolID() {
		return rolID;
	}


	public void setRolID(Integer rolID) {
		this.rolID = rolID;
	}


	public GebruikerModel() {

	  TableName = "gebruiker";
	  KeyFieldName = "ID";
	  // toekomst muziek.. waar gemaakt :D
	  for (java.lang.reflect.Field T : getClass().getDeclaredFields()){
            if (java.lang.reflect.Modifier.isProtected(T.getModifiers())){
                AddMapping(T.getName());
            } 
          }
              
	}
        
        public static GebruikerModel GetInlogGebruiker(DatabaseConnection databaseconnection,String Username, String PasswordMD5) {
            try {
                String SQLString;
                
                if ((Username == null) || (PasswordMD5 == null)){
                    return null;
                }
                
                SQLString = " SELECT ID " +
                        " FROM gebruiker g " +
                        " WHERE gebruikersnaam = ? AND wachtwoord = ? AND RolID = 3"; //alleen adminmedewerker mogen er in..
                
                
                PreparedStatement prepStmt = null;
                prepStmt = databaseconnection.connection.prepareStatement(SQLString);
                prepStmt.setString(1, Username);
                prepStmt.setString(2, PasswordMD5);
                
                java.sql.ResultSet rs = null;
                rs = prepStmt.executeQuery();

                
                if (rs.next()) {
                    GebruikerModel gebruiker = new GebruikerModel();
                    gebruiker.KeyValue = rs.getInt("ID");
                    if (gebruiker.load(databaseconnection)){
                        return gebruiker;
                    } else{
                        return null;
                    }
                     
                } else {
                    return null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GebruikerModel.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

}
