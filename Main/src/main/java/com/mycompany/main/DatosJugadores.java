/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class DatosJugadores {
    private String NombreJugador;
    private int PosicionActual;
    private ListaEnlazada Posicion;
    
    public DatosJugadores(String NombreJugador, int PosicionActual){
    this.NombreJugador = NombreJugador;
    this.PosicionActual = PosicionActual;
  
}

    public DatosJugadores(String NombreJugador, ListaEnlazada Posicion) {
        this.Posicion = Posicion;
        this.NombreJugador = NombreJugador;
    }
    
    

    public String getNombreJugador() {
        return NombreJugador;
    }

    public void setNombreJugador(String NombreJugador) {
        this.NombreJugador = NombreJugador;
    }

    public int getPosicionActual() {
        return PosicionActual;
    }

    public void setPosicionActual(int PosicionActual) {
        this.PosicionActual = PosicionActual;
    }

    public ListaEnlazada getPosicion() {
        return Posicion;
    }

    public void setPosicion(ListaEnlazada Posicion) {
        this.Posicion = Posicion;
    }
    

}

