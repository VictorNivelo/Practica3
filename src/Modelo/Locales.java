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
    private String nombre;
    private String nombreLocal;
    private String descripcion;
    private ListaEnlazada<Posicion> posicion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Nombre=" + nombre + ", nombreLocal=" + nombreLocal + ", descripcion=" + descripcion + ", posicion=" + posicion;
    }
  
}
