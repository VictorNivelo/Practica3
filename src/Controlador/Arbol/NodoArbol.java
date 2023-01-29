/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Arbol;

/**
 *
 * @author Victor
 */
public class NodoArbol {
    private NodoArbol padre;
    private NodoArbol izquierda;
    private NodoArbol derecha;
    private Integer dato;

    public NodoArbol(Integer dato) {
        this.dato = dato;
        padre = null;
        izquierda = null;
        derecha = null;
    }
    
    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
    
}
