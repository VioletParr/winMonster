package br.ecomp.uefs.winMonster.controller;

import java.io.File;
import java.io.IOException;

import br.ecomp.uefs.winMonster.model.Huffman;
import br.ecomp.uefs.winMonster.util.Arquivo;


public class Controller {
	
	Arquivo manipulaArquivo = new Arquivo();
	Huffman arvoreHuffman = new Huffman();
	
	// Chama métodos da classe Huffman para criação da árvore e compactação do arquivo
		public void compactarArquivo(File arquivo) throws IOException{
			
			// Le arquivo e transfere pra String texto
			String texto = manipulaArquivo.lerArquivo(arquivo);
			
			// Cria novo arquivo, que será usado pra saída do arquivo compactado
			File saida = new File (arquivo.getAbsolutePath() + ".monster");
			
			// Caso consiga criar novo arquivo, compacta.
			if (saida.createNewFile()){
				// Compacta
				arvoreHuffman.compactar(texto, saida);
			} else{ // Caso não consiga, pede ao usuário pra digitar nome de saída do arquivo 
				
//				 Digite nome de saida blabla
//				 Depois compacta
			}
}

		public void descompactarArquivo(File arquivoDescompactar){
			
			// Instancia novo arquivo. Substitui .monster por "", para que arquivo volte à extensão original
			File arquivo = new File(arquivoDescompactar.getAbsolutePath().replace(".monster", ""));
			
			// Método de descompactar recebe 2 arquivos, arquivo a ser descompactado e arquivo onde deve ser escrito
			// texto original (?) OU linha de criação do novo arquivo fica dentro do método de descompactar 
			
			// Passa arquivo no qual deve ser escrito para método de descompactar, que chama:
			// manipulaArquivo.escreverArquivo(texto, arquivo), passando String recebida por 
			// um método de descompactação que retorna a String com o texto original 
		}
}
