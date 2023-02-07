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
    private String distancia;
    
    private ListaEnlazada<Posicion> posicion;
    

    public Locales(Integer id, String nombreLocal, String descripcion, String distancia) {
        this.id = id;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.distancia = distancia;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
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
        return "id=" + id + ", nombreLocal=" + nombreLocal + ", descripcion=" + descripcion + ", distancia=" + distancia;
    }
  
}
