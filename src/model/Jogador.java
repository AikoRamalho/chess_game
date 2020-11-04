package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;

class Jogador {
	String nome;
	private List<Peca> pecas = new ArrayList<>();
	Cor cor;
	
	protected Jogador(String nome, Cor cor) {
		this.nome = nome;
		this.cor = cor;
		inicializaPecas();
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
	
	protected List<Peca> getPecas() {
		return pecas;
	}
	
	public void inicializaPecas(){
		if(cor == Cor.BRANCO) {
			for(int i = 0; i<8; i++) {
				pecas.add(new Peao(Cor.BRANCO, i, 2));
			}
			pecas.add(new Torre(Cor.BRANCO, 0, 0));
			pecas.add(new Torre(Cor.BRANCO, 7, 0));
			pecas.add(new Cavalo(Cor.BRANCO, 1, 0));
			pecas.add(new Cavalo(Cor.BRANCO, 6, 0));
			pecas.add(new Bispo(Cor.BRANCO, 2, 0));
			pecas.add(new Bispo(Cor.BRANCO, 5, 0));
			pecas.add(new Rainha(Cor.BRANCO, 3, 0));
			pecas.add(new Rei(Cor.BRANCO, 4, 0));
		}else {
			for(int i = 0; i<8; i++) {
				pecas.add(new Peao(Cor.PRETO, i, 6));
			}
			pecas.add(new Torre(Cor.PRETO, 0, 7));
			pecas.add(new Torre(Cor.PRETO, 7, 7));
			pecas.add(new Cavalo(Cor.PRETO, 1, 7));
			pecas.add(new Cavalo(Cor.PRETO, 6, 7));
			pecas.add(new Bispo(Cor.PRETO, 2, 7));
			pecas.add(new Bispo(Cor.PRETO, 5, 7));
			pecas.add(new Rainha(Cor.PRETO, 3, 7));
			pecas.add(new Rei(Cor.PRETO, 4, 7));
		}
	}
}
