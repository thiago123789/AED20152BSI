package ArvoreBinaria;

import java.util.Scanner;

public class ArvoreB {
	Node<Integer> raiz;

	public static void main(String[] args) {
		ArvoreB arvore = new ArvoreB();

		int elementos;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Quantos elementos deseja inserir na arvore: ");
		elementos = entrada.nextInt();
		//		System.out.println("Digite o 1º elemento: ");
		//		int auxV = entrada.nextInt();
		//		ar
		for(int i = 0; i < elementos; i++){
			int valor;
			Node<Integer> aux = new Node<Integer>();

			System.out.println("Digite o "+(i+1)+"º elemento: ");

			valor = entrada.nextInt();
			aux.dados = valor;
			arvore.inserir(arvore.raiz, valor);

		}

		arvore.teste(arvore.raiz);
	}
	
	//CONSTRUTOR DEFAULT PARA ARVORE BINÁRIA
	public ArvoreB(){}

	//METODO INSERIR PARA INSERIR UM INTEIRO (TAMBÉM SALVA O PAI DO NÓ)
	public void inserir(Node<Integer> T, Integer valor) {
		if(this.raiz == null){
			Node<Integer> aux = new Node<Integer>(valor);
			this.raiz = aux;
			T = aux;
		}
		if (valor < T.getInfo()) {  
			if (T.esquerda != null) { 
				inserir(T.esquerda, valor);  
			} else {  
				//                System.out.println("  Inserindo " + valor + " a esqueda de " + T.dados);
				T.esquerda = new Node<Integer>(valor);  
				T.esquerda.pai = T;
			}  
		} else if (valor > T.getInfo()) {  
			if (T.direita != null) {  
				inserir(T.direita, valor);  
			} else {  
//                System.out.println("  Inserindo " + valor + " a direita de " + T.dados);
				T.direita = new Node<Integer>(valor);  
				T.direita.pai = T;
			}
		}  
	} 
	
	
	
	
	
	
	//METODO QUE IMPRIMI OS NÓS EM ESTRUTURAS DE STRING, UTILIZA METODO toString DA CLASSE NODE
	public void teste(Node<Integer> no){
		if(no != null){ 
			System.out.println(no.toString()); 
			teste(no.esquerda);
			teste(no.direita); 
		}
	}


}




