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
import logica.*;
/**
 *
 *
 * @author Leocarlos y moises
 */
public class Ingreso_datosController implements Initializable {
    
    Stage stage;
    Pila p = new Pila();
    
    public void setStage(Stage stage2){
        
        stage=stage2;
    }
    
    // componentes
    
    @FXML
    private Label label_info;
    
     @FXML
    private TextField text_duracion;

    @FXML
    private TextField text_id;

    @FXML
    private TextField text_nombre;
  
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

           p.aviso_Error("Error", "Tipo de error "+e);
        }
    }
    
    // evento generado para limpiar la la informacion del label_info cuando el usuario desee agregar otra pelicula
    @FXML
    void event_cambiar_info(KeyEvent event) {
        
        label_info.setText("");
    }

    @FXML
    void event_agregar(ActionEvent event) {
        
        
        boolean estado=false;
        Pelicula peli = null;
       
        try {
            // instanciamos la pelicula
            peli = new Pelicula(
                    Integer.parseInt(text_id.getText()),
                    text_nombre.getText(),
                    Float.parseFloat(text_duracion.getText()));
            // Luego guardamos la pelicula en la pila
            estado = p.setPushPelicula(peli);
            
        } catch (NumberFormatException e) {
          p.aviso_Error("Error al agregar pelicula", " Tipo de error "+e);
        }catch(Exception e){
             p.aviso_Error("Error al agregar pelicula", " Tipo de error "+e);
        }
        
        // luego si el estado es true quiere decir que la pelicula fue agregada correctamente.
        if(estado){
            
            label_info.setText("Pelicula agregada");
            // si la pelicula se agrego correctamente se guarda en el fichero
            try {
                p.guardar_P_fichero(peli);
                // como ya guardamos los datos en el fichero podemos eliminar los datos de la pila
                p.pilaP.clear();
            } catch (Exception e) {

                p.aviso_Error("Error", "Porfavor revise la ruta del fichero" + e);
            }
            
             // limpiamos los textos
            text_id.setText("");
            text_nombre.setText("");
            text_duracion.setText("");
            text_id.requestFocus();
            
        }else{
            
            text_id.setText("");
            label_info.setText("Id repetido por favor intente nuevamente");
            text_id.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
}
