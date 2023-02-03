/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.Locales;

/**
 *
 * @author Victor
 */
public class LocalController {
    
    private ListaEnlazada<Locales> locales = new ListaEnlazada<>();

    public ListaEnlazada<Locales> getLocales() {
        return locales;
    }

    public void setLocales(ListaEnlazada<Locales> locales) {
        this.locales = locales;
    }

}
