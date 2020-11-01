package model;

import common.Cor;

abstract class Peca {
	private boolean capturado;
	private Cor cor;
	private int linha,coluna;
	
	public Peca(Cor cor, int linha, int coluna) {
		this.capturado = false;
		this.cor = cor;
		this.linha = linha;
		this.coluna = coluna;
	}

	public boolean isCapturado() {
		return capturado;
	}

	public Cor getCor() {
		return cor;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[ " + cor + ", " + capturado + ", (" + linha +", "+ coluna +") ]";
	}
	
	public boolean isMovimentoIlegal(int novaLinha, int novaColuna) {
		Tabuleiro t = Tabuleiro.getTabuleiro();
		Rei rei = null;
		
		if(this.getLinha() == novaLinha && this.getColuna() == novaColuna)
			return false;
		
		for(int linha = 0; linha < 8; linha++) {
			for(int coluna = 0; coluna < 8; coluna++) {
				if(t.mPecas[linha][coluna] instanceof Rei &&
					t.mPecas[linha][coluna].getCor() == this.getCor()) { 
					rei = (Rei) t.mPecas[linha][coluna];
				}
			}
		}
		
		if(rei.isXeque()) {
			int linha = this.getLinha();
			int coluna = this.getColuna();
			// Faz copia em quem esta na nova posicao
			// TODO: Verificar se isso troca/remove a classe original, impede o instanceof
			Peca copia = t.mPecas[novaLinha][novaColuna];
			
			// Movimenta a peca e verifica
			this.setLinha(novaLinha);
			this.setColuna(novaColuna);
			t.mPecas[novaLinha][novaColuna] = this;
			
			if(rei.isXeque()) { // Rei continua em xeque e desfaz
				this.setLinha(linha);
				this.setColuna(coluna);
				t.mPecas[linha][coluna] = this;
				t.mPecas[novaLinha][novaColuna] = copia;
				return true;
			}
			// Apenas desfaz
			this.setLinha(linha);
			this.setColuna(coluna);
			t.mPecas[linha][coluna] = this;
			t.mPecas[novaLinha][novaColuna] = copia;
			
		} else {
			int linha = this.getLinha();
			int coluna = this.getColuna();
			// Faz copia em quem esta na nova posicao
			// TODO: Verificar se isso troca/remove a classe original
			Peca copia = t.mPecas[novaLinha][novaColuna];
			
			// Movimenta a peca e verifica
			this.setLinha(novaLinha);
			this.setColuna(novaColuna);
			t.mPecas[novaLinha][novaColuna] = this;
			
			if(rei.isXeque()) { // Movimento deixou rei em xeque
				this.setLinha(linha);
				this.setColuna(coluna);
				t.mPecas[linha][coluna] = this;
				t.mPecas[novaLinha][novaColuna] = copia;
				return true;
			}
			this.setLinha(linha);
			this.setColuna(coluna);
			t.mPecas[linha][coluna] = this;
			t.mPecas[novaLinha][novaColuna] = copia;
		}
		return false;
	}

	public abstract boolean movimentoValido(int x, int y);
}
