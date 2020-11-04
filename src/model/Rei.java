package model;

import common.Cor;

class Rei extends Peca {

	public Rei(Cor cor, int x, int y) {
		super(cor, x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	private boolean checkYPositivo(int xRei, int yRei, Casa[][] tabCasas) {
		//iterando na direção p/ cima do yRei
		int aux = yRei+1;
		while(aux < 8) {
			// ver se a casa é uma peça
			if(tabCasas[xRei][aux].getPeca() != null) { // ve se a posicao tem uma peca 
				if(tabCasas[xRei][aux].getPeca().getCor() != this.getCor()) {	// ve se a peca tem cor diferente do rei						
					if (tabCasas[xRei][aux].getPeca() instanceof Rainha || tabCasas[xRei][aux].getPeca() instanceof Torre) {
						return true;
					}else { // outras peças q n sejam rainha ou torre nao oferecem perigo pro rei quando estao na mesma coluna q ele
						break;
					}
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o rei ta protegido naquela posicao
				}
			}
			aux++;
		}
		return false;
	}
	
	private boolean checkYNegativo(int xRei, int yRei, Casa[][] tabCasas) {
		int aux = yRei - 1;
		
		//iterando na direção p/ baixo do yRei 
		while(aux >= 0) {
			// ver se a casa é uma peça
			if(tabCasas[xRei][aux].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xRei][aux].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xRei][aux].getPeca() instanceof Rainha || tabCasas[xRei][aux].getPeca() instanceof Torre) {
						return true;
					}else { // outras peças q n sejam rainha ou torre nao oferecem perigo pro rei quando estao na mesma coluna q ele
						break;
					}
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o rei ta protegido naquela posicao
				}
			}
			aux--;
		}
		return false;
	}

	private boolean checkXYPositivo(int xRei, int yRei, Casa[][] tabCasas) {
		
		int xPositivo = xRei;
		int yPositivo = yRei;
		
		if(xPositivo < 7 && yPositivo < 7) {
			xPositivo++;
			yPositivo++;
		}
		
		//iterando na diagonal x-y positiva
		while(xPositivo < 8 && yPositivo < 8) {
			// ver se a casa é uma peça
			if(tabCasas[xPositivo][yPositivo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xPositivo][yPositivo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xPositivo][yPositivo].getPeca() instanceof Rainha || tabCasas[xPositivo][yPositivo].getPeca() instanceof Bispo) {
						return true;
					}else { // outras peças q n sejam rainha ou bispo nao oferecem perigo pro rei quando estao na mesma diagonal q ele
						break;
					}
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o rei ta protegido naquela posicao
				}
			}
			xPositivo++;
			yPositivo++;
		}
		return false;
	}
	
	private boolean checkXNegativoYPositivo(int xRei, int yRei, Casa[][] tabCasas) {
		
		int xNegativo = xRei;
		int yPositivo = yRei;
		
		if(xNegativo >= 0 && yPositivo < 7) {
			xNegativo--;
			yPositivo++;
		}
		
		//iterando na diagonal x-y positiva
		while(xNegativo >= 0 && yPositivo < 8) {
			// ver se a casa é uma peça
			if(tabCasas[xNegativo][yPositivo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xNegativo][yPositivo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xNegativo][yPositivo].getPeca() instanceof Rainha || tabCasas[xNegativo][yPositivo].getPeca() instanceof Bispo) {
						return true;
					}else { // outras peças q n sejam rainha ou bispo nao oferecem perigo pro rei quando estao na mesma diagonal q ele
						break;
					}
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o rei ta protegido naquela posicao
				}
			}
			xNegativo--;
			yPositivo++;
		}
		return false;
	}
	
	private boolean checkXNegativoYNegativo(int xRei, int yRei, Casa[][] tabCasas) {
		int xNegativo = xRei;
		int yNegativo = yRei;
		
		if(xNegativo >= 0 && yNegativo >= 0) {
			xNegativo--;
			yNegativo--;
		}
		
		//iterando na diagonal x-y positiva
		while(xNegativo >= 0 && yNegativo >= 0) {
			// ver se a casa é uma peça
			if(tabCasas[xNegativo][yNegativo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xNegativo][yNegativo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xNegativo][yNegativo].getPeca() instanceof Rainha || tabCasas[xNegativo][yNegativo].getPeca() instanceof Bispo) {
						return true;
					}else { // outras peças q n sejam rainha ou bispo nao oferecem perigo pro rei quando estao na mesma diagonal q ele
						break;
					}
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o rei ta protegido naquela posicao
				}
			}
			xNegativo--;
			yNegativo--;
		}
		return false;
	}
	
	private boolean checkXPositivoYNegativo(int xRei, int yRei, Casa[][] tabCasas) {
		int xPositivo = xRei;
		int yNegativo = yRei;
		
		if(xPositivo < 8 && yNegativo >= 0) {
			xPositivo++;
			yNegativo--;
		}
		
		//iterando na diagonal x-y positiva
		while(xPositivo < 8 && yNegativo >= 0) {
			// ver se a casa é uma peça
			if(tabCasas[xPositivo][yNegativo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xPositivo][yNegativo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xPositivo][yNegativo].getPeca() instanceof Rainha || tabCasas[xPositivo][yNegativo].getPeca() instanceof Bispo) {
						return true;
					}else { // outras peças q n sejam rainha ou bispo nao oferecem perigo pro rei quando estao na mesma diagonal q ele
						break;
					}
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o rei ta protegido naquela posicao
				}
			}
			xPositivo++;
			yNegativo--;
		}
		return false;
	}
	
	private boolean checaSePeaoChecouRei(int xRei, int yRei, Casa[][] tabCasas) {
		Cor corDoRei = this.getCor();
		
		if(corDoRei == Cor.BRANCO) { // se a cor for branco
			if(yRei+1 < 8) { // se a casa de cima do tabuleiro ainda estiver no tabuleiro
				if(xRei+1 < 8) { // se a casa do lado direito estiver no tabuleiro
					if(tabCasas[xRei+1][yRei+1].getPeca() != null && 
					   tabCasas[xRei+1][yRei+1].getPeca().getCor() == Cor.PRETO && 
					   tabCasas[xRei+1][yRei+1].getPeca() instanceof Peao ) { // se a peca do lado direito na casa de cima for um peao preto
						return true; // o rei esta em cheque
					}
				}
				if(xRei-1 >= 0) { // se a casa da esquerda estiver no tabuleiro
					if(tabCasas[xRei-1][yRei+1].getPeca() != null && 
					   tabCasas[xRei-1][yRei+1].getPeca().getCor() == Cor.PRETO &&
					   tabCasas[xRei-1][yRei+1].getPeca() instanceof Peao ) { // se a casa da esquerda e a casa de cima for um peao preto
						return true; // o rei branco esta em cheque
					}
				}
			}
		}
		
		if(corDoRei == Cor.PRETO) { // se a cor for preta (o rei esta em cima)
			if(yRei-1 >= 0) { // se a peca debaixo (na frente do rei preto) estiver dentro do tabuleiro
				if(xRei+1 < 8) { // se a peca da direita estiver dentro do tabuleiro
					if(tabCasas[xRei+1][yRei-1].getPeca() != null && 
					   tabCasas[xRei+1][yRei-1].getPeca().getCor() == Cor.BRANCO &&
					   tabCasas[xRei+1][yRei-1].getPeca() instanceof Peao ) { // se a peca embaixo do rei preto e a direita for um peao branco
						return true;
					}
				}
				if(xRei-1 >= 0) {
					if(tabCasas[xRei-1][yRei-1].getPeca() != null && 
					   tabCasas[xRei-1][yRei-1].getPeca().getCor() == Cor.BRANCO &&
					   tabCasas[xRei-1][yRei-1].getPeca() instanceof Peao ) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	boolean isChecked () {
		int xRei = this.x;
		int yRei = this.y;
		Tabuleiro t = Tabuleiro.getTabuleiro();
		
		if (t == null) {
			return false;
		}
		
		Casa[][] tabCasas = t.getCasas();	

		// Vamos começar verificando variando em y [0, 7]
		boolean yPositivo = this.checkYPositivo(xRei, yRei, tabCasas);
		boolean yNegativo = this.checkYNegativo(xRei, yRei, tabCasas);
		
		// verificar entre x [0, 7]
		
		// checar todas as diagonais
		boolean xPositivoYPositivo = this.checkXYPositivo(xRei, yRei, tabCasas);
		boolean xNegativoYPositivo = this.checkXNegativoYPositivo(xRei, yRei, tabCasas);
		boolean xNegativoYNegativo = this.checkXNegativoYNegativo(xRei, yRei, tabCasas);
		boolean xPositivoYNegativo = this.checkXPositivoYNegativo(xRei, yRei, tabCasas);
		
		//checar se tem peão checando o rei
		boolean reiChequePorPeao = checaSePeaoChecouRei(xRei, yRei, tabCasas);
		
		// cavalo checando o rei
		
		//ainda falta checar se tem um rei checando o rei mas vamos deixar isso p deois
		
		return yPositivo && yNegativo && xPositivoYPositivo && xNegativoYPositivo && xNegativoYNegativo && xPositivoYNegativo && reiChequePorPeao;
		
	}

}
