/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

/**
 *
 * @author DE LA CRUZ VILLANUEV
 */
public class PerroFrame extends javax.swing.JFrame {

    /**
     * Creates new form PerroFrame
     */
    
    crearEscenaGraficaPerro creaEscena;
    int contador = 0;
    HiloCaminata hilo;
    HiloSentar hiloSentar;
    public PerroFrame() {
        initComponents();
        GraphicsConfiguration config =SimpleUniverse.getPreferredConfiguration();
        Canvas3D lienzo=new Canvas3D(config);
        lienzo.setBounds(20, 20, 580, 500);
        this.setTitle("Perro globo graficación 2022");
        this.add(lienzo);
        this.setBounds(250, 50, 800, 600);
        setLocationRelativeTo(null);
        BranchGroup Scene=new BranchGroup();
        creaEscena= new crearEscenaGraficaPerro();
        Scene=creaEscena.objRaiz;
        SimpleUniverse n=new SimpleUniverse(lienzo);
        n.getViewingPlatform().setNominalViewingTransform();
        n.addBranchGraph(Scene);
        hilo = new HiloCaminata(creaEscena);
        hiloSentar = new HiloSentar(creaEscena);
        lienzo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'a':
                        creaEscena.girar(creaEscena.panza.tgCapsula, 8, "x");
                        break;
                    case 'd':
                        creaEscena.girar(creaEscena.panza.tgCapsula, -8, "x");
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'c':

                        if (hilo.c == true) {
                            hilo.c = false;
                            hilo= new HiloCaminata(creaEscena);
                        } else {

                            hilo.start();
                            hilo.c = true;
                        }
                        break;
                        
                    case '1':
                        if(hiloSentar.c == true)
                    {
                        hiloSentar.c=false;
                        hiloSentar=new HiloSentar(creaEscena);
                    } else {
                        hiloSentar.start();
                        hiloSentar.c=true;
                    }
                        break;    
                        
                }
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnCaminar = new javax.swing.JButton();
        btnMoverCola = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCaminar.setText("Caminar");
        btnCaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaminarActionPerformed(evt);
            }
        });

        btnMoverCola.setText("Mover cola");
        btnMoverCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoverColaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(605, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCaminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMoverCola, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnCaminar)
                .addGap(30, 30, 30)
                .addComponent(btnMoverCola)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaminarActionPerformed
        //creaEscena.Caminata();
        if(hilo.c == true)
        {
            hilo.c=false;
            hilo = new HiloCaminata(creaEscena);
        } else {
            hilo.start();
            hilo.c=true;
        }
    }//GEN-LAST:event_btnCaminarActionPerformed

    private void btnMoverColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoverColaActionPerformed
        //creaEscena.MoverCola();
          if(hiloSentar.c == true)
          {
              hiloSentar.c=false;
              hiloSentar=new HiloSentar(creaEscena);
          } else {
              hiloSentar.start();
              hiloSentar.c=true;
          }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoverColaActionPerformed

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
            java.util.logging.Logger.getLogger(PerroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerroFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaminar;
    private javax.swing.JButton btnMoverCola;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
