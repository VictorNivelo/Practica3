/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Grafo;

import Controlador.Grafo.Exception.VerticeOfSizeException;

/**
 *
 * @author Victor
 */

public class GrafoNoDirigidoEtiquetado<E> extends GrafoDirigidoEtiquetado<E>{
    
    public GrafoNoDirigidoEtiquetado(Integer numVertices) {
        super(numVertices);
    }
    
    @Override
    public void insertarArista(Integer origen, Integer destino, Double peso) throws Exception {
        if (origen <= numVertices && destino <= numVertices) {
            if (!existeArista(origen, destino)) {
                listaAdyacente[origen].insertar(new Adyacencia(destino, peso));
                listaAdyacente[destino].insertar(new Adyacencia(origen, peso));
            }
            numAristas++;
        } 
        else {
            throw new VerticeOfSizeException();
        }
    }

}
