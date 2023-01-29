/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ListaEnlazada;

import Controlador.ListaEnlazada.Excepciones.AtributoException;
import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.Utilidades.Utilidades;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;
    private final Integer ascendente = 1;
    private final Integer descendente = 2;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }
    
    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);

        if (estaVacia()) {
            this.cabecera = nodo;

        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {

        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }

    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                insertarCabecera(dato);
            } else {
                NodoLista<E> nodo = new NodoLista(dato, null);
                NodoLista<E> aux = cabecera;

                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public void modificarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {

                NodoLista<E> aux = cabecera;

                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }

        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public E obtener(Integer pos) throws ListaVaciaExcepcion, PosicionNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }

            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaExcepcion();
        }

    }

    public E eliminar(Integer pos) throws ListaVaciaExcepcion, PosicionNoEncontradaException {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;

                } else {
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }

                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }

            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaExcepcion();
        }

    }

    public E[] toArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public ListaEnlazada<E> ordenarShell(String atributo, Integer tipoOrdenacion) {
        E[] arreglo = toArray();
        Class<E> clazz = null;

        if (size > 0) {
            Integer intervalo, i, j, k;
            Integer n = arreglo.length;
            intervalo = n / 2;
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);

            while (intervalo > 0) {
                for (i = intervalo; i < n; i++) {
                    j = i - intervalo;
                    while (j >= 0) {
                        k = j + intervalo;
                        if (isObject) {

                            try {
                                compararAtributoShell(arreglo, j, k, tipoOrdenacion, atributo, clazz);
                            } catch (Exception e) {
                                System.out.println("error: " + e.getMessage() + "\nLinea:" + e.getStackTrace()[0].getLineNumber() + e.getStackTrace()[0].getClassName());
                            }

                        } else {
                            intercambioDatoShell(arreglo, j, k, tipoOrdenacion);
                        }
                        j -= intervalo;
                    }
                }
                intervalo = intervalo / 2;
            }
        }
        if (arreglo != null) {
            toList(arreglo);
        }
        return this;
    }

    public void intercambioDatoShell(E[] arreglo, Integer j, Integer k, Integer tipoOrdenacion) {
        Class clazz = arreglo[0].getClass();
        Object aux;

        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == descendente) {
                if (((Number) arreglo[j]).doubleValue() > ((Number) arreglo[k]).doubleValue()) {
                    j = -1;
                } else {
                    aux = (Number) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (((Number) arreglo[j]).doubleValue() < ((Number) arreglo[k]).doubleValue()) {
                    j = -1;
                } else {
                    aux = (Number) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
        if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == descendente) {
                if (arreglo[j].toString().toLowerCase().compareTo(arreglo[k].toString().toLowerCase()) > 0) {
                    j = -1;
                } else {
                    aux = (String) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (arreglo[j].toString().toLowerCase().compareTo(arreglo[k].toString().toLowerCase()) < 0) {
                    j = -1;
                } else {
                    aux = (String) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
        if(Utilidades.isDate(clazz)){
            if(tipoOrdenacion == descendente){
                if ( ((Date)arreglo[j]).getYear() > ((Date)arreglo[k]).getYear() ) {
                    j = -1;
                } else {
                    aux = (Date) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                    
                }
            }else{
                if ( ((Date)arreglo[j]).getYear() < ((Date)arreglo[k]).getYear() ) {
                    j = -1;
                } else {
                    aux = (Date) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
        
        
    }

    public void compararAtributoShell(E[] arreglo, Integer j, Integer k, Integer tipoOrdenacion, String atributo, Class clazz) throws Exception {
        E auxJ = arreglo[j];
        E auxK = arreglo[k];
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            Object a = field.get(auxJ);
            Object b = field.get(auxK);

            intercambioObjetoShell(arreglo, a, b, j, k, tipoOrdenacion, atributo);
        }
    }

    public void intercambioObjetoShell(E[] arreglo, Object auxJ, Object auxK, Integer j, Integer k, Integer tipoOrdenacion, String atributo) {
        Class clazz = auxJ.getClass();
        Object aux;
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == descendente) {
                if (((Number) auxJ).doubleValue() > ((Number) auxK).doubleValue()) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (((Number) auxJ).doubleValue() < ((Number) auxK).doubleValue()) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }

        }
        if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == descendente) {
                if (auxJ.toString().toLowerCase().compareTo(auxK.toString().toLowerCase()) > 0) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (auxJ.toString().toLowerCase().compareTo(auxK.toString().toLowerCase()) < 0) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
    }

    public ListaEnlazada<E> busquedaSecuencial(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        if (size > 0) {
            E[] arreglo = toArray();
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            for (int i = 0; i < arreglo.length; i++) {
                if (isObject) {
                    Boolean band = evaluarBusquedaObjeto(arreglo[i], dato, clazz, atributo);
                     if(band){
                         resultado.insertar(arreglo[i]);
                     }
                } else {
                    Boolean encontrado = buscarPosicion(arreglo[i], dato);
                    if (encontrado) {
                        resultado.insertar(arreglo[i]);
                    } else {
                    }
                }
            }

        }
        return resultado;
    }
    
    public Integer busquedaBinaria(String atributo, Object dato) throws Exception {
        Integer posicion = 0;
        E[] arreglo = toArray();
        Boolean isObject = Utilidades.isObject(arreglo[0].getClass());
        Object a;
        Class<E> clazz = (Class<E>) cabecera.getDato().getClass();

        Integer central, bajo, alto;
        Object valorCentral;
        bajo = 0;
        alto = arreglo.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            valorCentral = arreglo[central];
            if (isObject) { //Objetos
                
                Field field = Utilidades.obtenerAtributo(clazz, atributo);
                if (field == null) {
                    throw new AtributoException();
                } else {
                    field.setAccessible(true);
                    a = field.get(valorCentral);
                }
                if (Utilidades.isNumber(a.getClass())) { //Atributo con numeros
                    if (((Number) dato).doubleValue() == ((Number) a).doubleValue()) {
                        return central;
                    } else if (((Number) dato).doubleValue() < ((Number) a).doubleValue()) {
                        alto = central - 1;
                    } else {
                        bajo = central + 1;
                    }
                }
                if (Utilidades.isString(a.getClass())) { //Atributo con cadenas

                    if (dato.toString().toLowerCase().equals(a.toString().toLowerCase())) {
                        return central;
                    } else if (dato.toString().toLowerCase().compareTo(a.toString().toLowerCase()) < 0) {
                        alto = central - 1;
                    } else {
                        bajo = central + 1;
                    }
                }

            } else { //Datos primitivos
                if (Utilidades.isNumber(arreglo[0].getClass())) { //Numeros
                    if (((Number) dato).doubleValue() == ((Number) valorCentral).doubleValue()) {
                        return central;
                    } else if (((Number) dato).doubleValue() < ((Number) valorCentral).doubleValue()) {
                        alto = central - 1;
                    } else {
                        bajo = central + 1;
                    }
                }

            }
        }
        return -1;
    }

    public ListaEnlazada<E> busquedaBinariaSecuencial(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        E[] arreglo = toArray();
        Integer bajo = 0;
        Integer alto = arreglo.length - 1;
        Integer central = (bajo + alto) / 2;
        clazz = (Class<E>) cabecera.getDato().getClass();
        Boolean isObject = Utilidades.isObject(clazz);
        Object valorCentral = arreglo[central];

        if (isObject) {//Objetos
            compararObjetos(resultado, arreglo, bajo, alto, central, clazz, atributo, dato, valorCentral);
        } else {

        }
        return resultado;
    }

    private void compararObjetos(ListaEnlazada<E> resultado, E[] arreglo, Integer bajo, Integer alto, Integer central,
            Class clazz, String atributo, Object dato, Object valorCentral) throws Exception {
        Object a;

        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            a = field.get(valorCentral);
        }

        if (Utilidades.isNumber(a.getClass())) { //Atributos Numeros
            if (((Number) dato).doubleValue() == ((Number) a).doubleValue()) {
                resultado.insertar(arreglo[central]);
            } else if (((Number) dato).doubleValue() < ((Number) a).doubleValue()) {
                alto = central;
                bajo = 0;
            } else {
                alto = arreglo.length - 1;
                bajo = central;
            }
            buscarObjetos(resultado, bajo, alto, arreglo, clazz, atributo, dato);

        }
        if (Utilidades.isString(a.getClass())) { //Atributos Strings
            if (dato.toString().toLowerCase().equals(a.toString().toLowerCase())) {
                resultado.insertar(arreglo[central]);
            } else if (dato.toString().toLowerCase().compareTo(a.toString().toLowerCase()) < 0) {
                alto = central;
                bajo = 0;
            } else {
                alto = arreglo.length - 1;
                bajo = central;
            }
            buscarObjetos(resultado, bajo, alto, arreglo, clazz, atributo, dato);

        }

    }

    private void buscarObjetos(ListaEnlazada<E> resultado, Integer bajo, Integer alto, E[] arreglo, Class clazz, String atributo, Object dato) throws Exception{
        Boolean band;
        for (int aux = bajo; bajo < alto+1; bajo++) {
            band = evaluarBusquedaObjeto(arreglo[bajo], dato, clazz, atributo);
            if (band) {
                resultado.insertar(arreglo[bajo]);
            }
        }
    }

    private Boolean evaluarBusquedaObjeto(E aux, Object dato, Class clazz, String atributo) throws Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            Object a = field.get(aux);
            return buscarPosicion(a, dato);
        }
    }

    private Boolean buscarPosicion(Object datoMatriz, Object busqueda) {
        if (Utilidades.isNumber(busqueda.getClass())) {
            if ((((Number) datoMatriz)).doubleValue() == (((Number) busqueda)).doubleValue()) {
                return true;
            }
        } else if (Utilidades.isString(busqueda.getClass())) {
            if (datoMatriz.toString().toLowerCase().startsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().endsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().equalsIgnoreCase(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                return true;
            }

        }

        return false;
    }

    public float generarNumeroAleatorio() {
        float numAleatorio = 0;
        numAleatorio = (float) (Math.random() * 1000);
        return numAleatorio;
    }

    public void llenarLista(Integer tamanio) {
        Object aux;
        for (int i = 0; i < tamanio; i++) {
            aux = generarNumeroAleatorio();
            insertar((E) aux);
        }
    }

    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
    }

    public void imprimir() {
        System.out.println("-------------------------LISTA ENLAZADA-------------------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.print(aux.getDato().toString() + "\n");
            aux = aux.getSiguiente();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n");
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
