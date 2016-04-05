package br.uefs.ecomp.winMonster.controller;

import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;

import br.uefs.ecomp.winMonster.model.Huffman;

import java.io.File;


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
			
			// Printa String lida, só para efeito de teste. APAGAR DEPOIS
			System.out.println(texto + " " + funcaoHash(texto));  
			return texto;
	}	
	
	// Chama métodos da classe Huffman para criação da árvore e compactação do arquivo
	public void compactarArquivo(File arquivo) throws IOException{
		String texto = this.lerArquivo(arquivo);
		arvoreHuffman.compactar(texto);
	}
	
	// Cria um código hash que será utilizado para verificar integridade do arquivo 
	public static int funcaoHash(String string){
			
			int codigoHash = 0; 
			for (int i = 0; i < string.length(); i++) 
			{
				char caractere = string.charAt(i); 
				
				int ascii = caractere; 
				
				// O código final corresponde à soma do valor númerico de todos os caracteres do texto
				codigoHash += ascii; 
			}
			return codigoHash;
		}
			
}
