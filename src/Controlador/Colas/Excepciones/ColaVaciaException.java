/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Colas.Excepciones;

/**
 *
 * @author Victor
 */
public class ColaVaciaException extends Exception{
    
    public ColaVaciaException(){
        super("La cola esta vacia");
    }
    
    public ColaVaciaException(String msg){
        super(msg);
    }
    
}
