/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * 
 *
 * @author Leocarlos
 */
public class PrincipalController implements Initializable {

    
       @FXML
    void event_agregarPeli(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Evento generado para agregar peli");
    }
    
     @FXML
    void event_mostrar_antiguos(MouseEvent event) {
         JOptionPane.showMessageDialog(null, "Evento generado para mostrar estrenos antiguos ");
    }

    @FXML
    void event_mostrar_estrenos(MouseEvent event) {
         JOptionPane.showMessageDialog(null, "Evento generado para mostrar estrenos");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
