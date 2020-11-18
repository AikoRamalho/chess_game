package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;
import common.TiposPeca;

class Cavalo extends Peca {

	public Cavalo(Cor cor, int x, int y) {
		super(TiposPeca.CAVALO,cor, x, y);
	}
	
	private boolean getMovimentoValidoPos(int xCavalo, int yCavalo, Casa[][] tabCasas) {
		if (xCavalo > 7 || yCavalo > 7 || xCavalo < 0 || yCavalo < 0) {
			return false;
		}
		if(tabCasas[xCavalo][yCavalo].getPeca() == null) {
			return true;
		}
		if(tabCasas[xCavalo][yCavalo].getPeca().getCor() != this.getCor()) {
			return true;
		}
		return false;
	}
	
	private List<List<Integer>> getCasas(int x, int y, Casa[][] tabCasas) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        
        if(this.getMovimentoValidoPos(x+1, y+2, tabCasas)) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x+1);
			innerList.add(y+2);
	        listOfLists.add(innerList);
        }

        if(this.getMovimentoValidoPos(x+2, y+1, tabCasas)) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x+2);
			innerList.add(y+1);
	        listOfLists.add(innerList);
        }
        
        if(this.getMovimentoValidoPos(x+2, y-1, tabCasas)) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x+2);
			innerList.add(y-1);
	        listOfLists.add(innerList);
        }
        
        if(this.getMovimentoValidoPos(x+1, y-2, tabCasas)) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x+1);
			innerList.add(y-2);
	        listOfLists.add(innerList);
        }
        
        if(this.getMovimentoValidoPos(x-1, y-2, tabCasas)) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x-1);
			innerList.add(y-2);
	        listOfLists.add(innerList);
        }
        
        if(this.getMovimentoValidoPos(x-2, y-1, tabCasas)) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x-2);
			innerList.add(y-1);
	        listOfLists.add(innerList);
        }
        
        if(this.getMovimentoValidoPos(x-2, y+1, tabCasas)) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x-2);
			innerList.add(y+1);
	        listOfLists.add(innerList);
        }
        
        if(this.getMovimentoValidoPos(x-1, y+2, tabCasas)) {
	        List<Integer> innerList = new ArrayList<>();
	        innerList.add(x-1);
			innerList.add(y+2);
	        listOfLists.add(innerList);
        }
        
        System.out.println(listOfLists);
        
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
