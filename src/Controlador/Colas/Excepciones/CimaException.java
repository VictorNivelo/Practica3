/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Colas.Excepciones;

/**
 *
 * @author Victor
 */
public class CimaException extends Exception{
    
    public CimaException(){
       super("La cola esta llena");
    }
    
    public CimaException(String msg){
        super(msg);
    }
}
