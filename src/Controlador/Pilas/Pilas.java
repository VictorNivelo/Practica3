/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pilas;

import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.ListaEnlazada.ListaEnlazada;
import Controlador.Pilas.Exceptions.PilaLlenaException;
import Controlador.Pilas.Exceptions.PilaVaciaException;
import java.util.Objects;

/**
 *
 * @author Victor
 */
public class Pilas<E> extends ListaEnlazada<E> {
    private Integer Limite;

    public Pilas() {
    }

    public Pilas(Integer tope) {
        this.Limite = tope;
    }
    
    public Boolean estaLleno(){
        return Objects.equals(Limite, getSize());
    }
    
    public void push(E dato) throws PilaLlenaException{
        if(!estaLleno()){
            insertarCabecera(dato);
        } else throw new PilaLlenaException();
    }
    
    public E pop() throws PilaVaciaException, ListaVaciaExcepcion, PosicionNoEncontradaException{
        if (!estaVacia()){
            E dato = eliminar(0);
            
            return dato;
        } else throw new PilaVaciaException();
    }
    
}  

