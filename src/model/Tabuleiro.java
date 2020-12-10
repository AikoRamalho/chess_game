package model;

import java.util.ArrayList;
import java.util.List;

import common.Estado;
import common.Observable;
import common.Observer;

class Tabuleiro implements Observable {
	private Casa[][] casas = new Casa[8][8];
	private static Tabuleiro staticTabuleiro = null; // a gente quer um tab so pro jogo inteiro entao a gente cria um estatico p/ nao criar diferentes instancias
	private static Peca selecionada = null; //peca do tabuleiro selecionada
	List<Observer> lob=new ArrayList<Observer>();
	
	public static Tabuleiro getTabuleiro(Jogador j, Jogador j2) {
		if(staticTabuleiro != null)
			return staticTabuleiro;
		
		staticTabuleiro = new Tabuleiro();
		staticTabuleiro.setTabuleiro(j, j2);
		
		return staticTabuleiro;
	}
	
	public static Tabuleiro getTabuleiro() {
		if(staticTabuleiro != null)
			return staticTabuleiro;
		
		staticTabuleiro = new Tabuleiro();
		return staticTabuleiro;
	}
	
	public static void deleteTabuleiro() {
		staticTabuleiro = null;
	}
	
	protected Casa[][] getCasas() {
		return casas;
	}
	
	public boolean selecionaPeca(int x, int y, Jogador jogadorDaVez)
	{
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		if(staticTabuleiro.casas[x][y].getPeca() == null) {
			return false;
		}
		if(staticTabuleiro.casas[x][y].getPeca().getCor() == jogadorDaVez.getCor()) {
			setSelecionada(staticTabuleiro.casas[x][y].getPeca());
			return true;
		}
		return false;
	}
	
	public boolean selecionaCasa(int xDestino, int yDestino, Jogador jogadorDaVez) // esse metodo recebe as coordenadas de destino de uma pe�a previamente selecionada, validando a movimenta��o
	{
		if(xDestino < 0 || xDestino > 7 || yDestino < 0 || yDestino > 7) {
			return false;
		}
		// Verifica se a casa selecionanda contem peca aliada
		if(staticTabuleiro.casas[xDestino][yDestino].getPeca() != null && 
				staticTabuleiro.casas[xDestino][yDestino].getPeca().getCor() == selecionada.getCor()) {
//			return false;
			if(selecionada instanceof Rei) {
				selecionada.movimentoValido(xDestino, yDestino);
			} else {
				return false;
			}
		}
		// Verifica se a casa selecionanda é um movimento valido da peca
//		if(selecionada.movimentoValido(xDestino, yDestino)) {
//			return false;
//		}
//		return true;
		return selecionada.movimentoValido(xDestino, yDestino);
	}
	
	public void setTabuleiro(Jogador j, Jogador j2) {
		for(int i=0; i<8; i++) {
			for(int k=0; k<8;k++) {
				staticTabuleiro.casas[i][k] = new Casa(i, k, null);
			}
		}
		for(int i=0; i<j.getPecas().size(); i++){
			staticTabuleiro.casas[j.getPecas().get(i).getX()][j.getPecas().get(i).getY()].ocupaCasa(j.getPecas().get(i));
			staticTabuleiro.casas[j2.getPecas().get(i).getX()][j2.getPecas().get(i).getY()].ocupaCasa(j2.getPecas().get(i));
        }
		
		for(Observer o:lob) {
			o.notify(this);
		}
	}
	
	public void movePecaDePara(int xAtual, int yAtual, int xPara, int yPara) {
		Peca pecaParaMover = staticTabuleiro.getPeca(xAtual, yAtual);
		Peca pecaParaCapturar = staticTabuleiro.getPeca(xPara, yPara);
		if(pecaParaCapturar == null) { // posicao vazia
			// é roque
			if(staticTabuleiro.casas[xAtual][yAtual].getPeca() instanceof Rei &&
					((Rei)staticTabuleiro.casas[xAtual][yAtual].getPeca()).isRoque(xPara,yPara)) {
				System.out.println("Roque");
				if(xPara == 6) { // roque curto
					Torre torre = (Torre)staticTabuleiro.casas[7][yPara].getPeca();
					staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
					pecaParaMover.movePara(xPara, yPara);
					staticTabuleiro.casas[xPara-1][yPara].setPeca(torre);
					torre.movePara(xPara-1, yPara);
					staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
				} else { // roque longo
					Torre torre = (Torre)staticTabuleiro.casas[0][yPara].getPeca();
					staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
					pecaParaMover.movePara(xPara, yPara);
					staticTabuleiro.casas[xPara+1][yPara].setPeca(torre);
					torre.movePara(xPara+1, yPara);
					staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
				}
			} else {
				staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
//				pecaParaMover.setX(xPara);
//				pecaParaMover.setY(yPara);
				pecaParaMover.movePara(xPara, yPara);
				staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
			}			
		} else {
			staticTabuleiro.casas[xPara][yPara].setPeca(pecaParaMover);
//			pecaParaMover.setX(xPara);
//			pecaParaMover.setY(yPara);
			pecaParaMover.movePara(xPara, yPara);
			staticTabuleiro.casas[xAtual][yAtual].setPeca(null);
			
			// Talvez seja desnecessario.
			pecaParaCapturar.setEstado();
			pecaParaCapturar.setX(-1);
			pecaParaCapturar.setY(-1);
		}
		
		for(Observer o:lob) {
			o.notify(this);
		}
	}
	
	public Peca getPeca(int x, int y) {
		return staticTabuleiro.casas[x][y].getPeca();
	}
	
	public List<Peca> getAllPecas() {
		List<Peca> lista = new ArrayList<>();
		for(int x = 0; x<8;x++) {
			for(int y=0;y<8;y++) {
				if(this.getPeca(x,y) != null) {
					lista.add(staticTabuleiro.getPeca(x,y));
				}
			}
		}
		return lista;
	}
	
	public List<List<Object>> getDisposicaoPecas() {
		List<List<Object>> listOfLists = new ArrayList<>();
		List<Peca> pecas =  this.getAllPecas();		
		for(Peca peca: pecas) {
			List<Object> innerList = new ArrayList<>();
			innerList.add(peca.getX());
			innerList.add(peca.getY());
			innerList.add(peca.getTipo());
			innerList.add(peca.getCor());
			listOfLists.add(innerList);
		}
		return listOfLists;
	}
	
	public static Peca getSelecionada() {
		return selecionada;
	}

	public static void setSelecionada(Peca selecionada) {
		Tabuleiro.selecionada = selecionada;
	}

	@Override
	public void addObserver(Observer o) {
		lob.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		lob.remove(o);
	}

	@Override
	public Object get() {
		// TODO Auto-generated method stub
		Object dados[]=new Object[1];
		dados[0]=this.getDisposicaoPecas();
		return dados;
	}
	
    /*
    public static void main(String[] args) {
    	selecionada = new Torre(Cor.BRANCO);
    	selecionada.movimentoValido(10, 231);
    }
    */
	
}
