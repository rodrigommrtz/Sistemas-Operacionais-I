package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

import controller.Metodos;

public class Principal {

	private JFrame frame;
	private JTextField textCampo1;
	private JTextField textCampo2;
	private JTextField textCampo3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJogar.setBounds(251, 154, 89, 23);
		frame.getContentPane().add(btnJogar);
		
		textCampo1 = new JTextField();
		textCampo1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textCampo1.setBounds(104, 70, 50, 50);
		frame.getContentPane().add(textCampo1);
		textCampo1.setColumns(10);
		
		textCampo2 = new JTextField();
		textCampo2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textCampo2.setColumns(10);
		textCampo2.setBounds(176, 70, 50, 50);
		frame.getContentPane().add(textCampo2);
		
		textCampo3 = new JTextField();
		textCampo3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textCampo3.setColumns(10);
		textCampo3.setBounds(251, 70, 50, 50);
		frame.getContentPane().add(textCampo3);
		
		Metodos botaoAcionar = new Metodos(btnJogar, textCampo1, textCampo2, textCampo3);
		btnJogar.addActionListener(botaoAcionar); 
		// criacao do envio dos dados para acionametno, sendo os 3 labels + botao (btnJogar)
		
	}
}
