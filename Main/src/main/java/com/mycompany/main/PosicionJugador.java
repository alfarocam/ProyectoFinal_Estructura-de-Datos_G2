/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class PosicionJugador {
    public void actualizarPosicion(int random, PilaPremios premios, PilaCastigos castigos, int posicionJugador) {

        if ((random & 1) == 0) { 
         
            DatosPremios premio = premios.despilar();
            posicionJugador += premio.getPosicionesMas();
            System.out.println("¡Ganaste un premio! " + premio.getPremio());
        } else {
        
            DatosCastigos castigo = castigos.despilar();
            posicionJugador -= castigo.getPosicionesMenos();
            System.out.println("¡Recibiste un castigo! " + castigo.getCastigo());
        }

        System.out.println("Tu nueva posición es: " + posicionJugador); 
    }
}