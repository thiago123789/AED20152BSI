package Ordenacao;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		int tamanhoArranjo;
		System.out.println("Digite o tamanho do arranjo: ");
		Scanner a = new Scanner(System.in);
		tamanhoArranjo = a.nextInt();
		int[] vetor = new int[tamanhoArranjo];
		int i;
		for(i = 0; i < tamanhoArranjo; i++){
			System.out.println("Digite o elemento "+(i+1)+" do arranjo: ");
			vetor[i] = a.nextInt();
		}
		
		HeapSort h = new HeapSort(vetor);
		h.algoritmoHeap();
//		h.construirMaxHeap();
	
//		Quicksort q = new Quicksort(vetor);
//		q.fazerQuick(0, tamanhoArranjo-1);
		
		for(i = 0; i < vetor.length; i++){
			System.out.print(vetor[i]+" ");
		}
		
		
	}

}
