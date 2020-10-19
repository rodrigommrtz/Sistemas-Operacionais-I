package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RedesController {

	public RedesController() {
		super();
	}
	
	
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
		
	/*
	 * Processo para iniciar o ipconfig, mas aparentemente, ele nao precisa ser mostrado na tela,
	 * pois será lido pelo 'e' copiado na tela pelo processo ip(processo)
	 * 
	public void abreProcesso(String processo) {
		try {
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("cmd /c start ");
			buffer.append(processo);
			Runtime.getRuntime().exec(buffer.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
		
	public void ip(String processo) {
		try {
			Process coletador = Runtime.getRuntime().exec(processo);
			InputStream fluxo = coletador.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String ethernet = null;
			while (linha != null) {
				linha = buffer.readLine();
				if(linha.contains("Wireless") || linha.contains("Ethernet")) {
					ethernet = linha;
				}
				if(linha.contains("IPv4")) {
					System.out.println(ethernet);
					System.out.println(linha);
				}	
			} 				
			buffer.close();
			fluxo.close();
			leitor.close();			
		} catch (Exception e) {
			//e.printStackTrace(); ESTA DANDO JAVA LANG NULL POINTER EXCEPTION
		}	
	}
	
	public void ping(String processo) {
		try {
			Process coletador = Runtime.getRuntime().exec(processo);
			InputStream fluxo = coletador.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			//String ethernet = null;

			System.out.print("Contabilizando .");
			int soma= 0;
			int div = 0;
			for (int i=0; i<=10; i++) {
			//while (linha != null) {
				linha = buffer.readLine();
				
				if(linha.contains("Reply")) {
					String[] ms = linha.split("time="); // quebra a String no time=
					String[] ms2 = ms[1].split(" "); //quebra a string no espaço após o ms
					String[] ms3 = ms2[0].split("ms"); // quebra a string no ms
					soma = soma + Integer.parseInt(ms3[0]);
					System.out.print(".");
					//System.out.println(ms3[0]); // mostra o numero
					div++;	
					
				}
				/*
				f(linha.contains("Wireless") || linha.contains("Ethernet")) {
					ethernet = linha;
				}
				if(linha.contains("IPv4")) {
				System.out.println(ethernet);
				}
				*/
			}	
			
			soma = soma/div; //calculado como int para para dar os 2 ou 3 primeiros números 
			System.out.println("\nTempo médio do ping: " + soma +"ms");
						
			buffer.close();
			fluxo.close();
			leitor.close();			
		} catch (Exception e) {
			//e.printStackTrace(); ESTA DANDO JAVA LANG NULL POINTER EXCEPTION
		}	
}
}
