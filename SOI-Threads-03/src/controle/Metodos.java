package controle;

public class Metodos extends Thread {


	private static int numeroSapo;
	private int valorPulo; 
	private static int[] vetor = new int[5];
	
	
	public Metodos(int sapos, int pulos) {
		this.numeroSapo = sapos;
		this.valorPulo = pulos;
	
	}

		
	@Override
	public void run() {
		
		vetor[numeroSapo] = vetor[numeroSapo] + valorPulo;
		System.out.println("O Sapo "+numeroSapo +" pulou "+valorPulo +" metros. Total acumulado: "+vetor[numeroSapo]);	
		
		if(vetor[numeroSapo]>150) {			
			//int campeao = vetor[numeroSapo];
			try {
				sleep(10);
				System.out.println("O Sapo " +numeroSapo + " é o Campeão!");
			}catch (Exception erro) {			
			}			
		}		
	}
}


	
	

