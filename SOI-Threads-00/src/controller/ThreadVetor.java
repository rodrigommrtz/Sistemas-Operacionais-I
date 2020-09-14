package controller;
	
	public class ThreadVetor extends Thread {
		
		private int numero;
		private int[] vetor;
		
		public ThreadVetor(int numero, int[] vetor) {
			this.numero = numero;
			this.vetor = vetor;
		}
		
		public void run() {
			
			double inicio = System.currentTimeMillis();
			
			if(numero % 2 == 1) {
				for(int i=0; i<vetor.length; i++); 
				} else {
				for(int posicao: vetor);			
				}
			
			double fim = System.currentTimeMillis() - inicio;
					
			if(numero % 2 == 1) {			
				System.out.println("Tempo para leitura da Thread ímpar: " + fim + " ms");
			} else {
				System.out.println("Tempo para leitura da Thread par: " + fim + " ms");
				 // o tempo tem dado 00 ms, exceto se aumentarmos o tamanho do vetor
			}
		}
	}

	
	
	
	
	
