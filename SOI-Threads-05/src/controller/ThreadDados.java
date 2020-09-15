package controller;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ThreadDados extends Thread {

	private JButton btnJogar;
	private JTextField textDado;
	private int contagem;
	private String numero;

	public ThreadDados(JButton btnJogar, JTextField textDado) { 
		this.textDado = textDado;
		this.btnJogar = btnJogar;
		// cada Thread enviou um campo (textCampo1, 2 e 3) mas aqui sera recebida apenas 1 de cada vez,
		// por isso sera criada a variavel textDado, que ira receber o valor de cada uma da thread, na sequencia que for enviado.
	}

	public void jogarDados(){ // metodo solicitado no override da classe Metodos
		Random numeroAleatorio = new Random();
		btnJogar.setEnabled(false); // aqui desabilita a funcao do botao eqto roda o programa 
		contagem = ((numeroAleatorio.nextInt(149)+1)); // indica o valor de rodadas, sendo de 1 a 150
		
		while(contagem > 0) {
			for (int i = contagem; contagem >00; contagem--) {
				numero = Integer.toString((numeroAleatorio.nextInt(6)+1)); // indicacao do valor a ser mostrado na tela

				try {
					sleep(100);
					this.textDado.setText("  " +numero); // numero (tipo String) sendo mostrado na tela
				}catch (Exception erro){					
				}
			}
		}

		btnJogar.setEnabled(true); // habilitar o botao 'Jogar" ao final do processo
	}


	
	@Override
	public void run() {
		jogarDados();
	} 

}
