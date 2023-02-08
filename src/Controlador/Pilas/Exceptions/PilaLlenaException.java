/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pilas.Exceptions;

/**
 *
 * @author Victor
 */
public class PilaLlenaException extends Exception{
    
    public PilaLlenaException(){
       super("La pila esta llena");
    }
    
    public PilaLlenaException(String msg){
        super(msg);
    }
}