package br.uefs.ecomp.winMonster.util;

import br.uefs.ecomp.sisNema.model.Comprador;
import br.uefs.ecomp.sisNema.util.Iterador;
import br.uefs.ecomp.sisNema.util.Lista;

public class Lista implements ILista {

	// Atributos
	private Celula cabeca = new Celula();
	private Celula ultima;
	

	
    /**
     * COnstrutor para objetos da classe Lista
     */
    public Lista()
    {
    }
    
    public Lista(Celula primeira){
    	cabeca.setProximo(primeira);
    }
    
	public Celula getCabeca() {
		return cabeca;
	}

	public void setCabeca(Celula cabeca) {
		this.cabeca = cabeca;
	}

	public Celula getUltima() {
		return ultima;
	}

	public void setUltima(Celula ultima) {
		this.ultima = ultima;
	}
    
	/** 
	 * Retorna verdadeiro caso a lista esteja vazia. Falso caso contrário.
	 * @return Verdadeiro caso lista vazia. Falso caso contrário.
	 */
	@Override
	public boolean estaVazia()
	{
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
	@Override
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
	@Override
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
	
	@Override
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
	public Object removerFinal() { 
		if (removerVazia()){  // CAso esteja vazia nao remove e printa erro
			return null;
		}
		int tamanho = obterTamanho();
		Object removido = ultima.getElemento();
		if (tamanho == 1) {
			cabeca.setProximo(null);
			ultima = null;
		}
		else{
			remover (tamanho);
		}
		return removido;
	}
	
	@Override
	public Object remover(int index) {
		if (removerVazia()){  // CAso esteja vazia nao remove e printa erro
			return null;
		}
		if (index < 1){ // Index validos a partir de 1
			System.out.println("Insira index maior que 1");
			return null;
		}
		if (index > obterTamanho()){ // Voce está tentando trapacear?
			System.out.println("Index informado eh maior que tamanho da lista");
			return null;
		}
		Object removido = null;
		if (index == 1){ // Se for primeiro primeiro elemento, remove no inicio
			removido = removerInicio();
			return removido;
		}
		int n = 0;
		MeuIterador iterador = new MeuIterador(cabeca);
		while (n < (index - 1)) {
			iterador.obterProximo();
			n++;
		}
		Celula celulaAux = (Celula) iterador.getAtual();
		removido = celulaAux.getProximo().getElemento();
		if (celulaAux.getProximo().getProximo() == null){ // Caso celula removida seja a última, atualiza a informação em última.
			ultima = celulaAux;
		}
		celulaAux.setProximo(celulaAux.getProximo().getProximo());
		return removido;
	}
	
	
	@Override
	public Object recuperar(int index) {
		if (removerVazia()){  // CAso esteja vazia nao remove e printa erro
			return null;
		}
		if (index < 1){ // Index validos a partir de 1
			System.out.println("Insira index maior que 1");
			return null;
		}
		if (index > obterTamanho()){ // Voce está tentando trapacear?
			System.out.println("Index informado eh maior que tamanho da lista");
			return null;
		}
		int n = 0;
		Iterador iterador = new MeuIterador(cabeca);
		while (n < (index -1)) {
			iterador.obterProximo();
			n++;
		}
		Object recuperado = iterador.obterProximo();
		return recuperado;
	}
	
	
	@Override
	public Iterador iterador() 
	{
		Iterador iterador = new MeuIterador(cabeca);
		return iterador;
	}
	
	/**
	 * Insere ordenado em um determinado index da lista.
	 * Compara valorIndex com valor e insere o objeto O caso esteja na posição.
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
			System.out.println("Valor de index invalido!");
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
	
	/**
	 * Separa a lista em duas. A parte da esquerda fica na própria lista que chamou o método
	 * A parte da direita é retornada
	 */
	public Lista dividirMetade(){
		int meio = obterTamanho()/2;
		int index = 0;
		Celula iteradora = this.cabeca;
		Celula anterior = null;
		while (index != meio+1){
			anterior = iteradora;
			iteradora = iteradora.getProximo();
			index++;
		}
		Lista listaDireita = new Lista(iteradora);
		listaDireita.ultima = this.ultima;
		anterior.setProximo(null);
		this.ultima = anterior;
		return listaDireita; 
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
	
	/**
	 * Ordena lista usando metodo mergeSort
	 * @param listaEsquerda
	 * @return
	 */
	private Lista mergeSort(){

		// Caso lista tenha tamanho 0 ou 1, ela já está ordenada.
		if (this.obterTamanho() < 2){
			return this;
		}
		
		// Se lista tiver tamanho > 2,
		// divida-a na metade, ordene parte esquerda, depois direita, depois merge
		
		// listaDireita terá a parte direita e lista terá parte esquerda.
		Lista listaDireita = this.dividirMetade();
		this.mergeSort();
		listaDireita.mergeSort();
		
		return merge(this, listaDireita);
		
	}
	
	/**
	 * Combina duas listas de compradores em uma de acordo com uma, por ordem alfabética
	 * @param listaEsquerda
	 * @param listaDireita
	 * @return
	 */
	private Lista merge (Lista listaEsquerda, Lista listaDireita){
		Lista listaResultado = new Lista();
		Iterador iteradorEsquerda = listaEsquerda.iterador();
		Iterador iteradorDireita = listaDireita.iterador();
		Comprador compradorEsquerda, compradorDireita;
		compradorEsquerda = (Comprador) iteradorEsquerda.obterProximo();
		compradorDireita = (Comprador) iteradorDireita.obterProximo();
		boolean temEsquerda = true; // Confere se ainda ha elementos na esquerda
		boolean temDireita = true; // Confere se ainda ha elementos na direita
		
		// Enquanto existir alguma lista, compara elemento da direita com o da esquerda e insere o menor.
		while (temEsquerda && temDireita){
			// Se o nome do comprador da esquerda for menor em ordem alfabetica do que o da direita,
			// insira o comprador na lista resultado e incremente o iterador da lista esquerda.
			if (compradorEsquerda.getNome().compareToIgnoreCase(compradorDireita.getNome()) < 0){
				listaResultado.inserirFinal(compradorEsquerda);
				if (iteradorEsquerda.temProximo()){
					compradorEsquerda = (Comprador) iteradorEsquerda.obterProximo();
				} else{
					temEsquerda = false;
				}
			} else{ // Caso comprador da direita for menor, mesma coisa pra direita.
				listaResultado.inserirFinal(compradorDireita);
				if (iteradorDireita.temProximo()){
					compradorDireita = (Comprador) iteradorDireita.obterProximo();
				} else{
					temDireita = false;
				}
			}
		}
		
		
		// Se ainda tem algo na lista da esquerda
		while (temEsquerda){
			listaResultado.inserirFinal(compradorEsquerda);
			if (iteradorEsquerda.temProximo()){
				compradorEsquerda = (Comprador) iteradorEsquerda.obterProximo();
			} else{
				temEsquerda = false;
			}
			
		}
		
		// Se ainda tem algo na lista da direita
		while (temDireita){
			listaResultado.inserirFinal(compradorDireita);
			if (iteradorDireita.temProximo()){
				compradorDireita = (Comprador) iteradorDireita.obterProximo();
			} else{
				temDireita = false;
			}
		}
		
		return listaResultado;
		
	}
}
