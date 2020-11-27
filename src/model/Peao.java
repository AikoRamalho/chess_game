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
        	if(y == 1) { //está na casa inicial 
    	        List<Integer> innerList = new ArrayList<>();
    	        List<Integer> innerList2 = new ArrayList<>();
    	        innerList.add(x);
    			innerList.add(y+1);
    	        listOfLists.add(innerList);
    	        innerList2.add(x);
    	        innerList2.add(y+2);
    	        listOfLists.add(innerList2);	        
            }//
        	else {
        		if(y+1 < 8) {
        			if(tabCasas[x][y+1].getPeca() == null) { //se a casa da frente estiver vazia
        				List<Integer> innerList = new ArrayList<>();
            	        innerList.add(x);
            			innerList.add(y+1);
            			listOfLists.add(innerList);
        			}                	
        			//diagonal Branco:
        			if(x+1 < 8 && y+1 < 8 && tabCasas[x+1][y+1].getPeca() != null && tabCasas[x+1][y+1].getPeca().getCor() == Cor.PRETO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x+1);
        				innerList2.add(y+1);
        				listOfLists.add(innerList2);
        	        }
        			if(x-1 >= 0 && y+1 < 8 && tabCasas[x-1][y+1].getPeca() != null && tabCasas[x-1][y+1].getPeca().getCor() == Cor.PRETO) {
        	        	List<Integer> innerList2 = new ArrayList<>();
        		        innerList2.add(x-1);
        				innerList2.add(y+1);
        				listOfLists.add(innerList2);
        	        }
                }
        	}            
        }
        else { //se for preto
        	if(y == 6) { //está na casa inicial
    	        List<Integer> innerList = new ArrayList<>();
    	        List<Integer> innerList2 = new ArrayList<>();
    	        innerList.add(x);
    			innerList.add(y-1);
    	        listOfLists.add(innerList);
    	        innerList2.add(x);
    	        innerList2.add(y-2);
    	        listOfLists.add(innerList2);	        
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
		
		return movimentosValidos;
	}
	
//	@Override
//	public boolean movimentoValido(int xDestino, int yDestino)
//	{
//		super.movimentoValido(xDestino, yDestino);
//		System.out.println("aaaaaaaa");
//		return true;
//	}
}