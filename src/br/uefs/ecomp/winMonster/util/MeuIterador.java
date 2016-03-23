package br.uefs.ecomp.winMonster.util;

public class MeuIterador implements Iterador {
	
	private Celula atual;
	
	
	public MeuIterador(Celula atual){
		this.atual = atual;
	}
	

	@Override
	public boolean temProximo()
	{
		if (atual.getProximo() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	
	@Override
	public Object obterProximo() {
		atual = atual.getProximo();
		return atual.getElemento();
	}


	public Celula getAtual() {
		return atual;
	}


	public void setAtual(Celula atual) {
		this.atual = atual;
	}
	
	
	
}