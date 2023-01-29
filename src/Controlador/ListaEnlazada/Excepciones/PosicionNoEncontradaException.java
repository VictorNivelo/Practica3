/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ListaEnlazada.Excepciones;

/**
 *
 * @author Victor
 */
public class PosicionNoEncontradaException extends Exception{
    public PosicionNoEncontradaException(String msg){
        super(msg);
        
    }
    
    public PosicionNoEncontradaException(){
        super("La posición dada está fuera de los límites");
    }
}
