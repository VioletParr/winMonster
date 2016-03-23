package br.uefs.ecomp.winMonster.model;

import br.uefs.ecomp.winMonster.util.FilaPrioritaria;
import br.uefs.ecomp.winMonster.util.Iterador;
import br.uefs.ecomp.winMonster.util.Lista;

public class Compactatacao {
	
	
	public FilaPrioritaria construirFila(){
		
		FilaPrioritaria fila = new FilaPrioritaria();
		Lista lista = new Lista();
		Iterador iterador = lista.iterador();

		char c;
		// While para ler arquivo inteiro, char por char.
			while (iterador.temProximo()){ // DUVIDA: É suficiente? E último item?
				//modificando umas coisa aqui so pra ver o que rola
			}
		
	}
	
	public ArvoreHuffman construirArvore(){
		
	}
	
	public String codificar(){
		
	}
	
	public void compactar(){
		
	}
}
