package ArvoreRubroNegra;

import java.util.Scanner;
///++++ DUVIDAS +++++///
/*
 * PERGUNTAR AO PROFESSOR SE DEVE SER CRIADO UM NOVO ATRIBUTO PARA ARVORE CHAMADO NIL E TODAS AS FOLHAS 
 * E O PAI DA RAIZ DEVE DEVEM APONTAR PARA ELE (RESPONDIDA)
 * 
 *
 * 
 * */
public class ArvoreRN {
	Node<Integer> raiz;//RAIZ DA ARVORE RUBRO-NEGRA
	Node<Integer> nil;//NO NIL (COR PRETA, DADOS NIL) AUXILIAR (SE NAO TIVER ESTA BOSTA VAI BUGAR)

	static String vermelho = "vermelho".toUpperCase();//STRING PARA COR VERMELHAR(TOUPERCASE PRA DEIXAR TUDO MAIUSCULO)
	static String preto = "preto".toUpperCase();//STRING PARA COR PRETA ---------

	//METODDO MAIN PARA TESTE DOS METODOS DA ARVORE
	public static void main(String[] args) {
		ArvoreRN arvore = new ArvoreRN();//INSTACIANDO A ARVORE RUBRO-NEGRA

		int elementos, cor, delete;/*INICIALIZANDO VARIAVEL "ELEMENTOS" PARA CONTAGEM DOS ELEMENTOS A SEREM INSERIDOS PELO USUÁRIO
							E COR COMO VARIAVEL AUXILIAR PARA SER COLOCADA NO NÓ A SER INSERIDO
		 */
		Scanner entrada = new Scanner(System.in);
		System.out.println("Quantos elementos deseja inserir na arvore: ");
		elementos = entrada.nextInt();//RECEBE O QUE O USUÁRIO DIGITA E SALVA NA VARIAVEL "ELEMENTOS"
		for(int i = 0; i < elementos; i++){//LAÇO PARA INSERIR A QUANTIDADE DE ELEMENTOS QUE O USUÁRIO ESCOLHEU
			int valor;//VARIÁVEL PARA GUARDAR O VALOR DO NÓ QUE O USUÁRIO VAI DIGITAR
			Node<Integer> aux = new Node<Integer>();//INSTANCIANDO UM NÓ NULLO PARA RECEBER OS VALORES DIGITADOS PELO USUÁRIO
			System.out.println("Digite o "+(i+1)+"º elemento: ");
			valor = entrada.nextInt();//A VARIÁVEL "VALOR" VAI RECEBER O PROXIMO INTEIRO DIGITADO PELO USUÁRIO
			aux.setDados(valor);//SETA O VALOR DO NÓ AUXILIAR CRIADO; 
			arvore.inserir(arvore, aux);//INSERE O NÓ AUXLIAR NA ARVORE RUBRO NEGRA

		}

		System.out.println("Delete um nó");
		delete = entrada.nextInt();
		Node<Integer> aux1  = new Node<Integer>();
		aux1.setDados(delete);
		if(arvore.existeNode(arvore, aux1)){
			System.out.println("existe");
		}else{
			System.out.println("nao existe");
		}
		//		arvore.buscaRemove(arvore, aux1);
		arvore.teste(arvore, arvore.raiz);//IMPRIME A ARVORE
	}
	//----------------------------FIM DO MAIN ------------------------------------


	//CONSTRUTOR DEFAULT PARA INSTANCIAR A ARVORE;
	public ArvoreRN(){
		this.nil = new Node(preto, "nil");//INICIALIZA O ATRIBUTO NIL PARA OBEDECER AS REGRAS DA ARVORE RUBRO NEGRA
		this.nil.setPai(this.nil);
		this.nil.setDireita(this.nil);
		this.nil.setEsquerda(this.nil);
		this.raiz = new Node();//RAIZ RECEBE UM NÓ
		this.raiz = this.nil;//ARVORE COMEÇA VAZIA, ENTÃO RAIZ DA ARVORE RECEBE O NÓ NIL;
	}

	//METODO PARA INSERIR NÓS EM UMA ARVORE RUBRO-NEGRA	
	public void inserir(ArvoreRN T, Node<Integer> z){
		Node<Integer> y = T.nil;		
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
		if(y.equals(T.nil)){
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
				Node<Integer> aux = no.getPai().getPai().getEsquerda();//inverti para teste, erro resolvido
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
				Node<Integer> aux = no.getPai().getPai().getDireita();//mudei para getdireita, erro resolvido.
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


	public void teste(ArvoreRN T, Node<Integer> no){
		if(no != T.nil){
			System.out.println(no.toString()); 
			teste(T, no.getEsquerda());
			teste(T, no.getDireita()); 
		}
	}

	public void transplant(ArvoreRN T, Node<Integer> nodeA, Node<Integer> nodeB){
		if(nodeA.getPai() == T.nil){
			T.raiz = nodeB;
		}else if(nodeA == nodeA.getPai().getEsquerda()){
			nodeA.getPai().setEsquerda(nodeB);
		}else{
			nodeA.getPai().setDireita(nodeB);
			nodeB.setPai(nodeA.getPai());
		}
	}

	//auxiliar para deletar;
	public Node<Integer> arvoreMinimo(Node<Integer> no){
		Node<Integer> nil = new Node(preto, "nil");
		while (no.getEsquerda() != nil){
			no = no.getEsquerda();
		}
		return no;
	}

	//METODO PARA DELETAR NODE
	public void delete(ArvoreRN T, Node<Integer> no){
		Node<Integer> aux = new Node<Integer>();
		Node<Integer> x = new Node<Integer>();
		aux = no;
		String auxCorOriginal = aux.getCor();
		if(no.getEsquerda() == T.nil){
			x = no.getDireita();
			this.transplant(T, no, no.getDireita());
		}else if(no.getDireita() == T.nil){
			x = no.getEsquerda();
			this.transplant(T, no, no.getEsquerda());
		}else{
			aux = this.arvoreMinimo(no.getDireita());
			auxCorOriginal = aux.getCor();
			x = aux.getDireita();
			if(aux.getPai().equals(no)){
				x.setPai(aux);
			}else{
				this.transplant(T, aux, aux.getDireita());
				aux.setDireita(no.getEsquerda());
				aux.getEsquerda().setPai(aux);
				aux.setCor(no.getCor());
			}
		}
		if(auxCorOriginal.equals(preto)){
			this.deleteFixup(T, x);
		}
	}

	//COMPLETO FALTA TESTAR
	public void deleteFixup(ArvoreRN T, Node<Integer> no){
		while(!(no.equals(T.raiz)) && (no.getCor().equals(preto))){
			if(no.equals(no.getPai().getEsquerda())){
				Node<Integer> aux = no.getPai().getDireita();
				if(aux.getCor().equals(vermelho)){
					aux.setCor(preto);
					no.getPai().setCor(vermelho);
					this.leftRotate(T, no.getPai());
					aux = no.getPai().getDireita();
				}
				if ((aux.getEsquerda().getCor().equals(preto))&&(aux.getDireita().getCor().equals(preto))){
					aux.setCor(vermelho);
					no = no.getPai();
				}else if(aux.getDireita().getCor().equals(preto)){
					aux.getEsquerda().setCor(preto);
					aux.setCor(vermelho);
					this.rightRotate(T, aux);
					aux = no.getPai().getDireita();
				}
				aux.setCor(no.getPai().getCor());
				no.getPai().setCor(preto);
				aux.getDireita().setCor(preto);
				this.leftRotate(T, no.getPai());
				no = T.raiz;
			}else{
				Node<Integer> aux = no.getPai().getEsquerda();
				if(aux.getCor().equals(vermelho)){
					aux.setCor(preto);
					no.getPai().setCor(vermelho);
					this.leftRotate(T, no.getPai());
					aux = no.getPai().getEsquerda();
				}
				if ((aux.getDireita().getCor().equals(preto))&&(aux.getEsquerda().getCor().equals(preto))){
					aux.setCor(vermelho);
					no = no.getPai();
				}else if(aux.getEsquerda().getCor().equals(preto)){
					aux.getDireita().setCor(preto);
					aux.setCor(vermelho);
					this.rightRotate(T, aux);
					aux = no.getPai().getEsquerda();
				}
				aux.setCor(no.getPai().getCor());
				no.getPai().setCor(preto);
				aux.getEsquerda().setCor(preto);
				this.leftRotate(T, no.getPai());
				no = T.raiz;
			}
		}
		no.setCor(preto);
	}

	//METODO PARA SABER SE UM NUMERO EXISTE NA ARVORE
	public boolean existeNode(ArvoreRN T, Node<Integer> no){
		boolean resultado = false;
		Node<Integer> y = T.nil;		
		Node<Integer> x = T.raiz;
		while(x != T.nil){
			y = x;
			if(no.getDados() < x.getDados()){
				x = x.getEsquerda();
				if((x != T.nil)){
					if(x.getDados().equals(no.getDados())){
						resultado = true;
						break;
					}
				}
			}else{
				x = x.getDireita();
				if((x != T.nil)){
					if(x.getDados().equals(no.getDados())){
						resultado = true;
						break;
					}
				}
			}
		}
		return resultado;
	}


	public Node<Integer> buscarNode(ArvoreRN T, Node<Integer> no){
		Node<Integer> retorno = new Node<Integer>();
		if(this.existeNode(T, no)){
			Node<Integer> y = T.nil;		
			Node<Integer> x = T.raiz;
			while(x != T.nil){
				y = x;
				if(no.getDados() < x.getDados()){
					x = x.getEsquerda();
					if(x.getDados().equals(no.getDados())){
						retorno = x;
						break;
					}
				}else{
					x = x.getDireita();
					if(x.getDados().equals(no.getDados())){
						retorno = x;
						break;
					}
				}
			}
		}

		return retorno;
	}

	public void buscaRemove(ArvoreRN T, Node<Integer> no){
		if(this.existeNode(T, no)){
			Node<Integer> y = T.nil;		
			Node<Integer> x = T.raiz;
			while(x != T.nil){
				y = x;
				if(no.getDados() < x.getDados()){
					x = x.getEsquerda();
					if(x.getDados().equals(no.getDados())){
						this.delete(T, x);
						break;
					}
				}else{
					x = x.getDireita();
					if(x.getDados().equals(no.getDados())){
						this.delete(T, x);
						break;
					}
				}
			}
		}
	}


}
