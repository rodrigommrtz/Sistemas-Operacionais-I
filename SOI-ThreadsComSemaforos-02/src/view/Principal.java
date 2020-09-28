package view;

import java.util.concurrent.Semaphore;
import controller.Threads;


public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for(int i=0; i<5; i++) {
			Thread pratos = new Threads(i, semaforo);
			pratos.start();
		}
	}
}


