package Vista.ModeloTabla;

import Controlador.Grafo.GrafoNoDirigidoEtiquetado;
import Modelo.Posicion;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaAdyacencia extends AbstractTableModel {

    private GrafoNoDirigidoEtiquetado<Posicion> grafo;
    private String[] columnas;
    
    @Override
    public int getRowCount() {
        return grafo.numVertices();
    }

    @Override
    public int getColumnCount() {
        return grafo.numVertices() + 1;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return columnas[rowIndex+1];
        } 
        else {
            try {
                if (grafo.existeArista(rowIndex+1, columnIndex)) {
                    return grafo.pesoArista(rowIndex+1, columnIndex);
                }
                else{
                    return "--";
                }
            } 
            catch (Exception e) {
                System.out.println("Error en ver arista");
            }
        }
        return "";
    }
    
    private String[] generarColumnas(){
        columnas = new String[grafo.numVertices()+1];
        columnas[0] = "--V--";
        for(int i = 1; i < columnas.length; i++){
            columnas[i] = grafo.obtenerEtiqueta(i).toString();
        }
        return columnas;
    }

    public GrafoNoDirigidoEtiquetado<Posicion> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<Posicion> grafo) {
        this.grafo = grafo;
        generarColumnas();
    }

}
