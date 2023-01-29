/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;

import javax.swing.table.AbstractTableModel;
import Controlador.Arbol.Locales;

/**
 *
 * @author Victor
 */
public class ModeloTablaArbolBinario extends AbstractTableModel {

    private Locales locales;

    @Override
    public int getRowCount() {
        return locales.getNiveles().getSize();
    }

    @Override
    public int getColumnCount() {
        return locales.getNro_nodos();
    }

    @Override
    public String getColumnName(int column) {
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return locales.getNiveles().obtener(0).obtener(0).getDato().toString();
//            for (int i = 0; i < arbol.getNiveles().obtener(i).getSize(); i++) {
//                ListaEnlazada<NodoArbol> aux = arbol.getNiveles().obtener(i);
//                aux.imprimir();
//                for(int j = 0; j < aux.getSize(); j++){
//                    NodoArbol nodo = aux.obtener(j);
//                    setValueAt(nodo.getDato().toString(), rowIndex/2, columnIndex);
//                }
//            }
        } 
        catch (Exception e) {
//            System.out.println(e);
//            System.out.println(e.getStackTrace()[0].getLineNumber()+" "+e.getStackTrace()[0].getClassName());
        }
        return "";
    }

    public Locales getLocales() {
        return locales;
    }

    public void setLocales(Locales locales) {
        this.locales = locales;
    }
    
}
