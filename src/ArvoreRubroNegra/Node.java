package ArvoreRubroNegra;

import ArvoreRubroNegra.TreePrint.PrintableNode;

public class Node<T> implements PrintableNode{
	String cor;
	Node<T> pai;
	Node<T> esquerda;
	Node<T> direita;
	T dados;
	
	public Node(){
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Node<T> getPai() {
		return pai;
	}
	public void setPai(Node<T> pai) {
		this.pai = pai;
	}
	public Node<T> getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(Node<T> esquerda) {
		this.esquerda = esquerda;
	}
	public Node<T> getDireita() {
		return direita;
	}
	public void setDireita(Node<T> direita) {
		this.direita = direita;
	}
	public T getDados() {
		return dados;
	}
	public void setDados(T dados) {
		this.dados = dados;
	}
	
	@Override
	public String toString(){
		String resultado = "";
		if(this != null){
			resultado += "\nNó: "+this.getDados();
		}
		if(this.pai == null){
			resultado += "\nPai: nulo";
		}else{
			resultado += "\nPai: "+this.pai.getDados();
		}
		resultado += "\nFilho>>";
		if(this.esquerda == null){
			resultado += "\nE: null";
		}else{
			resultado += "\nE: "+this.esquerda.getDados();
		}
		if(this.direita == null){
			resultado += "\nD: null";
		}else{
			resultado += "\nD: "+this.direita.getDados();
		}
		if(this.cor == "Preto".toUpperCase()){
			resultado += "\nCor: Preto";
		}else{
			resultado += "\nCor: Vermelho";
		}
		return resultado;
	}

	@Override
	public PrintableNode getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintableNode getRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
