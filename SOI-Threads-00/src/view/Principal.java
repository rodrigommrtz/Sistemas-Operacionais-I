package view;
	
	import java.util.Random;
	
	import controller.ThreadVetor;
	
	public class Principal {
	
		public static void main(String[] args) {
		
			
			int[] vetor = new int[1000];
			Random numeroAleatorio = new Random();
			
			for(int posicao: vetor) {
				int numero = numeroAleatorio.nextInt(99)+1;
				vetor[posicao] = numero;
			}
			
			for(int i=0; i<2; i++) {			
				Thread envia = new ThreadVetor(i, vetor);
				envia.start();		
			}
		}
	}
