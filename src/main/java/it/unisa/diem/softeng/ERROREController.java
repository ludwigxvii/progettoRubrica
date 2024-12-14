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
 * @brief Questa Classe si occupa semplicemente di Visualizzare a schermo le info riguardanti errori come Aggiunta
 * Contatti non riuscita  o ricerca di un contatto inesistente
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
     * @brief Questo Setter viene evocato ogni volta prima che la scena venga visualizzata a schermo
     * @param testo Il testo da visualizzare a Schermo
     * @version 2.0
     */
    
    public void setLabel(String testo){
    erroreText.setText(testo);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
/**
 * 
 * @brief Evento del pulsante che chiude la finestra a schermo
 */
    @FXML
    private void chiudiFinestra(ActionEvent event) {
        Stage stage = (Stage) returno.getScene().getWindow();
    stage.close();
    }
    
}
