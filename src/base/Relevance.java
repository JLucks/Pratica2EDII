/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author jluck_000
 */
public class Relevance implements Comparable<Relevance>{
    private String idDoc;
    private float w;
    private int numberWords;

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
        return (1f / this.numberWords) * this.w;
    }

    public void addW(int f, int N, int dt) {
        this.w += f * (Math.log10(N)/dt);        
    }

    @Override
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
