/*
Entrega a Atividade 1 - Algoritmos e Programação II

Nós,

Paulo Henrique Moreira Maia
Gabriel Santos Attuy
Kauan de Souza Pereira


declaramos que

todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/

package atividade01;

import java.util.Scanner;
import java.util.Random;

public class Atividade01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int[] n = null;
		boolean caso1 = false;
		// primeiro menu com as funções iniciais
		while (caso1 == false) {
			System.out.println("===============Bem-Vindo============");
			System.out.println("Escolha uma opção para ser executada");
			System.out.println("1 - Regitrar Vetor");
			System.out.println("2 - Sair do Programa");
			System.out.println("====================================");
			int opc = sc.nextInt();
			switch (opc) {
			case 1:
				// criação do vetor
				System.out.println("Digite o tamanho do vetor desejado");
				int tam = sc.nextInt();
				System.out.println("Digite o valor maximo dos numeros gerados:");
				int max = sc.nextInt();
				n = new int[tam];
				for (int i = 0; i < n.length; i++) {
					n[i] = r.nextInt(max + 1);
					caso1 = true;
				}
				break;
			case 2:
				// encerra o programa
				System.out.println("Saindo do Sistema!");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Opção invalida");

			}
		}
		// menu principal
		System.out.println("=====================================================================");
		System.out.println("1. Criar novo vetor com números aleatórios");
		System.out.println("2. Imprimir o vetor");
		System.out.println("3. Verificar se um número está no vetor");
		System.out.println("4. Buscar o maior número no vetor");
		System.out.println("5. Calcular a média dos números pares no vetor");
		System.out.println("6. Calcular o percentual de números ímpares no vetor");
		System.out.println("7. Calcular a média centralizada do vetor");
		System.out.println("8. Verificar se dois números somados são iguais a um valor informado");
		System.out.println("9. Sair");
		System.out.println("=====================================================================");

		while (caso1 == true) {
			System.out.println("Escolha uma opção para ser executada:");
			int opc2 = sc.nextInt();
			// menu

			switch (opc2) {
			case 1:
				// criação do vetor
				System.out.println("Digite o tamanho do vetor desejado");
				int tam = sc.nextInt();
				System.out.println("Digite o valor maximo dos numeros gerados:");
				int max = sc.nextInt();
				n = new int[tam];
				for (int i = 0; i < n.length; i++) {
					n[i] = r.nextInt(max + 1);
					caso1 = true;
				}
				break;
			case 2:
				// impressão
				impressao(n);
				break;

			case 3:
				// busca de valor
				System.out.println("Digite o valor que deseja procurar:");
				int valor3 = sc.nextInt();
				int i = verificarIgual(n, valor3);
				if (i >= 0) {
					System.out.printf("Valor %d, foi encontrado na posição %d!!%n", valor3, i);
					System.out.printf("N[%d] = %d %n", i, n[i]);
				} else {
					System.out.printf("Valor: %d, não foi encontrado! %d", valor3);
				}

				break;

			case 4:
				// maior valor
				int maior = maiorValor(n);
				System.out.printf("O maior valor desse vetor é %d", maior);

				break;

			case 5:
				// calcular pares
				int mediaVetor = calcularPares(n);
				System.out.printf("O resultado do calculo da media dos numeros pares é igual á : %d %n", mediaVetor);

				break;
			case 6:
				// percentual impar
				double perc = calcularPercentualImpar(n);
				System.out.printf("O percentual de numeros impares é: %.0f%% %n", perc);
				break;

			case 7:
				// media centralizada
				double mediaCentralizada = calcularMediaCentralizada(n);
				System.out.printf("A media centralizada desse vetor é %.2f %n", mediaCentralizada);
				break;
			case 8:
				// verificar soma
				System.out.println("Digite o numero que deseja verificar a soma:");
				int valorAProcurar = sc.nextInt();
				boolean verifica = somaEVerifica(n, valorAProcurar);
				System.out.println(verifica);
				break;
			case 9:
				// encerra o programa
				System.out.println("Encerrando o programa! Obrigado por usar !");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Opção Invalida");
				break;
			}
		}
	}

	public static void impressao(int[] n) {
		// impressão do vetor aleatório
		for (int i = 0; i < n.length; i++) {
			System.out.printf("N[%d]= %2d %n", i, n[i]);
		}
	}

	public static int verificarIgual(int[] n, int valor3) {
		// verifica se o valor solicitado existe no vetor aleatório
		for (int i = 0; i < n.length; i++) {
			if (valor3 == n[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int maiorValor(int[] n) {
		// exibe o maior valor no vetor
		int maior = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] > maior) {
				maior = n[i];
			}
		}
		return maior;
	}

	public static int calcularPares(int[] n) {
		// verifica e tida a media dos pares no vetor aleatório
		int soma = 0;
		int div = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] % 2 == 0) {
				soma += n[i];
				div ++;
			}
		}
		int media = soma / div;
		return media;
	}

	public static double calcularPercentualImpar(int[] n) {
		// calcula o percentual de numeros impares no vetor
		double qtnd = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] % 2 != 0) {
				qtnd++;
			}
		}
		double percentual = (qtnd / n.length) * 100.0;
		return percentual;
	}

	public static double calcularMediaCentralizada(int[] n) {
		// calcula media centralizada
		int maior = 0;
		int menor = 0;
		int soma = 0;
		for (int i = 0; i < n.length; i++) {
			soma += n[i];
			if (n[i] > maior) {
				maior = n[i];
			}
			if (n[i] < menor) {
				menor = n[i];
			}
		}
		double media = (soma - menor - maior) / (n.length - 2);
		return media;
	}

	public static boolean somaEVerifica(int[] n, int valorAProcurar) {
		// soma 2 numeros do vetor e verifica se é igual ao numero solicitado
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i]; j++) {
				if (n[j] + n[i] == valorAProcurar) {
					return true;
				}
			}
		}
		return false;
	}
}
