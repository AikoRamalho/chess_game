package model;

import common.Cor;

class Tabuleiro {
	public Peca[][] mPecas = new Peca[8][8];
	private static Tabuleiro tabuleiro = null;
	
	// TODO: Decidir se o singleton fica aqui ou no Facade.
	public Tabuleiro getTabuleiro() {
		if(tabuleiro != null)
			return tabuleiro;
		
		tabuleiro = new Tabuleiro();
		tabuleiro.setTabuleiro();
		
		return tabuleiro;
	}
	
	public void setTabuleiro() {
		mPecas[0][0] = new Torre(Cor.BRANCO, 0, 0);
		mPecas[7][0] = new Torre(Cor.PRETO, 7, 0);
		
		mPecas[0][7] = new Torre(Cor.BRANCO, 0, 7);
		mPecas[7][7] = new Torre(Cor.PRETO, 7, 7);
		
		mPecas[0][1] = new Cavalo(Cor.BRANCO, 0, 1);
		mPecas[7][1] = new Cavalo(Cor.PRETO, 7, 1);
		
		mPecas[0][6] = new Cavalo(Cor.BRANCO, 0, 6);
		mPecas[7][6] = new Cavalo(Cor.PRETO, 7, 6);
		
		mPecas[0][2] = new Bispo(Cor.BRANCO, 0, 2);
		mPecas[7][2] = new Bispo(Cor.PRETO, 7, 2);
		
		mPecas[0][5] = new Bispo(Cor.BRANCO, 0, 5);
		mPecas[7][5] = new Bispo(Cor.PRETO, 7, 5);
		
		mPecas[0][3] = new Rainha(Cor.BRANCO, 0, 3);
		mPecas[7][3] = new Rainha(Cor.PRETO, 7, 3);
		
		mPecas[0][4] = new Rei(Cor.BRANCO, 0, 4);
		mPecas[7][4] = new Rei(Cor.PRETO, 7, 4);
		
		for(int i = 0; i < 8; i++) {
			mPecas[1][i] = new Peao(Cor.BRANCO, 1, i);
			mPecas[6][i] = new Peao(Cor.PRETO, 6, i);
		}
	}
	
}
