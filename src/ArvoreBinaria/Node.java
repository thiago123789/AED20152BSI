package ArvoreBinaria;

public class Node<T> {
	Node<T> pai;
	Node<T> esquerda;
	Node<T> direita;
	T dados;
	
	public Node() {}
	
	public Node(T i){
		this.dados = i;
	}
	
	public T info(Node<T> a){
		return a.dados;
	}
	
	public Node<T> filhoDireita(Node<T> no){
		return no.direita;
	}
	
	public Node<T> filhoEsquerda(Node<T> no){
		return no.esquerda;
	}
	
	public Node<T> pai(Node<T> no){
		if (no.pai == null){
			return null;
		}else{
			return no.pai;
		}
	}
	
	public boolean daDireita(Node<T> no){
		boolean resultado = false;
		if(no == no.pai.direita){
			resultado = true;
		}
		return resultado;
	}
	
	public boolean daEsquerda(Node<T> no){
		boolean resultado = false;
		if(no == no.pai.esquerda){
			resultado = true;
		}
		return resultado;
	}
	
	public Node<T> irmao(Node<T> no){
		Node<T> aux = null;
		if(this.daDireita(no)){
			if(no.pai.esquerda != null){
				aux = no.pai.esquerda;
			}
		}else if(this.daEsquerda(no)){
			if(no.pai.direita != null){
				aux = no.pai.direita;
			}
		}
		return aux;		
	}
	
	public Node<T> getPai(){
		return this.pai;
	}
	
	public Node<T> getDireita(){
		return this.direita;
	}
	
	public Node<T> getEsquerda(){
		return this.esquerda;
	}
	
	public T getInfo(){
		return this.dados;
	}
	
	public void setDireita(Node<T> no){
		this.direita = no;
	}
	
	public void setEsquerda(Node<T> no){
		this.esquerda = no;
	}
	
	public void setDados(T valor){
		this.dados = valor;
	}
	
	@Override
	public String toString(){
		String resultado = "";
		resultado += "\n";
		if(this != null){
			resultado += "No: "+this.getInfo().toString();
		}
		if(this.pai == null){
			resultado += "\nPai: nulo ";
		}else{
			resultado += "\nPai: "+this.pai.getInfo().toString();
		}
		resultado += "\nFilho>\\/";
		if(this.direita != null){
			resultado += "\nD: "+this.getDireita().getInfo();
		}else{
			resultado += "\nD: none ";
		}
		if(this.esquerda != null){
			resultado += "\nE: "+this.getEsquerda().getInfo();
		}else{
			resultado += "\nE: none ";
		}
		
		return resultado;
	}
	
}
