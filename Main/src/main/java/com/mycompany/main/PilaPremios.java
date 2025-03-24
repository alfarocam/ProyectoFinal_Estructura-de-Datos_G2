/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 * @author Ian
 * @author CamilaAlfaro 3/2/2025
 */

public class PilaPremios {
   
    NodoPremiosCastigos top; 

    public NodoPremiosCastigos getTop() {
        return top;
    }

    public void setTop(NodoPremiosCastigos top) {
        this.top = top;
    }
    
    public void pila(){
        top = null;
 
    }

    
    public void apilar(String Numero, String premio, int PosicionesMas) {

    DatosPremios miDato = new DatosPremios(Numero, premio, PosicionesMas);
    NodoPremiosCastigos miNodo = new NodoPremiosCastigos(miDato);
    
    if (esVacia()) {
        top = miNodo; 
    } else {                   
        miNodo.setAbajo(top); 
        top = miNodo; 
    }
}

public DatosPremios despilar(){
    if (esVacia()){
        System.out.println("Error: la pila está vacía, no se puede desapilar.");
        return null;
    } else {
        DatosPremios valorTemp = top.getMiDatoPremio();
        top = top.getAbajo();
        return valorTemp;
    }
}


    public boolean esVacia(){
        if (top == null)
            return true; 
        else
            return false;
        }

    public void imprimirPila(){
        if (esVacia()){
        System.out.println("La pila esta vacia");
        
        }
        else{
        NodoPremiosCastigos actual = top; 
        while (actual != null){
            System.out.println("####Premios Restantres####");
            System.out.println("Premio: " + actual.getMiDatoPremio().getPremio());
            System.out.println("Ganas +"+ actual.getMiDatoPremio().getPosicionesMas());

            actual = actual.getAbajo();
            
        }
        
        }
    }
    public String sacarPremio() {
        if (top == null) {
            return "No hay mas premios disponibles."; 
        }
        String premio = top.getMiDatoPremio().getPremio();  
        top = top.getAbajo();      
        return premio;
    }
  
}