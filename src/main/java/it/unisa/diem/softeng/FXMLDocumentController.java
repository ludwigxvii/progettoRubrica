/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.it.unisa.diem.softeng;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.java.it.unisa.diem.softeng.rubricaClasses.Contatto;
import main.java.it.unisa.diem.softeng.rubricaClasses.Rubrica;
import main.java.it.unisa.diem.softeng.rubricaClasses.caricaScarica;

/**
 * FXML Controller class
 *
 * @author ludwi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField labnome;
    @FXML
    private TextField labcognome;
    @FXML
    private TextField mail1;
    @FXML
    private TextField mail2;
    @FXML
    private TextField mail3;
    @FXML
    private TextField tel1;
    @FXML
    private TextField tel2;
    @FXML
    private TextField tel3;
    @FXML
    private Button aggiungiContatto;
    @FXML
    private Button cancellaCampi;
    @FXML
    private TextField modNome;
    
    @FXML
    private TextField modCognome;
    @FXML
    private TextField modMail1;
    @FXML
    private TextField modMail2;
    @FXML
    private TextField modMail3;
    @FXML
    private TextField modTel1;
    @FXML
    private TextField modTel2;
    @FXML
    private TextField modTel3;
    @FXML
    private Button ricercaContatto;
    @FXML
    private Button eliminaContatto;
    @FXML
    private Button inviaModifiche;
    @FXML
    private TextField nomeRicerca;
    @FXML
    private TextField cognomeRicerca;
    @FXML
    private ImageView bottoneCarica;
    @FXML
    private Button bottoneSalva;
    @FXML
    private Button bottoneCarica2;
    @FXML
    private Button bottoneSalva2;
    @FXML
    private Button caricaDaFile;
    @FXML
    private TableColumn<Contatto, String> nome;
    @FXML
    private TableColumn<Contatto, String> cognome;
    @FXML
    private TableColumn<Contatto, String> email;
    @FXML
    private TableColumn<Contatto, String> telefoni;
    @FXML
    private TableView<Contatto> tabellaRubrica;
    @FXML
    private Button refresh;
    @FXML
    private Button refresh1;
    @FXML
    private Button inviaModifichepart2;
    
    public String buffNome = new String();
    public String buffCognome = new String();
   Rubrica rubrica = new Rubrica();
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       inviaModifichepart2.setVisible(false);
        BooleanBinding campiCompilati = Bindings.createBooleanBinding(()->
        (labnome.getText().equals("") && labcognome.getText().equals("")),
                labnome.textProperty(),
                labcognome.textProperty()
        );
        aggiungiContatto.disableProperty().bind(campiCompilati);
        
        cognome.setCellValueFactory(new PropertyValueFactory<Contatto, String>("cognome"));   
        nome.setCellValueFactory(new PropertyValueFactory<Contatto,String>("nome"));
        email.setCellValueFactory(new PropertyValueFactory<Contatto,String>("email1"));
        telefoni.setCellValueFactory(new PropertyValueFactory<Contatto,String>("telefono1"));
     
    }    


    @FXML
    private void bottoneAggiungi(ActionEvent event) {
        
        if(rubrica.aggiungiContatto(labnome.getText(),labcognome.getText(),tel1.getText(),tel2.getText(),tel3.getText(),mail1.getText(),
                mail2.getText(),mail3.getText())){
             tabellaRubrica.getItems().clear();
            tabellaRubrica.getItems().addAll(rubrica.tableConverter().contatti);
            
        labnome.setText("");
        labcognome.setText("");
        mail1.setText("");
        mail2.setText("");
        mail3.setText("");
        tel1.setText("");
        tel2.setText("");
        tel3.setText("");
        }
       
    }

    @FXML
    private void bottoneCancella1(ActionEvent event) {
        labnome.setText("");
        labcognome.setText("");
        mail1.setText("");
        mail2.setText("");
        mail3.setText("");
        tel1.setText("");
        tel2.setText("");
        tel3.setText("");
    }

    @FXML
    private void eliminaContatto(ActionEvent event) {
        rubrica.eliminaContatto(buffNome, buffCognome);
        tabellaRubrica.getItems().clear();
            tabellaRubrica.getItems().addAll(rubrica.tableConverter().contatti);
    }

    @FXML
    private void aggiuntaModifiche(ActionEvent event) {
Contatto select = tabellaRubrica.getSelectionModel().getSelectedItem();
buffNome =select.getNome();
modNome.setText(select.getNome());
buffCognome=select.getCognome();
modCognome.setText(select.getCognome());
modMail1.setText(rubrica.ricercaContatto(buffNome, buffCognome).getEmail1());
modMail2.setText(rubrica.ricercaContatto(buffNome, buffCognome).getEmail2());
modMail3.setText(rubrica.ricercaContatto(buffNome, buffCognome).getEmail3());
modTel1.setText(rubrica.ricercaContatto(buffNome, buffCognome).getTelefono1());
modTel2.setText(rubrica.ricercaContatto(buffNome, buffCognome).getTelefono2());
modTel3.setText(rubrica.ricercaContatto(buffNome, buffCognome).getTelefono3());
inviaModifiche.setVisible(false);
inviaModifichepart2.setVisible(true);
    }

    @FXML
    private void ricercaContatto(ActionEvent event) {
        if(rubrica.ricercaContatto(nomeRicerca.getText(), cognomeRicerca.getText())!=null){
        tabellaRubrica.getItems().clear();
        tabellaRubrica.getItems().add(rubrica.ricercaContatto(nomeRicerca.getText(), cognomeRicerca.getText()));
    }else{
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ERRORE.fxml"));
                
                Parent root = (Parent)fxmlLoader.load();
                ERROREController controller = fxmlLoader.<ERROREController>getController();
                controller.setLabel("Il Contatto ricercato non è nella rubrica, prova ad aggiungerlo dalla schermata Aggiungi");
                Scene scene = new Scene(root);
                
                stage.setScene(scene);
                   
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    @FXML
    private void caricaDaFile(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialDirectory(new File("saves"));
            File file = fileChooser.showOpenDialog(stage);
            String filename=file.toString();
            caricaScarica.caricaDaFile(rubrica, filename);
            tabellaRubrica.getItems().clear();
            tabellaRubrica.getItems().addAll(rubrica.tableConverter().contatti);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void salvaSuFile(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialDirectory(new File("saves"));
            File file = fileChooser.showOpenDialog(stage);
            String filename=file.toString();
            caricaScarica.salvaSuFile(rubrica, filename);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void refresh(ActionEvent event) {
        tabellaRubrica.getItems().clear();
            tabellaRubrica.getItems().addAll(rubrica.tableConverter().contatti);
    }

    @FXML
    private void aggiuntaModifiche2(ActionEvent event) {
        if(!rubrica.modificaContatto(buffNome, buffCognome, modNome.getText(), modCognome.getText(),
                modTel1.getText(),modTel2.getText(), modTel3.getText(),
                modMail1.getText(), modMail2.getText(), modMail3.getText())){
        
        }
        tabellaRubrica.getItems().clear();
            tabellaRubrica.getItems().addAll(rubrica.tableConverter().contatti);
            inviaModifiche.setVisible(true);
inviaModifichepart2.setVisible(false);
    }
    
}
