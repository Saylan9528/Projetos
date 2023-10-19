import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class atividadeALG {
    public static void main(String[] args) throws IOException {
        FileReader arquivo = new FileReader("text.txt");
        BufferedReader le = new BufferedReader(arquivo);
        String linha = le.readLine();
        String[] palavras = new String[1000];

        int indice = 0;
        palavras = palavras(linha, palavras, indice, le);
        imprimir(palavras);
    }

    // cria os vetores e converte para toLowerCase
    public static String[] palavras(String linha, String[] palavras, int indice, BufferedReader le) throws IOException {
        while (linha != null) {
            String[] palavrasDaLinha = linha.split(" ");

            for (String palavra : palavrasDaLinha) {
                palavras[indice] = palavra.toLowerCase();
                indice++;
            }
            linha = le.readLine();
        }
        return palavras;
    }

    // imprime as palavras e evita que valores nulos sejam impressos
    public static void imprimir(String[] palavras) {
        for (int i = 0; i < palavras.length && palavras[i] != null; i++) {
            System.out.println(palavras[i]);
        }
    }

    public static int buscaBinaria(String[] palavras, String x) {
        int inicio = 0;
        int fim = palavras.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = x.compareTo(palavras[meio]);
            if (comparacao == 0) {
                return meio; // Encontrou a palavra
            } else if (comparacao > 0) {
                fim = meio - 1; // Procura na metade esquerda
            } else {
                inicio = meio + 1; // Procura na metade direita
            }
        }
        return -1; // A palavra não foi encontrada
    }

}
