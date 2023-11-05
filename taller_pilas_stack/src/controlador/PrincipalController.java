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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * 
 *
 * @author Leocarlos y moises
 */
public class PrincipalController implements Initializable {
    
    Stage stage;
    
    public void setStage(Stage stage1){
        
        stage=stage1;
    }
    
    
    @FXML
    void event_agregarPeli(MouseEvent event) {
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ingreso_datos.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Ingreso_datosController controller = loader.getController();
            controller.setStage(stage); 
            
        }catch(Exception e){
            
           JOptionPane.showMessageDialog(null, "Error "+e);
        } 
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
