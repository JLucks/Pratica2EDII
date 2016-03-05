/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import base.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import outros.ReaderDoc;

/**
 *
 * @authors Jorge & Daniel
 */
public class DocumentFeeder extends javax.swing.JPanel {
    
    /**
     * Creates new form EntryDocument
     */
    
    private JFileChooser JFCFiles;
    private List<Word> words;
    private List<AddressDoc> docs;
    private int numberIds;
    
    public DocumentFeeder(int numberIds, List<Word> words, List<AddressDoc> docs) {
        this.numberIds = numberIds; //Id atual
        this.words = words; //Indice Invertido atual
        this.docs = docs;   //Documentos atuais
        initComponents();
        JFCFiles = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("TxT file", new String[]{"txt"});   //Mostrar e escolher somentes txts
        JFCFiles.setDialogTitle("Selecionar Arquivo");
        JFCFiles.setFileFilter(filter);
        JFCFiles.addChoosableFileFilter(filter);
        JFCFiles.setAcceptAllFileFilterUsed(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bttSelect = new javax.swing.JButton();
        bttGoBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTId = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTAddress = new javax.swing.JTextArea();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        bttSelect.setText("Selecionar");
        bttSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSelectActionPerformed(evt);
            }
        });

        bttGoBack.setText("Voltar");
        bttGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGoBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel1.setText("Selecione os Aquivos");

        JTId.setEditable(false);
        JTId.setColumns(20);
        JTId.setRows(5);
        jScrollPane1.setViewportView(JTId);

        jLabel2.setText("Local");

        jLabel3.setText("Identificador");

        JTAddress.setEditable(false);
        JTAddress.setColumns(20);
        JTAddress.setRows(5);
        jScrollPane5.setViewportView(JTAddress);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(bttSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttSelect)
                    .addComponent(bttGoBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGoBackActionPerformed
        Main.janela.setVisible(false);
        Main.janela.remove(this);
        Main.janela.add(new Home(this.numberIds,this.words,this.docs)); //Chama a janela Home passando o id, indice invertido, documentos
        Main.janela.setSize(615,460);
        Main.janela.setVisible(true);
    }//GEN-LAST:event_bttGoBackActionPerformed

    private void bttSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSelectActionPerformed
        JTAddress.setVisible(false);
        JTId.setVisible(false);
        if(JFCFiles.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            String url = JFCFiles.getSelectedFile().getAbsolutePath();
            String Sid = "Doc_" + numberIds;    //Cria um id
            AddressDoc doc = new AddressDoc(Sid,url);   //Cria um documento
            JTAddress.setText(JTAddress.getText()+url+"\n");    //Mostra na janela o caminho
            JTId.setText(JTId.getText()+Sid+"\n");  //Mostra na janela o id
            numberIds++;    //Imcrementa o id
            try {
                InvertedIndex.getInvertedIndex(ReaderDoc.getWords(url), doc, words);    //Chamada a função para criação do indice invertido         
                docs.add(doc);  //Adiciona o documento a lista de documentos
            } catch (IOException ex) {
                Logger.getLogger(DocumentFeeder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        JTId.setVisible(true);
        JTAddress.setVisible(true);
    }//GEN-LAST:event_bttSelectActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTAddress;
    private javax.swing.JTextArea JTId;
    private javax.swing.JButton bttGoBack;
    private javax.swing.JButton bttSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
