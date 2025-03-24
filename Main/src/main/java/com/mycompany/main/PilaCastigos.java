/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 * @author Ian
 * @author CamilaAlfaro 2/26/2025
 */
public class PilaCastigos{
   
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

    
    public void apilar(String Numero, String castigo, int PosicionesMenos) {

    DatosCastigos miDato = new DatosCastigos(Numero, castigo, PosicionesMenos);
    NodoPremiosCastigos miNodo = new NodoPremiosCastigos(miDato);
    
    if (esVacia()) {
        top = miNodo; 
    } else {                   
        miNodo.setAbajo(top); 
        top = miNodo; 
    }
}

public DatosCastigos despilar(){
    if (esVacia()){
        System.out.println("Error: la pila está vacía, no se puede desapilar.");
        return null;
    } else {
        DatosCastigos valorTemp = top.getMiDatoCastigo();
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
            System.out.println("####Castigos Restantres####");
            System.out.println("Castigo: " + actual.getMiDatoCastigo().getCastigo());
            System.out.println("Pierdes -"+ actual.getMiDatoCastigo().getPosicionesMenos());

            actual = actual.getAbajo();
            
        }
        
        }
    }
        public String sacarCastigo() {
        if (top == null) {
            return "No hay mas premios disponibles."; 
        }
        String Castigo = top.getMiDatoCastigo().getCastigo();
        top = top.getAbajo();      
        return Castigo;
    }
  
}
