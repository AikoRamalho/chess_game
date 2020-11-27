package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;
import common.TiposPeca;

class Rainha extends Peca {

	public Rainha(Cor cor, int x, int y) {
		super(TiposPeca.RAINHA,cor, x, y);
		// TODO Auto-generated constructor stub
	}
	
	private List<List<Integer>> getCasasDiagonalDireitaSuperior(int x, int y, Casa[][] tabCasas) { 
		List<List<Integer>> listOfLists = new ArrayList<>();
		
		int xPositivo = x;
		int yPositivo = y;
		
		if(xPositivo < 7 && yPositivo < 7) {
			xPositivo++;
			yPositivo++;
		}
		
		//iterando na diagonal direita superior
		while(xPositivo < 8 && yPositivo < 8) {
			// ver se a casa é uma peca
			if(tabCasas[xPositivo][yPositivo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xPositivo][yPositivo].getPeca().getCor() != this.getCor()) { // ve se a peca é inimiga		
					List<Integer> innerList = new ArrayList<>();
					innerList.add(xPositivo);
					innerList.add(yPositivo);
			        listOfLists.add(innerList);
			        break;
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o restante da direcao esta invalida.
				}
			} else { // posicao esta livre, pois nao contem peca.
				List<Integer> innerList = new ArrayList<>();
				innerList.add(xPositivo);
				innerList.add(yPositivo);
		        listOfLists.add(innerList);
			}
			// Sobe uma coluna e uma linha
			xPositivo++;
			yPositivo++;
		}
		
		return listOfLists;
	}
	
	private List<List<Integer>> getCasasDiagonalDireitaInferior(int x, int y, Casa[][] tabCasas) {
		List<List<Integer>> listOfLists = new ArrayList<>();
		
		int xPositivo = x;
		int yNegativo = y;
		
		if(xPositivo < 7 && yNegativo >= 0) {
			xPositivo++;
			yNegativo--;
		}
		
		//iterando na diagonal direita inferior
		while(xPositivo < 8 && yNegativo >= 0) {
			// ver se a casa é uma peca
			if(tabCasas[xPositivo][yNegativo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xPositivo][yNegativo].getPeca().getCor() != this.getCor()) { // ve se a peca é inimiga			
					List<Integer> innerList = new ArrayList<>();
					innerList.add(xPositivo);
					innerList.add(yNegativo);
			        listOfLists.add(innerList);
			        break;
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o restante da direcao esta invalida.
				}
			} else { // posicao esta livre, pois nao contem peca.
				List<Integer> innerList = new ArrayList<>();
				innerList.add(xPositivo);
				innerList.add(yNegativo);
		        listOfLists.add(innerList);
			}
			// Sobe uma coluna e desce uma linha
			xPositivo++;
			yNegativo--;
		}
		return listOfLists;
	}
	
	private List<List<Integer>> getCasasDiagonalEsquerdaSuperior(int xRei, int yRei, Casa[][] tabCasas) {
		List<List<Integer>> listOfLists = new ArrayList<>();
		
		int xNegativo = xRei;
		int yPositivo = yRei;
		
		if(xNegativo >= 0 && yPositivo < 7) {
			xNegativo--;
			yPositivo++;
		}
		
		// iterando na diagonal esquerda superior
		while(xNegativo >= 0 && yPositivo < 8) {
			// ver se a casa é uma peca
			if(tabCasas[xNegativo][yPositivo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xNegativo][yPositivo].getPeca().getCor() != this.getCor()) { // ve se a peca é inimiga		
					List<Integer> innerList = new ArrayList<>();
					innerList.add(xNegativo);
					innerList.add(yPositivo);
			        listOfLists.add(innerList);
			        break;
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o restante da direcao esta invalida.
				}
			} else { // posicao esta livre, pois nao contem peca.
				List<Integer> innerList = new ArrayList<>();
				innerList.add(xNegativo);
				innerList.add(yPositivo);
		        listOfLists.add(innerList);
			}
			// Desce uma coluna e sobe uma linha
			xNegativo--;
			yPositivo++;
		}
		return listOfLists;
	}

	private List<List<Integer>> getCasasDiagonalEsquerdaInferior(int x, int y, Casa[][] tabCasas) {
		List<List<Integer>> listOfLists = new ArrayList<>();
		
		int xNegativo = x;
		int yNegativo = y;
		
		if(xNegativo >= 0 && yNegativo >= 0) {
			xNegativo--;
			yNegativo--;
		}
		
		// iterando na diagonal esquerda inferior
		while(xNegativo >= 0 && yNegativo >= 0) {
			// ver se a casa é uma peca
			if(tabCasas[xNegativo][yNegativo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xNegativo][yNegativo].getPeca().getCor() != this.getCor()) { // ve se a peca é inimiga		
					List<Integer> innerList = new ArrayList<>();
					innerList.add(xNegativo);
					innerList.add(yNegativo);
			        listOfLists.add(innerList);
			        break;
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o restante da direcao esta invalida.
				}
			} else { // posicao esta livre, pois nao contem peca.
				List<Integer> innerList = new ArrayList<>();
				innerList.add(xNegativo);
				innerList.add(yNegativo);
		        listOfLists.add(innerList);
			}
			// Desce uma coluna e uma linha
			xNegativo--;
			yNegativo--;
		}
		return listOfLists;
	}

	private List<List<Integer>> getCasasX(int x, int y, Casa[][] tabCasas) {
        List<List<Integer>> listOfLists = new ArrayList<>();
		
		for(int i = x+1; i<8; i++) { //iterar p/ direita da torre
			if(tabCasas[i][y].getPeca() == null) {
		        List<Integer> innerList = new ArrayList<>();
				innerList.add(i);
				innerList.add(y);
		        listOfLists.add(innerList);
			}else {
				if(tabCasas[i][y].getPeca().getCor() != this.getCor()) {
			        List<Integer> innerList = new ArrayList<>();
					innerList.add(i);
					innerList.add(y);
			        listOfLists.add(innerList);
				}
				break;
			}
		}
		
		for(int i = x-1; i>=0; i--) {
			if(tabCasas[i][y].getPeca() == null) {
		        List<Integer> innerList = new ArrayList<>();
				innerList.add(i);
				innerList.add(y);
		        listOfLists.add(innerList);
			}else {
				if(tabCasas[i][y].getPeca().getCor() != this.getCor()) {
			        List<Integer> innerList = new ArrayList<>();
					innerList.add(i);
					innerList.add(y);
			        listOfLists.add(innerList);
				}
				break;
			}
		}
		return listOfLists;
 	}
	
	private List<List<Integer>> getCasasY(int x, int y, Casa[][] tabCasas) {
        List<List<Integer>> listOfLists = new ArrayList<>();
		
		for(int i = y+1; i<8; i++) {
			if(tabCasas[x][i].getPeca() == null) {
		        List<Integer> innerList = new ArrayList<>();
		        innerList.add(x);
				innerList.add(i);
		        listOfLists.add(innerList);
			}else {
				if(tabCasas[x][i].getPeca().getCor() != this.getCor()) {
			        List<Integer> innerList = new ArrayList<>();
			        innerList.add(x);
					innerList.add(i);
			        listOfLists.add(innerList);
				}
				break;
			}
		}
		
		for(int i = y-1; i>=0; i--) {
			if(tabCasas[x][i].getPeca() == null) {
		        List<Integer> innerList = new ArrayList<>();
		        innerList.add(x);
				innerList.add(i);
		        listOfLists.add(innerList);
			}else {
				if(tabCasas[x][i].getPeca().getCor() != this.getCor()) {
			        List<Integer> innerList = new ArrayList<>();
			        innerList.add(x);
					innerList.add(i);
			        listOfLists.add(innerList);
				}
				break;
			}
		}
		return listOfLists;
 	}

	@Override
	public List<List<Integer>> getMovimentosValidos() {
		List<List<Integer>> movimentosValidos = new ArrayList<>();
		int xRainha = this.x;
		int yRainha = this.y;
		Tabuleiro t = Tabuleiro.getTabuleiro();
		
		movimentosValidos.addAll(this.getCasasX(xRainha, yRainha, t.getCasas()));
		movimentosValidos.addAll(this.getCasasY(xRainha, yRainha, t.getCasas()));
		movimentosValidos.addAll(this.getCasasDiagonalDireitaSuperior(xRainha, yRainha, t.getCasas()));
		movimentosValidos.addAll(this.getCasasDiagonalDireitaInferior(xRainha, yRainha, t.getCasas()));
		movimentosValidos.addAll(this.getCasasDiagonalEsquerdaSuperior(xRainha, yRainha, t.getCasas()));
		movimentosValidos.addAll(this.getCasasDiagonalEsquerdaInferior(xRainha, yRainha, t.getCasas()));
		
		return movimentosValidos;
	}
}
