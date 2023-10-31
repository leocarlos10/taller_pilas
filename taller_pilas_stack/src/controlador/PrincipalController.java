/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * 
 *
 * @author Leocarlos
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button btn_ingresar;

    @FXML
    private Label label_nombre;

    @FXML
    private TextField text_nombre;

    @FXML
    void event_mostrar_nombre(ActionEvent event) {
        
        label_nombre.setText(text_nombre.getText()); 
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_ingresar.requestFocus();
    }    
    
}
