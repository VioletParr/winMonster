package br.ecomp.uefs.winMonster.util;

public class No implements Comparable{

	private No noDireita;
	private No noEsquerda;
	private int freq;
	private char ch;
	
	public No (){
	}
	
	public No (No noDireita, No noEsquerda, int freq, char ch)
	{
		this.noDireita = noDireita;
		this.noEsquerda = noEsquerda;
		this.freq = freq;
		this.setCh(ch);
	}
	
	public boolean isFolha()
	{
		return noEsquerda == null && noDireita == null;
	}
	
	@Override
	public int compareTo(Object objeto) {
		No noRecebido = (No) objeto;
		
		int a = this.freq;
		int b = noRecebido.freq;
		
		if(a<b) 
			return 1;
		if(b<a)
			return -1;
		return 0;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}
	
	public void setFreq(int freq)
	{
		this.freq = freq;
	}
}