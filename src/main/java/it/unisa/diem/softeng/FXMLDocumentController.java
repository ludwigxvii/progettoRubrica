/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.it.unisa.diem.softeng;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import main.java.it.unisa.diem.softeng.rubricaClasses.Contatto;
import main.java.it.unisa.diem.softeng.rubricaClasses.Rubrica;

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
    private TableColumn<Contatto, String[]> email;
    @FXML
    private TableColumn<Contatto, String[]> telefoni;
    @FXML
    private TableView<Contatto> tabellaRubrica;
    

   Rubrica rubrica = new Rubrica();
ObservableList<Contatto> observableList = FXCollections.observableArrayList();
        SortedList<Contatto> sortedList = new SortedList<>(observableList);
        
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        BooleanBinding campiCompilati = Bindings.createBooleanBinding(()->
        (labnome.getText().equals("") && labcognome.getText().equals("")),
                labnome.textProperty(),
                labcognome.textProperty()
        );
        aggiungiContatto.disableProperty().bind(campiCompilati);
           
        nome.setCellValueFactory(new PropertyValueFactory<Contatto,String>("nome"));
        cognome.setCellValueFactory(new PropertyValueFactory<Contatto, String>("cognome"));
        email.setCellValueFactory(new PropertyValueFactory<Contatto,String[]>("email"));
        telefoni.setCellValueFactory(new PropertyValueFactory<Contatto,String[]>("telefono"));
        

    }    


    @FXML
    private void bottoneAggiungi(ActionEvent event) {
        String[]mail={mail1.getText(),mail2.getText(),mail3.getText()};
        String[]tel={tel1.getText(),tel2.getText(),tel3.getText()};
        if(rubrica.aggiungiContatto(labnome.getText(),labcognome.getText(),tel,mail)){
             tabellaRubrica.getItems().clear();
            tabellaRubrica.getItems().addAll(rubrica.contatti);
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
    }

    @FXML
    private void aggiuntaModifiche(ActionEvent event) {
       Contatto select = tabellaRubrica.getSelectionModel().getSelectedItem();
        System.out.println(select.getNome());
    }

    @FXML
    private void ricercaContatto(ActionEvent event) {
    }

    @FXML
    private void caricaDaFile(ActionEvent event) {
    }

    @FXML
    private void salvaSuFile(ActionEvent event) {
    }
    
}
