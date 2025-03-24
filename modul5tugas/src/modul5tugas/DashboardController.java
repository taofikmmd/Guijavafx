/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package modul5tugas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;





/**
 * FXML Controller class
 *
 * @author Taofik Dimas
 */
public class DashboardController implements Initializable {
    
    @FXML
    private Button buttonLogout;
    @FXML
    private Button btnMasterData;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception{
        
        Main main = new Main();
        main.changeScene("Main.fxml");
    }
     @FXML
    private void handleButtonMasterAction(ActionEvent event) throws Exception{
        
        Main main = new Main();
        main.changeScene("MasterData.fxml");
    }

    /**
     * Initializes the controller class.
     */
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
