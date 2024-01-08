/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.aes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class MainAes extends javax.swing.JFrame {

    public static String direccionArchivo;

    /**
     * Creates new form MainRsa
     */
    public MainAes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextPass = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jRadioEn = new javax.swing.JRadioButton();
        jRadioDes = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Archivo");

        jButton1.setText("Elegir archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        jTextPass.setText("jTextField1");

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioEn);
        jRadioEn.setText("Encriptar");

        buttonGroup1.add(jRadioDes);
        jRadioDes.setText("Desencriptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioDes)
                    .addComponent(jRadioEn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextPass)))
                    .addComponent(jButton2))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jRadioEn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioDes)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Archivo seleccionado: " + selectedFile.getAbsolutePath());
            direccionArchivo = selectedFile.getAbsolutePath();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jRadioEn.isSelected()) {
            String texto = "";
            try (BufferedReader reader = new BufferedReader(new FileReader(direccionArchivo))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Procesa la línea leída
                    texto += line + "\n";
                }
                //SecretKey key = AESKeyGenerator.generateKey();
                String pass = jTextPass.getText();
                String myKey = pass;
                SecretKey key = AESUtil.getKeyFromPassword(myKey);

                // Encriptar
                String encryptedText = AESUtil.encrypt(texto, key);
                //System.out.println("Texto encriptado: " + encryptedText);
                Random random = new Random();
                int randomNumber = 1 + random.nextInt(1000);
                String str = "Archivo" + randomNumber + ".txt";
                writeToFile(str, encryptedText);
                // Desencriptar
                //String decryptedText = AESUtil.decrypt(encryptedText, key);
                // System.out.println("Texto desencriptado: " + decryptedText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (jRadioDes.isSelected()) {

            String texto = "";
            try (BufferedReader reader = new BufferedReader(new FileReader(direccionArchivo))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Procesa la línea leída
                    texto += line ;
                }
                //SecretKey key = AESKeyGenerator.generateKey();
                String pass = jTextPass.getText();
                String myKey = pass;
                SecretKey key = AESUtil.getKeyFromPassword(myKey);

                // Encriptar
                //String encryptedText = AESUtil.encrypt(texto, key);
                //System.out.println("Texto encriptado: " + encryptedText);
                Random random = new Random();
                int randomNumber = 1 + random.nextInt(1000);
                
                // Desencriptar
                String decryptedText = AESUtil.decrypt(texto, key);
                String str = "ArchivoDes" + randomNumber + ".txt";
                writeToFile(str, decryptedText);
                // System.out.println("Texto desencriptado: " + decryptedText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public static void writeToFile(String filePath, String text) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(MainAes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioDes;
    private javax.swing.JRadioButton jRadioEn;
    private javax.swing.JTextField jTextPass;
    // End of variables declaration//GEN-END:variables
}
