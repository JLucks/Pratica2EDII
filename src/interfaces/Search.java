/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import algoritmos.*;
import base.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import outros.ReaderDoc;

/**
 *
 * @author jluck_000
 */
public class Search extends javax.swing.JPanel {

    private List<Word> words;
    private List<AddressDoc> docs;
    private int numberIds;
    private double limit;
    private Hash hash;
    private long timeStart, timeEnd;
    
    /**
     * Creates new form Search
     */
    public Search(int numberIds, List<Word> words, List<AddressDoc> docs) {
        this.numberIds = numberIds;
        this.words = words;
        this.docs = docs;
        this.hash = new Hash(loadC(), loadMode());
        resetTemp();
        printIdHash();
        loadHash();
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

        jLabel1 = new javax.swing.JLabel();
        JTFWord = new javax.swing.JTextField();
        bttSearch = new javax.swing.JButton();
        bttGoBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTResult = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel1.setText("Buscar Palavra");

        bttSearch.setText("?");
        bttSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSearchActionPerformed(evt);
            }
        });

        bttGoBack.setText("Voltar");
        bttGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGoBackActionPerformed(evt);
            }
        });

        JTResult.setEditable(false);
        JTResult.setColumns(20);
        JTResult.setRows(5);
        jScrollPane1.setViewportView(JTResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttGoBack)
                .addGap(165, 165, 165))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JTFWord, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGoBackActionPerformed
        Main.janela.setVisible(false);
        Main.janela.remove(this);
        Main.janela.add(new Home(this.numberIds,this.words,this.docs));
        Main.janela.setSize(615,460);
        Main.janela.setVisible(true);
    }//GEN-LAST:event_bttGoBackActionPerformed

    private void bttSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSearchActionPerformed
        JTResult.setText("Resultado:");
        List<Word> result = new ArrayList<>();
        for(String word: JTFWord.getText().split("\\s")){
            word = ReaderDoc.formatString(word);
            if(word.length() >= this.hash.getC()){
                this.timeStart = System.currentTimeMillis();
                Word rs = this.hash.search(word);                
                this.timeEnd = System.currentTimeMillis();
                System.out.println("Tempo de Execução da Busca da palavra "+word+" : "+(this.timeEnd-this.timeStart)*0.001);
                resetTemp();
                if(rs != null){
                    result.add(rs);                    
                }
            }
        }
        List<String> namesDocs = ordinateByRelevance(result);
        for(String nameDoc: namesDocs)
            JTResult.setText(JTResult.getText()+"\n"+ loadNameDoc(nameDoc));
    }//GEN-LAST:event_bttSearchActionPerformed

    private void printIdHash(){
        System.out.print("Hash com resolução de conflito via ");
        switch(this.hash.getMode()){
            case 0:
                System.out.println("Lista Encadeada");
                break;
            case 1:
                System.out.println("Árvore Binaria");
                break;
            case 2:
                System.out.println("Árvore AVL");
                break;
            default:
                System.out.println("Árvore Rubro-Negra");
                break;
        }
    }
    
    private void resetTemp(){        
        this.timeStart = 0L;
        this.timeEnd = 0L;
    }
    
    private List<String> ordinateByRelevance(List<Word> A){
        List<String> result = new ArrayList<>();
        Relevance[] r = ordinateRelevance(loadRelevance(A));
        int i = 0;
        while(i < r.length){
            if(r[i].getRelevance() < getLimit()){
                break;
            }
            else{
                result.add(r[i].getIdDoc());
            }
            i++;
        }
        return result;
    }
    
    private Relevance[] ordinateRelevance(List<Relevance> A){
        Collections.sort(A);
        Relevance[] result = A.toArray(new Relevance[A.size()]);                
        return result;
    }
    
    private List<Relevance> loadRelevance(List<Word> A){
        List<Relevance> result = new ArrayList<>();
        Relevance relevance;
        boolean exist = false;
        for(Word word: A){
            for(WordInDoc doc: word.getQuantityByDocs()){
                for(Relevance rs: result){
                    if(rs.getIdDoc().equals(doc.getIdDoc())){
                        exist = true;
                        rs.addW(doc.getQuantity(), this.words.size(), word.getQuantityByDocs().size());
                        break;
                    }
                }
                if(!exist){
                    relevance = new Relevance(doc.getIdDoc(), getNumberWords(doc.getIdDoc()));
                    relevance.addW(doc.getQuantity(), this.words.size(), word.getQuantityByDocs().size());
                    result.add(relevance);
                }
                else{
                    exist = false;
                }
            }
        }
        return result;
    }
    
    private int getNumberWords(String id){
        for(AddressDoc documents:this.docs){
            if(documents.getIdDoc().equals(id)){
                return documents.getNumberWords();
            }
        }
        return 0;
    }
    
    private void loadHash(){
        this.timeStart = System.currentTimeMillis();
        for(Word word: words){
            this.hash.insert(word);
        }
        this.timeEnd = System.currentTimeMillis();
        System.out.println("Tempo de Execução da Inserção: "+(timeEnd-timeStart)*0.001);
        resetTemp();
    }
    
    private int loadMode(){
        int mode = -1;
        while(mode == -1){
            String sMode = JOptionPane.showInputDialog("Tratamento da colisão:Digite 0->Lista\t1->Arvore Binaria\t2->Arvore AVL\t3->Arvore Rubro-Negra");
            if(sMode.equals("0")||sMode.equals("1")||sMode.equals("2")||sMode.equals("3")){
		mode = Integer.parseInt(sMode);	
            }
        }
        return mode;
    }
    
    private int loadC(){
        int mode = -1;
        while(mode == -1){
            String sMode = JOptionPane.showInputDialog("Digite um valor para C:");
            try{
		mode = Integer.parseInt(sMode);	
            }catch(Exception e){
                System.err.println(e);
                mode = -1;
            }
        }
        return mode;
    }
    
    private String loadNameDoc(String idDoc){
        String nameDoc = null;
        for(AddressDoc doc: this.docs){
            if(idDoc.equals(doc.getIdDoc())){
                nameDoc = doc.getAddress().substring(doc.getAddress().lastIndexOf("\\")+1, doc.getAddress().length());
            }
        }
        return nameDoc;
    }

    
    public void setLimit(double l){
        this.limit = l;
    }
    
    
    /**
     * @return the limit
     */
    public double getLimit() {
        return limit;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFWord;
    private javax.swing.JTextArea JTResult;
    private javax.swing.JButton bttGoBack;
    private javax.swing.JButton bttSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
