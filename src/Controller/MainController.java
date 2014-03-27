package Controller;

import Model.BeoordelingModel;
import Model.GebruikerModel;
import Model.InschrijvingStudentModel;
import Model.PlanningModel;
import View.MainForm;
import View.frmLogin;
import dataStorageLayer.DatabaseConnection;
import java.util.ArrayList;

public final class MainController {
        private GebruikerModel User;

    public GebruikerModel getUser() {
        return User;
    }

        private ArrayList<PlanningModel> Planningen;
        private ArrayList<InschrijvingStudentModel> Inschrijvingen;
        private ArrayList<BeoordelingModel> Beoordelingen;

    public ArrayList<BeoordelingModel> getBeoordelingen() {
        return Beoordelingen;
    }

    public ArrayList<InschrijvingStudentModel> getInschrijvingen() {
        return Inschrijvingen;
    }
        public final DatabaseConnection databaseconnection;
        private MainForm mainform;
    
	public static void main(String[] args) {

            MainController maincontroller = new MainController();
	}
        
        
        public MainController(){
            databaseconnection = new DatabaseConnection();
            
            
            if (Login()) {
                LoadPlanningen();
                mainform = new MainForm(this);
                mainform.setPlanningTableModel(Planningen);             
            }
        }
         
        
        public boolean LoadPlanningen(){
            Planningen = PlanningModel.GetPlanningen(databaseconnection);  
            return true;
            
                }

        public boolean LoadInschrijvingen(Integer PlanningID){
            Inschrijvingen = InschrijvingStudentModel.GetInschrijvingen(databaseconnection, PlanningID);
            mainform.SetInschrijvingTableModel(Inschrijvingen);
            
            
            return true;      
        }
        
        public boolean LoadBeoordelingen(String Tentamencode){
            Beoordelingen = BeoordelingModel.GetBeoordeling(databaseconnection, Tentamencode);
            mainform.SetBeoordelingTableModel(Beoordelingen);
            
            
            return true;      
        }     
        
        public Boolean Login(){
            frmLogin LoginForm = new frmLogin(null, true, this);
            LoginForm.setModal(true);
            LoginForm.setVisible(true);
            
            if (LoginForm.getUser() != null ){
                User = LoginForm.getUser();
                return true;
            } else{
                return false;
            }
                
            


        
        }
        
        public void refreshPlanningen(){
            
            Planningen = PlanningModel.GetPlanningen(databaseconnection);  
            mainform.setPlanningTableModel(Planningen); 
        }
        
}
