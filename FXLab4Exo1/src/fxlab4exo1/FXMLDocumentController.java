/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxlab4exo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML 
    private TextField textField;
    
    /*
    Catching (on click) event of the app button
    */
    
    @FXML
    private void handleButtonAction(ActionEvent event) {    // on button click
        System.out.println(this.textField.getText());   // print the content of textfield in console
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
