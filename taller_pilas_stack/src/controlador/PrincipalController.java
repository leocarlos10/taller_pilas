/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
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
            
          p.aviso_Error("ERROR", "Tipo de error "+e);
        } 
    }
    
     @FXML
    void event_mostrar_antiguos(MouseEvent event) {
         
        String estado = "si";
        do {
            if (estado.equalsIgnoreCase("si")) {
                TextInputDialog dialog = p.aviso_captura_informacion("Captura de datos", "Ingresa el id de la pelicula", "id:");
                // guardo la info
                Optional<String> result = dialog.showAndWait();
                // verifico si la variable result tiene un valor
                if (result.isPresent()) {
                    // si es asi la obtengo
                    int id = Integer.parseInt(result.get());
                    p.mostrar_info_estrenos_antiguos(id);
                }
            }
            
            TextInputDialog dialog2 = p.aviso_captura_informacion("captura de datos", "Desea buscar la info de alguna pelicula ?", " si" + "\nno");
            Optional<String> result2 = dialog2.showAndWait();
            if (result2.isPresent()) {
                // si es asi la obtengo
                String estado2 = result2.get();
                estado = estado2;
            }

            
        } while (estado.equalsIgnoreCase("si"));
       
    }

    @FXML
    void event_mostrar_estrenos(MouseEvent event) {
        
        String estado = "si";
        do {
            
             if (estado.equalsIgnoreCase("si")) {
                TextInputDialog dialog = p.aviso_captura_informacion("Captura de datos", "Ingresa el id de la pelicula", "id:");
                // guardo la info
                Optional<String> result = dialog.showAndWait();
                // verifico si la variable result tiene un valor
                if (result.isPresent()) {
                    // si es asi la obtengo
                    int id = Integer.parseInt(result.get());
                    p.mostrar_info_estrenos(id);
                }
            }
             
            TextInputDialog dialog2 = p.aviso_captura_informacion("captura de datos", "Desea seguir buscando la info de alguna pelicula?", " si" + "\nno");
            Optional<String> result2 = dialog2.showAndWait();
            if (result2.isPresent()) {
                // si es asi la obtengo
                String estado2 = result2.get();
                estado = estado2;
            }
        } while (estado.equalsIgnoreCase("si"));

    }
    
     @FXML
    void event_total_categoria(MouseEvent event) {
        
        TextInputDialog dialog = p.aviso_captura_informacion("Captura de datos", "Ingrese la categoria(niño,adolecente,adulto)", "categoria: ");
        Optional<String> resultado = dialog.showAndWait();
        if(resultado.isPresent()){
            
            String categoria =resultado.get();
            p.Total_categoria(categoria); 
        }
    }
    
    @FXML
    void event_eliminar_categoria(MouseEvent event) {
        
        TextInputDialog dialog = p.aviso_captura_informacion("Captura de datos", "Ingrese la categoria a eliminar (niño,adolecente,adulto)", "categoria: ");
        Optional<String> resultado = dialog.showAndWait();
        if(resultado.isPresent()){
            
            String categoria =resultado.get();
            p.Total_categoria(categoria); 
        }
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
