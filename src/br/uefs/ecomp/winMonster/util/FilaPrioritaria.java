package br.uefs.ecomp.winMonster.util;

import br.uefs.ecomp.winMonster.util.Iterador;
import br.uefs.ecomp.winMonster.util.Celula;
import br.uefs.ecomp.winMonster.util.MeuIterador;

public class FilaPrioritaria {

	// Atributos
	private Celula cabeca = new Celula();
	private Celula ultima;
	
	public boolean estaVazia() {
		if (cabeca.getProximo() == null){
			return true;
		}
		else
		{
			return false;	
		}
	}

	/**
	 * Obtem o tamanho da lista
	 * @return Tamanho da lista
	 */
	public int obterTamanho() {
		int n = 0;
		Iterador iterador = new MeuIterador(cabeca);
		while (iterador.temProximo()) {
			iterador.obterProximo();
			n++;
		}
		return n;
	}

	/**
	 * Cria celula e insere objeto do parametro no inicio
	 * @param o
	 */
	private void inserirInicio(Object o)
	{
		Celula novaCelula = new Celula(o);
		if (estaVazia()){ // Caso a lista esteja vazia, somente insere.
			cabeca.setProximo(novaCelula);
			ultima = novaCelula;
		}
		else { // Caso não esteja vazia, salva o resto da lista e depois insere
			novaCelula.setProximo(cabeca.getProximo());
			cabeca.setProximo(novaCelula);
		}
	}
	
	/**
	 * Cria celula e insere objeto do parametro no final
	 * @param o
	 */
	private void inserirFinal(Object o) 
	{
		Celula novaCelula = new Celula(o);
		if (estaVazia()){
			cabeca.setProximo(novaCelula);
			ultima = novaCelula;
		}
		else{
			ultima.setProximo(novaCelula);
			ultima = novaCelula;
		}
	}
	
	private void inserir(int index, Object o){
		if (index < 1) {
			inserirInicio(o);
			return;
		}
		if (index > obterTamanho()){
			inserirFinal(o);
			return;
		}
		int n = 0;
		MeuIterador iterador = new MeuIterador(cabeca);
		while (n < (index -1)) {
			iterador.obterProximo();
			n++;
		}
		Celula celulaNova = new Celula(o);
		Celula celulaAux = (Celula) iterador.getAtual();
		celulaNova.setProximo(celulaAux.getProximo()); // Salva o resto da lista
		celulaAux.setProximo(celulaNova); // Insere na lista
		return;
	}
	
	/**
	 * Insere ordenado em um determinado index da lista.
	 * Compara valorIndex com valor e insere o objeto "o" caso esteja na posição.
	 * Retorna verdadeiro caso tenha inserido, falso caso contrario. 
	 * @param crescente
	 * @param index
	 * @param valorIndex
	 * @param valorInserido
	 * @param o
	 * @return True if inserted, false if not.
	 */
	public boolean inserirOrdenado(boolean crescente, int index, double valorIndex, double valorInserido, Object o){
		if (index < 1){
			return false;
		}
		if (index > obterTamanho()){
			inserirFinal(o);
			return true;
		}
		if (crescente){ // Caso esteja ordenando em ordem crescente
			if (valorIndex < valorInserido){
				return false;
			}
			else {
				inserir(index, o);
				return true;
			}
		}
		else{ // Caso esteja ordenando em ordem decrescente
			if (valorIndex < valorInserido){
				inserir(index, o);
				return true;
			}
			else {
				return false;
			}
		}
	}

	public Object removerInicio() {
		if (removerVazia()){ // Caso esteja vazia nao remove nada e printa erro
			return null;
		}
		Object removido = cabeca.getProximo().getElemento(); // Salva o elemento a ser removido
		if (obterTamanho() == 1) { 		// Caso so exista um elemento
			ultima = null;
		}
		cabeca.setProximo(cabeca.getProximo().getProximo()); // Remove o elemento
		return removido;
	}

	public Object recuperarInicio() {
		if (estaVazia()){
			System.out.println("Nao ha item para ser recuperado");
			return null;
		}
		Object recuperado = cabeca.getProximo().getElemento();		
		return recuperado;
	}

	public Iterador iterador() {
		Iterador iterador = new MeuIterador(cabeca);
		return iterador;
	}
	
	private boolean removerVazia(){
		if(estaVazia()){
			System.out.println("Nao ha item para ser removido");
			return true;
		}
		else {
			return false;
		}
	}

}
