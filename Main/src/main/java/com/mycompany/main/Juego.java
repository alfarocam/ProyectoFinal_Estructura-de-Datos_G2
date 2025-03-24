/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author josep
 * @author Kevin 3/1/2025
 * @author CamilaAlfaro 3/2/2025
 */
public class Juego {
    private ColaDeJugadores ColaDeJugadores;
    private BITACORA_HISTORICA BITACORA_HISTORICA;
    private Premios Premios;
    private Castigos Castigos;
    private Random random; 
    private int Jugador; 
    
    public Juego() {
        ColaDeJugadores = new ColaDeJugadores();
        BITACORA_HISTORICA = new BITACORA_HISTORICA();
        Premios = new Premios();
        Castigos = new Castigos();
        random = new Random();
        this.Jugador = 0;
        
    }

    public int getJugador() {
        return Jugador;
    }

    public void setJugador(int Jugador) {
        this.Jugador = Jugador;
    }

    public void iniciarJuego() {
        
        Premios.agregaPremio();
        Castigos.agregarCastigo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*              Bienvenidos al Juego de              *");
        System.out.println("*                                                   *");
        System.out.println("*                Dados del GRUPO #2!                *");
        System.out.println("*                                                   *");
        System.out.println("*                   Buena Suerte                    *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        boolean jugando = true;

        while (jugando) {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Mostrar jugadores");
            System.out.println("4. Jugar");
            System.out.println("5. Salirse del juego");
            System.out.println("6. Mostrar posiciones");
            System.out.println("7. Cambiar turno"); 
            System.out.println("8. Mostrar Pila de Premios");
            System.out.println("9. Mostrar Pila de Castigos");
            System.out.println("10. Ayuda");
            System.out.println("11. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                System.out.print("Ingrese el nombre del jugador: ");
                String nombre = scanner.next();

                NodoCola actual = ColaDeJugadores.getFrente();
                boolean existe = false; 

              
                while (actual != null) {
                    if (actual.getDato().getNombreJugador().equals(nombre)) {
                        System.out.println("El jugador ya existe");
                        existe = true;
                        break; 
                    }
                    actual = actual.getSiguiente();
                }

                if (existe) {
                    System.out.println("Este jugador ya existe.");
                } else {
                    ListaEnlazada miListaEnlazada = new ListaEnlazada();
                    
                    ColaDeJugadores.encolar(nombre, Jugador);
                    miListaEnlazada.insertaOrdenado(Jugador);
                    BITACORA_HISTORICA.insertar(nombre, miListaEnlazada);
                    BITACORA_HISTORICA.getUltimo().getAnterior().getDato().getPosicion().recorrer();    
                    
                }
                break; 
                case 2:
                    System.out.print("Ingrese el nombre del jugador a eliminar: ");
                    String jugadorEliminado = scanner.next();

                    NodoCola eliminado = ColaDeJugadores.desencolar(jugadorEliminado);

                    if (eliminado != null) {
                        System.out.println("Se ha eliminado a " + eliminado.getDato().getNombreJugador());
                    } else {
                        System.out.println("Jugador no encontrado en la cola.");
                    }
                break;
                case 3:
                    ColaDeJugadores.ImprimirParticipantes();
                    break;
                case 4:
                    jugar();
                    break;
                case 5:
                    System.out.print("Ingrese el ID del jugador que desea salir: ");
                    int idSalir = scanner.nextInt();
                    /**colaDeJugadores.salirDelJuego(idSalir);**/
                    break;
                case 6:
                    ColaDeJugadores.mostrarPosiciones(); 
                    break;
                case 7:
                    /**colaDeJugadores.cambiarTurno(); **/
                    break;
                case 8:
                    Premios.imprimirPila(); 
                    break;
                case 9: 
                    Castigos.imprimirPila();
                    break;
                case 10:
                    mostrarAyuda();
                    break;
                case 11:
                    jugando = false;
                    System.out.println("Gracias por jugar!");
                    break;
                case 12:
                    System.out.println(Premios.sacarPremio());
                default:
                    System.out.println("Opcion no valida");
            }
        }

        scanner.close();
    }
/**
* imprime la informacio de ayuda del juego, la versión y los desarrolladores.
*/
    private void mostrarAyuda() {
        System.out.println("*****************************************************");
        System.out.println("*                   Ayuda del Juego                 *");
        System.out.println("*                                                   *");
        System.out.println("*                  Version: V 1.0.2                 *");
        System.out.println("*                                                   *");
        System.out.println("*             Desarrolladores:                      *");
        System.out.println("*               - Camila Alfaro Rivera              *");
        System.out.println("*               - Kevin Guifarro Orellana           *");
        System.out.println("*               - Ian Villalobos Alvarez            *");
        System.out.println("*               - Jose Pablo Murillo Villamil       *");
        System.out.println("*****************************************************");
    }
    
    
/**
 * 
 * Este metodo es el que se encarga de todas las "reglas", es decir tirar los dados, realizar la suma y 
 * en base a eso aplicar ya sea las intrucciones de premios o castigos; también lleva el control de turnos y posiciones por jugador
 * 
 * si la suma es par el jugador recibe un premio de la pila de premios
 * si la suma es impar el jugador recibe un castigo de la pila de castigos
 * 
 *
* */

        
private void jugar() {
    Scanner scanner = new Scanner(System.in);
    
        System.out.println("!!!!!Inicia el Juego!!!!!!!");
        System.out.println("Participantes");
        ColaDeJugadores.ImprimirParticipantes();
        boolean juegoActivo = true;

        while (ColaDeJugadores.getFrente().getDato().getPosicionActual() < 30 && juegoActivo) {  // Cambié la condición para continuar hasta alcanzar o superar la posición 30
            String Menu = "pe";
            DatosJugadores JugadorActual = ColaDeJugadores.getFrente().getDato();  
            String Turno = BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador();
            int Posicion = JugadorActual.getPosicionActual();
            
            
            System.out.println("Es el turno de: " + Turno + " Se encuentra en posición " + Posicion);

            System.out.print("Listo para tirar los dados?(Y/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("Y")){
                System.out.println("¡Tira los dados!");
                int dado1 = random.nextInt(6) + 1; 
                int dado2 = random.nextInt(6) + 1; 
                int sumaDados = dado1 + dado2;

                System.out.println("Tu dado 1 quedó en: " + dado1 + ", tu dado 2 quedó en " + dado2 + ". En total tienes: " + sumaDados);

                if (sumaDados % 2 == 0) {
                    System.out.println("!!!!FELICIDADES!!!!!");
                    System.out.println("Obtuviste un número par, debes tomar un premio de la pila. Mucha Suerte");
                    DatosPremios premio = Premios.despilar();
                    System.out.println(premio.getPremio());
                    JugadorActual.setPosicionActual(JugadorActual.getPosicionActual() + premio.getPosicionesMas());
                    System.out.println(JugadorActual.getPosicionActual());
                    System.out.println("Jugador " + Turno + " estas en la posición " + Posicion + ", puedes avanzar " + premio.getPosicionesMas() + " posiciones en la carrera. Ahora su nueva posición es " + JugadorActual.getPosicionActual());
                    System.out.println("Tu posición actual es: " + JugadorActual.getPosicionActual());
                    /**                           **/
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                        System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();

                        
                    
                    
                } else {
                    System.out.println("!!!!Mala Suerte!!!!!");
                    System.out.println("Obtuviste un número impar, debes tomar un castigo de la pila. Mejor suerte la próxima vez");

                    if (JugadorActual.getPosicionActual() == 0) {
                        System.out.println("No tienes puntos para restar, puntos eliminados = 0");
                        System.out.println("Jugador " + Turno + " estas en la posición " + Posicion + ", puedes avanzar 0 posiciones en la carrera. Ahora su nueva posición es " + JugadorActual.getPosicionActual());
                        System.out.println("Tu posición actual es: " + JugadorActual.getPosicionActual());
                        /**                           **/
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                        System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();
                        


                    } else {
                        DatosCastigos castigo = Castigos.despilar();
                        System.out.println(castigo.getCastigo());
                        JugadorActual.setPosicionActual(JugadorActual.getPosicionActual() - castigo.getPosicionesMenos());
                        System.out.println(JugadorActual.getPosicionActual());
                        System.out.println("Jugador" + Turno + "estas en la posición" + Posicion + ", puedes avanzar" + castigo.getPosicionesMenos() + "posiciones en la carrera. Ahora su nueva posición es " + JugadorActual.getPosicionActual());
                        System.out.println("Tu posición actual es: " + JugadorActual.getPosicionActual());
                        /**                           **/
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                        System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();
                        
                        
                    }
                }
                
                
                while (!Menu.equals("pp")) {
                System.out.println("\nSeleccione una opcion:");
                System.out.println("1. Pasar turno");
                System.out.println("2. Historial de jugadas");
                System.out.println("3. Ver Posiciones de los demas jugadores");
                System.out.println("4. Salirse del juego Jugador:" + ColaDeJugadores.getFrente().getDato().getNombreJugador());
                System.out.println("5. Mostrar Premios restantes");
                System.out.println("6. Mostrar Castigos restantes");
                System.out.println("7. Terminar Juego");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                       

                 
                        ColaDeJugadores.moverJugadorAlFinal();

                    
                        if (BITACORA_HISTORICA.getCabeza().getDato() != ColaDeJugadores.getFrente().getDato()) {
                            BITACORA_HISTORICA.setCabeza(BITACORA_HISTORICA.getCabeza().getSiguiente());
                        }

                       

                        Menu = "pp";
                        break;
                    case 2:
                        boolean jugador = true;
                        NodoCola historialActual = BITACORA_HISTORICA.getCabeza(); 

                        while (jugador) {
                            System.out.println(historialActual.getDato().getNombreJugador());
                            historialActual.getDato().getPosicion().recorrer();

                            System.out.print("Exit, siguiente <> anterior: ");
                            String opciones = scanner.next();

                            if (opciones.equals("siguiente")) {
                                historialActual = historialActual.getSiguiente(); 
                            } else if (opciones.equals("anterior")) {
                                historialActual = historialActual.getAnterior(); 
                            } else {
                                break;
                            }
                        }
    
                                
                                           
                        break;
                    case 3:
                        ColaDeJugadores.ImprimirParticipantes();  
                        
                        break;
                    case 4:

                        NodoCola eliminado = ColaDeJugadores.desencolar(ColaDeJugadores.getFrente().getDato().getNombreJugador());
                        if (eliminado != null) {
                            System.out.println("Se ha eliminado a " + eliminado.getDato().getNombreJugador());
                            Menu = "pp";
                        } else {
                            System.out.println("Jugador no encontrado en la cola.");
                            Menu = "pp";
                        }
                        break;
                    case 5:
                        Premios.imprimirPila(); 
                       
                        break;
                    case 6: 
                        Castigos.imprimirPila();
                        
                        break; 
                    case 7:
                        System.out.println("Juego finalizado, los jugadores quedaron:");
                        ColaDeJugadores.ImprimirParticipantes();
                        NodoCola actual = ColaDeJugadores.getFrente();
                        

                         while (actual != null) {
                             actual.getDato().setPosicionActual(0);
                             actual = actual.getSiguiente();
                         }
                         juegoActivo = false; 
                         Menu = "pp";  // O cualquier otro valor según tu lógica
                         break;
                }
            }
        }
    }
    if(ColaDeJugadores.getFrente().getDato().getPosicionActual() >= 30){    
    System.out.println("¡El juego ha terminado! El jugador " + ColaDeJugadores.getFrente().getDato().getNombreJugador() + " ha ganado.");
    }
    else{
    System.out.println("Fin del juego");
    }
    }
}  
    
   
