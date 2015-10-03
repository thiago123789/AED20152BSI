package Listas.Duplamente;


public class ListDupla<T> {
	No<T> comeco;
	No<T> fim;
	
	
	//ADICIONA UM ELEMENTO NO FIM DA LISTA
	public void adicionarNoFim(No<T> n){
		if(this.comeco == null){
			this.comeco = n;
			this.fim = n;
		}else{
			No<T> aux = this.fim;
			aux.proximo = n;
			n.anterior = aux;
			this.fim = n;
		}
	}

	
	
	//METODO QUE RETORNA UMA STRING COM TODOS OS ELEMENTOS EXISTENTES NA LISTA
	public String listarElementos(){
		String resultado = "";
		if(this.existeElementos()){
			int i = 1;
			No<Integer> aux = (No<Integer>) this.comeco;
			while(aux!=null){
				resultado += i+"º- "+aux.valor+"\n";
				i++;
				aux = aux.proximo;
			}
		}else{
			resultado = "Não existem elementos na lista";
		}
		return resultado;

	}

	//REMOVE UM NUMERO DE QUALQUER LUGAR DA LISTA SE 
	public void removerNoDaLista(int buscaR){
		No<Integer> aux = (No<Integer>) this.comeco;
		if(this.pesquisarElemento(buscaR)){
			while(aux != null){
				if(aux.valor == buscaR){
					if (aux == this.comeco && this.comeco == this.fim){
						this.comeco = null;
						this.fim = null;
						break;
					}else if (aux == this.comeco && this.comeco != this.fim){
						aux.proximo.anterior = null;
						this.comeco = (No<T>) aux.proximo;
					}else if (aux == this.fim){
						aux.anterior.proximo = null;
						this.fim = (No<T>) aux.anterior;
					}else{
						aux.anterior.proximo = aux.proximo;
						aux.proximo.anterior = aux.anterior;
					}
				}
				aux = aux.proximo;
			}
		}else{
			System.out.println("Numero a ser excluido não existe");
		}

	}

	public boolean pesquisarElemento(int buscar){
		boolean achou = false;
		No<Integer> aux = (No<Integer>) this.comeco;
		while(aux!=null){
			if(aux.valor == buscar){
				achou = true;
				break;
			}
			aux = aux.proximo;
		}
		return achou;
	}

	public void alterarElemento(int antes, int depois){
		No<Integer> aux = (No<Integer>) this.comeco;
		if(this.pesquisarElemento(antes)){
			while(aux!=null){
				if(aux.valor == antes){
					aux.valor = depois;
				}
				aux = aux.proximo;
			}
		}else{
			System.out.println("Elemento a ser alterado não existe.");
		}
	}

	public String tabelarLista(){
		String resultado = "";
		resultado = "Ante | Valor | Prox\n";
		No<Integer> aux = (No<Integer>) this.comeco;
		while(aux != null){
			No<Integer> aux1 = aux.anterior, aux2 = aux.proximo;
			if(aux1 == null && aux2 == null){
				resultado += "null | "+aux.valor+" | null\n";
			}else if(aux1 != null && aux2 == null){
				resultado += aux.anterior.valor+" | "+aux.valor+" | null\n";
			}else if(aux1 == null && aux2 != null){
				resultado += "null | "+aux.valor+" | "+aux.proximo.valor+"\n";
			}else if(aux1 != null && aux2 != null){
				resultado += aux.anterior.valor+" | "+aux.valor+" | "+aux.proximo.valor+"\n";

			}
			aux = aux.proximo;
		}
		return resultado;
	}

	public boolean existeElementos(){
		boolean existe = false;
		if(this.comeco != null){
			existe = true;
		}
		return existe;
	}


}

class No<T>{
	T valor;
	No<T> anterior;
	No<T> proximo;
}