/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author josep
 */
public class Jugador {
    private String nombre;
    private int id;
    private int posicionActual; 

  
    public Jugador(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

  
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }
    

    @Override
    public String toString() {
        return "Jugador{" +
               "nombre='" + nombre + '\'' +
               ", id=" + id +
               '}';
    }
}
