package com.mycompany.main;


public class Nodo {

    private int dato;
    private Nodo siguiente;
    

    private String descripcion;
    private int orden;
    private String pregunta;
    private String respuesta;


    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

  
    public Nodo(int orden, String descripcion) {
        this.orden = orden;
        this.descripcion = descripcion;
    }

    // Constructor especializado para chatbot
    public Nodo(int orden, String pregunta, String respuesta) {
        this.orden = orden;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.descripcion = respuesta; 
    }

    
    public int getDato() { return dato; }
    public Nodo getSiguiente() { return siguiente; }
    public void setDato(int dato) { this.dato = dato; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }
    
    // Métodos específicos para chatbot
    public String getPregunta() { return pregunta; }
    public String getRespuesta() { return respuesta != null ? respuesta : descripcion; }
    
    public boolean coincideCon(String consulta) {
        if (consulta == null) return false;
        consulta = consulta.toLowerCase();
        return (pregunta != null && pregunta.toLowerCase().contains(consulta)) ||
               (respuesta != null && respuesta.toLowerCase().contains(consulta)) ||
               (descripcion != null && descripcion.toLowerCase().contains(consulta));
    }
}