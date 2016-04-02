package br.ecomp.uefs.winMonster.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ecomp.uefs.winMonster.controller.Controller;

public class InterfaceGrafica {

	public static void main(String[] args) throws IOException {
		

		
		final Controller controller = new Controller();

		SplashScreen splash = new SplashScreen(7000);
		splash.mostrarSplash();
		
		JButton botaoCompactar = new JButton("Compactar arquivo");
		JButton botaoSair = new JButton("Sair");
		JButton botaoDescompactar = new JButton("Descompactar arquivo");

		botaoSair.addActionListener(new ActionListener()
		{	@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// Indica o ação a ser realizada quando o botaoCompactar for selecionado
		botaoCompactar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
		
				JFileChooser seletorDeArquivo = new JFileChooser(); // Cria janela para seleção do arquivo a
															// ser compactado
		
				// Retorno indica se usuário selecionou um arquivo ou cancelou
				int retorno = seletorDeArquivo.showOpenDialog(null); 
	
				if (retorno == JFileChooser.APPROVE_OPTION) { 
					File arquivo = seletorDeArquivo.getSelectedFile(); // Recebe o arquivo selecionado pelo usuário
					try {
						// Passa o arquivo como parâmetro para método de leitura de arquivo
						controller.lerArquivo(arquivo);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				else {
					// Faz não sei que não sei que lá se tiver cancelado
				}
			}
});
			
		JPanel painel = new JPanel();
		painel.add(botaoCompactar);
		painel.add(botaoSair);
		painel.add(botaoDescompactar);
		
		JFrame janela = new JFrame("WINMonster");
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Indica que programa será fechado ao fechar janela
		janela.pack(); 
		janela.setVisible(true); // Janela será visível	
		
}
}		
