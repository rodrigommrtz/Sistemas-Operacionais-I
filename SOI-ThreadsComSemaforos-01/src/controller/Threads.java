package controller;
import java.util.Random;

public class Threads extends Thread{

	private int ThreadId;

	public Threads(int ThreadId) {
		this.ThreadId = ThreadId;
	}

	@Override
	public void run() {

		int tempo = 0;
		int tempoBd = 0;
		Random numeroAleatorio = new Random();

		if(ThreadId % 3 == 1) {
			tempo = numeroAleatorio.nextInt((800)+200); 

			calculos(tempo);
			transacaoDeBD(1000);
			calculos(tempo);
			transacaoDeBD(1000);

		} else if(ThreadId % 3 == 2) {
			tempo = numeroAleatorio.nextInt((1000)+500);

			calculos(tempo);
			transacaoDeBD(1500);
			calculos(tempo);
			transacaoDeBD(1500);
			calculos(tempo);
			transacaoDeBD(1500);

		} else {
			tempo = numeroAleatorio.nextInt((1000)+1000);

			calculos(tempo);
			transacaoDeBD(1500);
			calculos(tempo);
			transacaoDeBD(1500);
			calculos(tempo);
			transacaoDeBD(1500);
		}

		System.out.println("Thread " + ThreadId + " fim");
	}

	private void calculos(int tempo) {
		try {
			System.out.println("Thread " + ThreadId + " em cálculo");
			sleep(tempo);
		} catch (Exception erro) {
		}
	}


	private void transacaoDeBD(int tempoBd) {
		try {
			System.out.println("Thread " + ThreadId + " em transação de BD");
			sleep(tempoBd);
		} catch (Exception erro) {
		}
	}
}