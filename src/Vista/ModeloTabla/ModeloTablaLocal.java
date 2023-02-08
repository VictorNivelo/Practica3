/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;


import Controlador.ListaEnlazada.ListaEnlazada;
import Controlador.LocalController;
import Modelo.Locales;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Victor
 */
public class ModeloTablaLocal extends AbstractTableModel{
    private LocalController locales;
    
    @Override
    public int getRowCount() {
        return locales.getLocales().getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre Local";
            case 2: return "Descripcion";
            default:return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Locales local = null;
        try {
            local = locales.getLocales().obtener(rowIndex);
        } 
        catch (Exception e) {
            
        }
        
        switch(columnIndex){
            case 0: return rowIndex+1;
            case 1: return local.getNombreLocal();
            case 2: return local.getDescripcion();
            default:return null;
        }
    }

    public LocalController getArboles() {
        return locales;
    }

    public void setArboles(LocalController arboles) {
        this.locales = arboles;
    }
}
