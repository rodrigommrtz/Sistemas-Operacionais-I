package view;
import java.util.Random;
import controle.Metodos;


public class Principal {

	public static void main(String[] args) {

		int sapos;
		int pulo;
		Random numeroAleatorio = new Random();
		
		System.out.println("          Corrida de sapos          "
					   +"\n_____________________________________\n");									
			for (int i=0; i<5; i++) { // qtde de pulos de cada ciclo
				pulo = numeroAleatorio.nextInt(25); // tamanho do pulo do sapo
					for(int j=0; j<5; j++) {
						sapos = numeroAleatorio.nextInt(5); // 5 sapos (threads no jogo)
							Thread envioSapos = new Metodos(sapos, pulo);
							envioSapos.start();
				}
			}
		
		}		
	}
	