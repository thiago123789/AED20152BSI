package Ordenacao;


public class Quicksort {
	int[] vetorQuick;
	
	public Quicksort(int[] vetor){
		this.vetorQuick = vetor;
	}
	
	public void fazerQuick(int inicio, int fim){
		this.algoritmoQuick(this.vetorQuick, inicio, fim);
	}
	
	public void algoritmoQuick(int[] vetor,int inicio, int fim){
		int posicaoPivo;
		if (inicio < fim){
			posicaoPivo = this.partition(inicio, fim);
			this.algoritmoQuick(this.vetorQuick, inicio, posicaoPivo-1);
			this.algoritmoQuick(this.vetorQuick, posicaoPivo+1, fim);
		}
	}
	
	public int partition(int inicio, int fim){
		int x = this.vetorQuick[fim];
	    int i = inicio - 1;
		for(int j = inicio; j<fim; j++){
			if (this.vetorQuick[j] <= x){
				i++;
				int aux = this.vetorQuick[i];
				this.vetorQuick[i] = this.vetorQuick[j];
				this.vetorQuick[j] = aux;
			}
		}
		int aux2 = this.vetorQuick[i+1];
		this.vetorQuick[i+1] = this.vetorQuick[fim];
		this.vetorQuick[fim] = aux2;
		return i+1;
	}
		
}
