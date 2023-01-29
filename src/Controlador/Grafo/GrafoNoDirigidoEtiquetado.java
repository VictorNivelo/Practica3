/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Grafo;

import Controlador.Grafo.Exception.VerticeOfSizeException;

/**
 *
 * @author Victor
 */

public class GrafoNoDirigidoEtiquetado<E> extends GrafoDirigidoEtiquetado<E>{
    
    public GrafoNoDirigidoEtiquetado(Integer numVertices, Class clazz) {
        super(numVertices, clazz);
    }
    
    @Override
    public void insertarArista(Integer origen, Integer destino, Double peso) throws Exception {
        if (origen.intValue() <= numVertices && destino.intValue() <= numVertices) {
            if (!existeArista(origen, destino)) {
                numAristas++;
                listaAdyacente[origen].insertar(new Adyacencia(destino, peso));
                listaAdyacente[destino].insertar(new Adyacencia(origen, peso));
            }
        } 
        else {
            throw new VerticeOfSizeException();
        }
    }

}
