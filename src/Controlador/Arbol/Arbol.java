/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Arbol;

import Controlador.ListaEnlazada.ListaEnlazada;
import Vista.frmPrincipal;

/**
 *
 * @author Victor
 */
public class Arbol {

    private NodoArbol raiz;
    private ListaEnlazada<ListaEnlazada<NodoArbol>> niveles;
    private ListaEnlazada<NodoArbol> orden;
    private Integer altura;
    private Integer nro_nodos;

    public Arbol() {
        raiz = null;
        altura = 0;
        nro_nodos = 0;
        niveles = new ListaEnlazada<>();
        orden = new ListaEnlazada<>();
    }

    public Boolean insertar(Integer valor) throws Exception {
        if (raiz == null) {
            raiz = new NodoArbol(valor);
            nro_nodos++;
            nivel();
            return true;
        } 
        else {
            NodoArbol nuevo = new NodoArbol(valor);
            NodoArbol actual = raiz;
            NodoArbol padre;
            while (true) {
                padre = actual;
                if (valor.intValue() == actual.getDato()) {
                    return false;
                } 
                else if (valor.intValue() < actual.getDato()) {
                    actual = actual.getIzquierda();
                    if (actual == null) {
                        nuevo.setPadre(padre);
                        padre.setIzquierda(nuevo);
                        nro_nodos++;
                        nivel();
                        return true;
                    }
                } 
                else {
                    actual = actual.getDerecha();
                    if (actual == null) {
                        nuevo.setPadre(padre);
                        padre.setDerecha(nuevo);
                        nro_nodos++;
                        nivel();
                        return true;
                    }
                }
            }
        }
    }
    
    private void calcularNivel(NodoArbol arbol, Integer nivel) throws Exception {
        if (arbol != null) {
            niveles.obtener(nivel).insertar(arbol);
            nivel++;
            calcularNivel(arbol.getIzquierda(), nivel);
            calcularNivel(arbol.getDerecha(), nivel);
        } 
        else if (nivel.intValue() != getAltura()) {
            niveles.obtener(nivel).insertar(null);
            nivel++;
            calcularNivel(null, nivel);
            calcularNivel(null, nivel);
        } 
        else {

        }
    }
    
    private void nivel() throws Exception {
        niveles = new ListaEnlazada<>();
        this.altura = calcularAltura(raiz);
        for (int i = 0; i <= altura; i++) {
            niveles.insertar(new ListaEnlazada<>());
        }
        calcularNivel(raiz, 0);
        try {
            niveles.eliminar(niveles.getSize() - 1);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private Integer calcularAltura(NodoArbol arbol) throws Exception {
        if (arbol == null) {
            return 0;
        } 
        else {
            Integer izquierda = calcularAltura(arbol.getIzquierda());
            Integer derecha = calcularAltura(arbol.getDerecha());
            if (izquierda > derecha) {
                return izquierda + 1;
            } 
            else {
                return derecha + 1;
            }
        }
    }

    public ListaEnlazada<NodoArbol> pre_orden() throws Exception {
        orden = new ListaEnlazada<>();
        pre_orden(raiz);
        return orden;
    }

    private void pre_orden(NodoArbol arbol) throws Exception {
        if (arbol != null) {
            orden.insertar(arbol);
            pre_orden(arbol.getIzquierda());
            pre_orden(arbol.getDerecha());
        }
    }

    public ListaEnlazada<NodoArbol> post_orden() throws Exception {
        orden = new ListaEnlazada<>();
        post_orden(raiz);
        return orden;
    }

    private void post_orden(NodoArbol arbol) throws Exception {
        if (arbol != null) {
            post_orden(arbol.getIzquierda());
            post_orden(arbol.getDerecha());
            orden.insertar(arbol);
        }
    }

    public ListaEnlazada<NodoArbol> in_orden() throws Exception {
        orden = new ListaEnlazada<>();
        in_orden(raiz);
        return orden;
    }

    private void in_orden(NodoArbol arbol) throws Exception {
        if (arbol != null) {
            in_orden(arbol.getIzquierda());
            orden.insertar(arbol);
            in_orden(arbol.getDerecha());
        }
    }

    public static void main(String[] args) {
        Arbol a = new Arbol();
        
        try {
            a.insertar(56);
            a.insertar(34);
            a.insertar(78);
            a.insertar(24);
            a.insertar(35);
            a.insertar(60);
            a.insertar(90);
            a.insertar(1);
            System.out.println("Nro de nodos: " + a.getNro_nodos());
            System.out.println("Altura: " + a.getAltura());
            System.out.println("Niveles: "+a.getNiveles().getSize());
//            new frmPrincipal(a).setVisible(true);
//            a.getNiveles().obtener(1).imprimir();
            a.pre_orden().imprimir();
            a.post_orden().imprimir();
            a.in_orden().imprimir();
        } 
        catch (Exception e) {
        }
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public ListaEnlazada<ListaEnlazada<NodoArbol>> getNiveles() {
        return niveles;
    }

    public void setNiveles(ListaEnlazada<ListaEnlazada<NodoArbol>> niveles) {
        this.niveles = niveles;
    }

    public ListaEnlazada<NodoArbol> getOrden() {
        return orden;
    }

    public void setOrden(ListaEnlazada<NodoArbol> orden) {
        this.orden = orden;
    }

    public Integer getAltura() throws Exception {
//        altura = calcularAltura(raiz);
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getNro_nodos() {
        return nro_nodos;
    }

    public void setNro_nodos(Integer nro_nodos) {
        this.nro_nodos = nro_nodos;
    }

}
