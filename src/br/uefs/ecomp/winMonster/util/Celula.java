package br.uefs.ecomp.winMonster.util;

public class Celula {
	
    // variáveis de instância
    private Object elemento;
    private Celula proximo;   
    
     
    // CONSTRUTORES PARA CELULA    
    /**
     * COnstrutor para objetos da classe Celula
     */
    public Celula()
    {
    }
    
    /**
     * Construtor da celula com conteudo de proximo null
     */
    public Celula(Object conteudo)
    {
    	this.elemento = conteudo;
    	this.proximo = null;
    }
    
    
    // METODOS DE CELULA
    /**
     * Retorna o elemento da presente celula
     * @return elemento
     */
	public Object getElemento() {
		return elemento;
	}

	/**
	 * Modifica o elemento da presente célula
	 * @param elemento
	 */
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	/**
	 * Retorna o endereço da próxima célula na lista
	 * @return endereco da proxima celula
	 */
	public Celula getProximo() {
		return proximo;
	}

	/**
	 * Modifica o endereco da proxima célula
	 * @param novo proximo endereco
	 */
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}
