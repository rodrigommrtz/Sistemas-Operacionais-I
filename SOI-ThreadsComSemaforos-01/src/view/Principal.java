package view;

import controller.Threads;

public class Principal {

	public static void main(String[] args) {
		
		for(int threadId = 1; threadId < 22; threadId++) {
			
			Thread transacoes = new Threads(threadId);
			transacoes.start();
		}

	}

}