package view;
import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		int opc=0;
		
		RedesController netController = new RedesController();
		String os = netController.os();
		//System.out.println("Sistema: " + os +"\n"); mostra o OS
				
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha a Opção\n\n1 - Verificar IP\n2 - Verificar Ping\n9 - Sair \n "));			
		
				switch(opc){	
				
					case 1:
						if (os.contains("Windows")) {
							System.out.println("Sistema: " + os +"\n");
							String processo = "ipconfig.exe";
							//netController.abreProcesso(processo);
							netController.ip(processo);				
						} else {
							System.out.println("Sistema Operacional não é Windows. Sistema Operacional em uso: " + os);
						}
						break;
						
					case 2:
						if (os.contains("Windows")) {
							System.out.println("Sistema: " + os +"\n");
							String processo = "ping -t10 www.google.com.br";
							//netController.abreProcesso(processo);
							netController.ping(processo);				
						} else {
							System.out.println("Sistema Operacional não é Windows. Sistema Operacional em uso: " + os);
						}
						break;
				
					case 9:
						System.out.println("\nPrograma encerrrado");
						break;
					
					default:
						System.out.println("\nOpção inválida");
						
				}
			}					
	}
}
