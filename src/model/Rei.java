package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import common.Cor;
import common.TiposPeca;

class Rei extends Peca {
	private boolean jaMovimentou = false;
	private boolean Roque = false;
	public Rei(Cor cor, int x, int y) {
		super(TiposPeca.REI,cor, x, y);
		// TODO Auto-generated constructor stub
	}
	
//	private boolean checkYPositivo(int xRei, int yRei, Casa[][] tabCasas) {
	private boolean xequeSuperior(int xRei, int yRei, Casa[][] tabCasas) {
		//iterando na dire��o p/ cima do yRei
		int aux = yRei+1;
		while(aux < 8) {
			// ver se a casa � uma pe�a
			if(tabCasas[xRei][aux].getPeca() != null) { // ve se a posicao tem uma peca 
				if(tabCasas[xRei][aux].getPeca().getCor() != this.getCor()) {	// ve se a peca tem cor diferente do rei						
					if (tabCasas[xRei][aux].getPeca() instanceof Rainha || tabCasas[xRei][aux].getPeca() instanceof Torre) {
						return true;
					}else { // outras pe�as q n sejam rainha ou torre nao oferecem perigo pro rei quando estao na mesma coluna q ele
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
	
//	private boolean checkYNegativo(int xRei, int yRei, Casa[][] tabCasas) {
	private boolean xequeInferior(int xRei, int yRei, Casa[][] tabCasas) {
		int aux = yRei - 1;
		
		//iterando na dire��o p/ baixo do yRei 
		while(aux >= 0) {
			// ver se a casa � uma pe�a
			if(tabCasas[xRei][aux].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xRei][aux].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xRei][aux].getPeca() instanceof Rainha || tabCasas[xRei][aux].getPeca() instanceof Torre) {
						return true;
					}else { // outras pe�as q n sejam rainha ou torre nao oferecem perigo pro rei quando estao na mesma coluna q ele
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

//	private boolean checkXYPositivo(int xRei, int yRei, Casa[][] tabCasas) {
	private boolean xequeDiagonalDireitaSuperior(int xRei, int yRei, Casa[][] tabCasas) {
		
		int xPositivo = xRei;
		int yPositivo = yRei;
		
		if(xPositivo < 7 && yPositivo < 7) {
			xPositivo++;
			yPositivo++;
		}
		
		//iterando na diagonal x-y positiva
		while(xPositivo < 8 && yPositivo < 8) {
			// ver se a casa � uma pe�a
			if(tabCasas[xPositivo][yPositivo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xPositivo][yPositivo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xPositivo][yPositivo].getPeca() instanceof Rainha || tabCasas[xPositivo][yPositivo].getPeca() instanceof Bispo) {
						return true;
					}else { // outras pe�as q n sejam rainha ou bispo nao oferecem perigo pro rei quando estao na mesma diagonal q ele
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
	
//	private boolean checkXNegativoYPositivo(int xRei, int yRei, Casa[][] tabCasas) {
	private boolean xequeDiagonalEsquerdaSuperior(int xRei, int yRei, Casa[][] tabCasas) {
		
		int xNegativo = xRei;
		int yPositivo = yRei;
		
		if(xNegativo >= 0 && yPositivo < 7) {
			xNegativo--;
			yPositivo++;
		}
		
		//iterando na diagonal x-y positiva
		while(xNegativo >= 0 && yPositivo < 8) {
			// ver se a casa � uma pe�a
			if(tabCasas[xNegativo][yPositivo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xNegativo][yPositivo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xNegativo][yPositivo].getPeca() instanceof Rainha || tabCasas[xNegativo][yPositivo].getPeca() instanceof Bispo) {
						return true;
					}else { // outras pe�as q n sejam rainha ou bispo nao oferecem perigo pro rei quando estao na mesma diagonal q ele
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
	
//	private boolean checkXNegativoYNegativo(int xRei, int yRei, Casa[][] tabCasas) {
	private boolean xequeDiagonalEsquerdaInferior(int xRei, int yRei, Casa[][] tabCasas) {
		int xNegativo = xRei;
		int yNegativo = yRei;
		
		if(xNegativo >= 0 && yNegativo >= 0) {
			xNegativo--;
			yNegativo--;
		}
		
		//iterando na diagonal x-y positiva
		while(xNegativo >= 0 && yNegativo >= 0) {
			// ver se a casa � uma pe�a
			if(tabCasas[xNegativo][yNegativo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xNegativo][yNegativo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xNegativo][yNegativo].getPeca() instanceof Rainha || tabCasas[xNegativo][yNegativo].getPeca() instanceof Bispo) {
						return true;
					}else { // outras pe�as q n sejam rainha ou bispo nao oferecem perigo pro rei quando estao na mesma diagonal q ele
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
	
//	private boolean checkXPositivoYNegativo(int xRei, int yRei, Casa[][] tabCasas) {
	private boolean xequeDiagonalDireitaInferior(int xRei, int yRei, Casa[][] tabCasas) {
		int xPositivo = xRei;
		int yNegativo = yRei;
		
		if(xPositivo < 8 && yNegativo >= 0) {
			xPositivo++;
			yNegativo--;
		}
		
		//iterando na diagonal x-y positiva
		while(xPositivo < 8 && yNegativo >= 0) {
			// ver se a casa � uma pe�a
			if(tabCasas[xPositivo][yNegativo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xPositivo][yNegativo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					if (tabCasas[xPositivo][yNegativo].getPeca() instanceof Rainha || tabCasas[xPositivo][yNegativo].getPeca() instanceof Bispo) {
						return true;
					}else { // outras pe�as q n sejam rainha ou bispo nao oferecem perigo pro rei quando estao na mesma diagonal q ele
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
	
	private boolean xequeEsquerda(int xRei, int yRei, Casa[][] tabCasas) {
		int aux = xRei-1;
		while(aux >= 0) {
			if(tabCasas[aux][yRei].getPeca() != null) {
				if(tabCasas[aux][yRei].getPeca().getCor() != this.getCor()) {
					if (tabCasas[aux][yRei].getPeca() instanceof Rainha ||
							tabCasas[aux][yRei].getPeca() instanceof Torre) {
						return true;
					} else { // outras pecas q n sejam rainha ou torre nao oferecem perigo pro rei quando estao na mesma coluna q ele
						break;
					}
				} else {
					break; //nao precisa mais ver, pq se sao da mesma cor o rei ta protegido naquela posicao
				}
			}
			aux--;
		}
		return false;
	}
	
	private boolean xequeDireita(int xRei, int yRei, Casa[][] tabCasas) {
		int aux = xRei+1;
		while(aux < 8) {
			if(tabCasas[aux][yRei].getPeca() != null) {
				if(tabCasas[aux][yRei].getPeca().getCor() != this.getCor()) {
					if (tabCasas[aux][yRei].getPeca() instanceof Rainha ||
							tabCasas[aux][yRei].getPeca() instanceof Torre) {
						return true;
					} else { // outras pecas q n sejam rainha ou torre nao oferecem perigo pro rei quando estao na mesma coluna q ele
						break;
					}
				} else {
					break; //nao precisa mais ver, pq se sao da mesma cor o rei ta protegido naquela posicao
				}
			}
			aux++;
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

		// Vamos come�ar verificando variando em y [0, 7]
		boolean yPositivo = this.xequeSuperior(xRei, yRei, tabCasas);
		boolean yNegativo = this.xequeInferior(xRei, yRei, tabCasas);
		
		// verificar entre x [0, 7]
		boolean xPositivo = this.xequeDiagonalDireitaInferior(xRei, yRei, tabCasas);
		boolean xNegativo = this.xequeDiagonalEsquerdaSuperior(xRei, yRei, tabCasas);
		
		// checar todas as diagonais
		boolean xPositivoYPositivo = this.xequeDiagonalDireitaSuperior(xRei, yRei, tabCasas);
		boolean xNegativoYPositivo = this.xequeDiagonalEsquerdaSuperior(xRei, yRei, tabCasas);
		boolean xNegativoYNegativo = this.xequeDiagonalEsquerdaInferior(xRei, yRei, tabCasas);
		boolean xPositivoYNegativo = this.xequeDiagonalDireitaInferior(xRei, yRei, tabCasas);
		
		//checar se tem pe�o checando o rei
		boolean reiChequePorPeao = checaSePeaoChecouRei(xRei, yRei, tabCasas);
		
		// cavalo checando o rei
		
		//ainda falta checar se tem um rei checando o rei mas vamos deixar isso p deois
		
		return yPositivo && yNegativo && xPositivoYPositivo && xNegativoYPositivo && xNegativoYNegativo && xPositivoYNegativo && reiChequePorPeao && xPositivo && xNegativo;
		
	}
		
	
	private boolean posicaoColocaReiEmCheque(int x, int y) {
		Tabuleiro t = Tabuleiro.getTabuleiro();
		if(xequeSuperior(x, y, t.getCasas())) {
//			System.out.println("xequeSuperior");
			return true;
		}
		if(xequeInferior(x, y, t.getCasas())) {
//			System.out.println("xequeInferior");
			return true;
		}
		if(xequeDiagonalDireitaSuperior(x, y, t.getCasas())) {
//			System.out.println("xequeDiagonalDireitaSuperior");
			return true;
		}
		if(xequeDiagonalEsquerdaSuperior(x, y, t.getCasas())) {
//			System.out.println("xequeDiagonalEsquerdaSuperior");
			return true;
		}
		if(xequeDiagonalEsquerdaInferior(x, y, t.getCasas())) {
//			System.out.println("xequeDiagonalEsquerdaInferior");
			return true;
		}
		if(xequeDiagonalDireitaInferior(x, y, t.getCasas())) {
//			System.out.println("xequeDiagonalDireitaInferior");
			return true;
		}
		if(xequeEsquerda(x, y, t.getCasas())) {
//			System.out.println("xequeEsquerda");
			return true;
		}
		if(xequeDireita(x, y, t.getCasas())) {
//			System.out.println("xequeDireita");
			return true;
		}
		return false;
	}
	
	private List<Integer> getSuperior(int x, int y, Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		if(y+1 < 8) {
			int novoX = x;
			int novoY = y+1;
			if(tabCasas[novoX][novoY].getPeca() == null) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			}
		}
		return innerList;
	}
	
	private List<Integer> getInferior(int x, int y, Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		if(y-1 >= 0) {
			int novoX = x;
			int novoY = y-1;
			if(tabCasas[novoX][novoY].getPeca() == null) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			}
		}
		return innerList;
	}
	
	private List<Integer> getDiagonalDireitaSuperior(int x, int y, Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		if(x+1 < 8 && y+1 < 8) {
			int novoX = x+1;
			int novoY = y+1;
			if(tabCasas[novoX][novoY].getPeca() == null) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			}
		}
		return innerList;
	}
	
	private List<Integer> getDireita(int x, int y, Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		if(x+1 < 8) {
			int novoX = x+1;
			int novoY = y;
			if(tabCasas[novoX][novoY].getPeca() == null) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			}
		}
		return innerList;
	}
	
	private List<Integer> getDiagonalDireitaInferior(int x, int y, Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		if(x+1 < 8 && y-1 >= 0) {
			int novoX = x+1;
			int novoY = y-1;
			if(tabCasas[novoX][novoY].getPeca() == null) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			}
		}
		return innerList;
	}
	
	private List<Integer> getDiagonalEsquerdaSuperior(int x, int y, Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		if(x-1 >= 0 && y+1 < 8) {
			int novoX = x-1;
			int novoY = y+1;
			if(tabCasas[novoX][novoY].getPeca() == null) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			}
		}
		return innerList;
	}
	
	private List<Integer> getEsquerda(int x, int y, Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		if(x-1 >= 0) {
			int novoX = x-1;
			int novoY = y;
			if(tabCasas[novoX][novoY].getPeca() == null) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			}
		}
		return innerList;
	}
	
	private List<Integer> getDiagonalEsquerdaInferior(int x, int y, Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		if(x-1 >= 0 && y-1 >= 0) {
			int novoX = x-1;
			int novoY = y-1;
			if(tabCasas[novoX][novoY].getPeca() == null) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
				innerList.add(novoX);
				innerList.add(novoY);
				return innerList;
			}
		}
		return innerList;
	}
	
	private List<Integer> getRoquePequeno(Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		// nao esta em xeque e nao se movimentou ainda
		if(!isChecked() && jaMovimentou == false) { 
			if(this.getCor() == Cor.BRANCO) {
				// é torre e nao foi movimentada ainda
				if(tabCasas[7][0].getPeca() instanceof Torre && 
						!((Torre) tabCasas[7][0].getPeca()).isJaMovimentou()) {
					// Nao ha peca no caminho
					if(tabCasas[this.x+1][0].getPeca() == null &&
							tabCasas[this.x+2][0].getPeca() == null) {
						// Casa nao e de dominio inimigo
						if(!posicaoColocaReiEmCheque(this.x+1,0) && 
								!posicaoColocaReiEmCheque(this.x+2,0)) {
							innerList.add(x+2);
							innerList.add(0);
							return innerList;
						}
					}
				}
			} else {
				// é torre e nao foi movimentada ainda
				if(tabCasas[7][7].getPeca() instanceof Torre && 
						!((Torre) tabCasas[7][7].getPeca()).isJaMovimentou()) {
					// Nao ha peca no caminho
					if(tabCasas[this.x+1][7].getPeca() == null &&
							tabCasas[this.x+2][7].getPeca() == null) {
						// Casa nao e de dominio inimigo
						if(!posicaoColocaReiEmCheque(this.x+1,7) && 
								!posicaoColocaReiEmCheque(this.x+2,7)) {
							innerList.add(x+2);
							innerList.add(7);
							return innerList;
						}
					}
				}
			}			
		}
		return innerList;
	}
	
	private List<Integer> getRoqueLongo(Casa[][] tabCasas) {
		List<Integer> innerList = new ArrayList<>();
		// nao esta em xeque e nao se movimentou ainda
		if(!isChecked() && jaMovimentou == false) { 
			if(this.getCor() == Cor.BRANCO) {
				// é torre e nao foi movimentada ainda
				if(tabCasas[0][0].getPeca() instanceof Torre && 
						!((Torre) tabCasas[0][0].getPeca()).isJaMovimentou()) {
					// Nao ha peca no caminho
					if(tabCasas[x-1][0].getPeca() == null &&
							tabCasas[x-2][0].getPeca() == null &&
							tabCasas[x-3][0].getPeca() == null) {
						// Casa nao e de dominio inimigo
						if(!posicaoColocaReiEmCheque(x-1,0) && 
								!posicaoColocaReiEmCheque(x-2,0) &&
								!posicaoColocaReiEmCheque(x-3,0)) {
							innerList.add(x-2);
							innerList.add(0);
							return innerList;
						}
					}
				}
			} else {
				// é torre e nao foi movimentada ainda
				if(tabCasas[0][7].getPeca() instanceof Torre && 
						!((Torre) tabCasas[0][7].getPeca()).isJaMovimentou()) {
					// Nao ha peca no caminho
					if(tabCasas[x-1][7].getPeca() == null &&
							tabCasas[x-2][7].getPeca() == null &&
							tabCasas[x-3][7].getPeca() == null) {
						// Casa nao e de dominio inimigo
						if(!posicaoColocaReiEmCheque(x-1,7) && 
								!posicaoColocaReiEmCheque(x-2,7) &&
								!posicaoColocaReiEmCheque(x-3,7)) {
							innerList.add(x-2);
							innerList.add(7);
							return innerList;
						}
					}
				}
			}			
		}
		return innerList;
	}
	
	private List<List<Integer>> movimentosDoRei() {
		List<List<Integer>> listOfLists = new ArrayList<>();
		int xRei = this.x;
		int yRei = this.y;
		Tabuleiro t = Tabuleiro.getTabuleiro();
		
		listOfLists.add(getSuperior(xRei, yRei, t.getCasas()));
		listOfLists.add(getInferior(xRei, yRei, t.getCasas()));
		listOfLists.add(getDiagonalDireitaSuperior(xRei, yRei, t.getCasas()));
		listOfLists.add(getDireita(xRei, yRei, t.getCasas()));
		listOfLists.add(getDiagonalDireitaInferior(xRei, yRei, t.getCasas()));
		listOfLists.add(getDiagonalEsquerdaSuperior(xRei, yRei, t.getCasas()));
		listOfLists.add(getEsquerda(xRei, yRei, t.getCasas()));
		listOfLists.add(getDiagonalEsquerdaInferior(xRei, yRei, t.getCasas()));
		listOfLists.add(getRoquePequeno(t.getCasas()));
		listOfLists.add(getRoqueLongo(t.getCasas()));
		listOfLists.removeIf(mov -> mov.size() == 0 || posicaoColocaReiEmCheque(mov.get(0),mov.get(1)));
		return listOfLists;
	}
	
	public boolean isJaMovimentou() {
		return jaMovimentou;
	}
	
	public boolean isRoque(int x, int y) {
		Tabuleiro t = Tabuleiro.getTabuleiro();
		List<List<Integer>> listOfLists = new ArrayList<>();
		listOfLists.add(getRoquePequeno(t.getCasas()));
		listOfLists.add(getRoqueLongo(t.getCasas()));
		for(List<Integer> mov: listOfLists) {
			if(mov.size() > 0) {
				if(mov.get(0) == x && mov.get(1) == y)
					return true;
			}
		}
		return false;	
	}
	
	@Override
	public void movePara(int x, int y) {
		if(!this.jaMovimentou)
			this.jaMovimentou = true;
		this.setX(x);
		this.setY(y);
	}

	@Override
	public List<List<Integer>> getMovimentosValidos() {
		return this.movimentosDoRei();
	}
	
}
