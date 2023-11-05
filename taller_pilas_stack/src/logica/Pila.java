/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Stack;

/**
 *
 * @author Leocarlos y moises
 */
public class Pila {
    
    public Stack<Pelicula> pilaP;
    
    public Pila() { pilaP = new Stack(); }
    
    public void setPila(Stack<Pelicula> pila){
        
        pilaP.addAll(pila); 
    }
    
    public boolean setPushPelicula (
            int id,
            String nombre,
            float duracion,
            int edad,
            float valor 
    ){
        
        Pelicula p = new Pelicula(id,nombre,duracion,edad,valor);
        boolean band = false; // badera para saber si agrego correctamente o no.
        
        // buscamos si la pelicula a ingresar se repite en la pila
        int pos = pilaP.indexOf(p); // si retorna >0 lo encontro si retorna -1 no lo encontro
        
        if(pos==-1){
            
            pilaP.push(p); // utilizamos el metodo push para ir agregando en la parte del tope de la pila
            band=true;
        }
       return band; 
    }
    
    public void MostrarAll(){
        
        for(int i =0;i<pilaP.size();i++){
            
            // mostramos cada pelicula de la pila
            pilaP.get(i).mostrar();
        }
    }
}
