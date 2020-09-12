package view;
import java.util.Random;
import controle.Metodos;


public class Principal {

	public static void main(String[] args) {
		
		
		int matriz[][] = new int[3][5]; // matriz 3x5 para coleta dos n�meros
		int vetor[] = new int[3]; //vetor para coleta do somat�rio
		
		Random numeroAleatorio = new Random();		
		System.out.println("Soma dos valores dos n�meros por linha\n"
						+ "======================================");

		for (int i=0; i<3; i++) {				
			for(int j=0; j<5; j++) {
				matriz[i][j] = (numeroAleatorio.nextInt(10)); //coleta de n�mero aleat�rios de 0 a 10
				vetor[i] = vetor[i] + matriz[i][j]; // soma dos valores por linha (�ndice i)
			}
		}
		
		for (int i=0; i<3; i++) {
			Thread envio = new Metodos(vetor, i); 
			envio.start();
			// envia para a Thread o resultado do vetor[] e posi��o do i, para facilitar a indica��o da f
		}		
	
			Metodos.tempo(matriz, vetor);
		
		}
		
}


	


	