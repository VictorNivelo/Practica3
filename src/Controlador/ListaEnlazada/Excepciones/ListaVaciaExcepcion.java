/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ListaEnlazada.Excepciones;

/**
 *
 * @author Victor
 */
public class ListaVaciaExcepcion extends Exception{
     public ListaVaciaExcepcion(String msg){
        super(msg);
    }
    
    public ListaVaciaExcepcion(){
        super("La lista esta vacia");
    }
}
