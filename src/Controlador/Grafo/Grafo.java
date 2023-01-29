/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Grafo;

import Controlador.ListaEnlazada.ListaEnlazada;

/**
 *
 * @author Victor
 */
public abstract class Grafo {

    /**
     *
     * @return
     */
    public abstract Integer numVertices();

    public abstract Integer numAristas();

    public abstract Boolean existeArista(Integer origen, Integer destino) throws Exception;

    public abstract Double pesoArista(Integer origen, Integer destino);

    public abstract void insertarArista(Integer origen, Integer destino)throws Exception;

    public abstract void insertarArista(Integer origen, Integer destino, Double peso)throws Exception;

    public abstract ListaEnlazada<Adyacencia> adyacentes(Integer vertice);

    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");
        try {
            for (int i = 1; i <= numVertices(); i++) {
                grafo.append("Vertice " + String.valueOf(i));
                ListaEnlazada<Adyacencia> lista = adyacentes(i);
                for (int j = 0; j < lista.getSize(); j++) {

                    Adyacencia a = lista.obtener(j);
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("-- vertice destino: " + a.getDestino() + " -- SP");
                    } else {
                        grafo.append("-- vertice destino: " + a.getDestino() + " -- Peso: " + a.getPeso());
                    }
                }
                grafo.append("\n");
            }
        } catch (Exception e) {
            grafo.append(e.getMessage());
        }
        return grafo.toString();
    }
    
    public ListaEnlazada caminoMinimo(Integer origen, Integer destino) throws Exception{
        ListaEnlazada camino = new ListaEnlazada();
        if(estaConectado()){
            ListaEnlazada pesos = new ListaEnlazada();
            Boolean finalizar = false;
            Integer inicial = origen;
            camino.insertar(inicial);
            while(!finalizar){
                ListaEnlazada<Adyacencia> adyacencia = adyacentes(inicial);
                Double peso = 10000000.0;
                int T = -1;
                for (int i = 0; i < adyacencia.getSize(); i++){
                    Adyacencia ad = adyacencia.obtener(i);
                    if(!estaEnCamino(camino, destino)){
                        Double pesoArista = ad.getPeso();
                        if(destino.intValue() == ad.getDestino().intValue()){
                            T = ad.getDestino();
                            peso = pesoArista;
                            break;
                        }else if(pesoArista < peso){
                            T = ad.getDestino();
                            peso = pesoArista;
                        }
                    }
                    
                }
                pesos.insertar(peso);
                camino.insertar(T);
                inicial = T;
                if(destino.intValue() == inicial.intValue()){
                    finalizar = true;
                }
            }
        }else{
            throw new Exception("Grafo no conectado");
        }
        return camino;
    }
    
    public Boolean estaConectado(){
        Boolean band = true;
        for(int i = 1; i <= numVertices(); i++){
            ListaEnlazada<Adyacencia> lista = adyacentes(i);
            if(lista.estaVacia() || lista.getSize() == 0){
                band = false;
                break;
            }
        }
        return band;
    }
    
    public Boolean estaEnCamino(ListaEnlazada<Integer> lista, Integer vertice) throws Exception{
        Boolean band = false;
        for(int i = 0; i < lista.getSize(); i++){
            if(lista.obtener(i).intValue() == vertice.intValue()){
                band = true;
                break;
            }
        }
        return band;
    }

}
