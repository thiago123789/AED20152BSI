package Ordenacao;

public class HeapSort {
	private int tamanhoHeap;
	private int[] vetorHeap;

	public HeapSort(int[] vetor){
		this.tamanhoHeap = vetor.length;
		this.vetorHeap = new int[vetor.length];
		this.vetorHeap = vetor;
	}
	
	public void algoritmoHeap(){
		this.construirMaxHeap();
		int t = this.vetorHeap.length;
		for(int i = t-1; i >= 0 ; i--){
			int aux = this.vetorHeap[0];
			this.vetorHeap[0] = this.vetorHeap[i];
			this.vetorHeap[i] = aux;
			this.tamanhoHeap -= 1;
			this.max_Heapify(0);
		}
	}
	
	public void construirMaxHeap(){
		for(int k = (((this.vetorHeap.length)-1)/2) ; k > -1; k--){
				this.max_Heapify(k);
		}
	}
	
	private void max_Heapify(int posicao){
		int maior;
		int l = valorLeft(posicao);
		int r = valorRight(posicao);
		if ((l <= this.tamanhoHeap-1) && (this.vetorHeap[l] > this.vetorHeap[posicao])){
			maior = l;
		}else{
			maior = posicao;
		}
		if ((r <= this.tamanhoHeap-1) && (this.vetorHeap[r] > this.vetorHeap[maior])){
			maior = r;
		}
		if (maior != posicao){
			int aux = this.vetorHeap[posicao];
			this.vetorHeap[posicao] = this.vetorHeap[maior];
			this.vetorHeap[maior] = aux;
			this.max_Heapify(maior);
		}
	}
	
	private int valorLeft(int posicao){
		int i = (2*posicao)+1;
		return i;
	}
	
	private int valorRight(int posicao){
		int i = (2*posicao)+2;
		return i;
	}
	
}

