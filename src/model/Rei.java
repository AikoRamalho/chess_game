package model;

import common.Cor;

class Rei extends Peca {

	public Rei(Cor cor, int x, int y) {
		super(cor, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isXeque() {
		Tabuleiro t = Tabuleiro.getTabuleiro();
		
		// Varifica em linha horizontal
		for(int coluna = 0; coluna < this.getColuna(); coluna++) { // da esquerda ate o rei
			if(t.mPecas[this.getLinha()][coluna] != null) {
				if (t.mPecas[this.getLinha()][coluna].getCor() == this.getCor()) { // ta protegido
					continue;
				}
				if((t.mPecas[this.getLinha()][coluna] instanceof Rainha) ||
						(t.mPecas[this.getLinha()][coluna] instanceof Torre)) {
						return true;
				}
			}
		}
		for(int coluna = this.getColuna(); coluna < 8; coluna++) { // do rei ate o final da linha
			if(t.mPecas[this.getLinha()][coluna] != null) {
				if (t.mPecas[this.getLinha()][coluna].getCor() == this.getCor()) { // ta protegido
					continue;
				}
				if((t.mPecas[this.getLinha()][coluna] instanceof Rainha) ||
						(t.mPecas[this.getLinha()][coluna] instanceof Torre)) {
						return true;
				}
			}
		}
		// Verifica em linha vertical
		for(int linha = 0; linha < this.getColuna(); linha++) { // da costas do rei ate o fim
			if(t.mPecas[linha][this.getColuna()] != null) {
				if (t.mPecas[linha][this.getColuna()].getCor() == this.getCor()) { // ta protegido
					continue;
				}
				if((t.mPecas[linha][this.getColuna()] instanceof Rainha) ||
						(t.mPecas[linha][this.getColuna()] instanceof Torre)) {
						return true;
				}
			}
		}
		for(int linha = this.getLinha(); linha < 8; linha++) { // do rei ate o final da linha
			if(t.mPecas[linha][this.getColuna()] != null) {
				if (t.mPecas[linha][this.getColuna()].getCor() == this.getCor()) { // ta protegido
					continue;
				}
				if((t.mPecas[linha][this.getColuna()] instanceof Rainha) ||
						(t.mPecas[linha][this.getColuna()] instanceof Torre)) {
						return true;
				}
			}
		}
		// Verifica em diagonal
		for(int linha = this.getLinha()+1, coluna = this.getColuna()+1; linha < 8 && coluna < 8; linha++, coluna++) { // do rei ate o final da linha
			if(t.mPecas[linha][coluna] != null) {
				if (t.mPecas[linha][coluna].getCor() == this.getCor()) { // ta protegido
					continue;
				}
				if((t.mPecas[linha][coluna] instanceof Rainha) ||
						(t.mPecas[linha][coluna] instanceof Bispo)) {
						return true;
				}
			}
		}
		for(int linha = this.getLinha()-1, coluna = this.getColuna()-1; linha >= 0 && coluna >= 0; linha--, coluna--) { // do rei ate o final da linha
			if(t.mPecas[linha][coluna] != null) {
				if (t.mPecas[linha][coluna].getCor() == this.getCor()) { // ta protegido
					continue;
				}
				if((t.mPecas[linha][coluna] instanceof Rainha) ||
						(t.mPecas[linha][coluna] instanceof Bispo)) {
						return true;
				}
			}
		}
		for(int linha = this.getLinha()+1, coluna = this.getColuna()-1; linha < 8 && coluna >= 0; linha++, coluna--) { // do rei ate o final da linha
			if(t.mPecas[linha][coluna] != null) {
				if (t.mPecas[linha][coluna].getCor() == this.getCor()) { // ta protegido
					continue;
				}
				if((t.mPecas[linha][coluna] instanceof Rainha) ||
						(t.mPecas[linha][coluna] instanceof Bispo)) {
						return true;
				}
			}
		}
		for(int linha = this.getLinha()-1, coluna = this.getColuna()+1; linha >= 0 && coluna < 8; linha--, coluna++) { // do rei ate o final da linha
			if(t.mPecas[linha][coluna] != null) {
				if (t.mPecas[linha][coluna].getCor() == this.getCor()) { // ta protegido
					continue;
				}
				if((t.mPecas[linha][coluna] instanceof Rainha) ||
						(t.mPecas[linha][coluna] instanceof Bispo)) {
						return true;
				}
			}
		}
		
		
		int linha = this.getLinha();
		int coluna = this.getColuna();
		// Verifica Cavalo
		if((linha+2 < 8 && coluna+1 < 8) &&
		   (t.mPecas[linha+2][coluna+1] != null)	&&
		   (t.mPecas[linha+2][coluna+1].getCor() != this.getCor()) &&
		   (t.mPecas[linha+2][coluna+1] instanceof Cavalo) ) {
				return true;
			}
		if((linha+2 < 8 && coluna-1 >= 0) &&
		   (t.mPecas[linha+2][coluna-1] != null)	&&
		   (t.mPecas[linha+2][coluna-1].getCor() != this.getCor()) &&
		   (t.mPecas[linha+2][coluna-1] instanceof Cavalo) ) {
				return true;
			}
		if((linha-2 >=0 && coluna+1 < 8) &&
		   (t.mPecas[linha-2][coluna+1] != null)	&&
		   (t.mPecas[linha-2][coluna+1].getCor() != this.getCor()) &&
		   (t.mPecas[linha-2][coluna+1] instanceof Cavalo) ) {
				return true;
			}
		
		if((linha-2 >= 0 && coluna-1 >= 0) &&
		   (t.mPecas[linha-2][coluna-1] != null)	&&
		   (t.mPecas[linha-2][coluna-1].getCor() != this.getCor()) &&
		   (t.mPecas[linha-2][coluna-1] instanceof Cavalo) ) {
				return true;
			}
		if((linha+1 < 8 && coluna+2 < 8) &&
		   (t.mPecas[linha+1][coluna+2] != null)	&&
		   (t.mPecas[linha+1][coluna+2].getCor() != this.getCor()) &&
		   (t.mPecas[linha+1][coluna+2] instanceof Cavalo) ) {
				return true;
			}
		if((linha-1 >= 0 && coluna+2 < 8) &&
		   (t.mPecas[linha-1][coluna+2] != null)	&&
		   (t.mPecas[linha-1][coluna+2].getCor() != this.getCor()) &&
		   (t.mPecas[linha-1][coluna+2] instanceof Cavalo) ) {
				return true;
			}
		if((linha+1 < 8 && coluna-2 >= 0) &&
		   (t.mPecas[linha+1][coluna-2] != null)	&&
		   (t.mPecas[linha+1][coluna-2].getCor() != this.getCor()) &&
		   (t.mPecas[linha+1][coluna-2] instanceof Cavalo) ) {
				return true;
			}
		if((linha-1 >= 0 && coluna-2 >= 0) &&
		   (t.mPecas[linha-1][coluna-2] != null)	&&
		   (t.mPecas[linha-1][coluna-2].getCor() != this.getCor()) &&
		   (t.mPecas[linha-1][coluna-2] instanceof Cavalo) ) {
				return true;
			}
		
		// Verifica Peao
		if((linha+1 < 8 && coluna+1 < 8) &&
		   (t.mPecas[linha+1][coluna+1] != null)	&&
		   (t.mPecas[linha+1][coluna+1].getCor() != this.getCor()) &&
		   (t.mPecas[linha+1][coluna+1] instanceof Peao) ) {
				return true;
			}
		if((linha-1 >= 0 && coluna+1 < 8) &&
		   (t.mPecas[linha-1][coluna+1] != null)	&&
		   (t.mPecas[linha-1][coluna+1].getCor() != this.getCor()) &&
		   (t.mPecas[linha-1][coluna+1] instanceof Peao) ) {
				return true;
			}
		
		if((linha-1 >= 0 && coluna-1 >= 0) &&
		   (t.mPecas[linha-1][coluna-1] != null)	&&
		   (t.mPecas[linha-1][coluna-1].getCor() != this.getCor()) &&
		   (t.mPecas[linha-1][coluna-1] instanceof Peao) ) {
				return true;
			}
		if((linha+1 < 8 && coluna-1 >= 0) &&
		   (t.mPecas[linha+1][coluna-1] != null)	&&
		   (t.mPecas[linha+1][coluna-1].getCor() != this.getCor()) &&
		   (t.mPecas[linha+1][coluna-1] instanceof Peao) ) {
				return true;
			}
			
		return false;
	}

	@Override
	public boolean movimentoValido(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
