package com.mycompany.main;

public class Chatbot extends Arbolchatbot {

    public Chatbot() {
        cargarPreguntasBasicas();
    }

    public void cargarPreguntasBasicas() {
      
        insertar(new Nodo(1, "Agregar jugadores", "Usa la opcion 1 antes de jugar o 3 durante la partida"));
        insertar(new Nodo(2, "Cambiar configuracion", "Usa 'Opciones del juego' (opcion 2)"));
        insertar(new Nodo(3, "Como ganar", "Llega primero a la posicion final del laberinto"));
        insertar(new Nodo(4, "Como jugar", "Selecciona 'Jugar' (opcion 5) en el menu principal"));
        insertar(new Nodo(5, "Que hacen los premios", "Avanzas posiciones si sacas par en los datos"));
    }

    public void mostrarPreguntas() {
        System.out.println("\n=== PREGUNTAS DISPONIBLES ===");
        mostrarPreguntasRec(getRaiz());
        System.out.println("=============================");
    }

    private void mostrarPreguntasRec(NodoArbol actual) {
        if (actual != null) {
            mostrarPreguntasRec(actual.getIzquierda());
            System.out.printf("%2d: %s\n", 
                actual.getDato().getOrden(),
                actual.getDato().getPregunta());
            mostrarPreguntasRec(actual.getDerecha());
        }
    }

public String buscarRespuesta(String preguntaUsuario) {
   
    if (preguntaUsuario.equalsIgnoreCase("salir")) {
        return null; 
    }

    String preguntaLower = preguntaUsuario.toLowerCase().trim();
    NodoArbol actual = getRaiz();
    String posibleRespuestaExacta = null;
    StringBuilder sugerencias = new StringBuilder();

    
    while (actual != null) {
        String preguntaActual = actual.getDato().getPregunta().toLowerCase();
        int comparacion = preguntaLower.compareTo(preguntaActual);

        
        if (comparacion == 0) {
            return ">> " + actual.getDato().getRespuesta();
        }
        
       
        if (preguntaActual.contains(preguntaLower)) {
            if (preguntaActual.equals(preguntaLower)) {
                posibleRespuestaExacta = actual.getDato().getRespuesta();
            } else {
                sugerencias.append("- ").append(actual.getDato().getPregunta()).append("\n");
            }
        }

        
        if (comparacion < 0) {
            actual = actual.getIzquierda();
        } else {
            actual = actual.getDerecha();
        }
    }

    if (posibleRespuestaExacta != null) {
        return ">> " + posibleRespuestaExacta;
    }

    
    if (sugerencias.length() > 0) {
        return "¿Quizás quisiste decir?\n" + sugerencias.toString();
    }

    
    return "No encontré resultados. Escribe:\n"
         + "- 'mostrar' para ver preguntas\n"
         + "- 'salir' para volver al juego";
}

}