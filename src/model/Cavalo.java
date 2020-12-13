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
        	int novoX = x+1;
        	int novoY = y+2;
        	if(tabCasas[novoX][novoY].getPeca() == null) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);        		
        	} else if(tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList); 
        	}
        }

        if(x+2 < 8 && y+1 < 8) {
        	int novoX = x+2;
        	int novoY = y+1;
        	if(tabCasas[novoX][novoY].getPeca() == null) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	} else if (tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	}
        }
        
        if(x+2 < 8 && y-1 >= 0) {
        	int novoX = x+2;
        	int novoY = y-1;
        	if(tabCasas[novoX][novoY].getPeca() == null) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	} else if (tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	}
        }
        
        if(x+1 < 8 && y-2 >= 0) {
        	int novoX = x+1;
        	int novoY = y-2;
        	if(tabCasas[novoX][novoY].getPeca() == null) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	} else if (tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	}
        }
        
        if(x-1 >= 0 && y-2 >= 0) {
        	int novoX = x-1;
        	int novoY = y-2;
        	if(tabCasas[novoX][novoY].getPeca() == null) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	} else if (tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	}
        }
        
        if(x-2 >= 0 && y-1 >= 0) {
        	int novoX = x-2;
        	int novoY = y-1;
        	if(tabCasas[novoX][novoY].getPeca() == null) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	} else if (tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	}
        }
        
        if(x-2 >= 0 && y+1 < 8) {
        	int novoX = x-2;
        	int novoY = y+1;
        	if(tabCasas[novoX][novoY].getPeca() == null) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	} else if (tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	}
        }
        
        if(x-1 >= 0 && y+2 < 8) {
        	int novoX = x-1;
        	int novoY = y+2;
        	if(tabCasas[novoX][novoY].getPeca() == null) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	} else if (tabCasas[novoX][novoY].getPeca().getCor() != this.getCor()) {
        		List<Integer> innerList = new ArrayList<>();
        		innerList.add(novoX);
        		innerList.add(novoY);
        		listOfLists.add(innerList);
        	}
        }
        
        System.out.println(listOfLists);
        
        return listOfLists;
        
	}

	private Rei getRei() {
		Tabuleiro t = Tabuleiro.getTabuleiro();
		List<Peca> pecas = t.getAllPecas();
		for (Peca peca: pecas) {
			if(peca instanceof Rei) {
				return (Rei) peca;
			}
		}
		return null;
	}
	
	public List<List<Integer>> getMovimentosValidos() {
		List<List<Integer>> movimentosValidos = new ArrayList<>();
		int xCavalo = this.x;
		int yCavalo = this.y;
		Tabuleiro t = Tabuleiro.getTabuleiro();

		final Rei rei = this.getRei();
		
		
		movimentosValidos.addAll(this.getCasas(xCavalo, yCavalo, t.getCasas()));
		movimentosValidos.removeIf(mov -> t.getCasas()[mov.get(0)][mov.get(1)].getPeca() instanceof Rei);
		movimentosValidos.removeIf(mov -> t.verificaMovimentoTiraDoXeque(this.getX(), this.getY(), mov.get(0), mov.get(1)));
		
		return movimentosValidos;
	}
}
