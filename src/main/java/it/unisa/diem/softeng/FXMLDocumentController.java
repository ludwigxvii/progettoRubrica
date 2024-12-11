/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.it.unisa.diem.softeng;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private TextField nome;
    @FXML
    private TextField cognome;
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
    private TableView<?> tabellaRubrica;
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

   
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        BooleanBinding campiCompilati = Bindings.createBooleanBinding(()->
        (nome.getText().equals("") && cognome.getText().equals("")),
                nome.textProperty(),
                cognome.textProperty()
         
        );
        aggiungiContatto.disableProperty().bind(campiCompilati);
    }    
Rubrica rubrica = new Rubrica();

    @FXML
    private void bottoneAggiungi(ActionEvent event) {
        rubrica.aggiungiContatto(nome.getText(),cognome.getText(),mail1.getText(),mail2.getText(),mail3.getText(),tel1.getText(),tel2.getText(),tel3.getText());

    }

    @FXML
    private void bottoneCancella1(ActionEvent event) {
    }

    @FXML
    private void eliminaContatto(ActionEvent event) {
    }

    @FXML
    private void aggiuntaModifiche(ActionEvent event) {
    }

    @FXML
    private void ricercaContatto(ActionEvent event) {
    }
    
}
