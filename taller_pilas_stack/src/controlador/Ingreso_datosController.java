/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author Leocarlos
 */
public class Ingreso_datosController implements Initializable {
    
    Stage stage;
    
    public void setStage(Stage stage2){
        
        stage=stage2;
    }
    
    // componentes
    
    @FXML
    private Label label_info;
    
     @FXML
    private TextField text_duracion;

    @FXML
    private TextField text_edad;

    @FXML
    private TextField text_id;

    @FXML
    private TextField text_nombre;
    
    @FXML
    private TextField text_valor_boleta;
  
    @FXML
    void event_volver(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/principal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            PrincipalController controller = loader.getController();
            controller.setStage(stage);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
    
    // evento generado para limpiar la la informacion del label_info cuando el usuario desee agregar otra pelicula
    @FXML
    void event_cambiar_info(KeyEvent event) {
        
        label_info.setText("");
    }

    @FXML
    void event_agregar(ActionEvent event) {
        
        label_info.setText("Pelicula agregada");
        text_id.setText("");
        text_nombre.setText("");
        text_edad.setText("");
        text_duracion.setText("");
        text_valor_boleta.setText("");
        text_id.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
}
