/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.Locales;

/**
 *
 * @author Victor
 */
public class ArbolController {
    private ListaEnlazada<Locales> arboles = new ListaEnlazada<>();

    public ListaEnlazada<Locales> getArboles() {
        return arboles;
    }

    public void setArboles(ListaEnlazada<Locales> arboles) {
        this.arboles = arboles;
    }

}
