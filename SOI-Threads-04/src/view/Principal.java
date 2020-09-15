package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.Controle;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Principal {

	private JFrame frame;
	private JTextField textoVencedor;
	private JTextField textoPerdedor;

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
		frame.setBounds(100, 100, 520, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carro 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(29, 72, 89, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCarro = new JLabel("Carro 2");
		lblCarro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarro.setForeground(Color.BLUE);
		lblCarro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCarro.setBounds(29, 132, 89, 36);
		frame.getContentPane().add(lblCarro);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 119, 439, 2);
		frame.getContentPane().add(separator);
		
		textoVencedor = new JTextField();
		textoVencedor.setBounds(254, 227, 86, 20);
		frame.getContentPane().add(textoVencedor);
		textoVencedor.setColumns(10);
		
		textoPerdedor = new JTextField();
		textoPerdedor.setBounds(254, 269, 86, 20);
		frame.getContentPane().add(textoPerdedor);
		textoPerdedor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Vencedor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(150, 228, 77, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerdedor.setBounds(150, 270, 77, 14);
		frame.getContentPane().add(lblPerdedor);
		
		JButton btnNewButton = new JButton("Correr");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(150, 310, 190, 23);
		frame.getContentPane().add(btnNewButton);
		
		Controle carroCorrida = new Controle(lblNewLabel, lblCarro, btnNewButton, textoVencedor, textoPerdedor);
		btnNewButton.addActionListener(carroCorrida);
		// 	Parte importantissima para fazer funcionar! deve ser indicados como parametros, todos os envolvidos na operacao,
		// sendo eles: carro 1, carro 2, botao de inicio, mais o texto do vencedor e perdedor.
				
	}
}
