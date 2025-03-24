/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josep
 * @author Kevin G. 3/1/2025
 * @author CamilaAlfaro 3/2/2025
 */
public class ColaDeJugadores extends Cola{

    public ColaDeJugadores(){

        
    }
/**
   * En este Metodo contamos cuantos niños ahi inscritos en la cola 
   * @author Ian Villalobos Alvarez                    
   * @return Retorna contador que es la cantidad de niños inscritos
   */    
    public int cuentaParticipantes(){
        int contador = 0;

      NodoCola actual = frente;
      while (actual != null) {
        contador++; 
        actual = actual.getSiguiente();  
    }
    return contador;
      
    }
/**
   * En este Metodo imprimimos los datos de los niños inscritos 
   * @author Ian Villalobos Alvarez                    
   * @return No retorna nada
   */
    public void ImprimirParticipantes() {
        NodoCola actual = frente;  
    
    if (actual == null) {  
        System.out.println("La cola está vacía.");
    } 
    else {
        while (actual != null) {
           
            System.out.println("#### Participante ####");
            System.out.println("Nombre Completo: " + actual.getDato().getNombreJugador());
            System.out.println("Posicion: " + actual.getDato().getPosicionActual());
            System.out.println("---------------------");
    
            actual = actual.getSiguiente();
            }
        }
    }

}
