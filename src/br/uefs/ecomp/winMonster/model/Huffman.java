package br.ecomp.uefs.winMonster.model;

import br.ecomp.uefs.winMonster.util.FilaPrioritaria;
import br.ecomp.uefs.winMonster.util.MeuIterador;
import br.ecomp.uefs.winMonster.util.No;

public class Huffman {

	
	private int[] construirVetorFreq(String texto){
		char c = 0;
		int[] ascii = new int[256];

		for(int i = 0; i < texto.length(); i++)
		{
			c = texto.charAt(i);
			ascii[c]++;
		}
		return ascii;
	}
	
	/**
	 * Constroi arvore de Huffman conforme vetor de frequencias
	 * @return
	 */
	private No construirArvore(int[] ascii){
		
		FilaPrioritaria fila = new FilaPrioritaria();
		MeuIterador iterador;
		int index;

		for (char c = 0; c < 256; c++){
			if (ascii[c] > 0){ // Se o char for usado
				index = 0;
				iterador = (MeuIterador) fila.iterador();
				No no = new No(null, null, ascii[c], c); // Cria No do char
				int freq = 0;
				if (fila.estaVazia()){ // Se fila de Nos estiver vazia, insere na primeira posicao
					fila.inserirOrdenado(true, 1, 3, 2, no);
				} else{ // Caso contrario percorre a fila até achar o local certo de inserção.
					while (!(fila.inserirOrdenado(true, ++index, freq, no.getFreq(), no)) && iterador.obterProximo() != null){
						freq = ((No)iterador.getAtual().getElemento()).getFreq();
				}
				
					} // Insere na fila
				}
			}

		
		while (fila.obterTamanho() > 1){
			index = 0;
			iterador = (MeuIterador) fila.iterador();
			No menor = (No) fila.removerInicio();
			No segundoMenor = (No)  fila.removerInicio();
			No pai = new No(menor, segundoMenor, menor.getFreq() + segundoMenor.getFreq(), '\0');
			int freq = 0;
			
			while (!(fila.inserirOrdenado(true, ++index, freq, pai.getFreq(), pai)) && iterador.obterProximo() != null){
				freq =((No)iterador.getAtual().getElemento()).getFreq();
			}
		}
		
		return (No) fila.removerInicio();
	}
	
	/**
	 * Constroi codigos para todos os caracteres da arvore
	 * @param raiz
	 * @return
	 */
	private String[] codificarArvore(No raiz){
		
		String[] codigos = new String[256];
		codificarNo(codigos, raiz, "");
		return codigos;
	}
	
	/**
	 * Constroi codigo para um no de uma arvore, porem no final percorre todos
	 * @param codigos
	 * @param no
	 * @param codigo
	 */
	private void codificarNo(String[] codigos, No no, String codigo){
		if (no.ehFolha()){
			codigos[no.getCh()] = codigo;
			return;
		}
		codificarNo(codigos, no.getNoEsquerda(), codigo + '0');
		codificarNo(codigos, no.getNoDireita(), codigo + '1');
	}
	
	
	public void compactar(String texto){

		No raiz;
		
		raiz = construirArvore(construirVetorFreq(texto));
		
		String[] codigos;
		codigos = codificarArvore(raiz);
		
		// Printando mensagem só pra saber até onde tá rodando. APAGAR DEPOIS
		System.out.println("Chegamos aqui");
		
		// Escrever a arvore no arquivo
		
		// escrever tamanho?
		
		// Escrever codigo
		
		
		
		
	}
}

