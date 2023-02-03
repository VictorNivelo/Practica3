/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Grafo;

import Controlador.Grafo.Exception.VerticeOfSizeException;
import Controlador.ListaEnlazada.ListaEnlazada;

/**
 *
 * @author Victor
 */
public class GrafoNoDirigido extends GrafoDirigido{
    
    public GrafoNoDirigido (Integer numV){
        super(numV);
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
