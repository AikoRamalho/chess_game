package model;

import java.util.ArrayList;
import java.util.List;

import common.Cor;

class Peao extends Peca {

	public Peao(Cor cor, int x, int y) {
		super(cor, x, y);
		// TODO Auto-generated constructor stub
	}
	
	//retorna uma lista com as coordenadas possíveis
	private List<List<Integer>> getCasas(int x, int y, Casa[][] tabCasas) { 
        List<List<Integer>> listOfLists = new ArrayList<>();
        Peca diagBrancaDir = tabCasas[x+1][y+1].getPeca();
        Peca diagBrancaEsq = tabCasas[x+1][y-1].getPeca();
        Peca diagPretaDir = tabCasas[x-1][y+1].getPeca();
        Peca diagPretaEsq = tabCasas[x-1][y-1].getPeca();
        
        if(this.getCor() == Cor.BRANCO) {
        	if(x == 1) { //está na casa inicial
    	        List<Integer> innerList = new ArrayList<>();
    	        List<Integer> innerList2 = new ArrayList<>();
    	        innerList.add(x+1);
    			innerList.add(y);
    	        listOfLists.add(innerList);
    	        innerList2.add(x+2);
    	        innerList2.add(y);
    	        listOfLists.add(innerList2);	        
            }
        	else {
        		if(x+1 < 8) {
        			if(tabCasas[x+1][y].getPeca() == null) { //se a casa da frente estiver vazia
        				List<Integer> innerList = new ArrayList<>();
            	        innerList.add(x+1);
            			innerList.add(y);
            			listOfLists.add(innerList);
        			}                	
        			//diagonal Branco:
        			if(y+1 < 8 && diagBrancaDir != null && diagBrancaDir.getCor() == Cor.PRETO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x+1);
        				innerList2.add(y+1);
        				listOfLists.add(innerList2);
        	        }
        			if(y-1 >= 0 && diagBrancaEsq != null && diagBrancaEsq.getCor() == Cor.PRETO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x+1);
        				innerList2.add(y-1);
        				listOfLists.add(innerList2);
        	        }
                }
        	}            
        }
        else { //se for preto
        	if(x == 6) { //está na casa inicial
    	        List<Integer> innerList = new ArrayList<>();
    	        List<Integer> innerList2 = new ArrayList<>();
    	        innerList.add(x-1);
    			innerList.add(y);
    	        listOfLists.add(innerList);
    	        innerList2.add(x-2);
    	        innerList2.add(y);
    	        listOfLists.add(innerList2);	        
            }
        	else {
        		if(x-1 >= 0) {
        			if(tabCasas[x-1][y].getPeca() == null) { //se a casa da frente estiver vazia
        				List<Integer> innerList = new ArrayList<>();
            	        innerList.add(x-1);
            			innerList.add(y);
            			listOfLists.add(innerList);
        			}                	
        			if(y+1 < 8 && diagPretaDir != null && diagPretaDir.getCor() == Cor.BRANCO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x-1);
        				innerList2.add(y+1);
        				listOfLists.add(innerList2);
        	        }
        			if(y-1 >= 0 && diagPretaEsq != null && diagPretaEsq.getCor() == Cor.BRANCO) {
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
		
		return movimentosValidos;
	}
	
	@Override
	public boolean movimentoValido(int xDestino, int yDestino)
	{
		super.movimentoValido(xDestino, yDestino);
		System.out.println("aaaaaaaa");
		return true;
	}
}
