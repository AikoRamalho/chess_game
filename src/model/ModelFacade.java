package model;

import common.Cor;

public class ModelFacade {
	private Tabuleiro tb; // pega o static tabuleiro
	Jogador jogador1, jogador2;
	Partida partida;
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(String nome1, String nome2) {
		jogador1 = new Jogador(nome1, Cor.BRANCO);
		jogador2 = new Jogador(nome2, Cor.PRETO);
		this.partida = new Partida(jogador1, jogador2);
	}

	public void iniciaTabuleiro() {
		Tabuleiro.getTabuleiro(jogador1, jogador2);
	}
	
	public void reiniciaTabuleiro() {
		Tabuleiro.deleteTabuleiro();
	}
	
	public boolean selecionaPeca(int linhaPecaSelecionada, int colunaPecaSelecionada) { // indica se a peca eh do jogador da vez
		return tb.selecionaPeca(linhaPecaSelecionada, colunaPecaSelecionada, partida.jogadorDaVez);
	}
	
	public boolean selecionaCasa(int linhaCasaDesejada, int colunaCasaDesejada) {
		//Peca aux = tb.getPeca(linhaCasaDesejada, colunaCasaDesejada, partida.jogadorDaVez);
		return false;
	}
	
    public static void main(String[] args) {
		Tabuleiro.getTabuleiro(new Jogador("aiko", Cor.BRANCO), new Jogador("ajsdkljas", Cor.PRETO));
    }
}
