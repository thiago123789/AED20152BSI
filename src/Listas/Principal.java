package Listas;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {
		Integer quantidadeDeElementos;
		int opcao;
		List<Integer> l = new List<Integer>();
		Scanner scanner = new Scanner(System.in);

		do{
			System.out.println();
			System.out.println();
			menu();
			opcao = scanner.nextInt();
			System.out.println();
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.print("Digite quantos elementos deseja inserir na lista: ");
				quantidadeDeElementos = scanner.nextInt();

				for(int i = 1; i <= quantidadeDeElementos; i++){
					No<Integer> temporario = new No<Integer>();
					Integer valor;
					System.out.println();
					System.out.print("Digite o "+i+"º para ser inserido: ");
					valor = scanner.nextInt();
					temporario.valor = valor;
					l.adicionarNoFim(temporario);
				}
				break;
			case 2:
				System.out.println(l.listarElementos());
				break;
			case 3:
				int buscaR;
				System.out.print("Digite o numero que deseja remover: ");
				buscaR = scanner.nextInt();
				l.removerNoDaLista(buscaR);
				break;
			case 4:
				int busca;
				System.out.print("Digite o numero que deseja buscar: ");
				busca = scanner.nextInt();
				if(l.pesquisarElemento(busca)){
					System.out.println("Elemento pertence a lista");
				}else{
					System.out.println("Elemento não pertence a lista");
				}
				break;
			case 5:
				int buscaAlterar, buscaEle;
				System.out.print("Digite o numero que esta na lista para altera-lo: ");
				buscaEle = scanner.nextInt();
				System.out.print("Digite o valor que deseja colocar no lugar do numero modificado: ");
				buscaAlterar = scanner.nextInt();
				l.alterarElemento(buscaEle, buscaAlterar);
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}while(opcao != 0);






	}

	public static void menu(){
		
		System.out.println("Digite a opção desejada");
		System.out.println("1 - Inserir no fim da lista;");
		System.out.println("2 - Exibir elementos da lista;");
		System.out.println("3 - Remover numero na lista");
		System.out.println("4 - Pesquisar elemento (Existe/Não existe)");
		System.out.println("5 - Alterar Elemento");
		System.out.println("0 - Sair");
		
	}
	
	
}
