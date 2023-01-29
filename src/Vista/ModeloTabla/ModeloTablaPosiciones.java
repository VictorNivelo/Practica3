/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;

import Modelo.Locales;
import Modelo.Posicion;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaPosiciones extends AbstractTableModel{
    private Locales locales;
    @Override
    public int getRowCount() {
        return locales.getPosicion().getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Nro";
            case 1: return "Latitud";
            case 2: return "Longitud";
            case 3: return "Orientacion";
            default:return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Posicion p = null;
        try {
            p = locales.getPosicion().obtener(rowIndex);
        } 
        catch (Exception e) {
            
        }
        
        switch(columnIndex){
            case 0: return rowIndex+1;
            case 1: return p.getLatitud();
            case 2: return p.getLongitud();
            case 3: return p.getOrientacion().toString();
            default:return null;
        }
    }

    public Locales getLocales() {
        return locales;
    }

    public void setLocales(Locales locales) {
        this.locales = locales;
    }
    
}
