package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Threads extends Thread{

	private Semaphore semaforo;
	private int prato;
	private String pratoId;
	
	public Threads(int i, Semaphore semaforo) {
		this.prato = i;
		this.semaforo = semaforo;
	}
	
	
	@Override
	public void run() {
		
		cozinhar();
		try {
			semaforo.acquire();
			entregarPrato();
		} catch (Exception erro) {			
		} finally {
			semaforo.release();
		}
	}
	
	
	
	private void cozinhar() {
		int tempo;
		
		Random numeroAleatorio = new Random();
		
		if(prato % 2 == 0 ) {
			pratoId = "Lasanha";			
			tempo = numeroAleatorio.nextInt((600)+600);			
		} else {
			pratoId = "Sopa de Cebola";
			tempo = numeroAleatorio.nextInt((300)+500);			
		}
		
		System.out.println((prato +1) + "º prato iniciado: " + pratoId);
		
		
		for (double i = 0; i <= tempo; i+=100){ // laço do for para incremento de 0,1s (100 milissegundos) 
			try {
				sleep(100); // envio da info a cada 0,1 seg (100 milissegundos)
				int percentual = (int) ((i / tempo) * 100); // para transfomrar o número em XX %
				System.out.println((prato +1) +"º prato - conluído em: " +percentual +"% ");
			} catch (Exception erro) {				
			}
		}
		
	}
	
	
	private void entregarPrato() {
		try {
			sleep(500);
			System.out.println((prato +1) +"º prato - " +pratoId +": Entregue");
		} catch (Exception erro) {			
		}
	}
}