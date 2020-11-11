package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;
import common.Observer;

public class ModelFacade {
	public static ModelFacade mf = null;
	private Tabuleiro tb; // pega o static tabuleiro
	Jogador jogador1, jogador2;
	Partida partida;
	
	private ModelFacade() {
		tb = Tabuleiro.getTabuleiro();
	}
	
	public static ModelFacade getInstance() {
		if(mf != null)
			return mf;
		
		mf = new ModelFacade();
		return mf;
	}
	
	private Partida getPartida() {
		return partida;
	}

	public void setPartida(String nome1, String nome2) {
		jogador1 = new Jogador(nome1, Cor.BRANCO);
		jogador2 = new Jogador(nome2, Cor.PRETO);
		this.partida = new Partida(jogador1, jogador2);
	}

	public void iniciaTabuleiro() {
//		tb = Tabuleiro.getTabuleiro(jogador1, jogador2);
		tb = Tabuleiro.getTabuleiro();
	}
	
	public void iniciaPartida() {
		tb.setTabuleiro(jogador1, jogador2);
	}
	
	public void reiniciaTabuleiro() {
		Tabuleiro.deleteTabuleiro();
	}
	
	public boolean selecionaPeca(int linhaPecaSelecionada, int colunaPecaSelecionada) { // indica se a peca eh do jogador da vez
		return tb.selecionaPeca(linhaPecaSelecionada, colunaPecaSelecionada, partida.jogadorDaVez);
	}
	
	public boolean selecionaCasa(int linhaCasaDesejada, int colunaCasaDesejada) {
//		Peca aux = tb.selecionaPeca(linhaCasaDesejada, colunaCasaDesejada, partida.jogadorDaVez);
		return tb.selecionaPeca(linhaCasaDesejada, colunaCasaDesejada, partida.jogadorDaVez);
	}
	
	public List<List<Object>> getDisposicaoPecas() {
		return tb.getDisposicaoPecas();
	}
	
	public void register(Observer o) {
		tb.addObserver(o);
	}

//	public static void main(String[] args) {
//		Tabuleiro.getTabuleiro(new Jogador("aiko", Cor.BRANCO), new Jogador("ajsdkljas", Cor.PRETO));
//    }

}
