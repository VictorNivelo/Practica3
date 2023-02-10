/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Grafo;

import Controlador.Colas.Colas;
import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.ListaEnlazada.ListaEnlazada;
import Controlador.Pilas.Pilas;
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
        
        StringBuffer cadenaGrafo = new StringBuffer("");
        
        try {
            for (int i = 1; i <= numVertices(); i++) {
                
                cadenaGrafo.append("Vertice ").append(String.valueOf(i));
                ListaEnlazada<Adyacencia> lista = adyacentes(i);
                
                for (int j = 0; j < lista.getSize(); j++) {

                    Adyacencia a = lista.obtener(j);
                    
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(0))) {
                        cadenaGrafo.append("-- vertice destino: ").append(a.getDestino()).append(" -- SP");
                    } 
                    else {
                        cadenaGrafo.append("-- vertice destino: ").append(a.getDestino()).append(" -- Peso: ").append(a.getPeso());
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
                        }
                        else if(pesoArista < peso){
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
        }
        else{
            throw new Exception("Grafo no conectado");
        }
        return camino;
    }
    
    public Boolean estaConectado(){
        
        Boolean Marcador = true;
        
        for(int i = 1; i <= numVertices(); i++){
            ListaEnlazada<Adyacencia> lista = adyacentes(i);
            
            if(lista.estaVacia() || lista.getSize() == 0){
                Marcador = false;
                break;
            }
        }
        return Marcador;
    }
    
    public Boolean estaEnCamino(ListaEnlazada<Integer> lista, Integer vertice) throws Exception{
        
        Boolean Marcador = false;
        
        for(int i = 0; i < lista.getSize(); i++){
            if(lista.obtener(i).intValue() == vertice.intValue()){
                Marcador = true;
                break;
            }
        }
        return Marcador;
    }
    
    public ListaEnlazada ConvertirALista(Object[] matriz) {
        
        ListaEnlazada lista = new ListaEnlazada();
        lista.vaciar();
        
        for (Object matriz1 : matriz) {
            lista.insertar(matriz1);
        }
        return lista;
    }
    
    private Integer[][] matrizAdyacencia(Grafo grafo) throws Exception {
        
        Integer vertices = grafo.numVertices();
        Integer[][] matriz = new Integer[vertices][vertices];
        
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                Double peso = grafo.pesoArista(i + 1, j + 1);
                if(peso != 0){
                    matriz[i][j] = 1;
                }
                else{
                    matriz[i][j] = 0;
                }
            }
        }
        return matriz;
    }
    
    private Integer IndicardorMenor(Integer NumeroV, Boolean[] ValidadorBandera, Double[] DistanciaRecorrida) {
        
        Double maximo = 1000000000.0;
        Integer v = 1;
        
        for (int i = 0; i < NumeroV; i++) {
            if (!ValidadorBandera[i] && (DistanciaRecorrida[i] <= maximo)) {
                maximo = DistanciaRecorrida[i];
                v = i;
            }
        }
        return v;
    }
    
    private Double[][] CalcularPesoGrafo(Grafo grafo) throws Exception {
        
        Integer vertices = grafo.numVertices();
        Double[][] matriz = new Double[vertices][vertices];
        
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                Double peso = grafo.pesoArista(i, j );
                if(peso != 0){
                    matriz[i][j] = peso;
                }
                else{
                    matriz[i][j] = 10000000.0;
                }
            }
        }
        return matriz;
    }
    
    public ListaEnlazada Dijkstra(Integer origen) throws Exception {
        
        origen = origen -1;
        ListaEnlazada ListaCaminosDijkstra = new ListaEnlazada();
        Integer inicio = origen;
        Integer NumeroDeVertices = this.numVertices();
        
        Double[] AuxiliarDouble = new Double[NumeroDeVertices];
        Boolean[] Marca = new Boolean[NumeroDeVertices];
        Integer[] Ultimo = new Integer[NumeroDeVertices];
        Double[][] MatrizPesos = CalcularPesoGrafo(this);
        
        for (int i = 0; i < NumeroDeVertices; i++) {
            AuxiliarDouble[i] = MatrizPesos[inicio][i];
            Ultimo[i] = inicio;
            Marca[i] = false;
        }
        
        Marca[inicio] = true;
        AuxiliarDouble[inicio] = 0.0;

        for (int i = 0; i < NumeroDeVertices; i++) {
            Integer verticesN = IndicardorMenor(NumeroDeVertices, Marca, AuxiliarDouble);
            Marca[verticesN] = true;
            
            for (int j = 0; j < NumeroDeVertices; j++) {
                if (!Marca[j] && ((AuxiliarDouble[verticesN] + MatrizPesos[verticesN][j]) < AuxiliarDouble[j])) {
                    AuxiliarDouble[j] = AuxiliarDouble[verticesN] + MatrizPesos[verticesN][j];
                    Ultimo[j] = verticesN;
                }
            }
            ListaCaminosDijkstra.insertar(AuxiliarDouble[i]);
        }
        return ListaCaminosDijkstra;
    }

    public void Floyd() throws Exception {
        
        ListaEnlazada ListaFloyd = new ListaEnlazada();
        
        Double[][] Pesos = CalcularPesoGrafo(this);
        Integer NumeroVertices = this.numVertices();
        Integer[][] TrazarRuta = new Integer[NumeroVertices][NumeroVertices];
        Double[][] AuxiliarDouble = new Double[NumeroVertices][NumeroVertices];

        for (int i = 0; i < NumeroVertices; i++) {
            for (int j = 0; j < NumeroVertices; j++) {
                AuxiliarDouble[i][j] = Pesos[i][j];
                TrazarRuta[i][j] = -1;
            }
        }
        
        for (int i = 0; i < NumeroVertices; i++) {
            AuxiliarDouble[i][i] = 1.0;
        }
        
        for (int k = 0; k < NumeroVertices; k++) {
            for (int i = 0; i < NumeroVertices; i++) {
                for (int j = 0; j < NumeroVertices; j++) {
                    if ((AuxiliarDouble[i][k] + AuxiliarDouble[k][j]) < AuxiliarDouble[i][j]) {
                        AuxiliarDouble[i][j] = AuxiliarDouble[i][k] + AuxiliarDouble[k][j];
                        TrazarRuta[i][j] = k;
                    }
                }
            }
        }
        
        //imprimir la secuencia de la matriz
        System.out.println("---------------------------- Matriz Adyacencia ----------------------------");
        for(int i = 1; i <=NumeroVertices; i++){
            System.out.print("\t"+i);
        }
        System.out.print("\n");
//        System.out.println("\t1\t2\t3\t4\t5");
        
        for(int i = 0; i < NumeroVertices; i++){
            System.out.print(i+1+"\t");
            for(int j = 0; j < NumeroVertices; j++){
                System.out.print(AuxiliarDouble[i][j]+"\t");
            }
            System.out.println("\n");
        }
        System.out.println("----------------------------------------------------------------------------");
    }
    
    public ListaEnlazada BPP(Integer nodo) throws Exception{
        
        nodo = nodo -1;
        Integer NumeroVertices = this.numVertices();
        ListaEnlazada Recorrido = new ListaEnlazada();
        Boolean[] Visitados = new Boolean[NumeroVertices];
        Integer[][] matrizAd = matrizAdyacencia(this);
        
        for(int i = 0; i < matrizAd.length; i++){
            Visitados[i] = false;
        }
        
        Visitados[nodo] = true;
        Pilas pila = new Pilas();
        pila.push(nodo);
        
        while (!pila.estaVacia()) {
            Integer j = (Integer) pila.pop();
            Recorrido.insertar(j+1);
            ListaEnlazada<Adyacencia> lista = adyacentes(j+1);
            
            for(int i = 0; i < lista.getSize(); i++){
                Adyacencia ck = lista.obtener(i);
                Integer k = ck.getDestino()-1;
                if(!Visitados[k]){
                    pila.push(k);
                    Visitados[k] = true;
                }
            }
        }
        
        return Recorrido;
    }
    
    public ListaEnlazada BPA(Integer nodo) throws Exception{
        
        nodo = nodo -1;
        Integer NumeroVertices = this.numVertices();
        ListaEnlazada recorrido = new ListaEnlazada();
        Boolean[] Visitado = new Boolean[NumeroVertices];
        Integer[][] MatrizA = matrizAdyacencia(this);
        
        for(int i = 0; i < MatrizA.length; i++){
            Visitado[i] = false;
        }
        
        Visitado[nodo] = true;
        Colas cola = new Colas(this.numVertices());
        recorrido.insertar(nodo+1);
        cola.insertar(nodo);
        
        while(!cola.estaVacia()){
            Integer j = (Integer) cola.dequeue();
            for(int i = 0; i < MatrizA.length; i++){
                if((MatrizA[j][i] == 1) && (!Visitado[i])){
                    
                    cola.queue(i);
                    recorrido.insertar(i+1);
                    Visitado[i] = true;
                }
            }
        }
        return recorrido;
    }
    
}
