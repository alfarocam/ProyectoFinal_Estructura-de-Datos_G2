/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class Arbolchatbot {
    private NodoArbol raiz;

    public Arbolchatbot() {
        raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public void insertar(Nodo dato) {
        raiz = insertarRec(raiz, dato);
    }

    NodoArbol insertarRec(NodoArbol nodoActual, Nodo valor) {
        if (nodoActual == null) {
            return new NodoArbol(valor);
        } else {
            if (valor.getOrden() < nodoActual.getDato().getOrden()) {
                nodoActual.setIzquierda(insertarRec(nodoActual.getIzquierda(), valor));
            } else if (valor.getOrden() > nodoActual.getDato().getOrden()) {
                nodoActual.setDerecha(insertarRec(nodoActual.getDerecha(), valor));
            }
        }
        return nodoActual;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoArbol actual) {
        if (actual != null) {
            inOrdenRec(actual.getIzquierda());
            System.out.println("Orden: " + actual.getDato().getOrden() + " - " + actual.getDato().getDescripcion());
            inOrdenRec(actual.getDerecha());
        }
    }

    public void preOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(NodoArbol actual) {
        if (actual != null) {
            System.out.println("Orden: " + actual.getDato().getOrden() + " - " + actual.getDato().getDescripcion());
            preOrdenRec(actual.getIzquierda());
            preOrdenRec(actual.getDerecha());
        }
    }

    public void postOrden() {
        postOrdenRec(raiz);
    }

    private void postOrdenRec(NodoArbol actual) {
        if (actual != null) {
            postOrdenRec(actual.getIzquierda());
            postOrdenRec(actual.getDerecha());
            System.out.println("Orden: " + actual.getDato().getOrden() + " - " + actual.getDato().getDescripcion());
        }
    }

    public void eliminar(Nodo valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private NodoArbol eliminarRec(NodoArbol actual, Nodo valor) {
        if (actual == null) return actual;

        if (valor.getOrden() < actual.getDato().getOrden()) {
            actual.setIzquierda(eliminarRec(actual.getIzquierda(), valor));
        } else if (valor.getOrden() > actual.getDato().getOrden()) {
            actual.setDerecha(eliminarRec(actual.getDerecha(), valor));
        } else {
            if (actual.getIzquierda() == null && actual.getDerecha() == null) {
                return null;
            }
            if (actual.getIzquierda() == null)
                return actual.getDerecha();
            else if (actual.getDerecha() == null)
                return actual.getIzquierda();

            NodoArbol sucesor = minValorSucesor(actual.getDerecha());
            actual.setDato(sucesor.getDato());
            actual.setDerecha(eliminarRec(actual.getDerecha(), sucesor.getDato()));
        }
        return actual;
    }

    private NodoArbol minValorSucesor(NodoArbol nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }

    public int obtenerNivel(Nodo valor, int nivel) {
        return obtenerNivelRec(raiz, valor, nivel);
    }

    public int obtenerNivelRec(NodoArbol actual, Nodo valor, int nivel) {
        if (actual == null) return -1;
        if (actual.getDato().getOrden() == valor.getOrden()) return nivel;
        int nivelIzq = obtenerNivelRec(actual.getIzquierda(), valor, nivel + 1);
        if (nivelIzq != -1) return nivelIzq;
        return obtenerNivelRec(actual.getDerecha(), valor, nivel + 1);
    }

    public int obtenerAltura(NodoArbol actual) {
        if (actual == null) return -1;
        int alturaIzq = obtenerAltura(actual.getIzquierda());
        int alturaDer = obtenerAltura(actual.getDerecha());
        return Math.max(alturaIzq, alturaDer) + 1;
    }
}