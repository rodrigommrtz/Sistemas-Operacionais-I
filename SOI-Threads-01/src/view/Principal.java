package view;

import controle.ThreadId;

public class Principal {

	public static void main(String[] args) {

		System.out.println("\nThreads finalizadas na sequencia abaixo \n=======================================");
		for (int Id=0; Id<5; Id++) {				
			Thread id = new ThreadId(Id);
			id.start();
		}
		
		
		
		
	}

}
