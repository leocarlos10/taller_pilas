/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javafx.scene.control.Alert;

/**
 *
 * @author Leocarlos y moises
 */
public class Pelicula {
    
    private int id;
    private String nombrePelicula;
    private float duracion;
    private int edad;
    private float valorBoleta;
     String cat;
    
    public Pelicula(int id, String nombrePelicula, float duracion) {
        
        this.id = id;
        this.nombrePelicula = nombrePelicula;
        this.duracion = duracion;
        this.edad = (int ) (Math.random()*(60-5)+5);// la edad se generea automaticamente entre los rangos 5 y 60 años.
        // hacemos la verificaciones correspondientes para el valor de la Boleta
        if(edad >= 5 && edad<=10){
            
            this.valorBoleta=3000;
            this.cat = "niño";
            
        }else if(edad >= 11 && edad<=17){
            
            this.valorBoleta =7000;
            this.cat = "adolecente";
            
        }else if(edad>=18){
            
            this.valorBoleta=9000;
              this.cat = "adulto";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getValorBoleta() {
        return valorBoleta;
    }

    public void setValorBoleta(float valorBoleta) {
        this.valorBoleta = valorBoleta;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
    
    
    public void mostrar(){
      
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informacion de la pelicula");
        alerta.setContentText("id: " + id
                + " \nNombre: " + nombrePelicula
                + "\nDuracion: " + duracion
                + "\nEdad: " + edad
                + "\nValor de la boleta: " + valorBoleta);
       alerta.show();
    }
    
    public String escribir(){
        
       return id+"\n"+nombrePelicula+"\n"+duracion+"\n"+edad+"\n"+valorBoleta+"\n"+cat+"\n";
    }
}
