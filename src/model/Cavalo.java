package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;
import common.TiposPeca;

class Cavalo extends Peca {

	public Cavalo(Cor cor, int x, int y) {
		super(TiposPeca.CAVALO,cor, x, y);
	}
	
	private List<List<Integer>> getCasas(int x, int y, Casa[][] tabCasas) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        
        if(x+1 < 8 && y+2 < 8) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x+1);
			innerList.add(y+2);
	        listOfLists.add(innerList);
        }

        if(x+2 < 8 && y+1 < 8) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x+2);
			innerList.add(y+1);
	        listOfLists.add(innerList);
        }
        
        if(x+2 < 8 && y-1 >= 0) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x+2);
			innerList.add(y-1);
	        listOfLists.add(innerList);
        }
        
        if(x+1 < 8 && y-2 >= 0) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x+1);
			innerList.add(y-2);
	        listOfLists.add(innerList);
        }
        
        if(x-1 >= 0 && y-2 >= 0) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x-1);
			innerList.add(y-2);
	        listOfLists.add(innerList);
        }
        
        if(x-2 >= 0 && y-1 >= 0) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x-2);
			innerList.add(y-1);
	        listOfLists.add(innerList);
        }
        
        if(x-2 >= 0 && y+1 < 8) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x-2);
			innerList.add(y+1);
	        listOfLists.add(innerList);
        }
        
        if(x-1 >= 0 && y+2 < 8) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x-1);
			innerList.add(y+2);
	        listOfLists.add(innerList);
        }
        
        return listOfLists;
        
	}

	public List<List<Integer>> getMovimentosValidos() {
		List<List<Integer>> movimentosValidos = new ArrayList<>();
		int xCavalo = this.x;
		int yCavalo = this.y;
		Tabuleiro t = Tabuleiro.getTabuleiro();
		
		movimentosValidos.addAll(this.getCasas(xCavalo, yCavalo, t.getCasas()));
		
		return movimentosValidos;
	}
}
