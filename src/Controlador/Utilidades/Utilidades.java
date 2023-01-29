/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Utilidades;

import Controlador.Grafo.Grafo;
import Controlador.Grafo.GrafoNoDirigidoEtiquetado;
import Modelo.Posicion;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;

/**
 *
 * @author Victor
 */
public class Utilidades {
    public static Boolean isNumber(Class clase){
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }
    
    public static Boolean isString(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("String");
    }
    
    public static Boolean isCharacter(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }
    
    public static Boolean isBoolean(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }
    
    public static Boolean isDate(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Date");
    }
    
    public static Boolean isPrimitive(Class clase){
        return clase.isPrimitive();
    }
    
    public static Boolean isObject(Class clase){
        return (!isPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase) && !isDate(clase));
    }
    
    public static Field obtenerAtributo(Class clase, String nombre){ //Devuelve que tipo de dato es el atributo enviado
        Field atributo = null;
        for(Field aux : clase.getDeclaredFields()){
            if(nombre.equalsIgnoreCase(aux.getName())){
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
    
    public static Double calcularDistancia(Double y, Double y1, Double x, Double x1){
        Double yy = y - y1;
        Double xx = x - x1;
        return redondear(Math.sqrt((yy*yy)-(xx*xx)));
    }
    
    public static Double redondear(Double dato){
        return Math.round(dato * 100.0)/100.0;
    }
}

