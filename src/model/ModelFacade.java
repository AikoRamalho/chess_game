package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import common.Cor;
import common.Observer;
import common.TiposPeca;
import controller.Controller;

public class ModelFacade {
	public static ModelFacade mf = null;
	private Tabuleiro tb; // pega o static tabuleiro
	Jogador jogador1, jogador2;
	Partida partida;
	String sb;;
	
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
		return tb.selecionaCasa(linhaCasaDesejada, colunaCasaDesejada, partida.jogadorDaVez);
	}
	
	public void melhorarPeao(TiposPeca novoTipo) {
		tb.melhorarPeao(novoTipo);
	}
	
	public List<List<Object>> getDisposicaoPecas() {
		return tb.getDisposicaoPecas();
	}
	
	public void register(Observer o) {
		tb.addObserver(o);
	}

	public List<List<Integer>> getMovimentosValidosDaPeca(int x, int y) {
		Peca peca = tb.getPeca(x, y);
		if(peca == null)
			return null;
		return peca.getMovimentosValidos();
	}
	
	boolean isXequeMate() {
		List<Peca> pecas = tb.getAllPecas();
		for (Peca peca: pecas) {
			System.out.println("peca");
			System.out.println(peca);
			System.out.println(peca.getMovimentosValidos());
			if(partida.getJogadorDaVez().getCor() == peca.getCor() && peca.getMovimentosValidos().size() > 0) {
				return false;
			}
		}
		return true;
	}

	public void movePecaDePara(int xAtual, int yAtual, int xPara, int yPara) {
		tb.movePecaDePara(xAtual, yAtual, xPara, yPara);
		partida.passaVez();
		boolean xequeMate = this.isXequeMate();
		System.out.println("xeque mate");
		System.out.println(xequeMate);
		if (xequeMate) {
			System.out.println("entrou");
			Controller.getInstance().mostraDialogoReiniciaJogo(partida.getJogadorDaVez().getNome() == partida.getJogador1().getNome() ? partida.getJogador2().getNome() : partida.getJogador1().getNome());
		}
	}
	
	public void salvaJogo(FileWriter fw) {
		sb = new String();
		String jogadorVez = partida.getJogadorDaVez().nome; 
		sb += jogadorVez;
		List<List<Object>> dispoPecas = getDisposicaoPecas();
		dispoPecas.forEach(item -> sb += "\n" + item);
		try {
			fw.write(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void carregaPartida(String nomeJogadorAtual, List<List<Object>> disposicaoPecas) {
		partida.setJogadorDaVez(nomeJogadorAtual);
		tb.setDisposicaoPecas(disposicaoPecas);
	}

//	public static void main(String[] args) {
//		Tabuleiro.getTabuleiro(new Jogador("aiko", Cor.BRANCO), new Jogador("ajsdkljas", Cor.PRETO));
//    }

}