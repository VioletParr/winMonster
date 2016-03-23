package br.uefs.ecomp.winMonster.util;

import br.uefs.ecomp.winMonster.util.Iterador;
import br.uefs.ecomp.winMonster.util.Celula;
import br.uefs.ecomp.winMonster.util.MeuIterador;

public class FilaPrioritaria implements IFila {

	// Atributos
	private Celula cabeca = new Celula();
	private Celula ultima;
	
	@Override
	public boolean estaVazia() {
		// TODO Auto-generated method stub
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
	@Override
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
	public void inserirInicio(Object o)
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
	public void inserirFinal(Object o) 
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
	
	public void inserir(int index, Object o){
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

	@Override
	public Object recuperarInicio() {
		if (estaVazia()){
			System.out.println("Nao ha item para ser recuperado");
			return null;
		}
		Object recuperado = cabeca.getProximo().getElemento();		
		return recuperado;
	}

	@Override
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
