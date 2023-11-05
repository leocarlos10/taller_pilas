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

    public Pelicula(int id, String nombrePelicula, float duracion, int edad, float valorBoleta) {
        this.id = id;
        this.nombrePelicula = nombrePelicula;
        this.duracion = duracion;
        this.edad = edad;
        this.valorBoleta = valorBoleta;
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
}
