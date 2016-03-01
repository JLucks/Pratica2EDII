/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @authors Jorge & Daniel
 */
public class Relevance implements Comparable<Relevance>{
    //Variaveis
    private String idDoc;   //Id do documento
    private float w;    //W do calculo de relevancia
    private int numberWords;    //Numero de palavras do documento

    public Relevance(String id, int number){
        this.idDoc = id;
        this.numberWords = number;
        this.w = 0;
    }
    
    /**
     * @return the idDoc
     */
    public String getIdDoc() {
        return idDoc;
    }

    public float getRelevance() { 
        return (1f / this.numberWords) * this.w;    //Função de calculo de relevancia
    }

    public void addW(int f, int N, int dt) {
        this.w += f * (Math.log10(N)/dt);   //Calculo do w da equação de relevância
    }

    @Override
    //Função de Comparação da relevancia decrescente
    public int compareTo(Relevance o) { 
        if(getRelevance() < o.getRelevance()){
            return 1;
        }
        else{
            if(getRelevance() == o.getRelevance()){
                return 0;
            }
            else{
                return -1;
            }
        }            
    }
}
