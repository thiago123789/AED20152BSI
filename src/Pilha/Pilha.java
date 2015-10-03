package Pilha;

import java.util.Scanner;
import java.util.Stack;

public class Pilha {
	public static void main(String[] args) {
		Stack<Integer> pilha = new Stack<Integer>();
		int quantidade;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Quantos elementos deseja inserir? ");
		quantidade = scanner.nextInt();
		
		for(int i = 0; i < quantidade; i++){
			int numero;
			System.out.println("Digite o "+(i+1)+"º numero: ");
			numero = scanner.nextInt();
			pilha.push(numero);
		}
		
		while(!pilha.empty()){
			System.out.println(pilha.pop());
		}
		
		
	}
}
