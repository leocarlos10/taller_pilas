/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author Leocarlos y moises
 */
public class Pila {
    
    public Stack<Pelicula> pilaP;
    
    public Pila() { pilaP = new Stack(); }
    
    
    public int getBuscarIdPeli(Pelicula p){
       
        // traigo los datos del fichero
        getInfo_peliculas();
        // luego busco en la pila si se encuentra alguna pelicula con id igual
        for(int i=0;i<pilaP.size() -1;i++){
            
            if(pilaP.get(i).getId() == p.getId())
                return i;
        }
        
        // elimino los datos de la pila
        pilaP.clear();
        
        // si sale del for y no lo encontro retorna -1
        return -1;
    }
    
    // metodo encargado de agregar ala pila
    public boolean setPushPelicula (Pelicula pi){
        
        Pelicula p = pi;
        boolean band = false; // badera para saber si agrego correctamente o no.
        
        // buscamos si la pelicula a ingresar se repite en la pila
        int pos = getBuscarIdPeli(p); // si retorna >0 lo encontro si retorna -1 no lo encontro
        
        if(pos==-1){
            
            pilaP.push(p); // utilizamos el metodo push para ir agregando en la parte del tope de la pila
            band=true;
        }
        
        
       return band; 
    }
    
    // metodo encargado de agregar los datos de las pelicuals en un fichero de texto
    public void guardar_P_fichero(Pelicula p) throws Exception {
        
        // utilizamos la clase FileWriter para poder escribir en el fichero los datos de las peliculas
        FileWriter escritura = new FileWriter(
                "C:/Users/USUARIO/OneDrive/Documentos/taller_pilas/taller_pilas_stack/src/Archivos/ListaPeliculas.txt",
                true);
        escritura.write(p.escribir());
        escritura.close();
        
    }
    
    public void getInfo_peliculas(){
        
       try{
      
           File archivo = new File("C:/Users/USUARIO/OneDrive/Documentos/taller_pilas/taller_pilas_stack/src/Archivos/ListaPeliculas.txt");
           Scanner scanner = new Scanner(archivo);
           Pelicula peli=null;
           String atributo="";
          // atributos para poder instanciar el objeto pelicula
           int id=0,edad=0;
           String nombrePeli="";
           float duracion=0,valorBoleta=0;
           
           // utilizo este arrayList para poder capturar la informacion del fichero.
           List<String> info = new ArrayList<>();
          
           // recorro el fichero para ir guardando cada atributo en la lista
           while (scanner.hasNextLine()) {
                atributo = scanner.nextLine();
                // con esto evitamos que nos traiga un valor vacio.
                if(!atributo.equalsIgnoreCase(""))
                    info.add(atributo);
            }
            
           // ahora recorremos la lista de info para poder crear los objetos y guardarlos en la pila
           for(int i=0;i<info.size();i+=5){
              
               if (!info.isEmpty()) {
                   id = Integer.parseInt(info.get(i));
                   nombrePeli = info.get(i + 1);
                   duracion = Float.parseFloat(info.get(i + 2));
                   edad = Integer.parseInt(info.get(i + 3));
                   valorBoleta = Float.parseFloat(info.get(i + 4));
                   // creamos el objeto
                   peli = new Pelicula(id, nombrePeli, duracion);
                   peli.setEdad(edad);
                   peli.setValorBoleta(valorBoleta);
                   // por ultimo lo agregamos a la pila
                   pilaP.push(peli);
               }
           }
           // cerramos el flujo.
            scanner.close();
       
       }catch(Exception e){
           
           aviso_Error("Error al traer los datos del fichero", ""+e);
       }
    }
    
    public void mostrar_info_estrenos(int id){
        
        for (int i = pilaP.size() - 1; i >= 0; i--) {
            if(pilaP.get(i).getId() == id)
                pilaP.get(i).mostrar();
        }
    }
    
    public void mostrar_info_estrenos_antiguos(int id){
        
        for (int i =0; i < pilaP.size(); i++) {
            
            if(pilaP.get(i).getId() == id)
                pilaP.get(i).mostrar();
        }
    }
    
    // metodo general para mostrar avisos de informacion
    public void aviso_info(String titulo, String info){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setContentText(info);
        alerta.show();
    }
    // metodo general para mostrar avisos de errores
    public void aviso_Error(String titulo, String info){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(info);
        alerta.show();
    }
    // metodo general para captura de datos por pantalla
     public TextInputDialog aviso_captura_informacion(String titulo, String header, String info){
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titulo);
        dialog.setHeaderText(header);
        dialog.setContentText(info);
        
        return dialog;
    }
}
