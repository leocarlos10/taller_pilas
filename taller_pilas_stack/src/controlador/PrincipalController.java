/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.*;

/**
 * 
 *
 * @author Leocarlos y moises
 */
public class PrincipalController implements Initializable {
    
    Stage stage;
    // objeto para poder comunicarnos con los metodos de la pila
    Pila p = new Pila();
    
    public void setStage(Stage stage1){
        
        stage=stage1;
    }
    
    // componentes
     @FXML
    private TableView<Pelicula> Tabla;

    @FXML
    private TableColumn col_duracion;

    @FXML
    private TableColumn col_edad;

    @FXML
    private TableColumn col_id;

    @FXML
    private TableColumn col_nombre;

    @FXML
    private TableColumn col_valor_boleta;
    
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
        // primero obtenemos los datos desde el fichero
        p.mostrarAll();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         p.getInfo_peliculas();
         setLLenarTableView(); 
    }    
    
    
    // metodo encargado de resivir la pila desde el controlador Ingreso_datos, para posteriormente llenar 
    public void setLLenarTableView() {
        
        // creamos el modelo para el tableView
        ObservableList<Pelicula> lista = FXCollections.observableArrayList();
        
        // cargamos las columnas con los atributos correspondientes.
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombrePelicula"));
        col_duracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        col_edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        col_valor_boleta.setCellValueFactory(new PropertyValueFactory<>("valorBoleta"));
        
        // recorremos la lista para ir agreando los objetos peliculas al modelo
        // utilizamos un for que inicie en el tope de la pila y que vaya recorriendo hasta llegar ala base.
        
        for(int i= p.pilaP.size()-1; i>=0;i--){
            
            lista.add(p.pilaP.get(i));
        }
        
        // al terminar el de agregar las peliculas en la lista modelo se cargan en el tableView
        Tabla.setItems(lista); 
    }
}
