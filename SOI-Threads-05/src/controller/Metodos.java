package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Metodos implements ActionListener{
			
		private JTextField textCampo1;  
		private JTextField textCampo2;
		private JTextField textCampo3;
		private JButton btnJogar;
	
		
		public Metodos(JButton btnJogar, JTextField textCampo1, JTextField textCampo2, JTextField textCampo3) {
			this.textCampo1 = textCampo1;
			this.textCampo2 = textCampo2;
			this.textCampo3 = textCampo3;
			this.btnJogar = btnJogar;
		}


		// construcao das threads - sendo 3 no caso, uma para cada JTextField
		public void jogarDados() {
		Thread t1 = new ThreadDados(btnJogar, textCampo1);
		Thread t2 = new ThreadDados(btnJogar, textCampo2);
		Thread t3 = new ThreadDados(btnJogar, textCampo3);
		t1.start();
		t2.start();
		t3.start();
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			jogarDados(); // vai carregar esses dados todos
		}
		
}
