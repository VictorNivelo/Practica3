/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.Grafo.Adyacencia;
import Controlador.Grafo.Grafo;
import Controlador.Grafo.GrafoDirigidoEtiquetado;
import Controlador.ListaEnlazada.ListaEnlazada;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.orthogonal.mxOrthogonalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.view.mxGraph;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JScrollPane;

/**
 *
 * @author sebastian
 */
public class FrmGrafo extends javax.swing.JDialog {
    private Grafo grafo;
    /**
     * Creates new form FrmGrafo
     */
    public FrmGrafo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public FrmGrafo(java.awt.Frame parent, boolean modal, Grafo grafo, Integer estado) {
        super(parent, modal);
        this.grafo= grafo;
        initComponents();
        cargaDatos(estado);
    }
    
    private void cargaDatos(Integer estado) {
        mxGraph graph = new mxGraph();
        //jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setSize(new Dimension(552, 410));
        
        //jScrollPane1 = new javax.swing.JScrollPane();
       // jPanel1.setSize(new Dimension(800, 800));
       // jPanel1.add(graphComponent, BorderLayout.CENTER);
        //jScrollPane1.setViewportView(jPanel1);
        //jScrollPane1.setBounds(0, 0, 400, 300);
        getContentPane().add(graphComponent);
        

        ListaEnlazada<Object> pintados = new ListaEnlazada();
        Object parent = graph.getDefaultParent();
        try {
            for(int i = 1; i <= grafo.numVertices(); i++ ) {
                
                Object start = null;
                if (estado == 0)
                        start = graph.insertVertex(parent, String.valueOf(i), String.valueOf(i), 100, 100,80,30);
                else {
                    GrafoDirigidoEtiquetado ge = (GrafoDirigidoEtiquetado) grafo;
                    start = graph.insertVertex(parent, ge.obtenerEtiqueta(i).toString(), ge.obtenerEtiqueta(i).toString(), 100, 100,80,30);
                }
                    
                pintados.insertar(start);
                //insertar(i, start, pintados);
                
                
            }
            for(int i = 0; i <= pintados.getSize(); i++ ) {                               
                ListaEnlazada<Adyacencia> lista = grafo.adyacentes(i+1);
                Object start = pintados.obtener(i);
                for(int j = 0; j < lista.getSize();j++) {
                    Adyacencia a = lista.obtener(j);
                    Object dest = pintados.obtener(a.getDestino() - 1);
                    
                    graph.insertEdge(parent, null, String.valueOf(a.getPeso()), start, dest);
                }
                //insertar(i, start, pintados);
                
                
            }
            
        } catch (Exception e) {
            
        } finally {
            graph.getModel().endUpdate();
        }
        morphGraph(graph, graphComponent);
        new mxCircleLayout(graph).execute(graph.getDefaultParent());
        //new mxCircleLayout(graph).execute(graph.getDefaultParent());
        //new mxHierarchicalLayout(graph).execute(graph.getDefaultParent());
    }
    
    
    
    private void insertar(Integer id, Object obj, ListaEnlazada lista) {
        Object o = null;
        try {
            o = lista.obtener((id - 1));            
        } catch (Exception e) {
            lista.insertar(o);
        }
    }
    
    private static void morphGraph(mxGraph graph, mxGraphComponent graphComponent) {
        mxIGraphLayout layout = new mxFastOrganicLayout(graph);
        
        graph.getModel().beginUpdate();
        try {
            layout.execute(graph.getDefaultParent());
        } catch (Exception e) {
            
        } finally{
            mxMorphing morph = new mxMorphing(graphComponent, 20, 1.5, 20);
            morph.addListener(mxEvent.DONE, new mxEventSource.mxIEventListener() {
                @Override
                public void invoke(Object o, mxEventObject eo) {
                    graph.getModel().endUpdate();
                }
            });
            morph.startAnimation();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        setSize(new java.awt.Dimension(562, 424));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmGrafo dialog = new FrmGrafo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
