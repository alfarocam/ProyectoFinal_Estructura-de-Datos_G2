/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class BITACORA_HISTORICA {
    
   private NodoCola frente;
   private NodoCola ultimo;

    public BITACORA_HISTORICA() {
    }

    public BITACORA_HISTORICA(NodoCola cabeza, NodoCola ultimo) {
        this.frente = cabeza;
        this.ultimo = ultimo;
    }

    public void setCabeza(NodoCola cabeza) {
        this.frente = cabeza;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    public NodoCola getCabeza() {
        return frente;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }
    
    public void insertar (String nombre, ListaEnlazada Lista){

        DatosJugadores miDato = new DatosJugadores(nombre, Lista);
        NodoCola temp = new NodoCola(miDato);
        if (frente == null ){       
            frente = temp;                
            ultimo = frente;             
            ultimo.setSiguiente(frente);  
            frente.setAnterior(ultimo);    
        }
        else if (temp.getDato().getNombreJugador().compareTo(frente.getDato().getNombreJugador()) < 0){  
           
            temp.setSiguiente(frente);        
            frente.setAnterior(temp);
            frente = temp; 
            frente.setAnterior(ultimo);    
            ultimo.setSiguiente(frente); 
        }
        else if (temp.getDato().getNombreJugador().compareTo(ultimo.getDato().getNombreJugador()) >= 0){
         
            ultimo.setSiguiente(temp);    
            temp.setAnterior(ultimo);      
            ultimo = temp;               
            ultimo.setSiguiente(frente);
            frente.setAnterior(ultimo);
        }else {     
            NodoCola aux = frente;      
            while (aux.getSiguiente().getDato().getNombreJugador().compareTo(temp.getDato().getNombreJugador()) < 0){ 
                aux = aux.getSiguiente();
            }  
            temp.setSiguiente(aux.getSiguiente()); 
            temp.setAnterior(aux);                   
        
            aux.setSiguiente(temp);             
            temp.getSiguiente().setAnterior(temp);    
        }
    }
 
}