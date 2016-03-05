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
 * @authors Jorge & Daniel
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
        this.numberIds = numberIds; //Id atual
        this.words = words; //Indice Invertido atual
        this.docs = docs;   //Documentos atuais
        this.hash = new Hash(loadC(), loadMode());  //Inicializa hash
        printIdHash();  //Chamada a função que imprime a identificação do modo de resolução de conflitos do hash
        loadHash(); //Chamada a função que insere o indice invertido no hash
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
        Main.janela.add(new Home(this.numberIds,this.words,this.docs)); //Chama a janela Home passando o id, indice invertido, documentos
        Main.janela.setSize(615,460);
        Main.janela.setVisible(true);
    }//GEN-LAST:event_bttGoBackActionPerformed

    private void bttSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSearchActionPerformed
        JTResult.setText("Resultado:");
        List<Word> result = new ArrayList<>();  //Lista de palavras encontradas
        for(String word: JTFWord.getText().split("\\s")){   //Quebra a frase de busca em palavras
            word = ReaderDoc.formatString(word);    //Formata a palavra retirando caracteres especiais
            this.timeStart = System.nanoTime();    //Carrega tempo de inicio do algoritmo
            Word rs = this.hash.search(word);   //Chama a função de busca do hash
            this.timeEnd = System.nanoTime();  //Carrega tempo de fim do algoritmo
            System.out.println("Tempo de Execução da Busca da palavra "+word+" : "+(this.timeEnd-this.timeStart)/1000000.0+" ms");
            if(rs != null){
                result.add(rs); //Adiciona palavra encontra a lista de resultados                
            }
        }
        List<String> namesDocs = ordinateByRelevance(result);   //Chamada a função que ordena a lista de resultados por relevancia e retorna uma lista de documentos
        for(String nameDoc: namesDocs)
            JTResult.setText(JTResult.getText()+"\n"+ loadNameDoc(nameDoc));
    }//GEN-LAST:event_bttSearchActionPerformed

    //Função que imprime o identificador
    private void printIdHash(){
        System.out.print("Hash com C = "+this.hash.getC()+" com M = "+this.hash.getM()+" com resolução de conflito via ");
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
    
    //Função que ordena por relevância
    private List<String> ordinateByRelevance(List<Word> A){
        List<String> result = new ArrayList<>();
        Relevance[] r = ordinateRelevance(loadRelevance(A));    //Chamada a função que ordena a relevância
        int i = 0;
        while(i < r.length){    //Enquanto existir elementos
            if(r[i].getRelevance() < getLimit()){   //Verifica se a relevancia é maior igual ao limite
                break;
            }
            else{
                result.add(r[i].getIdDoc());    //Adiciona o id do documento a lista
            }
            i++;
        }
        return result;
    }
    
    //Função que ordenar a relevância
    private Relevance[] ordinateRelevance(List<Relevance> A){
        Collections.sort(A);    //Ordena a lista de relenvancia
        Relevance[] result = A.toArray(new Relevance[A.size()]);    //Transforma a lista em array                
        return result;
    }
    
    //Função que carrega a relevância
    private List<Relevance> loadRelevance(List<Word> A){
        List<Relevance> result = new ArrayList<>(); //Lista de relevancia resultante
        Relevance relevance;    
        boolean exist = false;  //Caso exista a relevancia do documento
        for(Word word: A){  //Enquanto tiver palavras
            for(WordInDoc doc: word.getQuantityByDocs()){   //Enquanto tiver indices
                for(Relevance rs: result){  //Enquanto tiver relevancias
                    if(rs.getIdDoc().equals(doc.getIdDoc())){   //Verifica se o id da relevancia é o mesmo do documento
                        exist = true;   //Avisa que existe
                        rs.addW(doc.getQuantity(), this.words.size(), word.getQuantityByDocs().size()); //Chamada ao metodo que carrega o w da função de calculo da relevancia
                        break;
                    }
                }
                if(!exist){ //Verifica se existe
                    relevance = new Relevance(doc.getIdDoc(), getNumberWords(doc.getIdDoc()));  //Cria a relevancia
                    relevance.addW(doc.getQuantity(), this.words.size(), word.getQuantityByDocs().size());  //Calcula o w da relevancia
                    result.add(relevance);  //Adiciona a relevancia a lista de relevancia
                }
                else{
                    exist = false;  //Reinicia a flag
                }
            }
        }
        return result;
    }
    
    //Função que retorna o numero de termos de um documento
    private int getNumberWords(String id){
        for(AddressDoc documents:this.docs){    //Enquanto tiver documentos
            if(documents.getIdDoc().equals(id)){    //Verifica se é o id buscado
                return documents.getNumberWords();
            }
        }
        return 0;
    }
    
    //Função que inicia o hash
    private void loadHash(){
        this.timeStart = System.nanoTime();
        for(Word word: words){  //Enquanto tiver palavras
            this.hash.insert(word); //Insere a palavra no hash
        }
        this.timeEnd = System.nanoTime();
        System.out.println("Tempo de Execução da Inserção: "+(timeEnd-timeStart)/1000000.0+" ms");
    }
    
    //Função que pega o modo de resolução de conflito
    private int loadMode(){
        int mode = -1;
        while(mode == -1){  //Enquanto nao for escolhida uma opção valida
            String sMode = JOptionPane.showInputDialog("Tratamento da colisão:Digite 0->Lista\t1->Arvore Binaria\t2->Arvore AVL\t3->Arvore Rubro-Negra");
            if(sMode.equals("0")||sMode.equals("1")||sMode.equals("2")||sMode.equals("3")){ //Verifica se a opção é valida
		mode = Integer.parseInt(sMode); //Passa para int
            }
        }
        return mode;
    }
    
    //Função que pega o c do hash
    private int loadC(){
        int mode = -1;
        while(mode == -1){  //Enquanto nao for escolhida uma opção valida
            String sMode = JOptionPane.showInputDialog("Digite um valor para C:");
            try{
		mode = Integer.parseInt(sMode); //Passa para int
            }catch(Exception e){
                System.err.println(e);
                mode = -1;
            }
        }
        return mode;
    }
    
    //Função retorna o nome do doumento referente ao id
    private String loadNameDoc(String idDoc){
        String nameDoc = null;
        for(AddressDoc doc: this.docs){ //Enquanto tiver documentos
            if(idDoc.equals(doc.getIdDoc())){   //Verifica se é o documento
                nameDoc = doc.getAddress().substring(doc.getAddress().lastIndexOf("\\")+1, doc.getAddress().length());  //Pega o nome do documento
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
