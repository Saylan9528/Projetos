
/*
Entrega a Atividade 2 - Algoritmos e Programação II

Nós,

Paulo Henrique Moreira Maia
Gabriel Santos Attuy 
Nome completo 
Nome completo 

declaramos que

todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class atividadeALG {
    public static void main(String[] args) throws IOException {
        FileReader arquivo = new FileReader("text.txt");
        BufferedReader le = new BufferedReader(arquivo);
        String linha; // modifiquei essa String para ler todas as linahs depois la em baixo dentro do
                      // while (PEDRO) ඞ ඞ ඞ ඞ ඞ AMONG {
        String[] palavras = new String[1000];

        int indice = 0;

        // Aqui ele le todas as linhas, fiz isso para evitar um erro que nao estava
        // lendo mais de uma linha (PEDRO)
        while ((linha = le.readLine()) != null) {
            palavras = palavras(linha, palavras, indice);
            indice += contarPalavras(linha);
        }

        bubbleSort(palavras, indice);
        imprimir(palavras, indice);
    }

    // cria os vetores e converte para toLowerCase
    public static String[] palavras(String linha, String[] palavras, int indice) {
        String[] palavrasDaLinha = linha.split(" ");

        for (String palavra : palavrasDaLinha) {
            palavra = palavra.toLowerCase();
            if (!existePalavra(palavras, palavra, indice)) {
                palavras[indice] = palavra;
                indice++;
            }
        }
        return palavras;
    }

    // Conta o número de palavras em uma linha pro indice do while funfar
    public static int contarPalavras(String linha) {
        String[] palavrasDaLinha = linha.split(" ");
        return palavrasDaLinha.length;
    }

    public static void bubbleSort(String[] palavras, int indice) {
        int n = indice;
        boolean teste;
        do {
            teste = false;
            for (int i = 1; i < n; i++) {
                if (palavras[i - 1] != null && palavras[i] != null && palavras[i - 1].compareTo(palavras[i]) > 0) {
                    // Aqui ele verifica se a String nao é nula ou nao pra evitar o erro la do
                    // NullPointException e se estão fora de ordem (PEDRO)
                    String temp = palavras[i - 1];
                    palavras[i - 1] = palavras[i];
                    palavras[i] = temp;
                    teste = true;
                }
            }
            n--;
        } while (teste);
    }

    // Funçao para verificar se a palavra existe, if sim entao corta ela, a busca
    // binaria que antes era uma funçao a parte agora está dentro dessa funçao ali
    // no While (PEDRO)
    public static boolean existePalavra(String[] palavras, String palavra, int indice) {
        int inicio = 0;
        int fim = indice - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (palavras[meio] != null) {
                int comparacao = palavra.compareTo(palavras[meio]);

                if (comparacao == 0) {
                    return true; // Aq a palavra ja existe
                } else if (comparacao < 0) {
                    fim = meio - 1; // Procura pra esquerda
                } else {
                    inicio = meio + 1; // Procura pra direita
                }
            } else {
                fim = meio - 1; // If palavras[meio] is null, search to the left
            }
        }

        return false; // Aq a palavra nao existe nao
    }

    // imprime as palavras e evita que valores nulos sejam impressos, POG! (PEDRO
    // :P) }ඞ ඞ ඞ ඞ ඞ US
    public static void imprimir(String[] palavras, int indice) {
        for (int i = 0; i < indice; i++) {
            if (palavras[i] != null) {
                System.out.println(palavras[i]);
            }
        }
    }
}
