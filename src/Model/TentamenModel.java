/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author chris
 */
public class TentamenModel extends BasicModel {
    
	protected String tentamencode;
	protected String Vak;
	protected String Periode;    
        protected Integer aantalStudenten;
        protected Boolean computerlokaal;
        protected Boolean surveillant;

    public String getTentamencode() {
        return tentamencode;
    }

    public void setTentamencode(String tentamencode) {
        this.tentamencode = tentamencode;
    }

    public String getVak() {
        return Vak;
    }

    public void setVak(String Vak) {
        this.Vak = Vak;
    }

    public String getPeriode() {
        return Periode;
    }

    public void setPeriode(String Periode) {
        this.Periode = Periode;
    }

    public Integer getAantalStudenten() {
        return aantalStudenten;
    }

    public void setAantalStudenten(Integer aantalStudenten) {
        this.aantalStudenten = aantalStudenten;
    }

    public Boolean isComputerlokaal() {
        return computerlokaal;
    }

    public void setComputerlokaal(Boolean computerlokaal) {
        this.computerlokaal = computerlokaal;
    }

    public Boolean isSurveillant() {
        return surveillant;
    }

    public void setSurveillant(Boolean surveillant) {
        this.surveillant = surveillant;
    }
 
	public TentamenModel() {

	  TableName = "Tentamen";
	  KeyFieldName = "code";
	  for (java.lang.reflect.Field T : getClass().getDeclaredFields()){
            AddMapping(T.getName());
            } 
	}       
        
}
