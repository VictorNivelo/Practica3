/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Enum.Orientacion;


/**
 *
 * @author Victor
 */
public class Posicion {
    private Integer local;
    private Double latitud;
    private Double longitud;
    private Orientacion orientacion;

    public Integer getLocal() {
        return local;
    }

    public void setLocal(Integer local) {
        this.local = local;
    }
    
    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }
    
    public void setLongitud(Double longitud) {    
        this.longitud = longitud;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }
    
    @Override
    public String toString() {
        return latitud+ "/"+longitud+"-"+orientacion;
    }
    
    
    
}
