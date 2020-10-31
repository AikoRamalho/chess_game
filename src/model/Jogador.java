package model;

import common.Cor;

class Jogador {
	String nome;
	Cor cor;
	
	protected Jogador(String nome, Cor cor) {
		this.nome = nome;
		this.cor = cor;
	}
	
	protected String getNome() {
		return nome;
	}

	protected Cor getCor() {
		return cor;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setCor(Cor cor) {
		this.cor = cor;
	}
}
