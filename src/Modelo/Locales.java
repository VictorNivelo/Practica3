/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ListaEnlazada.ListaEnlazada;

/**
 * @author Victor
 */
public class Locales {
    
    private Integer id;

    private String nombreLocal;
    private String descripcion;
    
    private ListaEnlazada<Posicion> posicion;
    
    private String latitud;
    private String longitud;
    private String Orientacion;

    public Locales(Integer id, String nombreLocal, String descripcion, String latitud, String longitud, String Orientacion) {
        this.id = id;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.Orientacion = Orientacion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getOrientacion() {
        return Orientacion;
    }

    public void setOrientacion(String Orientacion) {
        this.Orientacion = Orientacion;
    } 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ListaEnlazada<Posicion> getPosicion() {
        return posicion;
    }

    public void setPosicion(ListaEnlazada<Posicion> posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nombreLocal=" + nombreLocal + ", descripcion=" + descripcion + ", posicion=" + posicion;
    }
  
}
