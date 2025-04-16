/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class Nodo {
    private int dato;  
    private Nodo siguiente; 
    private String descripcion;
    private int orden;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;    
    }

    public Nodo(int orden, String descripcion){
        this.orden = orden;
        this.descripcion = descripcion;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

}
