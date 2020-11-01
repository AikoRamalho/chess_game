package model;

import common.Cor;

class Tabuleiro {
	public Peca[][] mPecas = new Peca[8][8];
	private static Tabuleiro tabuleiro = null;
	
	public static Tabuleiro getTabuleiro() {
		if(tabuleiro != null)
			return tabuleiro;
		
		tabuleiro = new Tabuleiro();
		
		return tabuleiro;
	}
	
	public void setTabuleiro() {
		tabuleiro.mPecas[0][0] = new Torre(Cor.BRANCO, 0, 0);
		tabuleiro.mPecas[7][0] = new Torre(Cor.PRETO, 7, 0);
		
		tabuleiro.mPecas[0][7] = new Torre(Cor.BRANCO, 0, 7);
		tabuleiro.mPecas[7][7] = new Torre(Cor.PRETO, 7, 7);
		
		tabuleiro.mPecas[0][1] = new Cavalo(Cor.BRANCO, 0, 1);
		tabuleiro.mPecas[7][1] = new Cavalo(Cor.PRETO, 7, 1);
		
		tabuleiro.mPecas[0][6] = new Cavalo(Cor.BRANCO, 0, 6);
		tabuleiro.mPecas[7][6] = new Cavalo(Cor.PRETO, 7, 6);
		
		tabuleiro.mPecas[0][2] = new Bispo(Cor.BRANCO, 0, 2);
		tabuleiro.mPecas[7][2] = new Bispo(Cor.PRETO, 7, 2);
		
		tabuleiro.mPecas[0][5] = new Bispo(Cor.BRANCO, 0, 5);
		tabuleiro.mPecas[7][5] = new Bispo(Cor.PRETO, 7, 5);
		
		tabuleiro.mPecas[0][3] = new Rainha(Cor.BRANCO, 0, 3);
		tabuleiro.mPecas[7][3] = new Rainha(Cor.PRETO, 7, 3);
		
		tabuleiro.mPecas[0][4] = new Rei(Cor.BRANCO, 0, 4);
		tabuleiro.mPecas[7][4] = new Rei(Cor.PRETO, 7, 4);
		
		for(int i = 0; i < 8; i++) {
			tabuleiro.mPecas[1][i] = new Peao(Cor.BRANCO, 1, i);
			tabuleiro.mPecas[6][i] = new Peao(Cor.PRETO, 6, i);
		}
	}
	
}
