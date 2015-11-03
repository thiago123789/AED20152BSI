package ArvoreBinaria;

import java.util.Scanner;

public class Arvore {
	Node<Integer> raiz;
	Arvore dir;
	Arvore esq;
	//CONSTRUTOR DA CLASSE
	public Arvore(){}

	//METODO MAIN PARA TESTE DOS METODOS
	public static void main(String[] args) {
		Arvore arvore = new Arvore();

		int elementos;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Quantos elementos deseja inserir na arvore: ");
		elementos = entrada.nextInt();

		for(int i = 0; i < elementos; i++){
			int valor;
			Node<Integer> aux = new Node<Integer>();

			System.out.println("Digite o "+(i+1)+"º elemento: ");

			valor = entrada.nextInt();
			aux.dados = valor;
			inserir(arvore, aux);
			
		}
		System.out.println(arvore.imprimir(arvore, arvore.raiz));
	}

	//METODO QUE INSERE NÓS NA ARVORE
	public static Arvore inserir(Arvore aux, Node<Integer> no){
		if(aux.raiz == null){
			aux.raiz = no;
			aux.dir = new Arvore();
			aux.esq = new Arvore();
		}else if(no.dados < aux.raiz.dados){
			aux.esq = inserir(aux.esq, no);
		}else if(no.dados > aux.raiz.dados){
			aux.dir = inserir(aux.dir, no);
		}
		return aux;
	}


	public String imprimir(Arvore aux, Node<Integer> no){
		String resultado = "";
		while(no != null){
			resultado += this.imprimirSub(aux.raiz);
			resultado += this.imprimir(aux.esq, aux.raiz.esquerda);
			resultado += this.imprimir(aux.dir, aux.raiz.direita);
		}
		return resultado;
	}


	public String imprimirSub(Node<Integer> aux){
		String resultado = "";
		if(aux != null){
			resultado += aux.toString();
			if(aux.esquerda != null){
				resultado += aux.esquerda.toString();
			}
			if(aux.direita != null){
				resultado += aux.direita.toString();
			}
		}
		return resultado;
	}

	//	public String imprimir(Arvore aux) {
	//		String retorno;
	//		
	//
	//
	//		return retorno;
	//	}

	public void prefixadoTeste(Node<Integer> no) { 
		if(no != null){
			System.out.print(no.dados + " ");
			prefixado(no.esquerda);
			prefixado(no.direita);
		}
	}


	public Node<Integer> getRaiz() {
		return raiz;
	}

	public void setRaiz(Node<Integer> raiz) {
		this.raiz = raiz;
	}

	public Arvore getArvoreDireita() {
		return dir;
	}

	public void setArvoreDireita(Arvore arvoreDireita) {
		this.dir= arvoreDireita;
	}

	public Arvore getArvoreEsquerda() {
		return esq;
	}

	public void setArvoreEsquerda(Arvore arvoreEsquerda) {
		this.esq = arvoreEsquerda;
	}

	//	public void inserirNode(Node<Integer> no){
	//		//Se arvore está vazia raiz recebe o nó a ser inserido
	//		if(this.raiz == null){
	//			this.raiz = no;
	//		}else{
	//			if(no.dados >= this.raiz.dados){
	//				if(this.arvoreDireita == null){
	//					this.arvoreDireita = new ArvoreAVL();
	//				}
	//				this.arvoreDireita.inserirNode(no);
	//			}else if(no.dados < this.raiz.dados){
	//				if(raiz.esquerda != null){
	//					this.arvoreEsquerda = new ArvoreAVL();
	//				}
	//				this.arvoreEsquerda.inserirNode(no);
	//			}
	//		}
	//	}

	//	public void treeInsert(Node<Integer> raiz, Node<Integer> no){
	//		Node y = null;
	//		Node x = this.raiz;
	//		while(x != null){
	//			y = x;
	//			if()			
	//			}
	//		}
	//	}


	public void prefixado(Node<Integer> no) { 
		if(no != null){
			System.out.print(no.dados + " ");
			prefixado(no.esquerda);
			prefixado(no.direita); 
		}
	}


}
