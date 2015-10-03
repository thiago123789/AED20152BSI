package Listas;
//Lista simples encadeada
public class List<T> {
	No<T> comeco;
	No<T> fim;
	
	
	public void alterarElemento(int elemento, int alterarPara){
		No<Integer> aux = (No<Integer>) this.comeco;
		if(this.pesquisarElemento(elemento)){
			while(aux != null){
				if(aux.valor == elemento){
					aux.valor = alterarPara;
				}
				aux = aux.proximo;
			}
		}else{
			System.out.println("Elemento não existe");
		}
	}
	
	public void adicionarNoFim(No<T> n){
		if(this.comeco == null){
			this.comeco = n;
			this.fim = n;
		}else{
			No<T> aux = fim;
			aux.proximo = n;
			this.fim = n;
		}
	}
	public boolean pesquisarElemento(int n){
		boolean achou = false;
		No<Integer> aux = (No<Integer>) this.comeco;
		while(aux!=null){
			if(aux.valor == n){
				achou = true;
				break;
			}
			aux = aux.proximo;
		}
		return achou;
	}
	
	public void removerNoDaLista(int n){
		No<Integer> aux = (No<Integer>) this.comeco;
		if(this.pesquisarElemento(n)){
			while(aux!=null){
				if((aux == this.comeco) && (aux.valor == n)){
					this.comeco = (No<T>) aux.proximo;
				}else if((aux.proximo != null) && (aux.proximo.valor == n)){
					aux.proximo = aux.proximo.proximo;
					break;
				}
				aux = aux.proximo;
			}
		}else{
			System.out.println("Elemento não existe");
		}
		
		
	}
	
	//Lista todos os elementos da lista
	public String listarElementos(){
		int i = 1;
		No<T> aux = this.comeco; // Cria um nó auxiliar que recebe o primeiro elemento da lista;
		String resultado = ""; //variavel para retorno do metodo;
		if(aux!= null){
			while(aux!=null){ // laço para correr todas posicoes da lista ate aux ser null, ou seja, não haver mais elementos;
				resultado += i+"º- "+aux.valor+"\n";//adiciona na variavel o valor de aux nesse laço;
				aux = aux.proximo;//incrementa uma posição em aux para passar para o proximo elemento da lista.
				i++;
			}
		}else{
			resultado = "Lista vazia";
		}
		return resultado;
	}
	
}

class No<T>{
	T valor;
	No<T> proximo;
}
