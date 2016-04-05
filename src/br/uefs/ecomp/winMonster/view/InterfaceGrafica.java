package br.uefs.ecomp.winMonster.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class InterfaceGrafica{

	
	public static void main(String[] args) throws IOException {
		
		// Instancia SplashScreen e chama o método de mostrar na tela
		SplashScreen splash = new SplashScreen(6200); 
		splash.mostrarSplash();
		
		// Instancia botões com as opções de escolha disponíveis ao usuário
		JButton botaoCompactar = new JButton("Compactar arquivo");
		JButton botaoSair = new JButton("Sair");
		JButton botaoDescompactar = new JButton("Descompactar arquivo");

		// Indica a ação a ser realizada quando botaoSair for selecionado. Nesse caso, fecha o programa.
		botaoSair.addActionListener(new ActionListener()
		{	@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// Indica a ação a ser realizada quando o botaoCompactar for selecionado
		ActionListener actionCompactar = new ActionCompactar();
		botaoCompactar.addActionListener(actionCompactar);
		
		// Ação do botaoDescompactar
		
		
		// Painel que contém os botões com opções de escolha disponíveis para o usuário	
		JPanel painel = new JPanel();
		painel.add(botaoCompactar);
		painel.add(botaoSair);
		painel.add(botaoDescompactar);
		
		// Cria janela padrão do programa
		JFrame janela = new JFrame("WINMonster");
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Indica que programa será fechado ao fechar janela
		janela.pack(); 
		janela.setVisible(true); // Janela será visível	
		
	}
}

