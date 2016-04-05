package br.uefs.ecomp.winMonster.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {

	// Baseado no http://www.devmedia.com.br/desenvolvendo-splash-screens-para-suas-aplicacoes/1667
	
	JPanel painel = (JPanel)getContentPane();
	
	
	private int duracao;
	
	public SplashScreen(int duracao)
	{
		this.duracao = duracao;
	}
	
	public void mostrarSplash()
	{
		int largura = 450;
		int altura = 115;
		
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (tela.width-largura)/2;
		int y = (tela.height-altura)/2;
		
		setBounds(x,y,largura,altura);
		
		JLabel label = new JLabel(new ImageIcon("splash.jpg"));
		JLabel copyrt = new JLabel("Copyright 2016, Buba Produções");
		
		painel.add(label);
		painel.add(copyrt, BorderLayout.SOUTH);
		setVisible(true);
		
		try{
			Thread.sleep(duracao);
		}catch(Exception e){
		}
		setVisible(false);
	}
}
