package ArvoreRubroNegra;

import java.util.Scanner;
///++++ DUVIDAS +++++///
/*
 * PERGUNTAR AO PROFESSOR SE DEVE SER CRIADO UM NOVO ATRIBUTO PARA ARVORE CHAMADO NIL E TODAS AS FOLHAS 
 * E O PAI DA RAIZ DEVE DEVEM APONTAR PARA ELE (RESPONDIDA)
 * 
 * 
 * */
public class ArvoreRN {
	Node<Integer> raiz;
	Node<Integer> nil;

	static String vermelho = "vermelho".toUpperCase(); 
	static String preto = "preto".toUpperCase();

	public static void main(String[] args) {
		ArvoreRN arvore = new ArvoreRN();

		int elementos, cor;
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

			System.out.println("Digite 1 para vermelho e 2 para preto");

			cor = entrada.nextInt();
			if(cor == 1){
				aux.setCor(vermelho);
			}else if(cor == 2){
				aux.setCor(preto);
			}else{
				System.out.println("cor invalida");
			}
			aux.setDados(valor);
			arvore.inserir(arvore, aux);

		}
		
		//		System.out.println(TreePrint.PrintableNode(arvore.raiz));

				arvore.teste(arvore.raiz);
	}

	//CONSTRUTOR DEFAULT PARA INSTANCIAR A ARVORE;
	public ArvoreRN(){
		this.nil = new Node(preto, "nil");
		this.raiz = new Node();
		this.raiz = this.nil;
	}

	//METODO PARA INSERIR NÓS EM UMA ARVORE RUBRO-NEGRA	
	public void inserir(ArvoreRN T, Node<Integer> z){
		Node<Integer> y = new Node<Integer>();
		Node<Integer> x = T.raiz;

		while(x != T.nil){
			y = x;
			if(z.getDados() < x.getDados()){
				x = x.getEsquerda();
			}else{
				x = x.getDireita();
			}
		}
		z.setPai(y);
		if(y.getDados() == null){
			T.raiz = z;
			//Editado 10/11
			T.raiz.setPai(T.nil);
			T.raiz.setDireita(T.nil);
			T.raiz.setEsquerda(T.nil);
		}else if(z.getDados() < y.getDados()){
			y.setEsquerda(z);			 
		}else{
			y.setDireita(z);
		}
		z.setEsquerda(T.nil);
		z.setDireita(T.nil);
		z.setCor(vermelho);
		this.insertFixup(T, z);
	}

	//METODO AUXILIAR PARA CONSERTAR A INSERÇÃO DE ELEMENTOS NA ARVORE CASO NECESSÁRIO
	public void insertFixup(ArvoreRN arvore, Node<Integer> no){
		while(no.getPai().getCor().equals(vermelho)){
			if(no.getPai() == no.getPai().getPai().getEsquerda()){
				Node<Integer> aux = no.getPai().getPai().getDireita();
				if(aux.getCor().equals(vermelho)){
					no.getPai().setCor(preto);
					aux.setCor(preto);
					no.getPai().getPai().setCor(vermelho);
					no = no.getPai().getPai();
				}else if(no == no.getPai().getDireita()){
					no = no.getPai();
					this.leftRotate(arvore, no);
					no.getPai().setCor(preto);
					no.getPai().getPai().setCor(vermelho);
					this.rightRotate(arvore, no.getPai().getPai());
				}
			}else{
				Node<Integer> aux = no.getPai().getPai().getEsquerda();
				if(aux.getCor().equals(vermelho)){
					no.getPai().setCor(preto);
					aux.setCor(preto);
					no.getPai().getPai().setCor(vermelho);
					no = no.getPai().getPai();
				}else if(no == no.getPai().getEsquerda()){
					no = no.getPai();
					this.leftRotate(arvore, no);
					no.getPai().setCor(preto);
					no.getPai().getPai().setCor(vermelho);
					this.rightRotate(arvore, no.getPai().getPai());
				}
			}
		}
		arvore.raiz.setCor(preto);
	}

	//METODO PARA REALIZAR ROTAÇÃO ESQUERDA
	public void leftRotate(ArvoreRN arvore, Node<Integer> no){
		Node<Integer> aux = no.getDireita();
		no.setDireita(aux.getEsquerda());
		aux.getEsquerda().setPai(no);
		aux.setPai(no.getPai());
		if(no.getPai() == null){
			arvore.raiz = aux;
		}else if( no == no.getPai().getEsquerda()){
			no.getPai().setEsquerda(aux);
		}else{
			no.getPai().setDireita(aux);
		}
		aux.setEsquerda(no);
		no.setPai(aux);
	}


	//METODO PARA REALIZAR ROTACAO DIREITA
	public void rightRotate(ArvoreRN arvore, Node<Integer> no){
		Node<Integer> aux = no.getEsquerda();
		no.setEsquerda(aux.getDireita());
		aux.getDireita().setPai(no);
		aux.setPai(no.getPai());
		if(no.getPai() == null){
			arvore.raiz = aux;
		}else if(no == no.getPai().getDireita()){
			no.getPai().setDireita(aux);
		}else{
			no.getPai().setEsquerda(aux);
		}
		aux.setDireita(no);
		no.setPai(aux);
	}

	
	public void teste(Node<Integer> no){
		if(no != null){ 
			System.out.println(no.toString()); 
			teste(no.getEsquerda());
			teste(no.getDireita()); 
		}
	}
	
	
	
}
