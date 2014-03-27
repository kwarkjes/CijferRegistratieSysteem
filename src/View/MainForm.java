package View;


import Controller.MainController;
import Model.BeoordelingModel;
import Model.InschrijvingStudentModel;
import Model.PlanningModel;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;




public final class MainForm  {
        private final MainController Controller;
        private final Main main;
        private JTable tablePlanning;
        private JTable tableInschrijvingen;  
        private JTable tableBeoordelingen;

        
	/**
	 * Create the panel.
         * @param AController 
	 */
	public MainForm(MainController AController) {
            main = new Main();
            main.SetMainForm(this);
            main.setVisible(true);
            Controller = AController;
            
            
            tableInschrijvingen = main.getTblInschrijving();
            tableBeoordelingen = main.getTblBeoordelingen();

            AddMouseClickEventTableInschrijvingen();
            AddValueChangedEventTableBeoordelingen();
            main.setBeoordelingEnabled(false);
	}
        
        
    public void setPlanningTableModel(ArrayList<PlanningModel> planningen){
        DefaultTableModel tablemodel;
        tablePlanning = main.getTblPlanning();
        tablemodel = (DefaultTableModel) tablePlanning.getModel();
        tablemodel.setNumRows(0); 
        
        for (PlanningModel planning : planningen){
            //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");              
            tablemodel.addRow(new Object[]{planning.getDatumtijd(), planning.getTentamenCode(), planning.getlokaalcode(), planning} );//{"Column 1", "Column 2", "Column 3"});
        }
        tablePlanning.setAutoCreateRowSorter(true); //sortering toevoegen...
        tablePlanning.setModel(tablemodel);
        tablePlanning.validate();
        tablePlanning.repaint();
        
        tablePlanning.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            Integer selectedrow = tablePlanning.getSelectedRow();
            
            if (selectedrow != -1){
            PlanningModel planning= (PlanningModel) tablePlanning.getValueAt(selectedrow, 3);
            main.SetPlanning(planning);
            Controller.LoadInschrijvingen(planning.KeyValue);
            Controller.LoadBeoordelingen(planning.getTentamenCode());
            }
            
        }});
        
        if (tablePlanning.getRowCount() > 0) {
            tablePlanning.setRowSelectionInterval(0,0);
        }
        
    }

    public void SetInschrijvingTableModel(ArrayList<InschrijvingStudentModel> inschrijvingen){
        DefaultTableModel tablemodel;
        
        tablemodel = (DefaultTableModel) tableInschrijvingen.getModel();
        tablemodel.setNumRows(0); 

        for (InschrijvingStudentModel inschrijving : inschrijvingen){
            //boolean afwezig = inschrijving.getBeoordeling() != 2;
            
            tablemodel.addRow(new Object[]{inschrijving.getVoornaam(), inschrijving.getTussenvoegsel() + " " + inschrijving.getAchternaam(), 
                inschrijving.isAanwezig() , inschrijving.getCijfer(), inschrijving} ); 
        }
        
        tableInschrijvingen.setAutoCreateRowSorter(true); //sortering toevoegen...
        tableInschrijvingen.setModel(tablemodel);
        tableInschrijvingen.validate();
        tableInschrijvingen.repaint();
        
    }
    
    
    public void SetBeoordelingTableModel(ArrayList<BeoordelingModel> beoordelingen){
        DefaultTableModel tablemodel;
        
        tablemodel = (DefaultTableModel) tableBeoordelingen.getModel();
        tablemodel.setNumRows(0); 

        for (BeoordelingModel beoordeling : beoordelingen){
            
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            tablemodel.addRow(new Object[]{dateFormat.format(beoordeling.getDatumtijd()), beoordeling.getCijfer(), beoordeling.getDocument(), beoordeling, beoordeling.getGebruikersnaam()} ); 
        }
        
        tableBeoordelingen.setAutoCreateRowSorter(true); //sortering toevoegen...
        tableBeoordelingen.setModel(tablemodel);
        tableBeoordelingen.validate();
        tableBeoordelingen.repaint();
        
    }    
    
    public void AddMouseClickEventTableInschrijvingen(){
        tableInschrijvingen.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InschrijvingStudentModel inschrijving = (InschrijvingStudentModel) tableInschrijvingen.getValueAt(tableInschrijvingen.getSelectedRow(), 4); //objectlink...

                Integer r,c;
                r = tableInschrijvingen.getSelectedRow();
                c = tableInschrijvingen.getSelectedColumn();
                // get the String at row r and column c

                if (c == 2) {
                    Boolean s = (Boolean) tableInschrijvingen.getValueAt(r, c);
                    inschrijving.setAanwezig(s);
                    inschrijving.SaveAanwezig(Controller.databaseconnection);
                }
            }
        });
    }    

    public void AddValueChangedEventTableBeoordelingen(){
        tableBeoordelingen.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            
            Integer selectedrow = tableBeoordelingen.getSelectedRow();

            if (selectedrow != -1){
                BeoordelingModel beoordeling= (BeoordelingModel) tableBeoordelingen.getValueAt(selectedrow, 3);
                main.SetBeoordeling(beoordeling);
                main.setBeoordelingEnabled(true);            
            } else{
                main.setBeoordelingEnabled(false);
            }
               
            
        }});
    }
    
    
    public void AddBeoordeling(){

        BeoordelingModel beoordeling = new BeoordelingModel();
        beoordeling.KeyValue = null;
        beoordeling.setDatumtijd((new java.util.Date()) );
        beoordeling.setGebruikerID(Controller.getUser().KeyValue);
        beoordeling.setTentamencode(main.GetCurrentTentamenCode());
        Controller.getBeoordelingen().add(beoordeling);

        Integer AddedIndex = Controller.getBeoordelingen().size() -1;

        // beoordeling toegevoegd, herladen..
        SetBeoordelingTableModel(Controller.getBeoordelingen());
        // net toegevoegde selecteren...
        tableBeoordelingen.getSelectionModel().setSelectionInterval(AddedIndex, AddedIndex);
        main.setBeoordelingEnabled(true);        
    }
    
    public void SaveBeoordeling() {
        
        Integer selectedrow = tableBeoordelingen.getSelectedRow();

            
        if (selectedrow != -1){
            BeoordelingModel beoordeling= (BeoordelingModel) tableBeoordelingen.getValueAt(selectedrow, 3);            
            if (beoordeling != null){
                main.readBeoordelingData(beoordeling);

                
                try {
                    if (beoordeling.Save(Controller.databaseconnection)){
                        beoordeling.setHasChanged(false);
                      Controller.LoadBeoordelingen(beoordeling.getTentamencode());
                      main.setBeoordelingEnabled(false);
                    } else {
                        
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
  
            } else{
                JOptionPane.showMessageDialog(main, "De beoordeling kon niet worden gevonden.", "Beoordeling niet gevonden.", JOptionPane.ERROR_MESSAGE);  
                
            }

        } else
        {
            JOptionPane.showMessageDialog(main, "Er is geen beoordeling geselecteerd, selecteer eerst een beoordeling.", "Selecteer een beoordeling", JOptionPane.INFORMATION_MESSAGE);  
        }
    }
    
    public void DeleteBeoordeling(){
        Integer selectedrow = tableBeoordelingen.getSelectedRow();

            
        if (selectedrow != -1){
            BeoordelingModel beoordeling= (BeoordelingModel) tableBeoordelingen.getValueAt(selectedrow, 3); 
            
            if (beoordeling != null){  
                
                if (beoordeling.getGebruikerID() == Controller.getUser().KeyValue){
                    int reply = JOptionPane.showConfirmDialog(null,
                                                              "Weet u zeker dat u deze beoordeling wilt verwijderen?",
                                                              "Verwijderen?",
                                                              JOptionPane.YES_NO_OPTION);  

                    if (reply == 0) {
                        beoordeling.Delete(Controller.databaseconnection);
                        Controller.LoadBeoordelingen(beoordeling.getTentamencode());
                        main.setBeoordelingEnabled(false);
                    }
                } else{
                    JOptionPane.showMessageDialog(main, "Alleen de beoordeling die door u zelf zijn aangemaakt mogen verwijderd worden.", "Niet bevoegd voor deze actie.", JOptionPane.ERROR_MESSAGE);                  
                    
                }
                 
                

            } else{
                JOptionPane.showMessageDialog(main, "De beoordeling kon niet worden gevonden.", "Beoordeling niet gevonden.", JOptionPane.ERROR_MESSAGE);  

            }

        } else
        {
            JOptionPane.showMessageDialog(main, "Er is geen beoordeling geselecteerd, selecteer eerst een beoordeling.", "Selecteer een beoordeling", JOptionPane.INFORMATION_MESSAGE);  
        }

    }
    
    public void SetBeoordelingHasChanged(){
        Integer selectedrow = tableBeoordelingen.getSelectedRow();


        if (selectedrow != -1){ 
            BeoordelingModel beoordeling= (BeoordelingModel) tableBeoordelingen.getValueAt(selectedrow, 3);            
            if (beoordeling != null){
                beoordeling.setHasChanged(true);
            }
        }
    }
    
    public void RefeshPlanningen(){
        Controller.refreshPlanningen();
    
    }
    
}

