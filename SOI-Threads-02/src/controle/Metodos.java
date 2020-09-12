package controle;

public class Metodos extends Thread {
	
	private int soma[] = new int[3]; //geração de um vetor private, para coletar os dados do vetor[]
	private int linha; // variavel para receber o resultado de i
	
	
	public Metodos(int[] vetor, int i) {
		this.soma = vetor; 
		this.linha = i;	
	}

	
	@Override
	public void run() {	
		System.out.println("Somatório da linha "+linha +": "+soma[linha]);
		// sendo linha o índice para indicar que houve uma thread (fora da sequencia) e o resultado da soma para aquela linha 
	}
	
		
	public static void tempo(int[][]matriz, int[]vetor) {
	// recebendo os paramentros do programa principal para que possa ser comparado com o resultado das threads
		try {
			int tempo = 10;
				sleep(tempo);
				// aplicar o conceito do tempo, para reslver o problema de mostrar essa tela junto com as threads
				// a função sleep precisa de um try/catch
				System.out.println("\n\nTeste para verificação dos resultados"+
						"\n=====================================");
				for (int i=0; i<3; i++) {
					for(int j=0; j<5; j++) {
						System.out.print(matriz[i][j]+", ");
					}
					System.out.println("--> Soma da linha " +i +" = " +vetor[i]);
				}
		}catch (Exception erro) {
		}
			
	}
	
}

