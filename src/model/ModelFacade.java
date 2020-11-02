package model;

import common.Cor;

public class ModelFacade {
	private Tabuleiro tb = Tabuleiro.getTabuleiro(); // pega o static tabuleiro
	Partida partida;
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(String nome1, String nome2) {
		this.partida = new Partida(new Jogador(nome1, Cor.BRANCO), new Jogador(nome2, Cor.PRETO));
	}

	public void iniciaTabuleiro() {
		Tabuleiro.getTabuleiro();
	}
	
	public void reiniciaTabuleiro() {
		Tabuleiro.deleteTabuleiro();
	}
	
	public boolean selecionaPeca(int linhaPecaSelecionada, int colunaPecaSelecionada) { // indica se a peca eh do jogador da vez
		return tb.selecionaPeca(linhaPecaSelecionada, colunaPecaSelecionada, partida.jogadorDaVez);
	}
	
	public boolean selecionaCasa(int linhaCasaDesejada, int colunaCasaDesejada) {
		Peca aux = tb.getPeca(linhaCasaDesejada, colunaCasaDesejada, partida.jogadorDaVez);
		return false;
	}
	
}
