
package controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ThreadCarros extends Thread {
	private JLabel lblCarro;  
	private JButton btnCorrer; 
	private JTextField txtPlacar1;
	private JTextField txtPlacar2;
	private int trajetoTotal = 350;
	private int trajetoPercorrido;
	private int posicao;
	private static int lugar = 0;
	
	
	public ThreadCarros(JLabel lblCarro, JButton btnCorrer, JTextField txtPlacar1, JTextField txtPlacar2){
		this.lblCarro = lblCarro;
		this.btnCorrer = btnCorrer;
		this.txtPlacar1 = txtPlacar1;
		this.txtPlacar2 = txtPlacar2;
		this.trajetoPercorrido = 0;
		this.posicao = 0;
	}
	
	
	public void botaoCorrida(){
		btnCorrer.setEnabled(false); 
		Random veloc = new Random();
		Rectangle posicao = lblCarro.getBounds();
		
		while (this.trajetoPercorrido < trajetoTotal){
			
			int arrancada = veloc.nextInt(9)+1;
			posicao.x += arrancada;
			lblCarro.setBounds(posicao);
			this.trajetoPercorrido += arrancada;
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		btnCorrer.setEnabled(true); 
		this.posicao = obterPosicao();
		System.out.println(this.posicao);
		
		try {
			sleep(this.posicao * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		if (this.posicao == 1){
			this.txtPlacar1.setText(this.lblCarro.getText());
		} else {
			this.txtPlacar2.setText(this.lblCarro.getText());
		}
		
		
	}
	
	@Override
	public void run() {
		botaoCorrida();
	} 
	
	public int obterPosicao(){
		lugar++;
		return lugar;
	}

}
