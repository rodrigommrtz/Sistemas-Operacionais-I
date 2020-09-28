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
		
		
		for (float i = 0; i <= tempo; i+=20){ 
			
/* 	For com passo de 20 em 20 para agilizar a demonstração do número, pois com o passo a 1 (i++),
 * 	o programaa teria mais linhas a serem impressas para indicar o percentual do 0% até o 100%.
 * 
 * 	O tempo de cada prato é fixo (pelo valor do Random) e não é alterado. O for de 20 em 20
 * 	agiliza a demonstração do %. 
 * 	
 * 	Eu entendi que não há a preocupação com o % e sim com a entrega, portanto, 
 * 	tanto faz se o % será detalhado acada 1%, 10% ou 20%.
 * 
 *   O 20 foi escolhido porque eu gostei da evolução de % impressa na tela.  
 */			 
			try {
				sleep(100); // envio da info a cada 0,1 seg (100 milissegundos)
				int percentual = (int) ((i / tempo) * 100);
				System.out.println((prato +1) +"º prato - conluído em: " +percentual +" % ");
			} catch (Exception erro) {				
			}
		}
		
	}
	
	
	private void entregarPrato() {
		try {
			sleep(500);
			System.out.println((prato +1) +"º prato - " +pratoId +" : Entregue");
		} catch (Exception erro) {			
		}
	}
}