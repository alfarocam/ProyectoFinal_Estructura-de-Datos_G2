/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;
import java.util.Random;


/**
 * Esta clase es la parte "visual" y en dónde se toman la decisiones y ajustes
 * de cómo será la partida del juego. Siendo este el juego, se permite agregar y
 * eliminar jugadores, tirar dados, y llevar un historial de las posiciones,
 * premios y castigos de cada jugador.
 *
 * @author CamilaAlfaro 3/23/2025
 * @author Kevin 3/1/2025
 * @author josep
 */
public class Juego {

    private ColaDeJugadores ColaDeJugadores;
    private BITACORA_HISTORICA BITACORA_HISTORICA;
    private Premios Premios;
    private Castigos Castigos;
    private Random random;
    private int Jugador;
    // char S para sí, N para no
    private char permitirIngreso;
    //posicionMaxima guarda el límite del laberinto, es decir en dónde decide el usuario que termine la partida
    private int posicionMaxima;

    /**
     * Constructor de la clase Juego Aquí se inicializa todo lo necesario para
     * que el juego funcione de manera correcta
     */
    public Juego() {
        ColaDeJugadores = new ColaDeJugadores();
        BITACORA_HISTORICA = new BITACORA_HISTORICA();
        Premios = new Premios();
        Castigos = new Castigos();
        random = new Random();
        this.Jugador = 0;
        // Esta posicion máxima es predetermina pero puede ser cambiado por el usuario
        this.posicionMaxima = 10;
    }

    /**
     * Adquiere el ID del jugador actual
     *
     * @return el ID del jugador actual
     */
    public int getJugador() {
        return Jugador;
    }

    /**
     * Fija o estblede el ID del jugador actual
     *
     * @param Jugador el ID del jugador
     */
    public void setJugador(int Jugador) {
        this.Jugador = Jugador;
    }

    /**
     * Método que da inicio al juego y tiene la interacción con el usuario segun
     * sus request Permite agregar jugadores, eliminar jugadores entre otras
     * acciones en relación con la partida
     */
    public void iniciarJuego() {
        Premios.agregaPremio();
        Castigos.agregarCastigo();
        Scanner scanner = new Scanner(System.in);

        //Print de bienvenida
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*              Bienvenidos al Juego de              *");
        System.out.println("*                                                   *");
        System.out.println("*                Dados del GRUPO #2!                *");
        System.out.println("*                                                   *");
        System.out.println("*                   Buena Suerte                    *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        System.out.println();

        //Se le pregunta al usuario y se establce el límite o la posicion maxima del laberinto que gusta
        System.out.print("Ingrese la posicion maxima del laberinto (La meta **NUMERO**): ");
        this.posicionMaxima = scanner.nextInt();

        //Se le pregunta al usuario si se permite agregar jugadores durante el juego
        System.out.println("Desea permitir ingreso de mas jugadores durante el juego? (S/N):  ");
        permitirIngreso = scanner.next().toUpperCase().charAt(0); // Guardar el valor
        boolean jugando = true;

        //Menú principal 
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
                    agregarJugador(scanner);
                    break;
                case 2:
                    eliminarJugador(scanner);
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
                    /**
                     * colaDeJugadores.salirDelJuego(idSalir);*
                     */
                    break;
                case 6:
                    ColaDeJugadores.mostrarPosiciones();
                    break;
                case 7:
                    /**
                     * colaDeJugadores.cambiarTurno(); *
                     */
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
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }

        scanner.close();
    }

    /**
     * Método que muestra la ayuda del juego Print información sobre la versión
     * del juego y los desarrolladores
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
     * Este método contiene y lleva el control de la lógica del juego, que
     * involucra tirar dados, determinar si el jugador avanza o retrocede, y
     * aplicar premios o castigos todo en torno a los dados
     *
     */
    private void jugar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" !!!!! Inicia el Juego !!!!!!! ");
        System.out.println("Participantes");
        ColaDeJugadores.ImprimirParticipantes();
        boolean juegoActivo = true;

        //cliclos que guardan la lógica del juego antes o mientras que ningun jugador haya "ganado" es decir alcanzado la posicion maxima
        while (ColaDeJugadores.getFrente().getDato().getPosicionActual() < posicionMaxima && juegoActivo) {
            String Menu = "pe";
            DatosJugadores JugadorActual = ColaDeJugadores.getFrente().getDato();
            String Turno = BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador();
            int Posicion = JugadorActual.getPosicionActual();

            System.out.println("Es el turno de: " + Turno + " Se encuentra en posicion " + Posicion);

            System.out.print("Listo para tirar los dados?(S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("S")) {
                System.out.println("Tira los dados!");
                int dado1 = random.nextInt(6) + 1;
                int dado2 = random.nextInt(6) + 1;
                int sumaDados = dado1 + dado2;

                System.out.println("Tu dado 1 quedo en: " + dado1 + ", tu dado 2 quedo en " + dado2 + ". En total tienes: " + sumaDados);

                if (sumaDados % 2 == 0) {
                    System.out.println(" !!!! FELICIDADES !!!!! ");
                    System.out.println("Obtuviste un numero par, debes tomar un premio de la pila. Mucha Suerte");
                    DatosPremios premio = Premios.despilar();
                    System.out.println(premio.getPremio());
                    JugadorActual.setPosicionActual(JugadorActual.getPosicionActual() + premio.getPosicionesMas());
                    System.out.println(JugadorActual.getPosicionActual());
                    System.out.println("Jugador " + Turno + " estas en la posicion " + Posicion + ", puedes avanzar " + premio.getPosicionesMas() + " posiciones en la carrera. Ahora su nueva posición es " + JugadorActual.getPosicionActual());
                    System.out.println("Tu posicion actual es: " + JugadorActual.getPosicionActual());

                    BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                    System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                    BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();
                } else {
                    System.out.println(" MALA SUERTE :C ");
                    System.out.println("Obtuviste un numero impar, debes tomar un castigo de la pila. Mejor suerte la proxima vez");

                    if (JugadorActual.getPosicionActual() == 0) {
                        System.out.println("No tienes puntos para restar, puntos eliminados = 0");
                        System.out.println("Jugador " + Turno + " estas en la posicion " + Posicion + ", puedes avanzar 0 posiciones en la carrera. Ahora su nueva posicion es " + JugadorActual.getPosicionActual());
                        System.out.println("Tu posicion actual es: " + JugadorActual.getPosicionActual());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                        System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();
                    } else {
                        DatosCastigos castigo = Castigos.despilar();
                        System.out.println(castigo.getCastigo());
                        JugadorActual.setPosicionActual(JugadorActual.getPosicionActual() - castigo.getPosicionesMenos());
                        System.out.println(JugadorActual.getPosicionActual());
                        System.out.println("Jugador" + Turno + " estas en la posicion" + Posicion + ", puedes avanzar" + castigo.getPosicionesMenos() + "posiciones en la carrera. Ahora su nueva posicion es " + JugadorActual.getPosicionActual());
                        System.out.println("Tu posicion actual es: " + JugadorActual.getPosicionActual());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                        System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();
                    }
                }
            }

            // Verificar si el jugador ha llegado al final del laberinto (posición máxima)
            if (JugadorActual.getPosicionActual() >= posicionMaxima) {
                System.out.println("Felicidades! El jugador " + JugadorActual.getNombreJugador() + " ha llegado al final del laberinto");
                break;
            }
        }
    }

    /**
     * Método para agregar un jugador al inicio del juego
     *
     * @param scanner scanner para leer lo ingresado por el usuario
     */
    private void agregarJugador(Scanner scanner) {
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
            System.out.println("Este jugador ya existe");
        } else {
            ListaEnlazada miListaEnlazada = new ListaEnlazada();
            ColaDeJugadores.encolar(nombre, Jugador);
            miListaEnlazada.insertaOrdenado(Jugador);
            BITACORA_HISTORICA.insertar(nombre, miListaEnlazada);
            BITACORA_HISTORICA.getUltimo().getAnterior().getDato().getPosicion().recorrer();
        }
    }

    /**
     * Método para eliminar un jugador del juego
     *
     * @param scanner scanner para leer lo ingresado por el usuario
     */
    private void eliminarJugador(Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador: ");
        String eliminado = scanner.next();
        boolean existente = false;

        NodoCola actuall = ColaDeJugadores.getFrente();
        while (actuall != null) {
            if (actuall.getDato().getNombreJugador().equals(eliminado)) {
                existente = true;
                break;
            }
            actuall = actuall.getSiguiente();
        }

        if (existente) {
            BITACORA_HISTORICA.desencolar(eliminado);
            ColaDeJugadores.desencolar(eliminado);
            System.out.println("Se ha eliminado a " + eliminado);
            BITACORA_HISTORICA.imprimir();
        } else {
            System.out.println("El Jugador no existe");
        }
    }
}
