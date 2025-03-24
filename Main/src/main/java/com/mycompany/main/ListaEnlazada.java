/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class ListaEnlazada {
    Nodo primero;
    
    public ListaEnlazada(){
    
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }
    
    public void insertaOrdenado(int valor){
    Nodo nuevo = new Nodo(valor);
    // #1caso: Insertar en una lista  vacia.
    if (this.getPrimero() == null) { // Significa que la lista esta vacia.
        this.setPrimero(nuevo);      // Inicializo el primer elemento con la neva cajita.
    
     }
    else if(this.getPrimero().getDato() <= valor){ // #2caso: Insertar antes del primer da la lista.
        nuevo.setSiguiente(primero);
        this.setPrimero(nuevo);
        
    }
    else{// #3caso: Insertar en cualquier lugar de la lista.
    
        Nodo aux = this.getPrimero();
        
        // Este ciclo me permite buscar la posicion correcta dentro de la lista
        while (aux.getSiguiente()!= null && 
               aux.getSiguiente().getDato() < valor){
            aux = aux.getSiguiente();  
        
        }
        nuevo.setSiguiente(aux.getSiguiente()); // amarro la nueva caja al resto de la lista
        aux.setSiguiente(nuevo);
        }
    }
    
    public void eliminarNodo(int valor) {
    Nodo actual = primero;  // Creo un auxiliar temporal y lo igualo al primero.
    Nodo anterior = null;   // Inicializo el anterior al primero en null.

    // Recorro la lista hasta encontrar el elemento que quiero eliminar.
    while (actual != null && actual.getDato() != valor) {  // Mientras no hayamos llegado al final y no hayamos encontrado el elemento.
        anterior = actual;
        actual = actual.getSiguiente();
    }
    
    if (actual == null) {  // Significa que no encontré el elemento a eliminar.
        return;
    }
    
    if (anterior == null) {  // Significa que voy a eliminar la cabeza.
        this.setPrimero(actual.getSiguiente());
    } 
    else {
        anterior.setSiguiente(actual.getSiguiente());
        }
    }

    
    public boolean buscar(int valor) {
        Nodo actual = primero;  // Creo un puntero auxiliar y lo inicializo igual al primero.
        while (actual != null) {  // Mientras actual NO sea null. Tenemos elementos en la lista.
            if (actual.getDato() == valor) {
                return true;  // Significa que encontré el elemento que estoy buscando, por lo tanto retorno TRUE.
            }
            actual = actual.getSiguiente();  // Muevo el puntero auxiliar (actual) al sgte de la lista.
        }
        return false;  // Retorna false porque llegó al final de la lista y nunca encontró el elemento que andaba buscando.
    }

    public void recorrer() {
        Nodo actual = primero;  // Creo un puntero auxiliar y lo inicializo igual al primero.
        while (actual != null) {  // Mientras actual NO sea null. Tenemos elementos en la lista.
            System.out.print(actual.getDato() + " - ");
            actual = actual.getSiguiente();  // Muevo el puntero auxiliar (actual) al sgte de la lista.
        }
    }
    
}
