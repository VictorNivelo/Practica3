/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Grafo;

import Controlador.Grafo.Exception.VerticeOfSizeException;
import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.ListaEnlazada.ListaEnlazada;
import java.util.HashMap;

/**
 *
 * @author Victor
 */
public class GrafoDirigidoEtiquetado<E> extends GrafoDirigido{
    protected E etiquetas[];
    protected HashMap<E, Integer> dicVertices;

    public GrafoDirigidoEtiquetado(Integer numVertices){
        super(numVertices);
        etiquetas = (E[]) new Object[numVertices+1];
        dicVertices = new HashMap(numVertices);
    }
    
    public Boolean existeAristaEtiquetada(E origen, E destino)throws Exception{
        return this.existeArista(obtenerCodigoE(origen), obtenerCodigoE(destino));
    }
    
    public Double pesoArista(E origen, E destino){
        return pesoArista(obtenerCodigoE(origen), obtenerCodigoE(destino));
    }
    
    public void insertarAristaEtiquetada(E origen, E destino, Double peso) throws Exception{
        insertarArista(obtenerCodigoE(origen), obtenerCodigoE(destino), peso);
    }
    
    public void insertarAristaEtiquetada(E origen, E destino) throws Exception{
        insertarArista(obtenerCodigoE(origen), obtenerCodigoE(destino));
    }
    
    public ListaEnlazada<Adyacencia> adyacentesE(E origen){
        return adyacentes(obtenerCodigoE(origen));
    }
    
    private Integer obtenerCodigoE(E etiqueta){
        int codigo;
        try{
            codigo=dicVertices.get(etiqueta);
        }
        catch(Exception e){
            codigo = -1;
        }
        return codigo;
    }
    
    public E obtenerEtiqueta(Integer codigo){
        return etiquetas[codigo];
    }
    
    public void etiquetar(Integer codigo, E etiqueta){
        etiquetas[codigo] = etiqueta;
        dicVertices.put(etiqueta, codigo);
    }
    
    public void etiquetarVertice(Integer codigo, E etiqueta) {
        etiquetas[codigo] = etiqueta;
        dicVertices.put(etiqueta, codigo);
    }
    
    public Boolean existeAristaE(E origen, E destino) throws Exception {
        return this.existeArista(obtenerCodigoE(origen), obtenerCodigoE(destino));        
    }
    
    public void insertarAristaE(E origen, E destino, Double peso) throws Exception {
        insertarArista(obtenerCodigoE(origen), obtenerCodigoE(destino), peso);
    }
    
    public void insertarAristaE(E origen, E destino) throws Exception {
        insertarArista(obtenerCodigoE(origen), obtenerCodigoE(destino));
    }
    
    
    @Override
    public String toString() {
        StringBuffer cadenaGrafo = new StringBuffer("");
        try {
            for (int i = 1; i <= numVertices(); i++) {
                cadenaGrafo.append("Vertice ").append(String.valueOf(i)).append(" (").append(obtenerEtiqueta(i)).append(")");
                ListaEnlazada<Adyacencia> lista = adyacentes(i);
                for (int j = 0; j < lista.getSize(); j++) {
                    Adyacencia a = lista.obtener(j);
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        cadenaGrafo.append("-- vertice etiquetado destino: ").append(obtenerEtiqueta(a.getDestino())).append(" -- SP");
                    } 
                    else {
                        cadenaGrafo.append("-- vertice destino: ").append(obtenerEtiqueta(a.getDestino())).append(" -- Peso: ").append(a.getPeso());
                    }
                }
                cadenaGrafo.append("\n");
            }
        } 
        catch (ListaVaciaExcepcion | PosicionNoEncontradaException e) {
            cadenaGrafo.append(e.getMessage());
        }
        return cadenaGrafo.toString();
    }
    
}
