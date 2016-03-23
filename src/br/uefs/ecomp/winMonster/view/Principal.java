package br.ecomp.uefs.winMonster.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {
	
	// Testando leitura de arquivo 
	public static void main (String[] args)
	{
		Scanner scanner = null; 
		try
		{
			File file = new File("arquivo.txt"); // Instancia objeto do tipo File passando como parâmetro nome do arquivo a ser aberto (ou diretório)
			scanner = new Scanner(file); 

		} catch(FileNotFoundException e){ // Lança exception caso o arquivo não seja encontrado
			e.printStackTrace();
		}
		
		String texto = ""; // Inicializa uma String vazia
		
		while(scanner.hasNext()) // Enquanto não for encontrado um caracter nulo no arquivo
		{
			texto += "" + scanner.nextLine(); // Linhas lidas são concatenadas à String texto
		}
		
		scanner.close();
		
		System.out.println(texto); // Printa String lida. Por enquanto, só para efeito de teste 

	}

}
