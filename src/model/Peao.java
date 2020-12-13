package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;
import common.TiposPeca;

class Peao extends Peca {

	public Peao(Cor cor, int x, int y) {
		super(TiposPeca.PEAO,cor, x, y);
		// TODO Auto-generated constructor stub
	}
	
	//retorna uma lista com as coordenadas possíveis
	private List<List<Integer>> getCasas(int x, int y, Casa[][] tabCasas) { //x é coluna, y é linha
        List<List<Integer>> listOfLists = new ArrayList<>();
        
        if(this.getCor() == Cor.BRANCO) {
        	Peca diagBrancaDir = null;
        	if(x<7) {
        		diagBrancaDir = tabCasas[x+1][y+1].getPeca();
        	}
            Peca diagBrancaEsq = null;
            if(x>0) {
            	diagBrancaEsq = tabCasas[x-1][y+1].getPeca();
            }
        	if(y == 1) { //está na casa inicial     	        
    	        if(tabCasas[x][y+1].getPeca() == null) {
    	        	List<Integer> innerList = new ArrayList<>();
    	        	innerList.add(x);
        			innerList.add(y+1);
        	        listOfLists.add(innerList);
        	        if(tabCasas[x][y+2].getPeca() == null) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        	        	innerList2.add(x);
            	        innerList2.add(y+2);
            	        listOfLists.add(innerList2);
        	        }
    	        }
    	        if(x+1 < 8 && diagBrancaDir != null && diagBrancaDir.getCor() == Cor.PRETO) {
    	        	List<Integer> innerList1 = new ArrayList<>();
    	        	innerList1.add(x+1);
    		        innerList1.add(y+1);
    				listOfLists.add(innerList1);
    	        }
    			if(x-1 >= 0 && diagBrancaEsq != null && diagBrancaEsq.getCor() == Cor.PRETO) {
    	        	List<Integer> innerList1 = new ArrayList<>();
    	        	innerList1.add(x-1);
    	        	innerList1.add(y+1);
    				listOfLists.add(innerList1);
    	        }
            }
        	else {        		
        		if(y+1 < 8) {
        			if(tabCasas[x][y+1].getPeca() == null) { //se a casa da frente estiver vazia
        				List<Integer> innerList = new ArrayList<>();
            	        innerList.add(x);
            			innerList.add(y+1);
            			listOfLists.add(innerList);
        			}                	
        			//diagonal Branco:        			
        			if(x+1 < 8 && diagBrancaDir != null && diagBrancaDir.getCor() == Cor.PRETO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x+1);
        				innerList2.add(y+1);
        				listOfLists.add(innerList2);
        	        }
        			
        			if(x-1 >= 0 && diagBrancaEsq != null && diagBrancaEsq.getCor() == Cor.PRETO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x-1);
        				innerList2.add(y+1);
        				listOfLists.add(innerList2);
        	        }        	        
                }
        	}            
        }
        else { //se for preto
            Peca diagPretaDir = null;
        	if(x<7) {
        		diagPretaDir = tabCasas[x+1][y-1].getPeca();
        	}
            Peca diagPretaEsq = null;
            if(x>0) {
            	diagPretaEsq = tabCasas[x-1][y-1].getPeca();
            }
        	if(y == 6) { //está na casa inicial    	        
    	        
    	        if(tabCasas[x][y-1].getPeca() == null) {
    	        	List<Integer> innerList = new ArrayList<>();
    	        	innerList.add(x);
        			innerList.add(y-1);
        	        listOfLists.add(innerList);
        	        if(tabCasas[x][y-2].getPeca() == null) { //só pode ir pra segunda casa, se a primeira estiver vazia
        	        	List<Integer> innerList2 = new ArrayList<>();
        	        	innerList2.add(x);
            	        innerList2.add(y-2);
            	        listOfLists.add(innerList2);
        	        } 
    	        }
    	           	        	
    	        if(x+1 < 8 && diagPretaDir != null && diagPretaDir.getCor() == Cor.BRANCO) {
    	        	List<Integer> innerList1 = new ArrayList<>();
    	        	innerList1.add(x+1);
    		        innerList1.add(y-1);
    				listOfLists.add(innerList1);
    	        }
    			if(x-1 >= 0 && diagPretaEsq != null && diagPretaEsq.getCor() == Cor.BRANCO) {
    	        	List<Integer> innerList1 = new ArrayList<>();
    	        	innerList1.add(x-1);
    	        	innerList1.add(y-1);
    				listOfLists.add(innerList1);
    	        }
            }
        	else {
        		if(y-1 >= 0) {
        			if(tabCasas[x][y-1].getPeca() == null) { //se a casa da frente estiver vazia
        				List<Integer> innerList = new ArrayList<>();
            	        innerList.add(x);
            			innerList.add(y-1);
            			listOfLists.add(innerList);
        			}                	
        			if(x+1 < 8 && y-1 >= 0 && tabCasas[x+1][y-1].getPeca() != null && tabCasas[x+1][y-1].getPeca().getCor() == Cor.BRANCO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x+1);
        				innerList2.add(y-1);
        				listOfLists.add(innerList2);
        	        }
        			if(x-1 >= 0 && y-1 >= 0 && tabCasas[x-1][y-1].getPeca() != null && tabCasas[x-1][y-1].getPeca().getCor() == Cor.BRANCO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x-1);
        				innerList2.add(y-1);
        				listOfLists.add(innerList2);
        	        }
                }
        	}            
        }        
        
        return listOfLists;
        
	}

	public List<List<Integer>> getMovimentosValidos() {
		List<List<Integer>> movimentosValidos = new ArrayList<>();
		int xPeao = this.x;
		int yPeao = this.y;
		Tabuleiro t = Tabuleiro.getTabuleiro();
		
		movimentosValidos.addAll(this.getCasas(xPeao, yPeao, t.getCasas()));
		movimentosValidos.removeIf(mov -> t.getCasas()[mov.get(0)][mov.get(1)].getPeca() instanceof Rei);
		movimentosValidos.removeIf(mov -> t.verificaMovimentoTiraDoXeque(this.getX(), this.getY(), mov.get(0), mov.get(1)));
		
		
		return movimentosValidos;
	}
	/*
	@Override
	public boolean movimentoValido(int xDestino, int yDestino)
	{
		super.movimentoValido(xDestino, yDestino);
		return true;
	}
	*/
}
