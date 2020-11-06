package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;

class Bispo extends Peca {

	public Bispo(Cor cor, int x, int y) {
		super(cor, x, y);
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
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o restante da direcao esta invalida.
				}
			} else { // posicao esta livre, pois nao contem peca.
				List<Integer> innerList = new ArrayList<>();
				innerList.add(xPositivo);
				innerList.add(yPositivo);
		        listOfLists.add(innerList);
			}
			xPositivo++;
			yPositivo++;
		}
		
		return listOfLists;
	}
	
	private List<List<Integer>> getCasasDiagonalDireitaInferior(int x, int y, Casa[][] tabCasas) {
		List<List<Integer>> listOfLists = new ArrayList<>();
		
		int xNegativo = x;
		int yPositivo = y;
		
		if(xNegativo >= 0 && yPositivo < 7) {
			xNegativo--;
			yPositivo++;
		}
		
		//iterando na diagonal direita inferior
		while(xNegativo >= 0 && yPositivo < 8) {
			// ver se a casa é uma peca
			if(tabCasas[xNegativo][yPositivo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xNegativo][yPositivo].getPeca().getCor() != this.getCor()) { // ve se a peca é inimiga			
					List<Integer> innerList = new ArrayList<>();
					innerList.add(xNegativo);
					innerList.add(yPositivo);
			        listOfLists.add(innerList);
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o restante da direcao esta invalida.
				}
			} else { // posicao esta livre, pois nao contem peca.
				List<Integer> innerList = new ArrayList<>();
				innerList.add(xNegativo);
				innerList.add(yPositivo);
		        listOfLists.add(innerList);
			}
			xNegativo--;
			yPositivo++;
		}
		return listOfLists;
	}
	
	private List<List<Integer>> getCasasDiagonalEsquerdaSuperior(int xRei, int yRei, Casa[][] tabCasas) {
		List<List<Integer>> listOfLists = new ArrayList<>();
		
		int xPositivo = xRei;
		int yNegativo = yRei;
		
		if(xPositivo < 8 && yNegativo >= 0) {
			xPositivo++;
			yNegativo--;
		}
		
		// iterando na diagonal esquerda superior
		while(xPositivo < 8 && yNegativo >= 0) {
			// ver se a casa é uma peca
			if(tabCasas[xPositivo][yNegativo].getPeca() != null) { // ve se a posicao tem uma peca
				if(tabCasas[xPositivo][yNegativo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					List<Integer> innerList = new ArrayList<>();
					innerList.add(xPositivo);
					innerList.add(yNegativo);
			        listOfLists.add(innerList);
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o restante da direcao esta invalida.
				}
			} else { // posicao esta livre, pois nao contem peca.
				List<Integer> innerList = new ArrayList<>();
				innerList.add(xPositivo);
				innerList.add(yNegativo);
		        listOfLists.add(innerList);
			}
			xPositivo++;
			yNegativo--;
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
				if(tabCasas[xNegativo][yNegativo].getPeca().getCor() != this.getCor()) { // ve se a peca tem cor diferente do rei		
					List<Integer> innerList = new ArrayList<>();
					innerList.add(xNegativo);
					innerList.add(yNegativo);
			        listOfLists.add(innerList);
				}else {
					break; //nao precisa mais ver, pq se sao da mesma cor o restante da direcao esta invalida.
				}
			} else { // posicao esta livre, pois nao contem peca.
				List<Integer> innerList = new ArrayList<>();
				innerList.add(xNegativo);
				innerList.add(yNegativo);
		        listOfLists.add(innerList);
			}
			xNegativo--;
			yNegativo--;
		}
		return listOfLists;
	}
	
	protected List<List<Integer>> getMovimentosValidos() {
		List<List<Integer>> movimentosValidos = new ArrayList<>();
		int xBispo = this.x;
		int yBispo = this.y;
		Tabuleiro t = Tabuleiro.getTabuleiro();
		
		movimentosValidos.addAll(this.getCasasDiagonalDireitaSuperior(xBispo, yBispo, t.getCasas()));
		movimentosValidos.addAll(this.getCasasDiagonalDireitaInferior(xBispo, yBispo, t.getCasas()));
		movimentosValidos.addAll(this.getCasasDiagonalEsquerdaSuperior(xBispo, yBispo, t.getCasas()));
		movimentosValidos.addAll(this.getCasasDiagonalEsquerdaInferior(xBispo, yBispo, t.getCasas()));
		return movimentosValidos;
	}

}
