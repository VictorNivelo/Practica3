/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Grafo.GrafoNoDirigidoEtiquetado;
import Controlador.ListaEnlazada.ListaEnlazada;
import Controlador.Utilidades.Utilidades;
import Modelo.Locales;
import Modelo.Posicion;

/**
 *
 * @author Victor
 */
public class PosicionController {

    private Posicion posicion;
    private Locales arbol;
    private GrafoNoDirigidoEtiquetado<Posicion> grafo;
    private ListaEnlazada<Posicion> posiciones = new ListaEnlazada<>();

    public void crearGrafoLista() {
        grafo = new GrafoNoDirigidoEtiquetado<>(posiciones.getSize(), Posicion.class);
        for (int i = 1; i <= posiciones.getSize(); i++) {
            try {
                grafo.etiquetar(i, posiciones.obtener(i - 1));

            } 
            catch (Exception e) {
            }
        }
    }
    
    public Posicion getPosicion() {
        if (posicion == null) {
            posicion = new Posicion();
        }
        return posicion;
    }
    
    public Double calcularDistancia(Integer o, Integer d)throws Exception{
        Posicion origen = getGrafo().obtenerEtiqueta(o);
        Posicion destino = getGrafo().obtenerEtiqueta(d);
//        Double y = origen.getLatitud() - destino.getLatitud();
//        Double x = origen.getLongitud() - destino.getLongitud();
        return Utilidades.calcularDistancia
        (origen.getLatitud(), destino.getLatitud(), origen.getLongitud(), destino.getLongitud());
    }

    public Locales getArbol() {
        return arbol;
    }

    public void setArbol(Locales arbol) {
        this.arbol = arbol;
    }

    public GrafoNoDirigidoEtiquetado<Posicion> getGrafo() {
//        if (grafo != null){
//            crearGrafoLista();
//        }
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<Posicion> grafo) {
        this.grafo = grafo;
    }

    public ListaEnlazada<Posicion> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ListaEnlazada<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

}
