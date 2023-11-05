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

    public pila() {
        tope1 = null;
        tope2 = null;
    }

    public nodo getCrearNodo(int valor) {

        nodo p = null;
        try {
            p = new nodo(valor);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e);
            p = null;
        }
        return p;
    }

    public void setPush_pila1(int valor) {

        // primero creamos el nodo para luego agregarlo a la pila.
        nodo p = getCrearNodo(valor);
        if (p != null) {
            if (tope1 == null) {

                tope1 = p;
                tope1.sig = tope1;
            } else {

                nodo base = tope1;
                do {
                    // esto para que baje en la pila.
                    base = base.sig;
                } while (base.sig != tope1);
                // ya teniendo la base podemos realizar el enlace del nodo a la pila
                p.sig = tope1;
                base.sig = p;
                tope1 = p;

            }
        }
    }

    public void setPush_pila2(int valor) {

        // primero creamos el nodo para luego agregarlo a la pila.
        nodo p = getCrearNodo(valor);
        if (p != null) {
            if (tope2 == null) {

                tope2 = p;
                tope2.sig = tope2;
            } else {

                nodo base = tope2;
                do {
                    // esto para que baje en la pila.
                    base = base.sig;
                } while (base.sig != tope2);
                // ya teniendo la base podemos realizar el enlace del nodo a la pila
                p.sig = tope2;
                base.sig = p;
                tope2 = p;
            }
        }
    }

    public boolean isEmpty_pila1() {

        return tope1 == null;

    }

    public boolean isEmpty_pila2() {

        return tope2 == null;

    }
    
     
    public nodo getPequena(nodo p1, nodo p2){
        
        int cont_pila1=0;
        int cont_pila2=0;
        nodo pila1=p1;
        nodo pila2=p2;
        
         do{
            cont_pila1++;
            pila1= pila1.sig;
        
        }while(pila1!=tope1);
        
        do{
            cont_pila2++;
            pila2=pila2.sig;
        }while(pila2!=tope2);
        
        return cont_pila1<cont_pila2 ? p1:p2; 
        
    }

    public nodo isPequena(nodo p1, nodo p2) {

        int cont_pila1 = 0;
        int cont_pila2 = 0;
        nodo pila1 = p1;
        nodo pila2 = p2;
        // tamaño pila1
        do {
            cont_pila1++;
            pila1 = pila1.sig;

        } while (pila1 != tope1);

        //tamaño pila 2
        do {
            cont_pila2++;
            pila2 = pila2.sig;
        } while (pila2 != tope2);

        // verificamos cual pila es menor
        return cont_pila1 < cont_pila2 ? p1 : p2;

    }
    
    public nodo getGrande(nodo p1, nodo p2){
        
        int cont_pila1=0;
        int cont_pila2=0;
        nodo pila1=p1;
        nodo pila2=p2;
        
        do{
            cont_pila1++;
            pila1= pila1.sig;
        
        }while(pila1!=tope1);
        
      
        do{
            cont_pila2++;
            pila2=pila2.sig;
        }while(pila2!=tope2);
        
        
        return cont_pila1>cont_pila2 ? p1:p2; 
        
    }

    public nodo isGrande(nodo p1, nodo p2) {

        int cont_pila1 = 0;
        int cont_pila2 = 0;
        nodo pila1 = p1;
        nodo pila2 = p2;
        // tamaño pila1
        do {
            cont_pila1++;
            pila1 = pila1.sig;

        } while (pila1 != tope1);

        //tamaño pila 2
        do {
            cont_pila2++;
            pila2 = pila2.sig;
        } while (pila2 != tope2);

        // verificamos cual pila es menor
        return cont_pila1 > cont_pila2 ? p1 : p2;

    }

    // con este metodo obtengo el tamaño de la pila pequeña
    public int getLongPila() {

        int cont = 0; // contador
        nodo pequeno = getPequena(tope1, tope2); // pila pequeña
        
        // luego dependiendo de cual tope es la pila pequeña verificamos su tamaño.
        if (pequeno == tope1) {

            nodo p = tope1;
            do {
                cont++;
                p = p.sig;

            } while (p != tope1);

        } else if (pequeno == tope2) {

            nodo p = tope2;
            do {
                cont++;
                p = p.sig;

            } while (p != tope2);
        }
        return cont;
    }

    public void essombrero() {

        // primero verificamos si las pilas estan vacias
        if (isEmpty_pila1()) {

            JOptionPane.showMessageDialog(null, " Li pila1 es sombrero de la pila 2");

        } else if (isEmpty_pila2()) {

            JOptionPane.showMessageDialog(null, " Li pila2 es sombrero de la pila 1");

        } else if (isEmpty_pila1() && isEmpty_pila2()) {

            JOptionPane.showMessageDialog(null, " Las pilas estan vacias");
        }

        // obtenemos la pila pequeña y la pila grande ya que si la pila pequeña llega a coincidir con los primero elementos de la grande cercanos el tope va a ser el sombrero de la grande

        nodo pequeno = getPequena(tope1, tope2);
        nodo grande = getGrande(tope1, tope2);
        int cont=0; // este contador me ayuda a verificar si todos los enteros eran iguales o no

        // recorremos las dos pilas, si pequeno es diferente de tope 1 o 2 y si los valores de las pilas son iguales contamos y avanzamos en la pila
        do {
            cont++;
            pequeno = pequeno.sig;
            grande = grande.sig;

        } while ((pequeno != tope1 || pequeno != tope2) && (pequeno.valor == grande.valor));

        /*
    por ultimo si el conteo es igual a el tamaño de la pila quiere decir que recorrio toda la pila pequena 
    y los valores eran iguales por tanto es sombrero de la pila grande
         */
        if (cont == getLongPila()) {

            // con estos if solo verificamos cual pila es sombrero de la otra
            if (pequeno == tope1) {
                JOptionPane.showMessageDialog(null, " La pila 1 es sombrero de la pila 2");
            } else {
                JOptionPane.showMessageDialog(null, "La pila 2 es sombrero de la pila 1");
            }
        } else {
            // si estado es false se verifica cual pila no es sombrero de la otra
            if (pequeno == tope1) {
                JOptionPane.showMessageDialog(null, " La pila 1 no es sombrero de la pila 2");
            } else {
                JOptionPane.showMessageDialog(null, "La pila 2 no es sombrero de la pila 1");
            }
        }
    }

    public void setLlenarJTable(JTable tab) {

        nodo p = tope1;
        nodo q = tope2;
        int fila = 0;

        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("Pila 1");
        miModelo.addColumn("Pila 2");

        do {
            miModelo.addRow(new Object[]{""});
            miModelo.setValueAt(p.valor, fila, 0);
            p = p.sig;
            fila++;

        } while (p != tope1);

        do {
            miModelo.addRow(new Object[]{""});
            miModelo.setValueAt(q.valor, fila, 1);
            p = p.sig;
            q = q.sig;
            fila++;

        } while (q != tope2);

        tab.setModel(miModelo);
    }

    public int compararBaseTam1() {
        if (isEmpty_pila1()) {
            return 0;
        }

        int baVal = tope1.valor;
        int pilaTamm = getLongPila();

        if (baVal < pilaTamm) {
            return -1;

        } else if (baVal == pilaTamm) {
            return 0;
        } else {
            return 1;
        }
    }
    
        public int compararBaseTam2() {
        
            if (isEmpty_pila1()) {
            return 0;
        }

        int baVal = tope1.valor;
        int pilaTamm = getLongPila();

        if (baVal < pilaTamm) {
            return -1;

        } else if (baVal == pilaTamm) {
            return 0;
        } else {
            return 1;
        }
    }
}

