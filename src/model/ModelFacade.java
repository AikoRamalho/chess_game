package model;

import common.Cor;

public class ModelFacade {
	private Tabuleiro tb = Tabuleiro.getTabuleiro();
	Partida partida;
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(String nome1,Cor cor1, String nome2, Cor cor2) {
		this.partida = new Partida(new Jogador(nome1, cor1), new Jogador(nome2, cor2));
	}

	public void iniciaTabuleiro() {
		tb.setTabuleiro();
	}
	
	public void reiniciaTabuleiro() {
		tb.setTabuleiro();
	}
	
	public boolean selecionaPeca(int linha, int coluna) {
		if (tb.mPecas[linha][coluna] == null) 
			return false;
		else if(tb.mPecas[linha][coluna].getCor() != partida.getJogadorDaVez().getCor()) // Nao pertence ao jogador da vez
			return false;
		return true;
	}
	
	public boolean selecionaCasa(int linha, int coluna) {
		if(tb.mPecas[linha][coluna] == null)
			return false;
		else if(tb.mPecas[linha][coluna].getCor() == partida.getJogadorDaVez().getCor()) // Pertence ao Jogador da Vez
				return false;
		return true;
	}
	
}
