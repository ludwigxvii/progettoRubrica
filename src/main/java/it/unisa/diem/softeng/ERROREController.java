/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.it.unisa.diem.softeng;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ludwi
 */
public class ERROREController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label erroreText;
    @FXML
    private Button returno;

    /**
     * Initializes the controller class.
     * @param testo
     */
    
    public void setLabel(String testo){
    erroreText.setText(testo);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void chiudiFinestra(ActionEvent event) {
        Stage stage = (Stage) returno.getScene().getWindow();
    stage.close();
    }
    
}
