/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pilas.Exceptions;

/**
 *
 * @author Victor
 */
public class PilaVaciaException extends Exception{
    
    public PilaVaciaException(){
        super("La pila esta vacia");
    }
    
    public PilaVaciaException(String msg){
        super(msg);
    }
    
}