package outros;

public class MergeSort {
    
    //Metodo base do mergesort
    public String[] mergeSort(String C[]){	//Tem como entrada o arranjo
            //Variaveis
            String temp[] = new String[C.length];	//Cria um arranjo temporario de mesmo tamanho do arranjo a ser ordenado
            C = this.mergeMain(C,temp,0,C.length - 1);	//Chamada ao metodo que fragmenta o arranjo
            return C;	//retorna o arranjo j� ordenado 
    }

    //Metodo que fragmenta o arranjo
    public String[] mergeMain(String C[], String temp[], int left, int right){	//Tem como entrada o arranjo, o arranjo temporario, a primeira posi��o e a ultima que ir�o ser ordenadas
            //Variaveis
            int half;	//Guarda a posi��o intermediaria do arranjo
            if(left < right){	//Verifica se a inicial n�o ultrapassou o fim
                    half = (left + right) / 2;	//posicao intermediaria
                    this.mergeMain(C, temp, left, half);	//Fragmenta do inicio ao meio
                    this.mergeMain(C, temp, half + 1, right);	//Fragmenta do meio ao fim
                    this.merge(C, temp, left, half + 1, right);	//Chamada ao metodo que intecalar no arranjo os fragmentos ordenados
            }
            return C;	//retorna o arranjo semi-ordenado
    }

    //Metodo que intercalar ordenadamente
    private void merge(String C[], String temp[], int left, int right, int end){	//Tem como entrada o arranjo, o arranjo temporario, a posi��o inicial para intercala��o, a posi��o do meio e a final
            //Variaveis
            int leftEnd = right - 1, tPos = left, numEle = end - left + 1;	//leftEnd limite ate o meio, tpos posicao do arranjo temporario, numEle o total de elementos
            while(left <= leftEnd && right <= end){	//Percorre do inicio ao meio e do meio ao fim ate que um alcance o limite
                    if(this.compareValueWithEqual(C[right], C[left])){	//Verifica quem � maio o da esquerda ou o da direita
                            temp[tPos] = C[left];	//Guarda no arranjo temporario caso seja o menor o da esquerda
                            left++;
                    }
                    else{
                            temp[tPos] = C[right];	//Guarda no arranjo temporario caso seja o da direita
                            right++;
                    }
                    tPos++;
            }
            while(left <= leftEnd){	//Preenche com o resto da esquerda
                    temp[tPos] = C[left];
                    left++;
                    tPos++;
            }
            while(right <= end){	//Preenche com resto da direita
                    temp[tPos] = C[right];
                    right++;
                    tPos++;
            }
            for(int i = 0; i < numEle; i++, end--){	//Percorre o total de elementos
                    C[end] = temp[end];	//Carrega o arranjo temporario no principal
            }
    }

    //Metodo que compara se o elemento A >= elemento B
    public boolean compareValueWithEqual(String A, String B){	//Tem como entrada o elemento A e o B
            if(A.compareTo(B) >= 0){	//Compara os dados pela ordem alfanumerica
                return true;
            }
            return false;
    }
}
