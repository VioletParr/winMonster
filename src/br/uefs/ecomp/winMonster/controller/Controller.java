package br.ecomp.uefs.winMonster.controller;

import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException; 
import java.io.File;
import br.ecomp.uefs.winMonster.model.Huffman;


public class Controller {
	
		Huffman arvoreHuffman = new Huffman();

	// Testando leitura de arquivo 		
	public String lerArquivo(File arquivo) throws IOException
	{
			BufferedReader ler = new BufferedReader(new FileReader(arquivo));
			
			String aux = ""; // Inicializa uma String vazia
			String texto = "";
			
			// Enquanto não for encontrado caractere nulo, percorre o arquivo 
			while((aux = ler.readLine()) != null)
			{
				texto += aux; // Linhas lidas são concatenadas à String texto
			}
		
			
			ler.close();
			System.out.println(texto + " " + funcaoHash(texto)); // Printa String lida. Por enquanto, só para efeito de teste 
			return texto;
	}	
	
	// Chama métodos da classe Huffman para criação da árvore e compactação do arquivo 
	public void compactarArquivo(String texto){
		arvoreHuffman.construirVetorFreq(texto);
	}
	
	
	// Cria um código hash que será utilizado para verificar integridade do arquivo 
	public static int funcaoHash(String string){
			
			int codigoHash = 0; 
			for (int i = 0; i < string.length(); i++) // Enquanto não encontrar caractere nulo,
													  // percorre a String recebida 
			{
				char caractere = string.charAt(i); // caractere recebe o valor do char econtrado 
												   // na posição i da String
				
				int ascii = caractere; // ascii recebe o valor númerico correspondente ao caracter
				// na tabela ASCII
				
				// O código final corresponde à soma do valor númerico de todos os caracteres do texto
				codigoHash += ascii; 
			}
			return codigoHash;
		}
			
}
