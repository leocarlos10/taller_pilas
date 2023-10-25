/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller_pilas;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Leocarlos, moises
 */
public class pila {
    
    nodo tope1;
    nodo tope2;
    
    public pila(){tope1=null; tope2=null;}
    
    public nodo getCrearNodo(int valor){
       
       nodo p=null; 
        try{
         p = new nodo(valor);
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error "+e);
            p = null;
        }
        return p;
    }
    
    public void setPush_pila1(int valor){
        
        // primero creamos el nodo para luego agregarlo a la pila.
        nodo p = getCrearNodo(valor);
        if(p!=null){
            if(tope1 == null){
                
                tope1=p;
                tope1.sig=tope1;
            }else{
                
                nodo base=tope1;
                do{
                    // esto para que baje en la pila.
                    base=base.sig;
                }while(base.sig!=tope1);
                // ya teniendo la base podemos realizar el enlace del nodo a la pila
                p.sig=tope1;
                base.sig=p;
                tope1=p;
              
            }
        }
    }
    
     public void setPush_pila2(int valor){
        
        // primero creamos el nodo para luego agregarlo a la pila.
        nodo p = getCrearNodo(valor);
        if(p!=null){
            if(tope2 == null){
                
                tope2=p;
                tope2.sig=tope2;
            }else{
                
                nodo base=tope2;
                do{
                    // esto para que baje en la pila.
                    base=base.sig;
                }while(base.sig!=tope2);
                // ya teniendo la base podemos realizar el enlace del nodo a la pila
                p.sig=tope2;
                base.sig=p;
                tope2=p;
            }
        }
    }
    
    
    public void verf_sombrero(){
        
        // primero verifico que las pilas no esten vacias
        if(tope1!=null && tope2!=null){
            
            // ya sabiendo que no estan vacias verificamos cual pila es sombrero de cual
            nodo aux1 = tope1;
            nodo aux2 = tope2;
            
            // recorremos las pilas verificando dos cosas mientras que sean diferentes del tope y 
            //mientras las variables aux.valor sean iguales es decir el valor sea igual va a seguir avanzando 
            //hasta que algunas de las dos vuelva al tope o los valores sean diferentes y se salga del do while
            
            do{
                
                aux1 = aux1.sig;
                aux2 = aux2.sig;
            }while( aux1!= tope1 && aux2!=tope2 && aux1.valor == aux2.valor);
            
            // cuando salga del while solo hay que verificar quien quedo en el tope el que haya quedado en el tope es sombrero del otro
            if (aux1 == tope1) {

                JOptionPane.showMessageDialog(null, " La pila 1 es  sombrero de la pila 2");
            } else if (aux2 == tope2) {
                JOptionPane.showMessageDialog(null, " La pila 2 es  sombrero de la pila 1");
            } else if(aux1== tope1 && aux2==tope2) {

                JOptionPane.showMessageDialog(null, "las dos listas son iguales");

            } else{
                
                JOptionPane.showMessageDialog(null, " ninguna de las dos listas cumple con los requisistos para ser sombrero de la otra");
            }
        }
    }
    
   
    
    public void setLlenarJTable(JTable tab){
       
        nodo p=tope1;
        nodo q=tope2;
        int fila=0;
        
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("Pila 1");
        miModelo.addColumn("Pila 2");
       
       do{
           miModelo.addRow( new Object [] {"",""});
           miModelo.setValueAt(p.valor, fila, 0);
           miModelo.setValueAt(q.valor, fila, 1);
           p=p.sig;
           q=q.sig;
           fila++;
       }while(p!= tope1 && q!= tope2);
       
        tab.setModel(miModelo);
    }
}
