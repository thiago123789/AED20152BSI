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
			System.out.println("Elemento n�o existe");
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
			System.out.println("Elemento n�o existe");
		}
		
		
	}
	
	//Lista todos os elementos da lista
	public String listarElementos(){
		int i = 1;
		No<T> aux = this.comeco; // Cria um n� auxiliar que recebe o primeiro elemento da lista;
		String resultado = ""; //variavel para retorno do metodo;
		if(aux!= null){
			while(aux!=null){ // la�o para correr todas posicoes da lista ate aux ser null, ou seja, n�o haver mais elementos;
				resultado += i+"�- "+aux.valor+"\n";//adiciona na variavel o valor de aux nesse la�o;
				aux = aux.proximo;//incrementa uma posi��o em aux para passar para o proximo elemento da lista.
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
