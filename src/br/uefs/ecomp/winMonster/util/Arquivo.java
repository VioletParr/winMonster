package br.uefs.ecomp.winMonster.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.ecomp.uefs.winMonster.model.Huffman;

public class Arquivo {
	
	Huffman huffman = new Huffman();

	public String lerArquivo(File arquivo) throws IOException
	{
			BufferedReader ler = new BufferedReader(new FileReader(arquivo));
			
			String aux = ""; // Inicializa uma String vazia
			StringBuffer texto = new StringBuffer();
			
			// Enquanto não for encontrado caractere nulo, percorre o arquivo 
			while((aux = ler.readLine()) != null)
			{
				texto.append(aux).append("\n"); // Linhas lidas são concatenadas à String texto
			}
			ler.close();
			
			// Printa String lida, só para efeito de teste. APAGAR DEPOIS
			System.out.println(texto + " " + huffman.funcaoHash(texto.toString()));  
			return texto.toString();
	}	
	
	public void escreverArquivo(String texto, File arquivo) throws IOException{
		
		BufferedWriter escreve = new BufferedWriter(new FileWriter(arquivo));
		escreve.write(texto);
		escreve.close();
	}
	
}
