/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Arbol;

import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.ListaEnlazada.ListaEnlazada;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ArbolBinario {

    private NodoArbol raiz;
    private ListaEnlazada<ListaEnlazada<NodoArbol>> niveles;
    private ListaEnlazada<NodoArbol> orden;
    private Integer altura;
    private Integer nro_nodos;

    public ArbolBinario() {
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
                else if (valor < actual.getDato()) {
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
        catch (ListaVaciaExcepcion | PosicionNoEncontradaException e) {
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

    //pre orden
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

    //post orden
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

    //in orden
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
    
    //buscar arbol
    public NodoArbol buscarNodo (int dato){
        NodoArbol auxArbol = raiz;
        while(auxArbol.getDato() != dato){
            if(dato<auxArbol.getDato()){
                auxArbol = auxArbol.getIzquierda();
            }
            else{
                auxArbol = auxArbol.getDerecha();
            }
            if(auxArbol == null){
                return null;
            }
        }
        return auxArbol;
    }
    
    //eliminar arbol
    public boolean eliminar(int dato){
        NodoArbol auxArbol = raiz;
        NodoArbol padre = raiz;
        boolean EsIzquierdo = true;
        while(auxArbol.getDato() != dato){
            padre = auxArbol;
            if(dato < auxArbol.getDato()){
                EsIzquierdo = true;
                auxArbol = auxArbol.getIzquierda();
            }
            else{
                EsIzquierdo = false;
                auxArbol = auxArbol.getDerecha();
            }
            if(auxArbol==null){
                return false;
            }
        }
        if(auxArbol.getIzquierda() == null && auxArbol.getDerecha()==null){
            if(auxArbol == raiz){
                raiz = null;
            }
            else if(EsIzquierdo){
                padre.setIzquierda(null);
            }
            else{
                padre.setDerecha(null);
            }
        }
        else if(auxArbol.getDerecha() == null){
            if(auxArbol==raiz){
                raiz=auxArbol.getIzquierda();
            }
            else if(EsIzquierdo){
                padre.setIzquierda(auxArbol.getIzquierda());
            }
            else{
                padre.setDerecha(auxArbol.getIzquierda());
            }
        }
        else if(auxArbol.getIzquierda() == null){
            if(auxArbol==raiz){
                raiz=auxArbol.getDerecha();
            }
            else if(EsIzquierdo){
                padre.setIzquierda(auxArbol.getDerecha());
            }
            else{
                padre.setDerecha(auxArbol.getIzquierda());
            }
        }
        else{
            NodoArbol remplazo = obtenerNodoRemplazo(auxArbol);
            if(auxArbol==raiz){
                raiz=remplazo;
            }
            else if(EsIzquierdo){
                padre.setIzquierda(remplazo);
            }
            else{
                padre.setDerecha(remplazo);
            }
            remplazo.setIzquierda(auxArbol.getIzquierda());
        }
        return true;
    }
    
    //devolver el remplazo
    public NodoArbol obtenerNodoRemplazo(NodoArbol nodoRemplazo){
        NodoArbol remplazarPadre = nodoRemplazo;
        NodoArbol remplazo = nodoRemplazo;
        NodoArbol auxiliar = nodoRemplazo.getDerecha();
        while(auxiliar!=null){
            remplazarPadre=remplazo;
            remplazo = auxiliar;
            auxiliar = auxiliar.getIzquierda();
        }
        if(remplazo != nodoRemplazo.getDerecha()){
            remplazarPadre.setIzquierda(remplazo.getDerecha());
            remplazo.setDerecha(nodoRemplazo.getDerecha());
        }
        return remplazo;
    }

    public static void main(String[] args) {
        ArbolBinario a = new ArbolBinario();
        
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
//            a.pre_orden().imprimir();
//            a.post_orden().imprimir();
            a.in_orden().imprimir();
//            int buscar = Integer.parseInt(JOptionPane.showInputDialog(null,"Nodo a buscar"));
//            System.out.println("Nodo buscar " + a.buscarNodo(buscar).toString());
            int eliminar = Integer.parseInt(JOptionPane.showInputDialog(null,"Nodo a eliminar"));
            a.eliminar(eliminar);
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
