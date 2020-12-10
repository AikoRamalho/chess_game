package model;

import common.Cor;
import common.TiposPeca;

import java.util.List;
import java.util.ArrayList;

class Torre extends Peca {
	private boolean jaMovimentou = false;
	public Torre(Cor cor, int x, int y) {
		super(TiposPeca.TORRE,cor, x, y);
		// TODO Auto-generated constructor stub
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
	
	public boolean isJaMovimentou() {
		return jaMovimentou;
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
		List<List<Integer>> movimentosValidos = new ArrayList<>();
		int xTorre = this.x;
		int yTorre = this.y;
		Tabuleiro t = Tabuleiro.getTabuleiro();
		
		movimentosValidos.addAll(this.getCasasX(xTorre, yTorre, t.getCasas()));
		movimentosValidos.addAll(this.getCasasY(xTorre, yTorre, t.getCasas()));
		return movimentosValidos;
	}

}
